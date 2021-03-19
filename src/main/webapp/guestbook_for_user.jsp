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
		<a href="${pageContext.request.contextPath}/comment/u_list/1/5">留言</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="${pageContext.request.contextPath}/index/welcome/1/8">首页</a></li>
			<c:forEach items="${sessionScope.parent}" var="pcp" varStatus="s">
				<c:if test="${cpl.get(s.index).epcId eq pcp.epcId}">
					<li class="current"><a href="${pageContext.request.contextPath}/product/getChildProductList/${pcp.epcId}">${pcp.epcName}</a></li>
				</c:if>
				<c:if test="${cpl.get(s.index).epcId!=pcp.epcId}">
					<li><a href="${pageContext.request.contextPath}/product/getChildProductList/${pcp.epcId}">${pcp.epcName}</a></li>
				</c:if>
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
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<c:forEach items="${sessionScope.parent}" var="pcp">
				<dl>
					<dt>${pcp.epcName}</dt>
					<c:forEach items="${sessionScope.child}" var="pcc">
						<c:if test="${pcp.epcId eq pcc.epcParentId}">
							<dd><a href="#">${pcc.epcName}</a></dd>
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
				<c:forEach items="${sessionScope.recentView}" var="item">
					<dt><img src="${pageContext.request.contextPath}/images/product/${item.epFileName}" /></dt>
					<dd><a href="${pageContext.request.contextPath}/product/view/${item.epId}">${item.epName}</a></dd>
				</c:forEach>
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="guestbook">
			<h2>全部留言</h2>
			<ul>

				<c:forEach items="${commentPageBean.items}" var="comment">
					<li>
						<dl>
							<dt>${comment.ecContent}</dt>
							<dd class="author">
								网友:${comment.ecNickName}
								<span class="timer">${comment.ecCreateTime}</span>
							</dd>
							<dd>${comment.ecReply}</dd>
						</dl>
					</li>
				</c:forEach>
			</ul>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					<li>
						<a href="${pageContext.request.contextPath}/comment/u_list/${commentPageBean.currentPage == 1 ? commentPageBean.currentPage : commentPageBean.currentPage - 1}/5">上一页</a>
					</li>
					<c:forEach begin="${commentPageBean.currentPage > 3 ? commentPageBean.currentPage - 3 : 1}" end="${commentPageBean.totalPages - commentPageBean.currentPage > 3 ? commentPageBean.currentPage + 3  : commentPageBean.totalPages  }" var="i">
						<c:if test="${commentPageBean.currentPage == i}">
							<li class="current"><a href="${pageContext.request.contextPath}/comment/u_list/${i}/5">${i}</a></li>
						</c:if>
						<c:if test="${commentPageBean.currentPage != i}">
							<li><a href="${pageContext.request.contextPath}/comment/u_list/${i}/5">${i}</a></li>
						</c:if>
					</c:forEach>

					<li>
						<a href="${pageContext.request.contextPath}/comment/u_list/${commentPageBean.currentPage == commentPageBean.totalPages ? commentPageBean.currentPage : commentPageBean.currentPage + 1  }/5">下一页</a>
					</li>
					<li>共 ${commentPageBean.totalPages} 页</li>
				</ul>
			</div>
			<div id="reply-box">
				<form id="regForm" action="${pageContext.request.contextPath}/comment/saveU" method="post" onsubmit="return checkForm(this)">
					<table>
						<tr>
							<td class="field">昵称：</td>
							<td><input class="text" type="text" name="ecNickName" onfocus="FocusItem(this)" onblur="CheckItem(this);"  /><span></span></td>
						</tr>
						<tr>
							<td class="field">留言内容：</td>
							<td><textarea style="width: 600px; height:200px" id="comment" name="ecContent" onfocus="FocusItem(this)" onblur="CheckItem(this);"></textarea><span></span></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-blue" style="margin-left: 120px"><input type="submit"  name="submit" value="提交留言" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2016 湖南软测信息技术有限公司 All Rights Reserved. 湘ICP证1001号
</div>
</body>
<script src="http://js.nicedit.com/nicEdit-latest.js" type="text/javascript"></script>
<script type="text/javascript">bkLib.onDomLoaded(nicEditors.allTextAreas);</script>
</html>
