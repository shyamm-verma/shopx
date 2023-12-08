<%-- 
    Document   : changeAddress
    Created on : 07-Jun-2023, 12:56:38 am
    Author     : raj94
--%>

<%@page import="javaClasses.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User auth = (User) session.getAttribute("auth");
        if(auth!=null){
            request.setAttribute("auth",auth);
        }else{
            response.sendRedirect("login.jsp");
        }
%>
<html>
<head>
    <%@include file="links/header.jsp" %>
    <meta charset="UTF-8">
    <title>Update Address</title>
</head>
<body class="bg-gray-100">
    <%@include file="links/navbar.jsp" %>
     <div class="container">
        <h1 class="mt-5">Change Address</h1>

        <%-- Display success or error messages --%>
        <% if (request.getAttribute("message") != null) { %>
            <div class="alert alert-primary mt-3" role="alert">
                <%= request.getAttribute("message") %>
            </div>
        <% } %>

        <form action="change-address" method="POST" class="mt-4" >
            <div class="form-group">
                <input type="hidden" id="uid" name="uid" value="<%= auth.getUid() %>" >
                <label for="address">Address:</label>
                <textarea class="form-control" id="address" name="address" rows="4" required><%= auth.getAddress() %></textarea>
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Save Address</button>
        </form>
    </div>
    <%@include file="links/footer.jsp" %>
</body>
</html>