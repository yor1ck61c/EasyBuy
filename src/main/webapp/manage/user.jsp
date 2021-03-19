<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>后台管理 - 易买网</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function-manage.js"></script>
	<script type="text/javascript">
		function deleteUser(userId) {
			if (confirm("您确认要删除吗")) {
				location.href = "${pageContext.request.contextPath}/user/delUser/" + userId;
			}
		}
	</script>
	<script type="text/javascript">
		window.onload = function() {
			var show = document.getElementById("show");
			setInterval(function() {
				var time = new Date();   // 程序计时的月从0开始取值后+1
				var m = time.getMonth() + 1;
				var t = time.getFullYear() + "-" + m + "-"
						+ time.getDate() + " " + time.getHours() + ":"
						+ time.getMinutes() + ":" + time.getSeconds();
				show.innerHTML = t;
			}, 1000);
		};
	</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${pageContext.request.contextPath}/images/logo.gif" /></div>
	<div class="help"><a href="${pageContext.request.contextPath}/index/welcome/1/8">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="${pageContext.request.contextPath}/index/welcome/1/8">首页</a></li>
			<li class="current"><a href="${pageContext.request.contextPath}/user/userList/1/10">用户</a></li>
			<li><a href="${pageContext.request.contextPath}/product/list/1/3">商品</a></li>
			<li><a href="${pageContext.request.contextPath}/order/list/1/5">订单</a></li>
			<li><a href="${pageContext.request.contextPath}/comment/list/1/5">留言</a></li>
			<li><a href="${pageContext.request.contextPath}/news/list/1/4">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员${sessionScope.user.euUserName}您好，现在是<span id="show"></span>，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="${pageContext.request.contextPath}/index/welcome/1/8">易买网</a> &gt; 管理后台
</div>

<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<div class="box">
			<%@include file="/lefter.jsp"%>
		</div>
	</div>
	<div class="main">
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list" style="text-align: center">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>Email</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<c:forEach items="${ebUser.items}" var="ebUser">
					<tr>
						<td>${ebUser.euUserId}</td>
						<td>${ebUser.euUserName}</td>
						<td>${ebUser.euSex}</td>
						<td>${ebUser.euEmail}</td>
						<td>${ebUser.euMobile}</td>
						<td>
                            <a href="${pageContext.request.contextPath}/user/beforeUpdate/${ebUser.euUserId}" >更改</a>
                            <a href="javascript:void(0);" onclick="deleteUser('${ebUser.euUserId}')" >删除</a>
                        </td>
					</tr>
				</c:forEach>

			</table>
		</div>
		<div class="pager" style="margin-left: 100px">
			<ul class="clearfix">
				<c:forEach begin="1" end="${ebUser.totalPages}" var="i">
					<c:if test="${ebUser.currentPage == i}">
						<li class="current"><a href="${pageContext.request.contextPath}/user/userList/${i}/10">${i}</a></li>
					</c:if>
					<c:if test="${ebUser.currentPage != i}">
						<li><a href="${pageContext.request.contextPath}/user/userList/${i}/10">${i}</a></li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2016 湖南软测信息技术有限公司 All Rights Reserved. 湘ICP证1001号
</div>
</body>
</html>
