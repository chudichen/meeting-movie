package com.stylefeng.guns.gateway.modular.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.user.api.UserServiceApi;
import com.stylefeng.guns.gateway.modular.auth.controller.dto.AuthRequest;
import com.stylefeng.guns.gateway.modular.auth.controller.dto.AuthResponse;
import com.stylefeng.guns.gateway.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.gateway.modular.auth.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请求验证的
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:22
 */
@RestController
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Reference(interfaceClass = UserServiceApi.class)
    private UserServiceApi userServiceAPI;

    @RequestMapping(value = "${jwt.auth-path}")
    public ResponseVO createAuthenticationToken(AuthRequest authRequest) {

        boolean validate = true;
        // 去掉guns自身携带的用户名密码验证机制，使用自定义的
        Integer userId = userServiceAPI.login(authRequest.getUserName(), authRequest.getPassword());
        if (userId == 0) {
            validate = false;
        }

        if (validate) {
            // 生成randomKey
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(userId.toString(), randomKey);
            // 返回值
            return ResponseVO.success(new AuthResponse(token, randomKey));
        } else {
            return ResponseVO.serviceFail("用户名或密码错误");
        }
    }
}
