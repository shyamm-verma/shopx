<%-- 
    Document   : view_cart
    Created on : 26-May-2023, 12:23:03 am
    Author     : raj94
--%>

<%@page import="javaClasses.User"%>
<%@page import="DataObj.ProdObj"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javaClasses.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="links/header.jsp" %>
        <title>ViewCart Page</title>
        <style>
            .table tbody td{
                vartical-align: middle;
            }
            .btn-incre, .btn-decre{
                box-shadow: none;
                font-size: 20px;
            }
            
        </style>
    </head>
    <body>
        <%@include file="links/navbar.jsp" %>
        <div class="container">
            <div class="d-flex py-3"><h3>Total Price: ₹ ${ (total>0)?total:0 }</h3><a class="mx-3" href="check-out"><button class="btn btn-primary">Check Out</button></a></div>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Category</th>
                        <th scope="col">Price</th>
                        <th scope="col">Buy Now</th>
                        <th scope="col">Cancel</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        if(cart_list != null){
                           for(Cart c:cartProd){%>
                           <tr class="p-0">
                                    <td><%= c.getProdName()%></td>
                                    <td><%= c.getCategory()%></td>
                                    <td>₹ <%= c.getPrice()%></td>
                                    <td>
                                        <form action="buy-now" method="post" class="form-inline">
                                            <input type="hidden" name="id" value="<%= c.getProdId()%>" class="form-input">
                                            <div class="form-group d-flex justify-content-between">
                                                <a class="btn btn-sm btn-decre" href="incer-decer?action=dec&id=<%= c.getProdId() %>"><i class="fas fa-minus-square"></i></a>
                                                <input type="text" name="quantity" class="form-control w-50" value="<%= c.getQuantity() %>" readonly>
                                                <a class="btn btn-sm btn-incre" href="incer-decer?action=inc&id=<%= c.getProdId() %>"><i class="fas fa-plus-square"></i></a>
                                                <button type="submit" class="btn btn-primary btn-sm" style="height:30px">Buy</button>
                                            </div>
                                        </form> 
                                    </td>
                                    <td><a class="btn btn-sm btn-danger" href="remove-item?id=<%= c.getProdId() %>">Remove</a></td>
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
