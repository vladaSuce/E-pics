<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<fmt:setBundle basename="messages.messages" />

<html>
<head>
<title><fmt:message key="registruj" /></title>
<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
<meta HTTP-EQUIV="Expires" CONTENT="-1">
</head>
<body>
	<ul>
		<c:forEach items="${greske}" var="greska">
			<li>${greska}</li>
		</c:forEach>
	</ul>
	<form action="./AddPictureController" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
		<table>

			<tr>
				<td>Photo:</td>
				<td><input type="file" name="newPhoto"
					accept="image/gif, image/jpeg, image/jpg, image/png"></td>
			</tr>

			<tr>
				<td>Title:</td>
				<td><input type="text" name="photoTitle" id="photoTitle"
					required="required"></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><input type="text" name="photoDecs" id="photoDecs"></td>
			</tr>
			<tr>
				<td>Public:</td>
				<td><input type="checkbox" name="photoPublic" id="photoPublic"
					value="true"></td>
			</tr>
			<tr>
				<td>Comments allowed:</td>
				<td><input type="checkbox" name="comments_allowed"
					id="comments_allowed" value="true"></td>
			</tr>
			<tr>
				<td>Notes allowed:</td>
				<td><input type="checkbox" name="notes_allowed"
					id="notess_allowed" value="true"></td>
			</tr>
			<tr>
				<td>Tags allowed:</td>
				<td><input type="checkbox" name="tags_allowed"
					id="tags_allowed" value="true"></td>
			</tr>

			<tr>
				<td>Album:</td>
				<td><select name="album11"> 
						<c:forEach items="${albums}" var="grupa">
							<option value="${grupa.id}">${grupa.title}</option>

						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
			</tr>
			<tr>

				<td><input type="submit" name="submit"></td>
			</tr>
		</table>
	</form>
<body>
</html>