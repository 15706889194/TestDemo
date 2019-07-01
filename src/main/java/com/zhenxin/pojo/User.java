package com.zhenxin.pojo;

import java.util.Date;

/**
 * database table is user
 * @mbg.generated do_not_delete_during_merge
 */
public class User extends BasePojo {
    /**
     * database column is user.user_id
     * @mbg.generated
     */
    private Integer userId;

    /**
     * 用户昵称
     * database column is user.nick_name
     * @mbg.generated
     */
    private String nickName;

    /**
     * 用户名
     * database column is user.user_name
     * @mbg.generated
     */
    private String userName;

    /**
     * 头像
     * database column is user.head_img
     * @mbg.generated
     */
    private Integer headImg;

    /**
     * 手机号
     * database column is user.phone
     * @mbg.generated
     */
    private String phone;

    /**
     * 用户加密密码
     * database column is user.passwd
     * @mbg.generated
     */
    private String passwd;

    /**
     * database column is user.random_serict
     * @mbg.generated
     */
    private String randomSerict;

    /**
     * 0表示女，1表示男
     * database column is user.sex
     * @mbg.generated
     */
    private Byte sex;

    /**
     * 城市
     * database column is user.city
     * @mbg.generated
     */
    private String city;

    /**
     * 创建时间
     * database column is user.create_time
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 修改时间
     * database column is user.modify_time
     * @mbg.generated
     */
    private Date modifyTime;

    /**
     * 是否删除（0表示未删除 1表示已经删除）
     * database column is user.is_deleted
     * @mbg.generated
     */
    private Byte isDeleted;

    /**
     * @return the value of user.user_id
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the value for user.user_id
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the value of user.nick_name
     * @mbg.generated
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the value for user.nick_name
     * @mbg.generated
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * @return the value of user.user_name
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the value for user.user_name
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * @return the value of user.head_img
     * @mbg.generated
     */
    public Integer getHeadImg() {
        return headImg;
    }

    /**
     * @param headImg the value for user.head_img
     * @mbg.generated
     */
    public void setHeadImg(Integer headImg) {
        this.headImg = headImg;
    }

    /**
     * @return the value of user.phone
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the value for user.phone
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * @return the value of user.passwd
     * @mbg.generated
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd the value for user.passwd
     * @mbg.generated
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    /**
     * @return the value of user.random_serict
     * @mbg.generated
     */
    public String getRandomSerict() {
        return randomSerict;
    }

    /**
     * @param randomSerict the value for user.random_serict
     * @mbg.generated
     */
    public void setRandomSerict(String randomSerict) {
        this.randomSerict = randomSerict == null ? null : randomSerict.trim();
    }

    /**
     * @return the value of user.sex
     * @mbg.generated
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * @param sex the value for user.sex
     * @mbg.generated
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * @return the value of user.city
     * @mbg.generated
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the value for user.city
     * @mbg.generated
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * @return the value of user.create_time
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the value for user.create_time
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the value of user.modify_time
     * @mbg.generated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime the value for user.modify_time
     * @mbg.generated
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * @return the value of user.is_deleted
     * @mbg.generated
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the value for user.is_deleted
     * @mbg.generated
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}