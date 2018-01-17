<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@	page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

${info}
<c:if test="${not empty loggedUser}">
		
			<a href="/logout" class="nav">Logout</a><br>
	
	<a href="users/list" class="nav">Users</a>
	
	<form:form method="post" modelAttribute="tweet" action="tweets/add">
		<form:errors path="*"/><br>
		
		Write new tweet <br>
		<form:textarea path="text" rows="3" cols="20"/><br> 
		<form:hidden path="user.id" value="${loggedUser.id}"/><br>
		<input type="submit" value="Save">
	</form:form>
	<a href="users/myTweets">Your Tweets</a>
	<a href="messages/myMessages">Your Messages</a>
	
	<c:forEach var="t" items="${tweets}">
		<p>
			Written By: ${t.user.username}<br> 
			Tweet<br> ${t.text}<br>
			Tweeted on: ${t.created}<br>
			<a href="tweets/details/${t.id}">Show Details</a>

		</p>


	</c:forEach>
	</c:if>
</body>
</html>