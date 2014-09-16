<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
<title>E- pics updatePersonalData</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
</head>
<body>
	<form action="./UpdatePersonalDataServlet" method="get">
		<p>
			<label for="newEmail" class="youmail" data-icon="e"> Your
				email address </label> <input id="newEmail" name="newEmail"
				required="required" type="email" value="${user.emailAdress}" />
		</p>
		<p>
			<label for="firstName">Your first name</label> <input id="firstName"
				name="firstName" type="text" value="${user.firstName}" />
		</p>
		<p>
			<label for="lastName">Your last name</label> <input id="lastName"
				name="lastName" type="text" value="${user.lastName}" />
		</p>
		<p>
			<label for="dateOfBirth">Your date of birth</label> <input
				id="dateOfBirth" name="dateOfBirth" type="date"
				value="${user.dateOfBirth}" />
		</p>
		<p>
			<label for="gender">Gender</label> <select name="gender" id="gender">
				<option value="Male"
					<c:if test="${user.gender=='Male'}">
                		selected
                	</c:if> > Male</option>
				<option value="Female"
					<c:if test="${user.gender=='Female'}">
                		selected
                	</c:if> >Female</option>
			</select>
		</p>
		<p>
			<label for="email_notification">Email notifications </label> <input
				id="notifications" name="notifications" type="checkbox"
				<c:if test="${user.emailNotifications==true }">cheked="checked"</c:if>
				/>
		</p>
		<p>
			<button name="ChangeOK" value="Change" type="submit">Accept
			</button>
			<button name="=Change Cancel" value="Cancel"
				onclick="location.href='./IndexController'" formnovalidate>
				Cancel</button>
		</p>
	</form>
</body>
</html>
