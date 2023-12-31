package com.grandfather.www.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static com.grandfather.www.util.LoginIntercepter.JWT_KEY;
import static com.grandfather.www.util.LoginIntercepter.UID;

/**
 * @author MrLiu
 */
@RequestMapping("/user")
@RestController
public class TokenController {


    /**
     * 访问地址：<a href="http://localhost:8081/user/login?username=admin&password=admin">...</a>
     * <p>
     * 用jwt登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录信息
     */
    @GetMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {
        Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);
        String token = JWT.create().withIssuer("auth0")
                .sign(algorithm);
        return token;
    }

    /**
     * 访问地址：<a href="http://localhost:8081/user/loginWithJwt?username=admin&password=admin">...</a>
     * <p>
     * 必须用上个接口的token,不然就会报错500
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回token
     */
    @GetMapping("/loginWithJwt")
    public String loginWithJwt(@RequestParam String username,
                               @RequestParam String password) {
        Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);
        String token = JWT.create()
                .withClaim("login_user", username)
                .withClaim(UID, 1)
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600000))
                .sign(algorithm);
        return token;
    }

    /**
     * 访问地址：<a href="http://localhost:8081/user/address">...</a>
     * <p>
     * <p>
     * 获取上个接口的id
     * 获取地址, token -> id
     *
     * @param uid 返回这个
     * @return 返回
     */
    @GetMapping("/address")
    public Integer address(@RequestAttribute Integer uid) {
        return uid;
    }

    /**
     * 访问地址：<a href="http://localhost:8081/user/infoWithJwt">...</a>
     * <p>
     * <p>
     * 获取用户信息
     *
     * @param loginUser 用户token
     * @return 用户信息
     */
    @GetMapping("/infoWithJwt")
    public String infoWithJwt(@RequestAttribute String login_user) {
        return login_user;
    }

}
