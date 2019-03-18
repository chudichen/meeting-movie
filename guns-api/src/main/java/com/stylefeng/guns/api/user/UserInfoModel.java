package com.stylefeng.guns.api.user;

import lombok.Data;

/**
 * 去除敏感信息的User信息
 *
 * @author Michael.Chu
 * @date 2019-03-18 21:08
 */
@Data
public class UserInfoModel {

    /** 用户信息 */
    private String userName;
    /** 用户昵称 */
    private String nickName;
    /** 用户邮箱 */
    private String email;
    /** 电话 */
    private String phone;
    /** 性别[0-男，1-女] */
    private int sex;
    /** 生日 */
    private String birthday;
    /** 生活状态[0-单身，1-热恋中，2-已婚，3-为人父母] */
    private String lifeState;
    /** 简介 */
    private String biography;
    /** 住址 */
    private String address;
    /** 头像地址 */
    private String headAddress;
    /** 创建时间 */
    private long beginTime;
    /** 更新时间 */
    private long updateTime;
}
