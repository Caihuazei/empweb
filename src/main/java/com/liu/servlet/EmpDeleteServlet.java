package com.liu.servlet;

import com.liu.service.EmpService;
import com.liu.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/deleteemp")
public class EmpDeleteServlet extends HttpServlet {

    EmpService empService = new EmpServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));

        empService.deleteEmpById(id);

        resp.sendRedirect("emplist");
    }
}
