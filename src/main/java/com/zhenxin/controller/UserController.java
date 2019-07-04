package com.zhenxin.controller;

import com.zhenxin.pojo.JsonData;
import com.zhenxin.pojo.User;
import com.zhenxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public JsonData findUser(){

        return userService.findUser();
    }
    /**
     * 用户新增
     * @param user
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public JsonData addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    /**
     * 用户修改
     * @param user
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public JsonData updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    /**
     * 用户修改
     * @param userId
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public JsonData deleteUser(int  userId){
        return userService.deleteUser(userId);
    }

    /**
     * 用户登陆
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public  JsonData login(String userName,String password){
        return  userService.login(userName,password);
    }


    /**
     * 比对验证码
     * @param phone
     * @return
     */
    @RequestMapping(value = "/message",method = RequestMethod.POST)
    @ResponseBody
    public  JsonData CompRandom(String phone){
        return  userService.sendRandom(phone);
    }
    /**
     * 生成验证码，存入redis
     * @param phone
     * @return
     */
    @RequestMapping(value = "/CompareMessage",method = RequestMethod.POST)
    @ResponseBody
    public  JsonData SendRandom(String phone,String random){
        return  userService.sendRandom(phone,random);
    }












}
