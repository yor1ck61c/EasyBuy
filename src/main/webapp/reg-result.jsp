<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${pageContext.request.contextPath}/images/logo.gif" /></div>
	<div class="help"><a href="${pageContext.request.contextPath}/shopping.jsp" class="shopping">购物车</a>
		<c:if test="${sessionScope.user == null}" >
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
		<a href="${pageContext.request.contextPath}/comment/u_list/1/5">留言</a>
	</div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="${pageContext.request.contextPath}/index/welcome/1/8">首页</a></li>
			<c:forEach items="${sessionScope.parent}" var="pcp" >
				<li><a href="${pageContext.request.contextPath}/product/getChildProductList/${pcp.epcId}">${pcp.epcName}</a></li>
			</c:forEach>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<c:forEach items="${sessionScope.child}" var="pcc" varStatus="status" begin="1" end="4">
				<c:if test="${status.index + 1} == 1">
					<li class="first"><a href="#">${pcc.epcName}</a></li>
				</c:if>
				<c:if test="${status.index + 1} == 4">
					<li class="last"><a href="#">${pcc.epcName}</a></li>
				</c:if>
			</c:forEach>
		</ul>
	</div>
</div>
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎注册易买网</h1>
			<ul class="steps clearfix">
				<li class="finished"><em></em>填写注册信息</li>
				<li class="last-current"><em></em>注册成功</li>
			</ul>
			<div class="msg">
				<p>恭喜：注册成功！</p>
				<p>正在进入首页...</p>
				<script type="text/javascript">
					setTimeout("location.href='${pageContext.request.contextPath}/index/welcome/1/8'", 3000);
				</script>
			</div>
		</div>
	</div>
</div>
<div id="footer">
	Copyright &copy; 2016 湖南软测信息技术有限公司 All Rights Reserved. 湘ICP证1001号
</div>
</body>
</html>
