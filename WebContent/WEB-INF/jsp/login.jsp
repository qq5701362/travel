<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-------------jquery库-------------->
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<!-------------Amazeui--------------->
<script type="text/javascript" src="js/amazeui.js"></script>
<link rel="stylesheet" type="text/css" href="css/amazeui.css">
<!------------核心样式-------------->
<link rel="stylesheet" type="text/css" href="css/user.css">
</head>
<body>
    <!-------------------登录------------------->
    <div id="log_register">

        <div class="lr_box">

            <div class="tag">
                <ul>
                    <li><a class="cur"
                        href="${pageContext.request.contextPath}/check/toLogin">登录</a></li>
                    <li><a href="${pageContext.request.contextPath}/check/toRegister">注册</a></li>
                    <div class="clear"></div>
                </ul>
            </div>
            <font color="red">${requestScope.errorMessage}</font>
            <form action="${pageContext.request.contextPath}/check/login.action" method="post">
                <input type="hidden" name="did" value="0" />
                <table class="table_list">
                    <tbody>
                        <tr>
                            <td><p>账号：<input class="text" name="userid" style="width:200px" type="text" placeholder="您的账号(数字)"  required/></p></td>
                        </tr>
                        <tr>
                            <td><p>密码：<input class="text" name="password" style="width:200px" type="password" placeholder="您的密码"  required/></p></td>
                            
                        </tr>
                         
                        <tr>
                            <td><input class="submit" type="submit" value="登录"></td>
                        </tr>
                    </tbody>
                </table>
            </form>

        </div>

    </div>
</body>
</html>