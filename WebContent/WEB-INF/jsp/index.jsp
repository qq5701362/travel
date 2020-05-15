<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>三娘湾景区旅游管理系统</title>
<!-- Bootstrap -->
<script type="text/javascript" src="js/jquery.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">     
<script type="text/javascript" src="js/bootstrap.min.js"></script>    
<!---Amazeui-->   
<script type="text/javascript" src="js/amazeui.js"></script>      
<link rel="stylesheet" type="text/css" href="css/amazeui.css">
<!---核心样式-->

<link rel="stylesheet" type="text/css" href="css/style.css">


</head>
<body>
    <script type="text/javascript">
    /*     轮播图 */
         $(function() {
            $.ajax({
                type : 'post',
                url :  '${pageContext.request.contextPath}/requestAds.action', 
                success : function(data) {//返回json结果 
                    var html = '';
                    $.each(data, function(i, item) {//each()函数遍历
                        if(i==0)
                                html+='<div  class="item active"><img src="pic/'+item.pic+'"></div>'
                                else
                                    html+='<div class="item"><img src="pic/'+item.pic+'"></div>';    
                    });
                    $('.carousel-inner').html(html);  //Bootstrap 轮播（Carousel）插件是一种灵活的响应式的向站点添加滑块的方式
                    
                }

            });
        }); 
        
    //三娘湾美景
          $(function() {
            $.ajax({
                type : 'post',
                url : '${pageContext.request.contextPath}/requestScenic.action',
                //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
                //contentType:'application/json;charset=utf-8',
                //数据格式是json串，商品信息
                success : function(data) {//返回json结果 
                    var html1 = '';
                    var html2 = '';
                    $.each(data, function(i, item) {//each()函数遍历
                        if(i<5){
                            html1+='<li><a href="${pageContext.request.contextPath}/scenic/getIndexScenic?id='+item.contentid+'"><span>'+item.title+'</span><img class="scale-effect" src=pic/'+item.pic+' /></a></li>'
                        }
                         else{
                             html2+='<li><a href="${pageContext.request.contextPath}/scenic/getIndexScenic?id='+item.contentid+'"><span>'+item.title+'</span><img class="scale-effect" src=pic/'+item.pic+' /></a></li>'
                        }
                        if(i==9){
                            $('.scerney1').html(html1);
                            $('.scerney2').html(html2);
                        }
                                    
                    });
                }

            });
        });
    
          //三娘湾特产 
            $(function() {
                $.ajax({
                    type : 'post',
                    url : '${pageContext.request.contextPath}/requestSpecialty.action',
                    //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
                    //contentType:'application/json;charset=utf-8',
                    //数据格式是json串，商品信息

                    success : function(data) {//返回json结果 
                        var html = '';
                        $.each(data, function(i,item) {
                                    html+='<li><a  href="${pageContext.request.contextPath}/specialty/getSpecialty?tnum='+item.areanum+'&id='+item.contentid+'"> <img title="" class="scale-effect" src=pic/'+item.pic+' /><p>'+item.title+'</p></a></li>'
                        });
                        
                        $('.fc').html(html);
                        
                    }

                });
            });
          
            //三娘湾游记
            $(function() {
                $.ajax({
                    type : 'post',
                    url : '${pageContext.request.contextPath}/requestTravels.action',
                    //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
                    //contentType:'application/json;charset=utf-8',
                    //数据格式是json串，商品信息

                    success : function(data) {//返回json结果 
                        var html = '';
                        $.each(data, function(i,item) {    
                        html+='<li>'
                        +'<div class="box">'
                             +'<div class="pic"><a title="" href="${pageContext.request.contextPath}/travel/travelArticle?id='+item.id+'"><img alt="" class="scale-effect" src=pic/'+item.pic1+' /></a></div>'
                            +'<div class="user">'
                             +'<div class="head"><img alt="" src=pic/'+item.userimag+' /></div>'
                             +'<p>'+item.username+'</p>'
                                +'<span><label><img alt="" src="images/state_icon1.png" />'+item.readnum+'</label></span>'
                            +'</div>'
                         +'<div class="cont">'
                                +'<a title="" href="${pageContext.request.contextPath}/travel/travelArticle?id='+item.id+'"><h3>'+item.title+'</h3></a>'
                                +'<p>'+item.signature+'</p>'
                         +'</div>'
                        +'</div>'
                             +'</li>'
                              
                        });
                        
                        $('#tour').html(html); 
                        
                    }

                });
            });
            
            
          
             /*新闻活动资讯、头条 */
            $(function() {
                $.ajax({
                    type : 'post',
                    url : '${pageContext.request.contextPath}/requestInformation.action',
                    //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
                    //contentType:'application/json;charset=utf-8',
                    //数据格式是json串，商品信息
                    data : 'value=11',

                    success : function(data) {//返回json结果 
                        var html1 = '';
                        var html2 = '';
                        $.each(data, function(i,item) {
                            var time = new Date(item.ptime) ;
                            commonTime = time.toLocaleString();//toLocaleString() 方法可根据本地时间把 Date 对象转换为字符串，并返回结果。
                            if(i<4){
                                    html1+='<li><a  href="${pageContext.request.contextPath}/information/getInformation?id='+item.id+'"> <img title="" class="scale-effect" src=pic/'+item.pic+' /><p>'+item.title+'</p></a></li>'
                            }
                            html2+='<li><a title="" href="${pageContext.request.contextPath}/information/getInformation?id='+item.id+'">'+item.title+'</a><span>'+commonTime+'</span></li>'        
                        });
                            html2+='<li><a title="" href="${pageContext.request.contextPath}/information/getALLInformations">更多</a><li>'
                            $('.a_new').html(html1);
                            $('.list').html(html2);
                        
                        
                        
                    }

                });
            });
    </script>

    <!--引入页面头部head.html-->
    <%@ include file="/WEB-INF/jsp/commons/head.jsp"%>
    <!------------------banner-------------------->
    <script src="js/jquery.superslide.2.1.1.js" type="text/javascript"></script>
    </script>
    <!-- 轮播图 -->
        <div id="myCarousel" class="carousel slide">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                 <!--  添加图片信息  -->
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="left carousel-control" href="#myCarousel" role="button"
                data-slide="prev"> <span
                class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a> <a class="right carousel-control" href="#myCarousel" role="button"
                data-slide="next"> <span
                class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
