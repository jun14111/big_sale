package com.controller;

import com.model.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author HuangCJ
 */
@WebServlet(urlPatterns = {"/logout"}, name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Emp user = (Emp) request.getSession().getAttribute("user");
        request.getSession().removeAttribute("user");
        System.out.println("[INFO] 注销成功-->" + user.toString());
        response.sendRedirect("login.jsp");
    }
}
