<%--
  Created by IntelliJ IDEA.
  User: 12098
  Date: 2024/4/5
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        html {
            height: 100%;
        }
        body {
            height: 100%;
        }
        .container {
            height: 100%;
            background-image: linear-gradient(to right, #999999, #330867);
        }
        /*登录表单*/
        .login-wrapper {
            background-color: bisque;
            width: 358px;
            height: 588px;
            border-radius: 15px;
            padding: 0 50px;
            position: relative;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
        }
        /*把登录表单放在具体位置*/
        .header {
            font-size: 38px;
            font-weight: bold;
            text-align: center;
            line-height: 200px;
        }
        /*具体登录的颜色*/
        .input-item {
            display: block;
            width: 100%;
            margin-bottom: 20px;
            border: 0;
            padding: 10px;
            border-bottom: 1px solid rgb(128,125,125);
            font-size: 15px;
            outline: none;
        }
        /*未输入的时候保持USERNAME和PASSWORD的样式*/
        .input-item::placeholder {
            text-transform: uppercase;
        }
        /*按钮的颜色和大小*/
        .btn {
            text-align: center;
            padding: 10px;
            width: 100%;
            margin-top: 40px;
            background-image: linear-gradient(to right,#a6c1ee, #fbc2eb);
            color: #fff;
        }
        .msg {
            text-align: center;
            line-height: 88px;
        }
        /*超链接的颜色*/
        a {
            text-decoration-line: none;
            color: #abc1ee;
        }
    </style>
   <%-- <%
        String username = "";
        String password = "";
        //获取当前站点的所有Cookie
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {//对cookies中的数据进行遍历，找到用户名、密码的数据
            if ("username".equals(cookie.getName())) {
                username = cookie.getValue();
            } else if ("password".equals(cookie.getName())) {
                password = cookie.getValue();
            }
        }

    %>--%>

</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div class="header">Login</div>
        <form id="adminlogin" action="${pageContext.request.contextPath}/user/login.do" method="post">
            <div class="form-wrapper">
                <label for="userName"></label><input type="text" value="${user.userName}" name="userName" id="userName"
                                                     placeholder="username" class="input-item" required>
                <label for="password"></label><input type="password" value="${user.password}" name="password"
                                                     id="password" placeholder="password" class="input-item" required>
                <a href="${pageContext.request.contextPath}/views/forgetpsw.jsp">忘记密码</a>
               <span >${errorMsg}</span>
                <button type="submit" class="btn" form="adminlogin">登录</button>
                <%--<a href="#"><div class="btn">Login</div></a>--%>
            </div>
        </form>
        <div class="msg">
            还没有一个账号？
            <a href="${pageContext.request.contextPath}/views/register.jsp">注册</a>
        </div>
    </div>
</div>
</body>
</html>

