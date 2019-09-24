package com.liu.filter;

import com.liu.entity.User;
import com.liu.service.UserService;
import com.liu.service.impl.UserServletImpl;
import com.liu.until.CookieUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebFilter(urlPatterns = "/*")
public class logOnFilter implements Filter {
    private UserService userService = new UserServletImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //判断是否登录
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        if (uri.equals("/logOnShow") || uri.equals("/logOn") || uri.endsWith(".js") || uri.endsWith(".css")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpSession session = request.getSession();

            User user = (User) session.getAttribute("user");

            if (user == null) {
                Cookie[] cookies = request.getCookies();
                Map<String, String> map = CookieUtils.cookiceToMap(cookies);
                String value = map.get("username");
                if (value == null) {
                    response.sendRedirect("logOnShow");
                } else {
                    User userCookies = userService.listUserByName(value);
                    session.setAttribute("user", userCookies);

                    filterChain.doFilter(servletRequest, servletResponse);
                }

            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
