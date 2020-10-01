<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>易买网 - 首页</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/function.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-3.5.1.min.js"></script>
	<script type="text/javascript">
		function backToIndex() {
			location.href="${pageContext.request.contextPath}/product/clearSC";
		}
	</script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="${pageContext.request.contextPath}/images/logo.gif" /></div>
	<div class="help">
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
				<li><a href="#">${pcp.epcName}</a></li>
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
<div id="position" class="wrap">
	您现在的位置：<a href="${pageContext.request.contextPath}/index/welcome/1/8">易买网</a> &gt; 购物车
</div>
<div class="wrap">
	<div id="shopping">
			<table>
				<tr>
					<th width="584">商品名称</th>
					<th width="136">商品价格</th>
					<th width="161">购买数量</th>
					<th width="59">操作</th>
				</tr>
				<c:forEach items="${sessionScope.shoppingCart}" var="product">
					<tr id="product_id_1">
						<td class="thumb">
							<img src="${pageContext.request.contextPath}/images/product/${product.epFileName}" />
							<a href="manage/product-view.jsp">${product.epName}</a>
						</td>
						<td class="price" id="price_id_1">
							<span>￥${product.epPrice}</span>
							<input type="hidden" value="${product.epPrice}" />
						</td>
						<td class="number">
							<dl>
								<dt><input id="number_id_1" type="text" name="number" value="1" disabled="disabled"/></dt>
								<dd onclick="reloadPrice(1,true);">+</dd>
								<dd onclick="reloadPrice(1,false);">-</dd>
							</dl>
						</td>
						<td class="delete"><a href="${pageContext.request.contextPath}/product/deleteSC/${product.epId}">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="button" ><input type="button" onclick="backToIndex()" /></div>
	</div>
	<script type="text/javascript">		
	</script>
</div>
<div id="footer">
	Copyright &copy; 2016 湖南软测信息技术有限公司 All Rights Reserved. 湘ICP证1001号
</div>
</body>
</html>
