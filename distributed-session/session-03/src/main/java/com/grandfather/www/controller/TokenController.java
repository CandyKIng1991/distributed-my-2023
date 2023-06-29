package com.grandfather.www.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.grandfather.www.common.Result;
import com.grandfather.www.common.Status;
import org.springframework.web.bind.annotation.*;


import java.util.Date;

import static com.grandfather.www.util.LoginIntercepter.JWT_KEY;
import static com.grandfather.www.util.LoginIntercepter.UID;

@RequestMapping("/user")
@RestController
public class TokenController {


    /**
     * 访问地址：<a href="http://localhost:8081/user/loginWithJwt?username=admin&password=admin">...</a>
     * <p>
     * 用jwt登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录信息
     */
    @GetMapping("/loginWithJwt")
    public String loginWithJwt(@RequestParam String username,
                               @RequestParam String password) {
        Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);
        String token = JWT.create().withIssuer("auth0")
                .sign(algorithm);
        return token;
    }

    /**
     * 访问地址：<a href="http://localhost:8081/user/infoWithJwt">...</a>
     * <p>
     * 获取用户信息
     *
     * @param token
     * @return
     */
    @GetMapping("/infoWithJwt")
    public DecodedJWT infoWithJwt(@RequestHeader String token) {
        Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);
        JWTVerifier verifier = JWT.require(algorithm).withIssuer("auth0").build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt;
    }


    /**
     * 访问地址：<a href="http://localhost:8081/user/loginWithJwt?username=admin&password=admin">...</a>
     * <p>
     * <p>
     * 改造自定义模式
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    @GetMapping("/loginWithJwt2")
    public String loginWithJwt2(@RequestParam String username,
                                @RequestParam String password) {
        Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);
        String token = JWT.create().
                withClaim("login_user", username)
                .sign(algorithm);
        return token;
    }

    /**
     * 访问地址：<a href="http://localhost:8081/user/infoWithJwt2">...</a>
     * <p>
     * <p>
     * 获取用户信息
     *
     * @param token 输入token
     * @return 用户名称
     */
    @GetMapping("/infoWithJwt2")
    public String infoWithJwt2(@RequestHeader String token) {
        Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("login_user").asString();
    }


    /**
     * 访问地址：<a href="http://localhost:8081/user/loginWithJwt3?username=admin&password=admin">...</a>
     * <p>
     * <p>
     * 改造自定义模式
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户信息
     */
    @GetMapping("/loginWithJwt3")
    public String loginWithJwt3(@RequestParam String username,
                                @RequestParam String password) {
        Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);
        String token = JWT.create().
                withClaim("login_user", username).
                // 设置过期时间
                        withExpiresAt(new Date(System.currentTimeMillis() + 3600000))
                .sign(algorithm);
        return token;
    }


    /**
     * 访问地址：<a href="http://localhost:8081/user/infoWithJwt2">...</a>
     * <p>
     * <p>
     * 获取用户信息
     *
     * @param token 输入token
     * @return 用户名称
     */
    @GetMapping("/infoWithJwt3")
    public Result infoWithJwt3(@RequestHeader String token) {
        Result result = new Result();


        Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);
        JWTVerifier verifier = JWT.require(algorithm).build();

        try {
            DecodedJWT jwt = verifier.verify(token);

            result.setId(9555);
            result.setStatus(Status.SUCCESS);
            result.setDescription("{ 'username':" + jwt.getClaim("login_user").asString() + " " +
                    "}");

            return result;
        } catch (TokenExpiredException e) {
            // token 过期
            result.setId(9527);
            result.setStatus(Status.EXCEPTION);
            result.setDescription("token 过期");


        } catch (JWTDecodeException e) {
            // 解码失败
            result.setId(9527);
            result.setStatus(Status.EXCEPTION);
            result.setDescription("解码失败");
        }

        result.setId(9527);
        result.setStatus(Status.EXCEPTION);
        result.setDescription("存在问题");


        return result;
    }
}
