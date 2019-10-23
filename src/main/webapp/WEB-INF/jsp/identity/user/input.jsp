<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath }/identity/user"
		method="post" modelAttribute="user">
		<input type="hidden" name="_method" value="PUT" />

		<c:if test="${user.id !=null }">
			<form:hidden path="id" />
		</c:if>
		<br>
		<br>
		
		姓名:<form:input path="name" />
		<form:errors path="name"></form:errors>
		<br>
		<br>

		<c:if test="${user.id == null }">
			<!-- path 属性对应 html 表单标签的 name 属性值 -->
			曾用名: <form:input path="lastName" />
			<form:errors path="lastName"></form:errors>
			<br>
			<br>
		</c:if>

		<c:if test="${user.id==null }">
			年龄:<input type="text" name="age"></input>
		</c:if>

		<c:if test="${user.id!=null }">
			年龄:<form:input path="age" />
		</c:if>
		<br>
		<br>
		<input type="submit" name="提交" />
		<br>
		<br>
	</form:form>
</body>
</html>