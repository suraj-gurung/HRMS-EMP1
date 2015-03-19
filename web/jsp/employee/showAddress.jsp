
<%@page import="com.hrms.beans.ShowAddressBean" %>
<%@page import="java.util.ArrayList" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <%
        ArrayList showAddressList = null;
        if (request.getAttribute("showAddressList") != null) {
            showAddressList = (ArrayList) request.getAttribute("showAddressList");
        }
    %>
    
        <form id='editEmpAddressForm'>
            <input type="hidden" name="actionId" id="actionId" value="showAddressDetails">
            <input type="hidden" name="addressId" id="addressId">
            <input type="hidden" name="empId" id="empId">
        </form>
        <table border="2">
            <br>            
            <tr>
                <td><b>Address Type</b></td>
                <td><b>House Number</b></td>
                <td><b>Street</b></td>
                <td><b>City</b></td>
                <td><b>State</b></td>
                <td><b>Pin-code</b></td>
                <td><b>Country</b></td>
                <td><b>Edit</b></td>
                <td><b>Delete</b></td>
            </tr>

            <%
                String showAddresss = null;
                if (showAddressList != null && showAddressList.size() > 0) {
                    for (int i = 0; i < showAddressList.size(); i++) {
                        ShowAddressBean showAddressBean = (ShowAddressBean) showAddressList.get(i);
            %>

            <tr>
                <td colspan="10" id="editAddress_<%=showAddressBean.getAddressId()%>">
                    <table width="100%" border="2">
                        <tr>       
                            <td><%=showAddressBean.getAddressTypeName()%></td>
                            <td><%=showAddressBean.getAddress()%></td>
                            <td><%=showAddressBean.getStreet()%></td>
                            <td><%=showAddressBean.getCity()%></td>
                            <td><%=showAddressBean.getState()%></td>
                            <td><%=showAddressBean.getPincode()%></td>
                            <td><%=showAddressBean.getCountry()%></td>
                            <td><button onclick="updateEditAddress(<%=showAddressBean.getEmployeeId()%>, <%=showAddressBean.getAddressId()%>, 'editAddress_<%=showAddressBean.getAddressId()%>','updateAddress.do')">Edit</button></td>
                            <td><button onclick="deleteAddress(<%=showAddressBean.getEmployeeId()%>)">Delete</button></td>
                            <td><input type="hidden" value="<%=showAddressBean.getEmployeeId()%>" name="employeeId" /></td>
                        </tr>
                    </table>
                </td>
            </tr>
            <%
                    }

                }
            %>
        </table>