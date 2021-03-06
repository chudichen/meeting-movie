package com.stylefeng.guns.gateway.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.user.api.UserServiceApi;
import com.stylefeng.guns.api.user.vo.UserInfoModel;
import com.stylefeng.guns.api.user.vo.UserModel;
import com.stylefeng.guns.gateway.common.CurrentUser;
import com.stylefeng.guns.gateway.modular.auth.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * 用户控制器
 *
 * @author Michael.Chu
 * @date 2019-03-19 22:08
 */
@RestController
@RequestMapping(value = "/user/")
public class UserController {

    /**
     * 引用User服务提供的UserAPI，配置check = false表示关闭启动检查，
     * 启动时不需要去Zookeeper中检查依赖，一般情况下不建议关闭启动检查。
     */
    @Reference(interfaceClass = UserServiceApi.class, check = false)
    private UserServiceApi userServiceApi;

    /**
     * 用户注册
     *
     * @param userModel {@link UserModel} 用户注册信息
     * @return 注册结果
     */
    @PostMapping(value = "register")
    public ResponseVO register(UserModel userModel) {
        if (userModel.getUsername() == null || userModel.getUsername().trim().length() == 0) {
            return ResponseVO.serviceFail("用户名不能为空");
        }
        if (userModel.getPassword() == null || userModel.getPassword().trim().length() == 0) {
            return ResponseVO.serviceFail("密码不能为空");
        }

        if (userServiceApi.register(userModel)) {
            return ResponseVO.success("注册成功");
        }
        return ResponseVO.serviceFail("注册失败");
    }

    /**
     * 检查用户名是否存在
     *
     * @param username {@link String} 需要检测的用户名
     * @return 是否存在
     */
    @PostMapping(value = "check")
    public ResponseVO check(String username) {
        if (username == null || username.trim().length() == 0) {
            return ResponseVO.serviceFail("用户名不能为空");
        }

        if (userServiceApi.checkUsername(username)) {
            return ResponseVO.success("用户名不存在，可以注册");
        }
        return ResponseVO.serviceFail("用户名已经存在");
    }

    @GetMapping(value = "logout")
    public ResponseVO logout() {

        return ResponseVO.success("用户退出成功");
    }

    @GetMapping(value = "getUserInfo")
    public ResponseVO getUserInfo() {
        String userId = CurrentUser.getCurrentUser();
        if (userId == null || userId.trim().length() < 1) {
            return ResponseVO.serviceFail("当前用户未登陆");
        }

        UserInfoModel userInfo = userServiceApi.getUserInfo(Integer.valueOf(userId));
        if (userInfo == null) {
            return ResponseVO.serviceFail("用户信息获取失败");
        }

        return ResponseVO.success(userInfo);
    }

    @PostMapping(value = "updateUserInfo")
    public ResponseVO updateUserInfo(UserInfoModel userInfoModel) {
        String userId = CurrentUser.getCurrentUser();
        if (userId == null || userId.trim().length() < 1) {
            return ResponseVO.serviceFail("当前用户未登陆");
        }

        if (!Objects.equals(Integer.parseInt(userId), userInfoModel.getUuid())) {
            return ResponseVO.serviceFail("请修改您的个人信息");
        }

        UserInfoModel updateUserResult = userServiceApi.updateUserInfo(userInfoModel);
        if (updateUserResult == null) {
            return ResponseVO.serviceFail("修改用户信息失败");
        }
        return ResponseVO.success(updateUserResult);
    }
}
