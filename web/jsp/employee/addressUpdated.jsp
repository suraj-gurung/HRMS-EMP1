
<div onload="color_green()">
    <p id="green">
        <%
            String addressType = (String) request.getAttribute("addressType");
            if (addressType != null) {
                out.write(addressType);
                out.write(" :- address has been updated.");
            }
        %>
    </p>
</div>