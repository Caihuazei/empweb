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
import java.math.BigDecimal;

@WebServlet(urlPatterns = "/updateemp")
public class EmpUpdateServlet extends HttpServlet {

    EmpService empService = new EmpServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Emp e = new Emp();
        e.setEmpId(Integer.parseInt(req.getParameter("empId")));
        e.setName(req.getParameter("name"));
        e.setAge(Integer.parseInt(req.getParameter("age")));
        e.setSex(req.getParameter("sex"));
        e.setSalary(new BigDecimal(req.getParameter("salary")));
        e.setDeptId(Integer.parseInt(req.getParameter("deptId")));

        empService.updateEmp(e);

        resp.sendRedirect("emplist");
    }
}
