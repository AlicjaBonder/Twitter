<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@	page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Coderslab Twitter</title>

</head>
<body>
	<%-- hello ${loggedUser.username}  --%>
	Twitter
	
	<c:if test="${empty info}">
	<p>
				<a href="<% out.print(request.getContextPath()); %>/login"> Logowanie </a><br>
			</p>
			<p>
				<a href="<% out.print(request.getContextPath()); %>/register"> Rejestracja </a><br>
			</p>	
		</c:if>
	
	
</body>
</html>