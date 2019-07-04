package com.zhenxin.service.Impl;

import com.alibaba.druid.util.StringUtils;
import com.zhenxin.admin.UserMapper;
import com.zhenxin.admin.dao.UserDao;
import com.zhenxin.pojo.JsonData;
import com.zhenxin.pojo.User;
import com.zhenxin.pojo.UserExample;
import com.zhenxin.service.UserService;
import com.zhenxin.utils.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    final static UUID uuid = UUID.randomUUID();
    MD5Utils md5Utils = new MD5Utils();
    @Autowired
    private UserMapper userMapper;
    @Resource
    private redisUtils redisPool;
    /**
     * 查找所有用户
     */

    public JsonData findUser() {
       UserExample userExample = new UserExample();
       List<User> users = userMapper.selectByExample(userExample);
       return JsonData.buildSuccess(users);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */


    public JsonData addUser(@RequestBody User user) {
        if (StringUtils.isEmpty(user.getUserName())) {
            return JsonData.buildError("用户名称不能为空");
        }
        if (StringUtils.isEmpty(user.getPasswd())) {
            return JsonData.buildError("用户密码不能为空");
        }
        if (StringUtils.isEmpty(user.getPhone())) {
            return JsonData.buildError("手机号不能为空");
        }
        long l = userMapper.countByExample(UserDao.findUser(user.getUserName()));
        if(l!=0){
            return JsonData.buildError("用户名已存在");
        }
        user.setIsDeleted(Byte.valueOf("0"));
        //创建随机密钥
        user.setCreateTime(new Date());
        user.setRandomSerict(uuid.toString());
        String passWord = MD5Utils.MD5(user.getRandomSerict() + user.getPasswd());
        user.setPasswd(passWord);
        user.setSex(Byte.valueOf("0"));
        int result = userMapper.insert(user);
        if (result == 0) {
            return JsonData.buildError("插入失败");
        }
        return JsonData.buildSuccess("操作成功");
    }

    /**
     * 更新用户
     * @param user
     * @return
     */


    public JsonData updateUser(User user) {
        user.setCreateTime(new Date());
        if(user==null){
            return JsonData.buildError("请输入需要修改的值");
        }
        //用户名称判断
        if(!StringUtils.isEmpty(user.getUserName())){
            long l = userMapper.countByExample(UserDao.findUser(user.getUserName()));
            if(l!=0){
                return JsonData.buildError("用户名与当前用户名相同");
            }
        }
        user.setRandomSerict(uuid.toString());
        String passWord = MD5Utils.MD5(user.getRandomSerict() + user.getPasswd());
        user.setPasswd(passWord);
        int result = userMapper.updateByExampleSelective(user, UserDao.findUserById(user.getUserId()));
        if(result!=1){
            return JsonData.buildError("更新失败");
        }
        return JsonData.buildSuccess("更新成功");
    }


    public JsonData deleteUser(int userId) {
        if(0==userId){
            return JsonData.buildError("用户Id不合法");
        }
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        User user =new User();
        user.setUserId(userId);
        user.setModifyTime(new Date());
        user.setIsDeleted(Byte.valueOf("1"));
        userMapper.updateByPrimaryKeySelective(user);
        return JsonData.buildSuccess("删除用户成功");
    }



    public JsonData login(String userName, String password) {
        if (StringUtils.isEmpty(userName)) {
            return JsonData.buildError("用户名称不能为空");
        }
        if (StringUtils.isEmpty(userName)) {
            return JsonData.buildError("密码不能为空");
        }
        List<User> users = userMapper.selectByExample(UserDao.findUser(userName));
        if(users.size()==0){
            return JsonData.buildError("该用户暂未注册");
        }
        User user=(User) users.get(0);
        User user1=new User();
        String randomSerict = user.getRandomSerict();
        String pwd = MD5Utils.MD5(randomSerict + password);
        password = user.getPasswd();
        if(!pwd.equals(password)){
            return JsonData.buildError("用户密码错误");
        }
        String token = JwtUtils.geneJsonWebToken(user);
        user1.setToken(token);
        user1.setTokenCreated(new Date());
        userMapper.updateByExampleSelective(user1,UserDao.updateToken(user.getUserId()));
        return JsonData.buildSuccess("登陆成功",token);
    }

    public JsonData sendRandom(String phone,String random) {
       if(StringUtils.isEmpty(phone)){
           return JsonData.buildError("手机号信息有误");
       }
        String redisJson = redisPool.get(phone);
        if(StringUtils.isEmpty(redisJson)){
            return JsonData.buildError("请稍后再试");
        }
        if(redisJson.equals(redisJson)){
            return JsonData.buildError("验证成功");
        }
        return JsonData.buildSuccess("稍后再试");
    }

    public JsonData sendRandom(String phone) {
        if (StringUtils.isEmpty(phone)) {
            return JsonData.buildError("手机号信息有误");
        }
        String result = MassageUtils.sendMessage(phone);
        String redisJson = redisPool.get(phone);
        if(StringUtils.isEmpty(redisJson)){
            redisPool.set(phone,result,60*5);
        }else{
            redisPool.del(phone);
            redisPool.set(phone,result,60*5);
        }
        return JsonData.buildSuccess("发送成功",result);
    }

    @Test
    public void test(){
        String phone="17521583740";
 //       String s = MassageUtils.sendMessage(phone);
        String s="26585265";
        System.out.println(s);
        redisPool.set(phone,s);

    }






}
