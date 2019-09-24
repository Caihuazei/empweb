<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <link rel="stylesheet" href="/bootstrap4/css/bootstrap.min.css">
    <script src="/js/jquery-3.4.1.min.js"></script>
    <script>
        $(function () {
            $('.login').click(function () {

                    $.ajax({
                        url:'logOn',
                        type:'post',
                        data:$('#logonFrom').serialize(),
                        success: function (res) {
                            console.log(typeof res);
                            if (res.status === 0){
                                location.href = 'emplist';
                            } else {
                                alert(res.message);
                            }
                        }
                    })
            })
        })
    </script>

</head>
<body>
<div class="container">

<form action="logOn" method="post" id="logonFrom">
    <div class="form-group">
        <label for="userName">账号</label>
        <input type="text" class="form-control" id="userName" aria-describedby="emailHelp" placeholder="账号" name="userName">
        <small id="emailHelp" class="form-text text-muted">We'll never share your password with anyone else.</small>
    </div>
    <div class="form-group">
        <label for="password">密码</label>
        <input type="password" class="form-control" id="password" placeholder="密码" name="password">
    </div>

    <div class="form-check">
        <input type="checkbox" class="form-check-input" id="Check" name="check">
        <label class="form-check-label" for="Check">Check me out</label>
    </div>
    <button type="button" class="btn btn-primary login" >登录</button>
</form>

</div>
<script src="/bootstrap4/js/bootstrap.min.js"/>
</body>
</html>
