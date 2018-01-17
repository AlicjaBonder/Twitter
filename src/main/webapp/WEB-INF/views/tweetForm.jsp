
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Tweet</title>
</head>
<body>
	<form:form method="post" modelAttribute="tweet">
		<form:errors path="*" />
		<br>
		
		Write new tweet <br>
		<form:textarea path="text" rows="3" cols="20" />
		<br>
		<form:select path="user.id" items="${users}" itemLabel="username"
			itemValue="id" />
		<br>
		<input type="submit" value="Save">
	</form:form>

</body>
</html>