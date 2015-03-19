<%-- 
    Document   : editDetails
    Created on : Feb 28, 2015, 6:20:53 PM
    Author     : srj
--%>

<%@page import="com.hrms.action.EmployeeUpdateAction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.beans.EmployeeUpdateBean"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% 
    EmployeeUpdateBean eubs = null;
    if(request.getAttribute("updateList")!=null){
        eubs = (EmployeeUpdateBean)request.getAttribute("updateList");
    }
%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update page</title>
    </head>
    <body>
        <form action="updateEmployee.do" method="post">
        <table border="1">
            <tr>
                <td> S.No. </td> 
                <td>Username</td> 
                <td>Department</td> 
                <td>Address Type</td>
                <td>House No.</td> 
                <td>Street</td>
                <td>City</td>
                <td>State</td>
                <td>Pincode</td> 
                <td>Country</td>
            </tr>
            <tr>
                  <%  if(eubs !=null ){
             %>
            
                <td>1</td>
<td><input type="text" value="<%=eubs.getUsername() %>" name="userName" /></td> 
<td><input type="text" value="<%=eubs.getDeptName() %>" name="department" /></td>
<td><input type="text" value="<%=eubs.getAddress_type() %>" name="addressType" /></td>
<td><input type="text" value="<%=eubs.getStreet() %>" name="houseNo" /></td> 
<td><input type="text" value="<%=eubs.getStreet() %>" name="street" /></td>
<td><input type="text" value="<%=eubs.getCity() %>" name="city" /></td> 
<td><input type="text" value="<%=eubs.getState() %>" name="state" /></td> 
<td><input type="number" max="6" autocomplete="off" value="<%=eubs.getPincode() %>" name="pincode" /></td> 
<td><input type="text" value="<%=eubs.getCountry() %>" name="country" /></td>

            </tr>
            
          
<% } %> 
        
        </table>
        </form>
    </body>
</html>
