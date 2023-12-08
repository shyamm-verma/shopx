<%-- 
    Document   : registration
    Created on : 26-May-2023, 2:16:59 pm
    Author     : raj94
--%>

<%@page import="javaClasses.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    User auth = (User) session.getAttribute("auth");
        if(auth!=null){
            request.setAttribute("auth",auth);
            response.sendRedirect("index.jsp");
        }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links/header.jsp" %>
        <title>Registration Page</title>
    </head>
    <body>
        <%@include file="links/navbar.jsp" %>
        
        <input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
               
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text-center">Register</div>
                <div class="card-body">
                    <form action="RegisterServlet" method="post">
                        <div class="form-group">
                            <label>Enter Name:</label>
                            <input type="text" class="form-control" id="reg-name" name="reg_name" placeholder="Enter Your Name" required>
                        </div><br>
                        <div class="form-group">
                            <label>Enter Phone Number:</label>
                            <input type="number" class="form-control" id="reg-num" name="reg_num" placeholder="Enter Your Phone Number" maxlength="10" required>
                        </div><br>
                        <div class="form-group">
                            <label>Gender:</label><br>
                            <input type="radio" value="Male" name="gender"> Male &nbsp;&nbsp;&nbsp;  
                            <input type="radio" value="Female" name="gender"> Female &nbsp;&nbsp;&nbsp;
                            <input type="radio" value="Other" name="gender"> Other &nbsp;&nbsp;&nbsp;
                        </div><br>
                        <div class="form-group">
                            <label>Enter Your Address:</label>
                            <textarea cols="80" rows="5" class="form-control" name="reg_address" id="reg-address" placeholder="Enter Your Address"></textarea>
                        </div><br>
                        <div class="form-group">
                            <label>Enter Email:</label>
                            <input type="email" class="form-control" id="login-email" name="reg_email" placeholder="Enter Your Email Id" required>
                        </div><br>
                        <div class="form-group">
                            <label>Enter Password:</label>
                            <input type="password" class="form-control" id="login-pass" name="reg_pass" placeholder="Enter Your Password" required>
                        </div><br>
                        <div class="text-center">
                            <input type="submit" class="btn btn-primary" value="Register">
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
            if(status == "Success"){
                swal("Congrats","Account Created Successfully","success");                
            }
        </script>
    </body>
</html>
