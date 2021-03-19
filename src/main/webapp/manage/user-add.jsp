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
		<h2>新增用户</h2>
		<div class="manage">
			<form id="regForm" method="post" action="${pageContext.request.contextPath}/user/register" onsubmit="return checkForm(this);">
				<table>
					<tr>
						<td class="field">用户名(*)：</td>
						<td><input class="text" type="text" name="euUserId" onfocus="FocusItem(this)" onblur="doAjax(this,'servlet/CheckUserNameAction?userName='+this.value);" /><span></span></td>
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
						<td><label class="ui-green"><input type="submit" name="submit" value="新增" /></label></td>
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
