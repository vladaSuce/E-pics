<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title>Comment</title>
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
		<link href="./theme.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<ul>
		<c:forEach items="${greske}" var="greska">
			<li>${greska}</li>
		</c:forEach>
		</ul>
		<form action="./CommentController" method="post" class="prijavaForma" accept-charset="ISO-8859-1">
			<table>
				<tr>
					<td>Title:</td>
					<td><input type="text" name="title" required="required">				
				</tr>
				<tr>
					<td>Contents:</td>
					<td><input type="text" name="contents"></td>
						</tr>
					<tr>
					
					
					<td><input type="hidden" name="id_slike" value="${id}"></td> 				
				
				<tr>
					
					<td><input type="submit" name="submit" value="Comment"></td>				
				</tr>
				</table>							
		</form>
	<a href="./IndexController"><fmt:message key="index" /></a><br />
	<body>	
</html>