
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recent activity</title>
</head>
<body>
	<table>
		<tr>
			<c:forEach items="${albums}" var="album">
				<tr>
					<td>${album.title}</td>
					<td><a href="./PreEditAlbumController?id=${album.id}">Edit
							Album</a></td>
					<td><a href="./DeleteAlbumController?id=${album.id}">Delete
							Album</a></td>
				</tr>
			</c:forEach>
		</tr>
		<tr>
			<td><a id="addAlbum" href ="album.jsp">Add
					Album</a></td>
		</tr>
		<tr>
			<td><a  href ="./IndexController?autor=${user.id}">Home</a></td>
		</tr>
	</table>
</body>
</html>