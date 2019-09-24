<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工信息修改页</title>
    <link rel="stylesheet" href="/bootstrap4/css/bootstrap.min.css">
</head>
<body>
<div class="container">

    <form action="/updateemp" method="get">
        <%--设置姓名，--%>
        <div class="input-group input-group-sm mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="name">姓名</span>
            </div>
            <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
                   name="name" value="${emp.name}">
        </div>
        <%--设置年龄--%>
        <div class="input-group input-group-sm mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="age">年龄</span>
            </div>
            <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
                   name="age" value="${emp.age}">
        </div>
        <%--设置性别--%>
        <div class="input-group input-group-sm mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="sex">性别</span>
            </div>
            <%--<input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
            name="sex" <c:if test="${emp.sex == '男'}">value="男"</c:if>
            <c:if test="${emp.sex != '男'}">value="女"</c:if>>--%>
            <select class="custom-select" name="sex">
                <option value="男" <c:if test="${emp.sex == '男'}">selected</c:if>>男</option>
                <option value="女" <c:if test="${emp.sex != '男'}">selected</c:if>>女</option>
            </select>
        </div>
        <%--设置工资--%>
        <div class="input-group input-group-sm mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="salary">工资</span>
            </div>
            <input type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm"
                   name="salary" value="${emp.salary}">
        </div>
        <%--设置部门--%>
        <div class="input-group input-group-sm mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="deptId">部门</span>
            </div>

            <select class="custom-select" name="deptId">
                <%--<option selected value="1">研发部</option>--%>
                <c:forEach items="${deptList}" var="dept">
                    <c:if test="${dept.deptId != emp.deptId}">
                        <option value="${dept.deptId}">${dept.dname}</option>
                    </c:if>
                    <c:if test="${dept.deptId == emp.deptId}">
                        <option value="${dept.deptId}" selected>${dept.dname}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <%--发送id值,提交表单--%>
        <input type="hidden" name="empId" value="${emp.empId}">
        <button type="submit" class="btn btn-primary">提交</button>
    </form>

</div>
<script src="/js/jquery-3.4.1.min.js"></script>
<script src="/bootstrap4/js/bootstrap.min.js"/>
</body>
</html>
