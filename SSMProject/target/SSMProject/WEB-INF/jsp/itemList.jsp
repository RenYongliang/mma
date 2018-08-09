<%--
  Created by IntelliJ IDEA.
  User: RYL
  Date: 2018/7/23
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>查询商品列表</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/itemList.action" method="post">
    查询条件：
    <table width="100%" border=1>
        <tr>
            <td>商品id：<input type="text" name="id"/></td>
            <td>商品名称：<input type="text" name="name"/></td>
            <td><input type="submit" value="查询"/></td>
        </tr>
    </table>
    商品列表：
    <table width="100%" border=1>
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <%--<td>生产日期</td>--%>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemList }" var="item">
            <tr>
                <td>${item.name }</td>
                <td>${item.price }</td>
                <%--<td>${item.createtime}</td>--%>
                <td>${item.detail }</td>
                <td><a href="${pageContext.request.contextPath }/editItem.action?id=${item.id}">修改</a></td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>
