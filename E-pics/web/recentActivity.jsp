
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
			<c:forEach items="${recentComments}" var="comment">
				<tr>
				<td>${comment.title} ${comment.contents} ${comment.photoComment.id} 
				<a href="./PictureController?id=${comment.photoComment.id}">Link ka slici</a>
				</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
</body>
</html>