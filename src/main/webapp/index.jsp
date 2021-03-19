<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--导入JSTL标签库--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>amazon海外购</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-3.5.1.min.js"></script>
</head>
<body >
<div id="header" class="wrap">
    <div id="logo" style="margin-right: 50px"><img style="width: 150px;height: 50px" src="${pageContext.request.contextPath}/images/logo.gif" /></div>
    <div class="help"><a href="${pageContext.request.contextPath}/shopping.jsp" class="shopping">购物车</a> <%--跳转至购物车--%>
        <c:if test="${sessionScope.user == null}" ><%--登录成功改变状态栏，并根据用户身份信息开放进入后台的权限--%>
            <a href="${pageContext.request.contextPath}/login.jsp">登录</a>
            <a href="${pageContext.request.contextPath}/register.jsp">注册</a>
        </c:if>
        <c:if test="${sessionScope.user != null}">
            <c:if test="${sessionScope.user.euStatus == 1}">
                欢迎您!${user.euUserName}
                <a href="${pageContext.request.contextPath}/user/quit">退出登录</a>
            </c:if>
            <c:if test="${sessionScope.user.euStatus == 2}">
                欢迎您!${user.euUserName}
                <a href="${pageContext.request.contextPath}/manage/manage.jsp">进入后台管理</a>
                <a href="${pageContext.request.contextPath}/user/quit">退出登录</a>
            </c:if>
        </c:if>
        <a href="${pageContext.request.contextPath}/comment/u_list/1/5">留言</a><%--进入留言板--%>
    </div>
    <div class="navbar">
        <ul class="clearfix">
            <li class="current"><a href="${pageContext.request.contextPath}/index/welcome/1/8">首页</a></li><%--返回首页连接--%>
            <c:forEach items="${sessionScope.parent}" var="pcp" ><%--展示父分类--%>
                <li><a href="${pageContext.request.contextPath}/product/getChildProductList/${pcp.epcId}">${pcp.epcName}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>
<div id="childNav">
    <div class="wrap">
        <form method="post" action="${pageContext.request.contextPath}/product/search"><%--搜索指定商品--%>
            <div style="margin-top: 3px;float: right; color: gainsboro">
                <label>
                   想买点啥：<input type="text" name="epName" style="color: black" placeholder="输入你想要购买的商品..."/>
                </label>
                <input type="button" value="搜索"/>
            </div>
        </form>
    </div>
</div>
<div id="main" class="wrap">
    <div class="lefter">
        <div class="box">
            <h2>商品分类</h2>
            <c:forEach items="${sessionScope.parent}" var="pcp">
                <%--
                二重循环展示商品的父分类以及下面的子分类，pcp为父类，pcc为子类
                并附带跳转功能，点击可链接到指定商品
                --%>
                <dl>
                    <dt>${pcp.epcName}</dt>
                    <c:forEach items="${sessionScope.child}" var="pcc">
                        <c:if test="${pcp.epcId eq pcc.epcParentId}">
                            <dd><a href="${pageContext.request.contextPath}/product/getChildProductList/${pcp.epcId}">${pcc.epcName}</a></dd>
                        </c:if>
                    </c:forEach>
                </dl>
            </c:forEach>
        </div>
        <div class="spacer">

        </div>
        <div class="last-view">
            <h2>最近浏览</h2>
            <dl class="clearfix">
                <%--
                最近浏览功能模块
                附带跳转功能，点击可链接到指定商品
                --%>
                <c:forEach items="${sessionScope.recentView}" var="item">
                    <dt><img src="${pageContext.request.contextPath}/images/product/${item.epFileName}" /></dt>
                    <dd><a href="${pageContext.request.contextPath}/product/view/${item.epId}">${item.epName}</a></dd>
                </c:forEach>
            </dl>
        </div>
    </div>
    <div class="main">
        <div class="price-off">
            <h2>商品列表</h2>
            <ul class="product clearfix">
                <%--
                商品展示部分
                附带跳转功能，点击可链接到指定商品
                --%>
                <c:forEach items="${products.items}" var="product">
                    <li>
                        <dl>
                            <dt>
                                <a href="${pageContext.request.contextPath}/product/view/${product.epId}" target="_blank">
                                <img src="${pageContext.request.contextPath}/images/product/${product.epFileName}" />
                                </a>
                            </dt>
                            <dd class="title">
                                <a href="${pageContext.request.contextPath}/product/view/${product.epId}" target="_blank">${product.epName}
                                </a>
                            </dd>
                            <dd class="price">￥${product.epPrice}</dd>
                        </dl>
                    </li>
                </c:forEach>

                
            </ul>
            <%--
            页码显示部分
            默认每页显示8个商品，从第一页开始展示，当前页特殊显示
            可根据页码，或超链接跳转至其他页面
            并显示总页数
            --%>
            <div class="pager">
                <ul class="clearfix">
                    <li>
                        <a href="${pageContext.request.contextPath}/index/welcome/${products.currentPage == 1 ? products.currentPage : products.currentPage - 1}/8">上一页</a>
                    </li>
                    <c:forEach begin="${products.currentPage > 8 ? products.currentPage - 8 : 1}" end="${products.totalPages - products.currentPage > 8 ? products.currentPage + 8  : products.totalPages  }" var="i">
                        <c:if test="${products.currentPage == i}">
                            <li class="current"><a href="${pageContext.request.contextPath}/index/welcome/${i}/8">${i}</a></li>
                        </c:if>
                        <c:if test="${products.currentPage != i}">
                            <li><a href="${pageContext.request.contextPath}/index/welcome/${i}/8">${i}</a></li>
                        </c:if>
                    </c:forEach>
                    <li>
                        <a href="${pageContext.request.contextPath}/index/welcome/${products.currentPage == products.totalPages ? products.currentPage : products.currentPage + 1  }/8">下一页</a>
                    </li>
                    <li>共 ${products.totalPages} 页</li>
                </ul>
            </div>

        </div>
        <div class="side">
            <div class="spacer"></div>
            <div class="news-list">
                <h4>新闻动态</h4>
                <ul>
                    <%--所有新闻展示，并附带跳转至特定新闻功能--%>
                    <c:forEach items="${news}" var="new_msg">
                        <li><a href="${pageContext.request.contextPath}/news/lists/1/3" target="_blank">${new_msg.enTitle}</a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2016 湖南软测信息技术有限公司 All Rights Reserved. 湘ICP证1001号
</div>
</body>
</html>
