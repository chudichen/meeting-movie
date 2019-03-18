package com.stylefeng.guns.api.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册时候的用户信息（仅注册时候使用）
 *
 * @author Michael.Chu
 * @date 2019-03-18 21:00
 */
@Data
public class UserModel implements Serializable {

    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** 邮箱 */
    private String email;
    /** 电话 */
    private String phone;
    /** 地址 */
    private String address;
}
