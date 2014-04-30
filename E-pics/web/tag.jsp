<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title>Tag</title>
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
		<form action="TagController?id=${id1}" method="get"  accept-charset="ISO-8859-1">
			<table>
				<tr>
					<td>tag ${id1} nesto ${id}":</td>
					<td><input type="text" name="tagName" required="required">				
				</tr>
				
					<td><input type="submit" name="submit"></td>
					<td><input type="hidden" name="id" value="${id}"/></td>				
				</tr>
				</table>							
		</form>
	<a href="./PictureController"><fmt:message key="index" /></a><br />
	<body>	
</html>