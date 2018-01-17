<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add user</title>
</head>
<body>
	<form:errors path="*" /><br>
	<form:form method="post" modelAttribute="user">
	username: <form:input path="username" /><br> 
	password:<form:password path="password" /><br>
	email: <form:input path="email" /><br>
	<input type="submit" value="Zarejestruj">
	</form:form>

</body>
</html>