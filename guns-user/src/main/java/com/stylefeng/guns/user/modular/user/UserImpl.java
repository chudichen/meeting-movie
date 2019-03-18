package com.stylefeng.guns.user.modular.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.user.UserAPI;
import com.stylefeng.guns.api.user.UserInfoModel;
import com.stylefeng.guns.api.user.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Michael.Chu
 * @date 2019-03-17 14:00
 */
@Slf4j
@Component
@Service(interfaceClass = UserAPI.class)
public class UserImpl implements UserAPI {

    @Override
    public int login(String username, String password) {
        log.info("This is gateway service, the username is {}.", username);
        return 0;
    }

    @Override
    public boolean register(UserModel userModel) {
        return false;
    }

    @Override
    public boolean checkUsername(String userName) {
        return false;
    }

    @Override
    public UserInfoModel getUserInfo(Integer userId) {
        return null;
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        return null;
    }
}
