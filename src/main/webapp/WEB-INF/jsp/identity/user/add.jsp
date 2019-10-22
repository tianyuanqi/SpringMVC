<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	添加用户
	<form action="save" method="post">
		ID:<input type="text" name="id"/><br><br>
		姓名:<input type="text" name="name"/><br><br>
		曾用名:<input type="text" name="lastName"/><br><br>
		年龄:<input type="text" name="age"/><br><br>
		<input type="submit" name="提交" /><br>
	</form>
</body>
</html>