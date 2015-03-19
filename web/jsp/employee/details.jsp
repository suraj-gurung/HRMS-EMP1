<%-- 
    Document   : details
    Created on : Feb 24, 2015, 2:05:21 PM
    Author     : srj
--%>

<%@page import="com.hrms.beans.AddressVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hrms.beans.EmployeeVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <% 
    EmployeeVO employeeVo = null;
    if(request.getAttribute("employeeObj")!=null){
        employeeVo = (EmployeeVO)request.getAttribute("employeeObj");
    }
    ArrayList addressList = null;
    if(request.getAttribute("addressList")!=null){
        addressList = (ArrayList)request.getAttribute("addressList");
    }
%>
    
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Details</title>
    </head>
    <body>
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
                <td>Edit</td> 
                <td>Delete</td>
            </tr>
           <% if(employeeVo !=null){%>
            <tr>
                <td>1</td>
                <td><%=employeeVo.getUsername()%></td>
                 <td ><%=employeeVo.getDeptName()%></td>
                 
                 <% if(addressList !=null &&  addressList.size()>0){
               for(int i = 0; i<addressList.size();i++){
               AddressVo addressVo = (AddressVo)addressList.get(i);
               
           %>
            
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td><%=addressVo.getAddressTypeName()%></td>
                <td><%=addressVo.getAddress()%></td>
                <td><%=addressVo.getStreet()%></td>
                <td><%=addressVo.getCity() %></td>
                <td><%=addressVo.getState() %></td>
                <td><%=addressVo.getPincode() %></td>
                <td><%=addressVo.getCountry() %></td>
                
            <%}
            %>
            </tr>
<% } %>
                <td><a href="editEmployee.do?edit=<%=employeeVo.getEmpId()%>">Edit</a></td>
                <td><a href="deleteEmployee.do?delete=<%=employeeVo.getEmpId()%>">Delete</a></td>     
            <%}%>
        </table>
        <br/>
        
<%--         <table border="1">
           <% if(addressList !=null &&  addressList.size()>0){
               for(int i = 0; i<addressList.size();i++){
               AddressVo addressVo = (AddressVo)addressList.get(i);
               
           %>
            <tr>
                <td><%=addressVo.getAddress()%></td>
                 <td><%=addressVo.getStreet()%></td>
            </tr>
            <%}
           
}%>
</table>--%>

<button type="button" value="show employees" name="showEmployees" onclick="location.href='<%=request.getContextPath()%>/allEmployee.do'"  >show employees</button>
    </body>
</html>
