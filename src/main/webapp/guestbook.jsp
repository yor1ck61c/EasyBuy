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
			<li><a href="${pageContext.request.contextPath}/user/userList/1/10">用户</a></li>
			<li><a href="${pageContext.request.contextPath}/product/list/1/3">商品</a></li>
			<li><a href="${pageContext.request.contextPath}/order/list/1/5">订单</a></li>
			<li class="current"><a href="${pageContext.request.contextPath}/comment/list/1/5">留言</a></li>
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
								<a href="${pageContext.request.contextPath}/comment/delete/${comment.ecId}" style="float: right">删除</a>
								<c:if test="${comment.ecReply == null}">
									<a href="${pageContext.request.contextPath}/comment/reply/${comment.ecId}" style="float: right; margin-right: 5px">回复</a>
								</c:if>
								<c:if test="${comment.ecReply != null}">
									<a href="${pageContext.request.contextPath}/comment/reply/${comment.ecId}" style="float: right; margin-right: 5px">修改</a>
								</c:if>
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
						<a href="${pageContext.request.contextPath}/comment/list/${commentPageBean.currentPage == 1 ? commentPageBean.currentPage : commentPageBean.currentPage - 1}/5">上一页</a>
					</li>
					<c:forEach begin="${commentPageBean.currentPage > 3 ? commentPageBean.currentPage - 3 : 1}" end="${commentPageBean.totalPages - commentPageBean.currentPage > 3 ? commentPageBean.currentPage + 3  : commentPageBean.totalPages  }" var="i">
						<c:if test="${commentPageBean.currentPage == i}">
							<li class="current"><a href="${pageContext.request.contextPath}/comment/list/${i}/5">${i}</a></li>
						</c:if>
						<c:if test="${commentPageBean.currentPage != i}">
							<li><a href="${pageContext.request.contextPath}/comment/list/${i}/5">${i}</a></li>
						</c:if>
					</c:forEach>

					<li>
						<a href="${pageContext.request.contextPath}/comment/list/${commentPageBean.currentPage == commentPageBean.totalPages ? commentPageBean.currentPage : commentPageBean.currentPage + 1  }/5">下一页</a>
					</li>
					<li>共 ${commentPageBean.totalPages} 页</li>
				</ul>
			</div>
			<div id="reply-box">
				<form id="regForm" action="${pageContext.request.contextPath}/comment/save" method="post" onsubmit="return checkForm(this)">
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
