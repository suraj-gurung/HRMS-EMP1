<%@page import="com.hrms.dao.EmployeeDao"%>  
<jsp:useBean id="obj" class="com.hrms.form.EmployeeForm"/>  
  
<jsp:setProperty property="*" name="obj"/>  
  
<%
boolean status=EmployeeDao.empvalidate(obj); 
if(status){
out.println("You are successfully logged in");
session.setAttribute("session","TRUE");
}
else
{
out.print("Sorry, email or password error");
 
}
%>

working