<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./AddPictureController" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
		<table>

			<tr>
				<td>Search criteria :</td>
				<td>
			</tr>

			<tr>
				<td>Author Name:</td>
				<td><input type="text" name="imeAutora" id="imeAutora"></td>
			</tr>
			<tr>
				<td>Author Surname:</td>
				<td><input type="text" name="prezimeAutora" id="prezimeAutora"></td>
			</tr>
			<tr>
				<td>Photo title:</td>
				<td><input type="text" name="photoTitle" id="photoTitle"></td>
			</tr>
			<tr>
				<td>Photo description:</td>
				<td><input type="text" name="photoDesc"
					id="photoDesc" ></td>
			</tr>
			<tr>
				<td>Tag name:</td>
				<td><input type="text" name="tagName"
					id="tagName" ></td>
			</tr>
			<tr>
				<td>Photo size:</td>
				<td><input type="checkbox" name="tags_allowed"
					id="tags_allowed" value="true"></td>
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
</body>
</html>