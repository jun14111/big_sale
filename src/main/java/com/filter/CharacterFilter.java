package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author HuangCJ
 */
@WebFilter("/*")
public class CharacterFilter implements Filter {
    public CharacterFilter() {
        System.out.println("CharacterFilter实例化");
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 前端的到端
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");

        // 后端到前端
        servletResponse.setContentType("text/html;charset=utf-8");

        //正常放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

}
