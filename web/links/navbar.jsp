<%-- 
    Document   : navbar
    Created on : 26-May-2023, 4:17:03 pm
    Author     : raj94
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">ShopX</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                 <ul class="navbar-nav ml-auto">
                   <li class="nav-item active">
                     <a class="nav-link" href="index.jsp">Home</a>
                   </li>
                   <li class="nav-item">
                       <a class="nav-link" href="view_cart.jsp">Cart<span class="badge badge-pill badge-dark">&nbsp;&nbsp;${ cart_list.size() }</span></a>
                   </li>
                   <% 
                    if(auth != null){%>
                      <li class="nav-item">
                        <a class="nav-link" href="orders.jsp">Orders</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="changeAddress.jsp">Change Address</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="LogoutServlet"><button class="btn btn-sm text-white bg-danger"> <%= auth.getName() %> </button></a>
                      </li>
                    <%}else{%>
                      <li class="nav-item">
                      <a class="nav-link" href="login.jsp"><button class="btn btn-sm text-white bg-success">Login</button></a>
                   </li>
                    <%}
                   %>
                 </ul>
            </div>
    </div>
</nav>
