<%-- 
    Document   : login
    Created on : Feb 23, 2015, 12:38:15 PM
    Author     : srj
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@page import="com.hrms.util.ResourceBundle"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HRMS Employee</title>
        
        
    </head>
    <body>
        <h1>Login Form for Employee</h1>
        <h5><%=ResourceBundle.getValue("lost.password.email.message") %></h5>
        <fieldset style="width:250px;">
        <form action="<%=request.getContextPath()%>/loginprocess.do" method="post">
            
            <label id="dis" style="color: red;"></label><br>
            
            Username : <input type="text" name="username" id="username" /> <br> <br>
            
            Password : <input type="text" name="password" id="password" /> <br>
            
            <input type="submit" name="submit" id="submit" />
        </form>
        </fieldset>
    </body>
</html>
