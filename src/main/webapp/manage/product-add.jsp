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
		<h2>添加商品</h2>
		<div class="manage">
			<%--
			表单提交至product的Controller层中。
			因为要上传图片，需要添加属性enctype="multipart/form-data"
			并使用post方式提交
			--%>
			<form action="${pageContext.request.contextPath}/product/save" enctype="multipart/form-data" method="post">
			  <table class="form">
			    <tr>
			      <td class="field">商品名称(*)：</td>
			      <td><input type="text" class="text" name="epName" value="索尼WH-1000X-M3" /></td>
		        </tr>
			    <tr>
			      <td class="field">描述：</td>
			      <td><input name="epDescription" type="text" class="text" id="productDescription" /></td>
		        </tr>
			    <tr>
			      <td class="field">所属分类：</td>
			      <td><select name="epcId">
			        <option value="545">生活用品</option>
			        <option value="545">├ 电子产品</option>
			        <option value="545">└ 办公用品</option>
			        <option value="546">图书</option>
			        <option value="548">化妆品                                                                                                                                        </option>
			        </select></td>
		        </tr>
			    <tr>
			      <td class="field">商品价格：</td>
			      <td><input type="text" class="text tiny" name="epPrice" />
			        元</td>
		        </tr>
			    <tr>
			      <td class="field">库存：</td>
			      <td><input type="text" class="text tiny" name="epStock" id="epStock" /></td>
		        </tr>
			    <tr>
			      <td class="field">商品图片：</td>
			      <td><input type="file"  name="file" id="productFileName" /></td>
		        </tr>
			    <tr>
			      <td></td>
			      <td><label class="ui-blue">
			        <input type="submit" name="submit" value="添加" />
			        </label></td>
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
