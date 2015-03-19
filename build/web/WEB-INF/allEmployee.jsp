<%-- 
    Document   : allEmployee
    Created on : Mar 2, 2015, 1:18:25 PM
    Author     : srj
--%>
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
        <title>All Employee page</title>

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
                    xmlhttp.open("GET", "<%=request.getContextPath()%>/showAddress.do?q=" + str, true);
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

        <table border="2">
            <tr>
                <td>S.No.</td>
                <td>Username</td>
                <td>Department</td>
                <td>More Information</td>
            </tr> 
            <%

                if (AllEmployeeList != null && AllEmployeeList.size() > 0) {
                    for (int i = 0; i < AllEmployeeList.size(); i++) {
                        AllEmployeeBean allEmployeeBean = (AllEmployeeBean) AllEmployeeList.get(i);
                        pageContext.setAttribute("allEmployeeBean", allEmployeeBean);
            %>
            <tr>
                <td>1</td>
                <td><%=allEmployeeBean.getUsername()%></td>
                <td><%=allEmployeeBean.getDepartName()%></td>
                <td><button onclick="showAddress(<%=allEmployeeBean.getEmployeeId()%>)">Address Details</button></td>
                <td><a href="<%=request.getContextPath()%>/showAddress.do?q=<%=allEmployeeBean.getEmployeeId()%>">Address Details</a></td>
                </tr>
            
            <%

                }
            %>
        <div id="showAddress">
                 
            </div>

        <%

            }
        %>
    </table>
</body>
</html>
