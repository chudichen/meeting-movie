package com.stylefeng.guns.user.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.api.user.UserAPI;
import com.stylefeng.guns.api.user.UserInfoModel;
import com.stylefeng.guns.api.user.UserModel;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.user.common.persistence.dao.UserTMapper;
import com.stylefeng.guns.user.common.persistence.model.UserT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * @author Michael.Chu
 * @date 2019-03-17 14:00
 */
@Slf4j
@Component
@Service(interfaceClass = UserAPI.class)
public class UserServiceImpl implements UserAPI {

    private final UserTMapper userTMapper;

    @Autowired
    public UserServiceImpl(UserTMapper userTMapper) {
        this.userTMapper = userTMapper;
    }

    @Override
    public boolean register(UserModel userModel) {
        // 将注册信息实体转换为数据实体
        UserT user = new UserT();
        user.setUserName(userModel.getUsername());
        // 使用MD5加密
        user.setUserPwd(MD5Util.encrypt(userModel.getPassword()));
        user.setEmail(userModel.getEmail());
        user.setAddress(userModel.getAddress());
        user.setUserPhone(user.getUserPhone());
        // 将数据实体存入数据库
        return userTMapper.insert(user) > 0;
    }

    @Override
    public int login(String username, String password) {
        // 根据登陆账号获取数据库信息
        UserT user = new UserT();
        user.setUserName(username);
        UserT userDb = userTMapper.selectOne(user);
        if (userDb != null && userDb.getUuid() > 0) {
            String md5Password = MD5Util.encrypt(password);
            if (Objects.equals(userDb.getUserPwd(), md5Password)) {
                return userDb.getUuid();
            }
        }
        return 0;
    }

    @Override
    public boolean checkUsername(String userName) {
        EntityWrapper<UserT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name", userName);
        Integer result = userTMapper.selectCount(entityWrapper);
        return result == null || result < 1;
    }

    @Override
    public UserInfoModel getUserInfo(Integer userId) {
        UserT user = userTMapper.selectById(userId);
        return do2UserInfo(user);
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        UserT user = userInfo2Do(userInfoModel);
        Integer isSuccess = userTMapper.updateById(user);
        if (isSuccess > 0) {
            return getUserInfo(user.getUuid());
        }
        return null;
    }

    /**
     * 将userInfo转换为DO
     * @param userInfoModel {@link UserInfoModel} 前端传递进来的用户信息
     * @return {@link UserInfoModel}
     */
    private UserT userInfo2Do(UserInfoModel userInfoModel) {
        UserT user = new UserT();
        user.setUserSex(userInfoModel.getSex());
        user.setUpdateTime(time2Date(System.currentTimeMillis()));
        user.setNickName(userInfoModel.getNickName());
        user.setLifeState(Integer.valueOf(userInfoModel.getLifeState()));
        user.setHeadUrl(userInfoModel.getHeadAddress());
        user.setBirthday(userInfoModel.getBirthday());
        user.setBiography(userInfoModel.getBiography());
        user.setBeginTime(time2Date(userInfoModel.getBeginTime()));
        user.setEmail(userInfoModel.getEmail());
        user.setAddress(userInfoModel.getAddress());
        user.setUserPhone(userInfoModel.getPhone());
        user.setUserName(userInfoModel.getUserName());
        user.setUuid(userInfoModel.getUuid());
        return user;
    }

    /**
     * 将userDO转换成UserInfoModle
     * @param user {@link UserT} userDO
     * @return {@link UserInfoModel}
     */
    private UserInfoModel do2UserInfo(UserT user) {
        UserInfoModel userInfoModel = new UserInfoModel();
        userInfoModel.setUserName(user.getUserName());
        userInfoModel.setUpdateTime(user.getUpdateTime().getTime());
        userInfoModel.setSex(user.getUserSex() == null ? 0 : user.getUserSex());
        userInfoModel.setPhone(user.getUserPhone());
        userInfoModel.setNickName(user.getNickName());
        userInfoModel.setLifeState(user.getLifeState() == null ? "0" : user.getLifeState().toString());
        userInfoModel.setHeadAddress(user.getHeadUrl());
        userInfoModel.setEmail(user.getEmail());
        userInfoModel.setBirthday(user.getBirthday());
        userInfoModel.setBiography(user.getBiography());
        userInfoModel.setBeginTime(user.getBeginTime().getTime());
        userInfoModel.setAddress(user.getAddress());
        return userInfoModel;
    }

    private Date time2Date(long time) {
        return new Date(time);
    }
}
