<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<base href="<%=basePath%>">
<html>
<head>
<title>注册</title>
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
    
    <div class="lr_box" style="margin-top:-220px">
        
        <div class="tag">
            <ul>
                <li><a href="${pageContext.request.contextPath}/check/toLogin">登录</a></li>
                <li><a class="cur" href="${pageContext.request.contextPath}/check/toRegister">注册</a></li>
                <div class="clear"></div>
            </ul>
        </div>
        <form method="post" action="${pageContext.request.contextPath}/check/register">
        <table class="table_list">
            <tbody>
                <tr>
                    <td>
                        <p>账号：<input value="${requestScope.userIdExiterror}" class="text" name="userid" style="width:200px" type="text"  placeholder="输入账号(必须为数字)"  required/></p>
                    </td>
                </tr>
                <tr>
                    <td><p>昵称：<input class="text" name="username" style="width:200px" type="text" value="${user.username}" placeholder="输入昵称"  required/></p></td>
                </tr>
                <tr>  
                    <td><p>密码：<input class="text" name="password" style="width:200px" type="password" placeholder="输入您的密码"  required/></p></td>
                </tr>
                <tr>
                    <td><p>性别：
                        <select name="sex" style="width:200px" value="${user.sex}" >
                           <option>男</option>
                           <option>女</option>
                        </select>
                    </p></td>
                </tr>
                
                <!--
                <tr>
                    <td><p>性别：<input class="text" name="sex" style="width:200px" type="text" value="${user.sex}" placeholder="输入性别，如：男" /></p></td>
                </tr>
                <tr>
                    <td><p>生日：<input class="text" name="birthday" style="width:200px" type="text" value="${user.address}" placeholder="输入生日，如：2020-01-02" /></p></td>
                </tr>
                 <tr>
                    <td><input style="width:60%;" class="text" type="password" placeholder="验证码"><a style="margin-left:30px;" href="#">获取验证</a></td>
                </tr> -->
                <tr>
                    <td><input class="submit" type="submit" value="注册"></td>
                </tr>
            </tbody>
        </table>
        </form>
    </div>

</div>
</body>
</html>