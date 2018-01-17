<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@	page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello ${sender.username}<br>
<form:form method="post" modelAttribute="message" action="/Warsztat6/messages/send">

		
		Write new Message to ${receiver.username}<br>
		<form:textarea path="text" rows="3" cols="20"/><br> 
		<form:errors path="text"/>
		<form:hidden path="receiver.id" value="${receiver.id}"/>
		<form:hidden path="sender.id" value="${sender.id}"/>
		<input type="submit" value="Send Message">
	</form:form>

</body>
</html>