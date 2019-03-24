package com.stylefeng.guns.api.user.api;

import com.stylefeng.guns.api.user.vo.UserInfoModel;
import com.stylefeng.guns.api.user.vo.UserModel;

/**
 * Dubbo暴露的API
 *
 * @author Michael.Chu
 * @date 2019-03-17 13:08
 */
public interface UserServiceApi {

    /**
     * 用户登陆信息
     * @param username {@link String} 用户名称
     * @param password {@link String} 用户密码
     * @return {@link Boolean} 是否登陆成功
     */
    int login(String username, String password);

    /**
     * 用户注册
     * @param userModel {@link UserModel} 用户注册信息
     * @return {@link Boolean} 是否注册成功
     */
    boolean register(UserModel userModel);

    /**
     * 检查用户名是否可用
     * @param userName {@link String} 被检测的用户名
     * @return {@link Boolean} 是否已经被注册过
     */
    boolean checkUsername(String userName);

    /**
     * 通过userId来获取用户信息
     * @param userId {@link Integer} userId
     * @return {@link UserInfoModel} 用户信息
     */
    UserInfoModel getUserInfo(Integer userId);

    /**
     * 修改用户信息
     * @param userInfoModel {@link UserInfoModel} 用户信息
     * @return {@link UserInfoModel} 修改之后的用户信息
     */
    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);
}
