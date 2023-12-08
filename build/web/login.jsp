<%-- 
    Document   : login
    Created on : 26-May-2023, 2:14:55 pm
    Author     : raj94
--%>

<%@page import="javaClasses.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javaClasses.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User auth = (User) session.getAttribute("auth");
    if(auth!=null){
        request.setAttribute("auth",auth);
        response.sendRedirect("index.jsp");
    }
    
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    if(cart_list != null){
        request.setAttribute("cart_list", cart_list);
    }
    
 %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links/header.jsp" %>
        <title>Login Page</title>
    </head>
    <body>
        <%@include file="links/navbar.jsp" %>
        
        <input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
        
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text-center">User Login</div>
                <div class="card-body">
                    <form action="LoginServlet" method="post">
                        <div class="form-group">
                            <label>Enter Email:</label>
                            <input type="email" class="form-control" id="login-email" name="login-email" placeholder="Enter Your Email Id" required>
                        </div><br>
                        <div class="form-group">
                            <label>Enter Password:</label>
                            <input type="password" class="form-control" id="login-pass" name="login-pass" placeholder="Enter Your Password" required>
                        </div><br>
                        <div class="text-center">
                            <input type="submit" class="btn btn-primary" value="Login">&nbsp;&nbsp;&nbsp;
                            <a href="registration.jsp" class="btn btn-primary">Register</a>
                        </div><br>
                        <div class="text-center">
                            <a href="index.jsp" class="btn btn-primary" >Home</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="links/footer.jsp" %>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
        <script>
            var status = document.getElementById("status").value;
            if(status == "Failed"){
                swal("Failed","Invalid Credencials","error")
            }
        </script>
    </body>
</html>

