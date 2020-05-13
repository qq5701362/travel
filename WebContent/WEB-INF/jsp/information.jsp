<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<base href="<%=basePath%>">
<html>
<head>
<title>最新发布的文章</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-------------jquery库-------------->
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<!-------------Amazeui--------------->
<script type="text/javascript" src="js/amazeui.js"></script>
<link rel="stylesheet" type="text/css" href="css/amazeui.css">
    <!------------核心样式-------------->
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <!--引入页面头部head.html-->
    <%@ include file="/WEB-INF/jsp/commons/head.jsp"%>
    <!------------------子页框架-------------------->
    <div id="sub_from">
        <div class="cw1200">
            <div class="w810 fl">
                <!------------------公共盒子-------------------->
                <div class="public_box bg1">
                    <div class="public_title">
                        <div class="fl">
                            <img src="images/from_title_left.png" onerror="this.src='images/moren.jpg'"/>
                        </div>
                        <div class="con">
                            <div class="lamp_ico">
                                <img src="images/lamp_ico.png" onerror="this.src='images/moren.jpg'"/>
                            </div>
                            <div class="name">
                                                                                    文章详情
                            </div>
                        </div>
                        <div class="fr">
                            <img src="images/from_title_right.png" onerror="this.src='images/moren.jpg'"/>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <!------------------文章-------------------->
                    <div id="article">
                        <div class="title">
                            <h2>${information.title}</h2>
                            <p>
                                发布时间：
                                <fmt:formatDate value="${information.ptime}"
                                    pattern="yyyy-MM-dd HH:mm:ss" />
                            </p>
                            
                        </div>
                        <div class="con">

                            <img src="pic/${information.pic}" />
                            <p>${information.describle}</p>

                        </div>
                    </div>
                </div>
            </div>
            <div class="w380 fr">
               
                   
           <!------------------公共盒子-------------------->
                <div class="public_box bg2">
                    <div class="public_title">
                        <div class="fl">
                            <img src="images/from_title_left.png" onerror="this.src='images/moren.jpg'"/>
                        </div>
                        <div class="con">
                            <div class="lamp_ico">
                                <img src="images/lamp_ico.png" onerror="this.src='images/moren.jpg'"/>
                            </div>
                            <div class="name">
                                <span>最新资讯</span>
                            </div>
                            <div class="more">
                                <a href="${pageContext.request.contextPath}/information/getALLInformations">更多></a>
                            </div>
                        </div>
                        <div class="fr">
                            <img src="images/from_title_right.png" onerror="this.src='images/moren.jpg'"/>
                        </div>
                        <div class="clear"></div>
                    </div>
                    <!------------------公共推荐-------------------->
                    <div id="activity_recom">
                        <ul>
                            <c:forEach items="${informationsList}" var="information">
                                <li>
                                    <div class="pic">
                                        <a title="" href="${pageContext.request.contextPath}/information/getInformation?id=${information.id}"><img alt="" class="scale-effect"
                                            src="pic/${information.pic}" onerror="this.src='images/moren.jpg'"/></a>
                                    </div>
                                    <div class="con">
                                        <a href="${pageContext.request.contextPath}/information/getInformation?id=${information.id}">${information.title}</a> <span><i
                                            class="am-icon-clock-o"></i><fmt:formatDate value="${information.ptime}"
                                    pattern="yyyy-MM-dd HH:mm:ss" /></span>
                                    </div>
                                    <div class="clear"></div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>

    <!-----------------版底---------------->
    <!--引入尾部-->
    <%@ include file="/WEB-INF/jsp/commons/foot.jsp"%>
</body>
</html>