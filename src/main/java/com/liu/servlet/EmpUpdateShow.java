package com.liu.servlet;

import com.liu.entity.Dept;
import com.liu.entity.Emp;
import com.liu.mapper.EmpMapper;
import com.liu.service.DeptService;
import com.liu.service.EmpService;
import com.liu.service.impl.DeptServiceImpl;
import com.liu.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/updateEmpShow")
public class EmpUpdateShow extends HttpServlet {

    private EmpService empService = new EmpServiceImpl();
    private DeptService deptService = new DeptServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));

        Emp emp = empService.getEmpById(id);
        req.setAttribute("emp",emp);

        List<Dept> deptList = deptService.listdept();
        req.setAttribute("deptList",deptList);


        req.getRequestDispatcher("WEB-INF/pages/updateEmp.jsp").forward(req,resp);
    }
}
