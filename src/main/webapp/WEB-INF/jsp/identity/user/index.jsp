<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户首页</title>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<script type="text/javascript" src="${path}/static/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(function() {
		$(".delete").click(function() {
			var href = $(this).attr("href");
			$("form").attr("action", href).submit();
			return false;
		});
	})
</script>
</head>
<body>
	<form action="" method="post">
		<input type="hidden" name="_method" value="DELETE" />
	</form>
	<a href="user">添加用户</a>


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
					<td><a href="user/${u.id }">修改</a></td>
					<td><a class="delete" href="user/${u.id }">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>