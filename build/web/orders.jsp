<%-- 
    Document   : orders
    Created on : 26-May-2023, 12:23:18 am
    Author     : raj94
--%>

<%@page import="javaClasses.Order"%>
<%@page import="DataObj.OrderObj"%>
<%@page import="javaClasses.User"%>
<%@page import="java.util.*"%>
<%@page import="javaClasses.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Order> order = null;
    User auth = (User) session.getAttribute("auth");
    if(auth!=null){
        request.setAttribute("auth",auth);
        OrderObj orderObj = new OrderObj();
        order = orderObj.userOrders(auth.getUid());
    }else{
        response.sendRedirect("login.jsp");
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
        <title>Orders Page</title>
    </head>
    <body>
        <%@include file="links/navbar.jsp" %>
        <div class="container">
            <div class="card-header my-3">All Orders</div>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">Date</th>
                        <th scope="col">Name</th>
                        <th scope="col">Category</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Price</th>
                        <th scope="col">Cancel</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if(order != null){
                            for(Order o:order){%>
                            <tr>
                                <td><%= o.getDate() %></td>
                                <td><%= o.getProdName()%></td>
                                <td><%= o.getCategory() %></td>
                                <td><%= o.getQuantity() %></td>
                                <td><%= o.getPrice() %></td>
                                <td><a class="btn btn-sm btn-danger" href="cancel-order?id=<%= o.getOrdId() %>">Cancel</a></td>
                            </tr>
                            <%}
                        }
                    %>
                </tbody>
            </table>
        </div>    
        <%@include file="links/footer.jsp" %>
    </body>
</html>
