<%-- 
    Document   : invoice
    Created on : 13-Jun-2023, 10:54:27 pm
    Author     : raj94
--%>

<%@page import="javaClasses.Product"%>
<%@page import="javaClasses.Order"%>
<%@page import="DataObj.ProdObj"%>
<%@page import="java.util.List"%>
<%@page import="javaClasses.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javaClasses.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Order> order = null;
    User auth = (User) session.getAttribute("auth");
    if(auth!=null){
        request.setAttribute("auth",auth);
    }
    
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    List<Cart> cartProd = null;
    
    if(cart_list != null){
        ProdObj po = new ProdObj();
        cartProd = po.getCartProducts(cart_list);
        request.setAttribute("cart_list", cart_list);
        
        int total = po.getTotatPrice(cart_list);
        request.setAttribute("total", total);
    }

 %>
<!DOCTYPE html>
<html>
<head>
    <title>Bill</title>
    <%@include file="links/header.jsp" %>
</head>
<body>
    <div class="container">
        <h1 class="mt-4 mb-4">Bill</h1>

        <div class="row">
            <div class="col-md-6">
                <h3>User Details</h3>
                <form action="" method="post">
                    <div class="form-group">
                        <label for="customerName">Customer Name:</label>
                        <input type="text" class="form-control" id="customerName" name="customerName" value="<%= auth.getName() %>" disabled>
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" id="email" name="email" value="<%= auth.getEmail() %>" disabled>
                    </div>
                    <div class="form-group">
                        <label for="address">Address:</label>
                        <textarea class="form-control" id="address" name="address" disabled><%= auth.getAddress() %></textarea>
                    </div>
                    <h3>Product Details</h3>
                    <div class="form-group">
                        <%
                        if(order != null){
                            for(Order o:order){
                        %>
                        <label for="productName">Product Name:</label>
                        <input type="text" class="form-control" id="productName" name="productName" value="<%= o.getProdName()  %>" disabled>
                    </div>
                    <div class="form-group">
                        <label for="quantity">Quantity:</label>
                        <input type="number" class="form-control" id="quantity" name="quantity" value="<%= o.getQuantity() %>" disabled>
                    </div>
                    <div class="form-group">
                        <label for="price">Price:</label>
                        <input type="number" class="form-control" id="price" name="price" value="<%= o.getPrice() %>" disabled>
                    </div>
                    <%
                        }
                    }
                    %>
                    <button type="submit" class="btn btn-primary">Generate Bill</button>
                </form>
            </div>

            <div class="col-md-6">
                <h3>Bill Summary</h3>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Product</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        if(order != null){
                            for(Order o:order){%>
                            <tr>
                                <td><%= o.getProdName() %></td>
                                <td><%= o.getQuantity() %><td>
                                <td><%= o.getPrice() %></td>
                                <td>₹ ${ (total>0)?total:0 }</td>
                            </tr>
                    </tbody>
                    <tfoot>
                        <tr>
                            <th colspan="3" class="text-right">Grand Total:</th>
                            <th>₹ ${ (total>0)?total:0 }</th>
                        </tr>
                        <%}
                        }
                    %>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
    <%@include file="links/footer.jsp" %>
</body>
</html>

