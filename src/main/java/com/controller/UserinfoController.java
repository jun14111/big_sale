package com.controller;

import com.model.Emp;
import com.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author HuangCJ
 */
@RequestMapping("/userinfo")
@RestController
public class UserinfoController {
    @Autowired
    UserinfoService userinfoService;

    @RequestMapping("/login")
    public Boolean login(String username, String password) {
        Boolean isRight = userinfoService.login(username, password);
        if (isRight) {
            System.out.println("[INFO] 登录成功-->" + username);
        } else {
            System.out.println("[INFO] 登录失败-->" + username);
        }
        return isRight;
    }

    @RequestMapping("/loginGetPk")
    int loginGetPk(String username, String password) {
        Integer id = userinfoService.loginGetPk(username, password);
        if (id != null) {
            System.out.println("[INFO] 登录成功-->" + username);
        } else {
            System.out.println("[INFO] 登录失败-->" + username);
        }
        return id;
    }

    ;

}
