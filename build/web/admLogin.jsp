<%-- 
    Document   : admLogin
    Created on : 02-Jun-2023, 4:21:48 pm
    Author     : raj94
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links/header.jsp" %>
        <title>Login Page</title>
    </head>
    <body>
        <%--<%@include file="links/navbar.jsp" %>--%>
        
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text-center">Admin Login</div>
                <div class="card-body">
                    <form action="admin-login" method="post">
                        <div class="form-group">
                            <label>Enter Email:</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="Enter Your Email Id" required>
                        </div><br>
                        <div class="form-group">
                            <label>Enter Password:</label>
                            <input type="password" class="form-control" id="pass" name="pass" placeholder="Enter Your Password" required>
                        </div><br>
                        <div class="text-center">
                            <input type="submit" class="btn btn-primary" value="Login">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="links/footer.jsp" %>
    </body>
</html>