<!------------------三娘湾美景-------------------->
    <div id="h_scenic">
        <div class="cw1200">
            <div class="title">
                <img alt="" src="images/title_1.jpg" />
            </div>
            <div class="con">
                <div class="tag">
                    <img alt="" src="images/h_title2_1.jpg" />
                </div>
                
                <div class="box">
                    <ul class="scerney1">
                        <!-- 动态插入 -->
                        <div class="clear"></div>
                    </ul>
                    <div class="more">景区景点</div>
                </div>
                
                <div class="box">
                    <ul class="scerney2">
                            <!-- 动态插入 -->
                        <div class="clear"></div>
                    </ul>
                    <div class="more">景区景点</div>
               </div>
               
                <div class="clear"></div>
            </div>
        </div>
    </div>
    <!------------------钦州美食-------------------->
    <div id="h_project">
        <div class="cw1200">
            <div class="title">
                <img alt="" src="images/title_2.jpg" onerror="this.src='images/moren.jpg'"/>
            </div>
            <div class="con">
                <ul class="fc">
                    <!-- 动态插入 -->
                </ul>
            </div>
        </div>
    </div>
    <!------------------我想说......-------------------->
    <div id="h_note">
        <div class="cw1200">
            <div class="title">
                <img alt="" src="images/title_3.jpg" onerror="this.src='images/moren.jpg'"/>
            </div>
            <div class="con">
                <ul id="tour">
                    <div class="clear"></div>
                </ul>
            </div>
        </div>
    </div>
    <!------------------首页新闻-------------------->
    <div id="h_news">
        <div class="cw1200">
            <div class="activity_news fl">
                <div class="title">
                    <img alt="" src="images/h_title6.png" onerror="this.src='images/moren.jpg'"/>
                </div>
                
                <!-- 活动资讯 -->
                <div class="con">
                    <ul class="a_new">
                        <!-- 动态插入活动资讯 -->
                    </ul>
                </div>
                
                
            </div>
            <div class="hot_news fr">
                <div class="title">
                    <img src="images/h_title7.png" onerror="this.src='images/moren.jpg'"/>
                </div>
                <div class="con">
                 <!--   热点资讯 -->
                    <div class="list">
                        <ul>
                            <!-- 动态插入热点资讯 -->
                        </ul>
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
    <!--引入尾部-->
    <%@ include file="/WEB-INF/jsp/commons/foot.jsp"%>
</body>
</html>