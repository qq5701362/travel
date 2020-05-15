﻿<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<base href="<%=basePath%>">
<head>
<title>购票详情</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-------------jquery库(图片放大，切换展示)-------------->
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- <script type="text/javascript" src="js/jquery.min.js"></script> -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>   
<!-------------Amazeui--------------->
<script type="text/javascript" src="js/amazeui.js"></script>
<link rel="stylesheet" type="text/css" href="css/amazeui.css">
<!------------核心样式-------------->
<link rel="stylesheet" type="text/css" href="css/style.css">
<!-- <link href="css/bootstrap.min.css" rel="stylesheet"> -->
</head>
<body>
    <!-------------------工具栏------------------->
    <!--引入页面头部head.html-->
    <%@ include file="/WEB-INF/jsp/commons/head.jsp"%>
    <!------------------子页框架-------------------->
    <div id="sub_from" style="padding-top: 10px;">
        <div class="cw1200">
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
                                                                         门票信息
                        </div>
                    </div>
                    <div class="fr"> 
                        <img src="images/from_title_right.png" onerror="this.src='images/moren.jpg'"/>
                    </div>
                    <div class="clear"></div>
                </div>
                <!------------------购票信息-------------------->
                <div id="item_info">
                    <!-----------------主图---------------->
                    <div class="preview">
                        <div id="vertical" class="bigImg">
                            <img src="pic/${ticket.pic1}" id="midimg" onerror="this.src='images/moren.jpg'"/>
                            
                        </div>
                        <div id="imageMenu">
                            <ul>
                                <li id="onlickImg"><img src="pic/${ticket.pic1}" /></li>
                                <li><img src="pic/${ticket.pic2}" onerror="this.src='images/moren.jpg'"/></li>
                                <li><img src="pic/${ticket.pic3}" onerror="this.src='images/moren.jpg'"/></li>
                            </ul>
                        </div>
                        
                    </div>
                    <!-----------------内容信息---------------->
                    <div class="cont_info">
                        <div class="name">
                        
                            <h2>${ticket.name}</h2>
                        </div>
                        <!-------------商品属性（价位数量）---------------->
                        <div class="p_number">
                            <div class="unit_price">
                                <ul>
                                    <li class="fl">票价：<strong id="price_item_1">￥${ticket.cost}元</strong></li>
                                    
                                    <div class="clear"></div>
                                </ul>
                            </div>
                            <!------------购票规格-------------->
                            <script type="text/javascript">
                                $(
                                function() {
                                    $(".yListr ul li em").click(
                                        function() {
                                                $(this).addClass("yListrclickem").siblings().removeClass("yListrclickem");})
                                        })
                            </script>
                            <!-- 表单提交 -->
                            <form action="${pageContext.request.contextPath}/synopsis/ticketPay" method="post">  
                                        <!-------------数量增减变动价格-------------->
                                        <script type="text/javascript" src="js/payfor.js"></script>
                                        <div class="add_chose">
                                            <label>数量：</label> 
                                            <a class="reduce" onClick="setAmount.reduce('#qty_item_1')" href="javascript:void(0)">-</a> 
                                
                                                 <!--订购门票数量 -->
                                                 <input type="text" name="qty_item_1" value="1" id="qty_item_1" onKeyUp="setAmount.modify('#qty_item_1')" class="text" />
                                                 <a class="add" onClick="setAmount.add('#qty_item_1')" href="javascript:void(0)">+</a> 
                                                 <!-- <span>库存：999张</span> -->
                                            <div class="clear"></div>
                                        </div>
                                        <div class="buy">
                                            <ul>
                                                <li>总价：<span class="total-font" id="total_item_1">￥0.00</span>元</li>
                                               <!-- <li><span class="jifen">购票可获得：<b
                                                        id="total_points">5</b>积分
                                                </span></li> --> 
                                                
                                               <!--  <li>运费：<span class="tp_bg">无需运费</span></li>  -->
                                                <li>提醒：<span class="tp_bg">订票解释权归三娘湾景区所有</span></li>
                                            </ul>
                                      </div>
                                        <input type="hidden" name="id" value="${ticket.id}">
			                            <input type="hidden" name="scenicname" value="${ticket.name}">
			                            <input type="hidden" name="cost" value="${ticket.cost}">
			                            <input type="hidden" name="pic"  value="${ticket.pic1}">
                                        <div id="ss"><input id="go_buy" style="margin-top:40px;" type="submit" value="立即购票"/>
                                        </div>
                            </form>
                            
                        </div>
                        
                    </div>
                </div>
                
                <div class="clear"></div>
            
            </div>
            
        
    </div>

    <!-----------------版底---------------->
    <!--引入尾部-->
    <%@ include file="/WEB-INF/jsp/commons/foot.jsp"%>




    <!-----------------产品主图特效---------------->
    <script type="text/javascript">
        $(document).ready(function() {
           // 图片上下滚动
           var count = $("#imageMenu li").length - 5; /* 显示 6 个 li标签内容 */
           var interval = $("#imageMenu li:first").width();
           var curIndex = 0;

           $('.scrollbutton').click(function() {
               if ($(this).hasClass('disabled'))
                   return false;

               if ($(this).hasClass('smallImgUp')){
                   --curIndex;
               }else {
                   ++curIndex;
               }
                   

               $('.scrollbutton').removeClass('disabled');
               if (curIndex == 0)
                   $('.smallImgUp').addClass('disabled');
               if (curIndex == count - 1)
                   $('.smallImgDown').addClass('disabled');

               $("#imageMenu ul").stop(false, true).animate({
                   "marginLeft" : -curIndex * interval + "px"
               }, 600);
           });

          // 解决 ie6 select框 问题
          $.fn.decorateIframe = function(options) {
              if ($.browser.msie && $.browser.version < 7) {
                  var opts = $.extend({},$.fn.decorateIframe.defaults,options);
                  $(this).each(function() {
                      var $myThis = $(this);
                      //创建一个IFRAME
                      var divIframe = $("<iframe />");
                      divIframe.attr("id",opts.iframeId);
                      divIframe.css("position","absolute");
                      divIframe.css("display","none");
                      divIframe.css("display","block");
                      divIframe.css("z-index",opts.iframeZIndex);
                      divIframe.css("border");
                      divIframe.css("top","0");
                      divIframe.css("left","0");
                      if (opts.width == 0) {
                          divIframe.css(
                             "width",
                             $myThis.width()+ parseInt($myThis.css("padding"))* 2 + "px"
                          );
                      }
                     if (opts.height == 0) {
                         divIframe.css(
                            "height",
                            $myThis.height() + parseInt($myThis.css("padding"))* 2 + "px"
                         );
                     }
                     divIframe.css("filter","mask(color=#fff)");
                     $myThis.append(divIframe);
                 });
              }
          }
          $.fn.decorateIframe.defaults = {
              iframeId : "decorateIframe1",
              iframeZIndex : -1,
              width : 0,
              height : 0
          }
          

          //点击到中图
          var midChangeHandler = null;

          $("#imageMenu li img").bind("click",function() {
              if ($(this).attr("id") != "onlickImg") {
                  midChange($(this).attr("src").replace("small", "mid"));
                  $("#imageMenu li").removeAttr("id");
                  $(this).parent().attr("id","onlickImg");
              }
          }).bind("mouseover",function() {
              if ($(this).attr("id") != "onlickImg") {
                 window.clearTimeout(midChangeHandler);
                 midChange($(this).attr("src").replace("small", "mid"));
                 $(this).css();
             }
         }).bind("mouseout",function() {
            if ($(this).attr("id") != "onlickImg") {
                $(this).removeAttr("style");
                midChangeHandler = window.setTimeout(function() {
                    midChange($("#onlickImg img").attr("src").replace("small","mid"));
                }, 1000);
            }
        });

        function midChange(src) {
            $("#midimg").attr("src", src).load(function() {
                changeViewImg();
            });
        }

          
      });
    </script>
</body>
</html>