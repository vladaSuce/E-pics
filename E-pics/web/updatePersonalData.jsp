<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>E- pics updatePersonalData</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
    <form action="./UpdatePersonalDataServlet" method="get">
        <p>
            <label for="newEmail" class="youmail" data-icon="e" > Your email address </label>
            <input id="newEmail" name="newEmail" required="required" type="email" /> 
        </p>
        <p> 
            <label for="firstName" >Your first name</label>
            <input id="firstName" name="firstName"  type="text"/>
        </p>
        <p> 
            <label for="lastName" >Your last name</label>
            <input id="lastName" name="lastName"  type="text"/>
        </p>
        <p> 
            <label for="dateOfBirth" >Your date of birth</label>
            <input id="dateOfBirth" name="dateOfBirth" type="date"  />
        </p>
        <p>    
            <label for="gender">Gender</label>
            <select name="gender" id="gender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
            </select >
        </p> 
        <p> 
            <label for="email_notification" >Email notifications </label>
            <input id="notifications" name="notifications"  type="checkbox" value="true"/>
        </p>
        <p>
            <button name="ChangeOK" value="Change" type="submit">Accept </button>
            <button name="=Change Cancel" value="Cancel" onclick="location.href='./IndexController'" formnovalidate> Cancel</button>
        </p>
        </form>
    </body>
</html>
