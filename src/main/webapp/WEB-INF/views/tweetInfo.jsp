<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	p {
		border: 1px solid black;
	
	}
</style>
</head>
<body>
	<a href="/Warsztat6">Main Page</a><br>
	Id: <c:out value="${tweet.id}"/><br>
	written by: <c:out value="${tweet.user.username}"/><br>
	text: <c:out value="${tweet.text}"/><br>
	tweeted on: <c:out value="${tweet.created}"/><br>
	
	Add Comment: 
	<form:form method="post" modelAttribute="comment" action="/Warsztat6/comments/add/${tweet.id}">
	
		<form:errors path="*"/><br>
		
		<form:textarea path="text"/><br> 
			
		
		<input type="submit" value="Save">
	</form:form>
	Comments: <br>
	
	<c:forEach var="c" items="${comments}">
		<p>
		Comment by:	<c:out value="${c.user.username}"/>, ${c.user.email}
		<c:choose>
		<c:when test="${c.user.loggedIn==true }">
			<c:out value="Zalogowany"/><br>
		</c:when>
		<c:otherwise>
			<c:out value="Niezalogowany"/><br>
		</c:otherwise>
	</c:choose>
		<br>
					<c:out value="${c.text}"/><br><br>
		posted on:  <c:out value="${c.created}"/>
		</p>	
			
	
	</c:forEach>

</body>
</html>