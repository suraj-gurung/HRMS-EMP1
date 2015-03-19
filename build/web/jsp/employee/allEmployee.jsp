<%-- 
    Document   : allEmployee
    Created on : Mar 2, 2015, 1:18:25 PM
    Author     : srj
--%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="com.hrms.beans.AllEmployeeBean" %>
<%@page import="java.util.ArrayList"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%

        ArrayList AllEmployeeList = null;
        if (request.getAttribute("AllEmployee") != null) {
            AllEmployeeList = (ArrayList) request.getAttribute("AllEmployee");
        }

    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="${pageContext.request.contextPath}/css/myStyle.css" type="text/css" rel="stylesheet">
        
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
        <title>All Employee page</title>
        <script>var myVar = '<%= request.getContextPath()%>';</script>

        <script>
            function showAddress(str) {
                if (str.length == 0) { 
                    document.getElementById("showAddress").innerHTML = "";
                    return;
                } else {
                    var xmlhttp = new XMLHttpRequest();
                    xmlhttp.onreadystatechange = function() {
                        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                            document.getElementById("showAddress").innerHTML = xmlhttp.responseText;
                        }
                    }
                    xmlhttp.open("GET", "${pageContext.request.contextPath}/showAddress.do?actionId=getAddressDetails&q=" + str, true);
                    xmlhttp.send();
                }
            }
        </script>


        <%--   <script>
             function showAddress(str) {
       var myUrl = "<%=request.getContextPath()%>/showAddress.do?q=" + str;
       $.ajax({
           type: "POST",
           xhr:  getAjaxObject(),
           url: myUrl,
           async: true,
           data: formData,
           success: function(returndata){
               alert("inside sucess");
               alert(returndata);
           },
           error: function(req,stat,err){
               alert('An Error has ocurred.Please try again');
           }
       });
       return false;
   }
    
   function getAjaxObject(){
       (window.ActiveXObject) ?
           function() {
               try {
                   return new window.ActiveXObject("Microsoft.XMLHTTP");
               } catch(e) {}
           } :
           function() {
               return new window.XMLHttpRequest();
           }
   }
   </script>--%>

    </head>
    <body>

        <html:form action="/deActivateEmp.do" styleId="deActivateForm"> 
            <input type="hidden" name="actionId" id="actionId" value="deActivateEmployee">

            <table border="2" >
                <tr>
                    <td>S.No.</td>
                    <td>Username</td>
                    <td>Department</td>
                    <td>More Information</td>
                    <td>address-details-new page</td>
                    <td>Activate status</td>
                    <td><input type="checkbox" name="deActivateAll" onclick="toggle(this)" id="selectAll">Deactivate All</td>
                </tr> 

                <%
                    
                    if (AllEmployeeList != null && AllEmployeeList.size() > 0) {
                        int z = 1;
                        for (int i = 0; i < AllEmployeeList.size(); i++) {
                            AllEmployeeBean allEmployeeBean = (AllEmployeeBean) AllEmployeeList.get(i);
                            pageContext.setAttribute("allEmployeeBean", allEmployeeBean);
                            
                            int status = allEmployeeBean.getDeactivate();
                                
                            if (status == 1) {
                %>
                <tr id="red">
                <%
                            } else{
                %>
                <tr>
                <%
                            }
                %>
                
                    <td><% out.print(z); z++; %> </td>
                    <td>${allEmployeeBean.getUsername()}</td>
                    <td>${allEmployeeBean.getDepartName()}</td>
                    <td><button type="button" onclick="showAddress(${allEmployeeBean.getEmployeeId()})">Address Details</button></td>
                    <td><a href="<%=request.getContextPath()%>/showAddress.do?q=<%=allEmployeeBean.getEmployeeId()%>">Address Details</a></td>

                    <td>
                        <%
                            if (status == 0) {
                                out.print("Active");
                            } else {
                                out.print("DeActive");
                            }
                        %>
                    </td>
                    <td>
                        <input type="checkbox" name="deActivateEmp" value="<%=allEmployeeBean.getEmployeeId()%>"></td>
                </tr>

                <%
                        }
                    }
                %>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td> <input type="button" name="deActivateEmp" value="DeActivate" onclick="deActivateEmpAll('deActivateEmp.do', '<%=request.getContextPath()%>/allEmployee.do')"></td>
                </tr>

            </table>
        </html:form>

        <div id="showAddress">

        </div>
            
            <c:out value="${pageContext.request.contextPath}"/>
            
            <%
                int a = 23;
                String work = "workingassssssssd";
                
    out.println(a);
    out.print(work);
%>
          ${a} <br> 
          ${work}
          ${"working1"} <br>
          ${pageContext.request.contextPath}
        </body>
</html>

<script type="text/javascript"> 
    function toggle(source) {
        checkboxes = document.getElementsByName('deActivateEmp');
        n=checkboxes.length;
        for(var i=0; i<n; i++) {
            checkboxes[i].checked = source.checked;
        }
    }
</script>