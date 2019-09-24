<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工信息添加</title>
    <link rel="stylesheet" href="/bootstrap4/css/bootstrap.min.css">
</head>
<body>
<div class="container">

    <form action="/addEmp" method="get">

        <div class="input-group input-group-sm mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="name">姓名</span>
            </div>
            <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
                   name="name">
        </div>

        <div class="input-group input-group-sm mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="age">年龄</span>
            </div>
            <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
                   name="age">
        </div>

        <div class="input-group input-group-sm mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="sex">性别</span>
            </div>
            <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
                   name="sex">
        </div>

        <div class="input-group input-group-sm mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="salary">工资</span>
            </div>
            <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
                   name="salary">
        </div>

        <div class="input-group input-group-sm mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="deptId">部门</span>
            </div>
            <select class="custom-select" name="deptId">
                <%--<option selected value="1">研发部</option>--%>
                <c:forEach items="${deptList}" var="dept">
                <option value="${dept.deptId}">${dept.dname}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">提交</button>

    </form>
</div>

<script src="/js/jquery-3.4.1.min.js"/>
<script src="/bootstrap4/js/bootstrap.min.js"/>
</body>
</html>
