<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title><fmt:message key="dodajAlbum"/></title>
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
	</head>
	<body>
		<ul>
			<c:forEach items="${greske}" var="greska">
				<li>${greska}</li>
			</c:forEach>
			</ul>
		<form action="./addAlbumController" method="post"  accept-charset="UTF-8">
			<table>
			
				<tr>
					<td>Title:</td>
					<td><input type="text" name="albumTitle" id="albumTitle" required="required"></td>			
				</tr>

				<tr>
					<td>Description:</td>
					<td><input type="text"  name="albumDesc" id="albumDesc" ></td>			
				</tr>
				<tr>
					<td>Public:</td>
					<td><input type="checkbox"  name="albumPublic" id="albumPublic" value="true" ></td>			
				</tr>
				

				<tr>
					
					<td><input type="submit" name="submit"></td>				
				</tr>
			</table>							
		</form>
	<a href="./IndexController"></a><br />
	<body>
</html>