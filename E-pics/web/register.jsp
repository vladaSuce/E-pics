<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="messages.messages"/>

<html>
	<head>
		<title><fmt:message key="registruj"/></title>
		<meta HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Expires" CONTENT="-1">
	</head>
	<body>
		<ul>
			<c:forEach items="${greske}" var="greska">
				<li>${greska}</li>
			</c:forEach>
			</ul>
		<form action="./CreateUserServlet" method="post"  accept-charset="UTF-8">
			<table>
			
				<tr>
					<td>Email:</td>
					<td><input type="email" name="emailSignup" id="emailSignup" required="required"></td>			
				</tr>
<!-- 				<tr> -->
<%-- 					<td><fmt:message key="slika"/>:</td> --%>
<!-- 					<td><input type="file" name="slika" ></td>			 -->
<!-- 				</tr> -->
				<tr>
					<td>First name:</td>
					<td><input type="text"  name="nameSignUp" id="nameSignUp" ></td>			
				</tr>
				<tr>
					<td>Last name:</td>
					<td><input type="text"  name="lastName" id="lastName" ></td>			
				</tr>
				<tr>
					<td>password:</td>
					<td><input type="password"  name="password" id="password" required="required" ></td>			
				</tr>
				<tr>
					<td>confirm password:</td>
					<td><input type="password"  name="password_confirm" id="password_confirm" required="required"></td>			
				</tr>
				<tr>
					<td>Date of birth:</td>
					<td><input type="date" name="dateOfBirth" id="dateOfBirth"  ></td>			
				</tr>
				<tr>
					<td>Gender:</td>
					<td><select name="gender" id="gender" >
						<option value="Male">Male</option>
						<option value="Female">Female</option> 
						</select>
					</td>			
				</tr>
				<tr>
					<td>Email notifications</td>
					<td><input type="checkbox" name="notifications" id="notifications" value="true"></td>
				</tr>
				<tr>
					
					<td><input type="submit" name="submit"></td>				
				</tr>
			</table>							
		</form>
	<a href="./IndexController"><fmt:message key="index" /></a><br />
	<body>
</html>