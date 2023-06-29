package com.grandfather.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author MrLiu
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 访问地址： <a href="http://localhost:8081/user/loginWithToken?username=admin&password=admin">...</a>
     * <p>
     * <p>
     * redis + token的方式获取token
     *
     * @param username 用户名
     * @param password 密码
     * @return 产生token
     */
    @GetMapping("/loginWithToken")
    public String loginWithToken(@RequestParam String username,
                                 @RequestParam String password) {
        //账号密码正确
        String key = "token_" + UUID.randomUUID();
        stringRedisTemplate.opsForValue().set(key, username, 3600, TimeUnit.SECONDS);
        return key;
    }

    /**
     * 访问地址： <a href="http://localhost:8081/user/infoWithToken">...</a>
     * <p>
     *
     * @param token 上个接口生成的token
     * @return 用户信息
     */
    @GetMapping("/infoWithToken")
    public String infoWithToken(@RequestHeader String token) {
        return "当前登录的是：" + stringRedisTemplate.opsForValue().get(token);
    }


}
