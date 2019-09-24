package com.liu.servlet;

import com.google.gson.Gson;
import com.liu.entity.User;
import com.liu.service.UserService;
import com.liu.service.impl.UserServletImpl;
import com.liu.vo.LogOnVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/logOn")
public class logOnServlet extends HttpServlet {
    UserService userService = new UserServletImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("userName");
        String password = req.getParameter("password");
        String check = req.getParameter("check");

        User user = userService.listUserByName(name);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                if (check != null) {
                    Cookie cookie = new Cookie("username", user.getUserName());
                    cookie.setMaxAge(60 * 60 * 24);
                    resp.addCookie(cookie);
//                    resp.sendRedirect("emplist");
                    LogOnVO logOnVO = LogOnVO.success();
                    String jsonStr = new Gson().toJson(logOnVO);
                    out.print(jsonStr);
                    System.out.println(jsonStr);
                }
            }else {
                //密码错误
                LogOnVO logOnVO = LogOnVO.error(1,"密码错误");
                String jsonStr = new Gson().toJson(logOnVO);
                out.print(jsonStr);


            }

        } else {
            //用户不存在
            LogOnVO logOnVO = LogOnVO.error(2,"用户名不存在");
            String jsonStr = new Gson().toJson(logOnVO);
            out.print(jsonStr);
//            resp.sendRedirect("logOnShow");
        }


    }
}
