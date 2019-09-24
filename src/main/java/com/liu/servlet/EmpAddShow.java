package com.liu.servlet;

import com.liu.entity.Dept;
import com.liu.service.DeptService;
import com.liu.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/addEmpShow"})
public class EmpAddShow  extends HttpServlet {

    private DeptService deptService = new DeptServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Dept> deptList = deptService.listdept();

        req.setAttribute("deptList",deptList);

//        resp.sendRedirect("WEB-INF/pages/addEmp.jsp");
        req.getRequestDispatcher("WEB-INF/pages/addEmp.jsp").forward(req,resp);
    }
}
