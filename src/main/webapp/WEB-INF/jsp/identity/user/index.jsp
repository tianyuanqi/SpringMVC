<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户首页</title>

</head>
<body>
	<a href="add">添加用户</a>

	<br>
	<br>
	<c:if test="${empty requestScope.user }">
		没有用户信息
	</c:if>
	<c:if test="${!empty requestScope.user }">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>曾用名</th>
				<th>年龄</th>
				<th>修改</th>
				<th>删除</th>

			</tr>

			<c:forEach items="${requestScope.user }" var="u">
				<tr>
					<td>${u.id }</td>
					<td>${u.name }</td>
					<td>${u.lastName }</td>
					<td>${u.age }</td>
					<td></td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>