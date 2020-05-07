<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <header> <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed"
                data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                aria-expanded="false">
                <span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">三娘湾旅游网管理后台</a>
        </div>
        <div class="collapse navbar-collapse"
            id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <!-- <li><a href="">消息 <span class="badge">1</span></a></li> -->
                <li class="dropdown">
                <a class="dropdown-toggle"  role="button" aria-haspopup="true" aria-expanded="false">admin </a>
                    <!-- <ul class="dropdown-menu dropdown-menu-left">
                        <li>
                            <a onclick="viewUser()" title="查看或修改个人信息" data-toggle="modal" data-target="#seeUserInfo" id="userView">个人信息</a>
                        </li>
                    </ul> -->
                </li>
                <li><a href="${pageContext.request.contextPath}/backCheck/logout" onClick="if(!confirm('是否确认退出？'))return false;">退出登录</a></li>
                <!-- <li><a data-toggle="modal" data-target="#WeChat">帮助</a></li> -->
            </ul>
            
        </div>
    </div>
    </nav> </header>
</body>
</html>