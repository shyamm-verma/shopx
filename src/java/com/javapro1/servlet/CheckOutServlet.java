package com.javapro1.servlet;

import DataObj.OrderObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;
import javaClasses.Cart;
import javaClasses.Order;
import javaClasses.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author raj94
 */
public class CheckOutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            
            Date date = new Date();
            
            //Cart Product Retrival using Session
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
            
            //User Login Authentication using Session
            User auth = (User) session.getAttribute("auth");
            
            if(cart_list !=null && auth != null){
                for(Cart c:cart_list){
                    Order ord = new Order();
                    ord.setProductId(c.getProdId());
                    ord.setUserId(auth.getUid());
                    ord.setQuantity(c.getQuantity());
                    ord.setDate(formatter.format(date));
                    
                    OrderObj orderObj = new OrderObj();
                    boolean result = orderObj.insertOrder(ord);
                    if(!result){
                        break;
                    }   
                } 
                response.sendRedirect("orders.jsp");
                cart_list.clear();
                
            }else{
                if(auth == null){
                    response.sendRedirect("login.jsp");
                }
                response.sendRedirect("view_cart.jsp");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            doGet(request,response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
