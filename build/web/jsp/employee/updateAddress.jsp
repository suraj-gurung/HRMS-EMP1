
<%@page import="com.hrms.beans.ShowAddressBean" %>
<%@page import="java.util.ArrayList" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%
        ShowAddressBean showAddressBean = null;
        if (request.getAttribute("showAddressBean") != null) {
            showAddressBean = (ShowAddressBean) request.getAttribute("showAddressBean");
        }
    %>
    
        

    <form action="<%=request.getContextPath()%>/updateAddress.do" id="updateAddressForm"  >

            <table border="2">
                <tr>
                <input type="hidden" name="empId" id="empId">
                <input type="hidden" name="addId" id="addressId">
                <input type="hidden" name="actionId" id="actionId" value="updateDone">
                          
                <td><input  name="addressType" type="text" value="<%=showAddressBean.getAddressTypeName()%>" readonly="yes" /></td>
                <td><input name="address" type="text" value="<%=showAddressBean.getAddress()%>" width="50px" ></td>
                <td><input name="street" type="text" value="<%=showAddressBean.getStreet()%>"></td>
                <td><input name="city" type="text" value="<%=showAddressBean.getCity()%>"></td>
                <td><input name="state" type="text" value="<%=showAddressBean.getState()%>"></td>
                <td><input name="pincode" type="number" value="<%=showAddressBean.getPincode()%>"></td>
                <td><input name="country" type="text" value="<%=showAddressBean.getCountry()%>"></td>

                <input name="employeeId" type="hidden" value="<%=showAddressBean.getEmployeeId()%>" />
                <input type="hidden" name="addressId" value="<%=showAddressBean.getAddressId()%>" />

                <td colspan="2"><input name="update" type="button" onclick="updateAddress(<%=showAddressBean.getEmployeeId()%>, <%=showAddressBean.getAddressId()%>, 'updateAddress.do')" value="Update"></td>
                    <%--<td><input name="delete" type="submit" value="Delete"></td>
                  --%>

                </tr>

            </table>

        </form>
    