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


@WebServlet(urlPatterns = {"/addEmp"})
public class EmpAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //创建Impl对象调用其方法
        EmpService empService = new EmpServiceImpl();

        //创建Emp对象将从页面form表单中获取到的信息存入对象
        Emp e = new Emp();
        e.setName(req.getParameter("name"));
        e.setAge(Integer.parseInt(req.getParameter("age")));
        e.setSex(req.getParameter("sex"));
        e.setSalary(new BigDecimal(req.getParameter("salary")));
        e.setDeptId(Integer.parseInt(req.getParameter("deptId")));

        //调用addEmp方法将获取对象传进addEmp()中
        empService.addEmp(e);

        //重定向到emplist员工信息页
        resp.sendRedirect("emplist");
    }
}
