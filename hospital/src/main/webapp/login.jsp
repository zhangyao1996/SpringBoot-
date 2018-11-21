<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="UTF-8">
        <title>登录</title>
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <div class="login">
            <div class="header">
                <h1>
                    <a href="login.do">登录</a>
                </h1>
                <button></button>
            </div>
            <form action="login.do" method="post">
                <div class="name">
                    账号<input type="text" id="name" name="username">
                    <p></p>
                </div>
                <div class="pwd">
                    密码<input type="password" id="pwd" name="password" >
                    <p></p>
                </div>
                <div class="btn-red">
                    <input type="submit" value="登录" id="login-btn">
                </div>
                <%
                String msg=(String)request.getAttribute("msg");
                if(msg!=null){
                	out.print("<script type='text/javascript'>alert('账号或者密码错误');</script>");
                }
                %>
            </form>
        </div>
    </body>
</html>