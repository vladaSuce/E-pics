<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:setBundle basename="messages.messages"/>
<html>
    <head>
        <title>E-pics updatePassword</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
	<ul>
		<c:forEach items="${greske}" var="greska">
			<li>${greska}</li>
		</c:forEach>
		</ul>
    <form action="./UpdatePassword" method="post">
        <p>
        <label for="oldPassword" class="youmail" data-icon="e" > Your old paswword </label>
        <input id="oldPassword" name="oldPassword" required="required" type="password" /> 
    </p>
    <p> 
        <label for="passwordsignup" class="youpasswd" data-icon="p">Your new password </label>
        <input id="passwordsignup" name="passwordsignup" required="required" type="password"/>
    </p>
    <p> 
        <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your new password </label>
        <input id="passwordsignup_confirm" name="passwordsignup_confirm" required="required" type="password"  />
    </p>
    <p>
        <button name="ChangeOK" value="Change" type="submit">Accept </button>
        <button name="=Change Cancel" value="Cancel" onclick="location.href='./IndexController'" formnovalidate> Cancel</button>
    </p>
    </form>
</body>
</html>
