<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-3.5.1.js"></script>
<script type="text/javascript">
	function alert_msg() {
		var username = $("#username").val();
		$.ajax({
			url:"${pageContext.request.contextPath}/user/checkUsername",
			type:"POST",
			data:{"username":username},
			success:function (data) {
				alert(data);
			},
			dataType:"text"
		})
	}
	function checkUsername() {
		var username = $("#username").val();
		$.ajax({
			url:"/user/checkUsername",
			type:"POST",
			data:{"username":username},
			success:function (data) {
				alert(data);
			},
		})
	}
</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img style="width: 150px;height: 50px" src="${pageContext.request.contextPath}/images/logo.gif" /></div>
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
			<h1>欢迎注册amazon海外购</h1>
			<ul class="steps clearfix">
				<li class="current"><em></em>填写注册信息</li>
				<li class="last"><em></em>注册成功</li>
			</ul>
			<form id="regForm" method="post" action="${pageContext.request.contextPath}/user/register" onsubmit="return checkForm(this);">
				<table>
					<tr>
						<td class="field">用户名(*)：</td>
						<td>
							<input class="text" id="username" type="text" name="euUserId" onfocus="FocusItem(this)"  />
							<a type="button" onclick="alert_msg()">检查用户名是否可用</a>
							<span></span>
						</td>
					</tr>
                    <tr>
						<td class="field">真实姓名(*)：</td>
						<td><input class="text" type="text" name="euUserName" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">登录密码(*)：</td>
						<td><input class="text" type="password" id="euPassword" name="euPassword" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">确认密码(*)：</td>
						<td><input class="text" type="password" name="rePassWord" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">性别(*)：</td>
						<td><input type="radio" name="euSex" checked="checked" value="T"/>男
						<input type="radio" name="euSex" value="F"/>女<span></span></td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td><input type="date" name="euBirthday"/></td>

					</tr>
                    <tr>
						<td class="field">身份证：</td>
						<td><input class="text" type="text" name="euIdentityCode" onfocus="FocusItem(this)" onblur="CheckItem(this);"/><span></span></td>
					</tr>
					<tr>
						<td class="field">电子邮件：</td>
						<td><input class="text" type="text" name="euEmail" onfocus="FocusItem(this)" onblur="CheckItem(this);"/><span></span></td>
					</tr>
                    <tr>
						<td class="field">手机：</td>
						<td><input class="text" type="text" name="euMobile" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">地址(*)：</td>
						<td><input class="text" type="text" name="euAddress" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" value="提交注册" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2016 湖南软测信息技术有限公司 All Rights Reserved. 湘ICP证1001号
</div>
</body>
</html>
