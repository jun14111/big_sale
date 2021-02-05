package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HuangCJ
 */
//@WebFilter("/*")
public class LoginFilter implements Filter {

    private static List<String> urls = new ArrayList<>();

    @Override
    public void init(FilterConfig config) throws ServletException {
        //放行地址集合

        // 登录
        urls.add("login.jsp");
        urls.add("userinfo/login");

        // 商品相关
        urls.add("killGoodsList.html");
        urls.add("/killGoods/list");
        urls.add("/killGoods/selectOneByPk");
        urls.add("details.jsp");

        // 资源相关
        urls.add(".jpg");

        //
        urls.add("orderList.jsp");
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 先获取当前请求的地址
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String requestURI = request.getRequestURI();

        System.out.println(requestURI);
        for (String url : urls) {
            if (requestURI.contains(url) || "/big_sale_war/".equals(requestURI)) {
                // 放行
                System.out.println("[INFO] 放行");
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        Integer userid = (Integer) session.getAttribute("userid");

        // 作用域有username放行
        if (username != null || userid != null) {
            System.out.println("[INFO] 放行");
            filterChain.doFilter(servletRequest, servletResponse);
        }
        // 作用域没有username，重定向登录页
        else {
            System.out.println("[INFO] 拦截");
            response.sendRedirect("login.jsp");
        }
    }
}

