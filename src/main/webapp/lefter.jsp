<%--
  Created by IntelliJ IDEA.
  User: 我今天一定要早睡
  Date: 2020/9/15
  Time: 9:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java"  pageEncoding="UTF-8"%>
<div id="main" class="wrap">
    <div id="menu-mng" class="lefter">
        <div class="box">
            <dl>
                <dt>用户管理</dt>
                <dd><em><a href="${pageContext.request.contextPath}/index/addUser">新增用户</a></em><a href="${pageContext.request.contextPath}/user/userList/1/10">用户管理</a></dd>
                <dt>商品信息</dt>
                <dd><em><a href="${pageContext.request.contextPath}/manage/productClass-add.jsp">新增分类</a></em>
                    <a href="${pageContext.request.contextPath}/productCategory/list/1/5">分类管理</a></dd>
                <dd><em><a href="${pageContext.request.contextPath}/product/add">新增商品</a></em><a href="${pageContext.request.contextPath}/product/list/1/3">商品管理</a></dd>
                <dt>订单管理</dt>
                <dd><a href="${pageContext.request.contextPath}/order/list/1/5">订单管理</a></dd>
                <dt>留言管理</dt>
                <dd><a href="${pageContext.request.contextPath}/comment/list/1/5">留言管理</a></dd>
                <dt>新闻管理</dt>
                <dd><em><a href="${pageContext.request.contextPath}/manage/news-add.jsp">新增新闻</a></em><a href="${pageContext.request.contextPath}/news/list/1/3">新闻管理</a></dd>
            </dl>
        </div>
    </div>
</div>
