package com.liu.servlet;

import com.liu.entity.Emp;
import com.liu.service.EmpService;
import com.liu.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = {"/emplist"})
public class EmpLiseServlet extends HttpServlet {

    private  EmpService empService = new EmpServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Emp> empList = empService.listemp();
        req.setAttribute("emplist",empList);
        req.getRequestDispatcher("WEB-INF/pages/emp.jsp").forward(req,resp);
    }
}
