package com.imooc.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserController {


    /**
     * 访问地址:<a href="http://localhost:8081/user/login?username=admin&password=123456">...</a>
     *
     * @param username 用户名称
     * @param password 用户密码
     * @param session  缓存
     * @return 登录成功信息
     */
    @GetMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) {
        //账号密码正确
        session.setAttribute("login_user", username);

        return "欢迎 " + username + " 爸爸,登录成功";
    }

    /**
     * 访问地址: <a href="http://localhost:8081/user/info">...</a>
     * 为了测试是否通过session登录成功
     *
     * @param session 缓存用户数据的session
     * @return 用户数据
     */
    @GetMapping("/info")
    public String info(HttpSession session) {
        return "当前登录的是：" + session.getAttribute("login_user");
    }


}
