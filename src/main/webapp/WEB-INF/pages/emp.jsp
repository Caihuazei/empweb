<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>员工信息</title>
    <link rel="stylesheet" href="/bootstrap4/css/bootstrap.min.css">
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script>
        $(function () {
            //为删除按钮添加事件
            $('.delete').click(function () {
                //1.获取ID
                var id = $(this).data('id');
                //2.发送网络请求
                location.href = 'deleteemp?id=' + id;
            })
            //为更改添加事件
            $('.update').click(function () {
                var id = $(this).data('id');
                //2.发送网络请求
                location.href = 'updateEmpShow?id=' + id;
            })
        });
    </script>
</head>
<body>
<div class="container">


<table class="table">
    <thead class="thead-dark">
    <tr>
        <th scope="col">姓名</th>
        <th scope="col">年龄</th>
        <th scope="col">性别</th>
        <th scope="col">工资</th>
        <th scope="col">部门</th>
        <th scope="col">地点</th>
        <th scope="col"> &nbsp; &nbsp; &nbsp; &nbsp;设置</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${emplist}" var="emp">
    <tr>
        <td>${emp.name}</td>
        <td>${emp.age}</td>
        <td>${emp.sex}</td>
        <td>${emp.salary}</td>
        <td>${emp.dept.dname}</td>
        <td>${emp.dept.location}</td>
        <td>
            <button type="button" class="btn btn-primary btn-sm update" data-id="${emp.empId}">修改</button>
            <button type="button" class="btn btn-danger btn-sm delete" data-id="${emp.empId}">删除</button>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
    <a href="addEmpShow" class="btn btn-success">增加数据</a>
</div>
<script src="/bootstrap4/js/bootstrap.min.js"/>
</body>
</html>
