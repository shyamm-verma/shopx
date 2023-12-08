package com.javapro1.servlet;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raj94
 */
public class RegisterServlet extends HttpServlet {
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try{
                String userName = request.getParameter("reg_name");
                String userPhone = request.getParameter("reg_num");
                String userAddress = request.getParameter("reg_address");
                String userGender = request.getParameter("gender");
                String userEmail = request.getParameter("reg_email");
                String userPassword = request.getParameter("reg_pass");
                RequestDispatcher rd = null;
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx","root","");
                PreparedStatement ps = con.prepareStatement("INSERT INTO shopx_users(name,gender,address,contactNum,email,password) VALUES(?,?,?,?,?,?)");
                ps.setString(1, userName);
                ps.setString(2, userGender);
                ps.setString(3, userAddress);
                ps.setString(4, userPhone);
                ps.setString(5, userEmail);
                ps.setString(6, userPassword);
                
                int count = ps.executeUpdate();
                
                rd = request.getRequestDispatcher("registration.jsp");
                if(count>0){
                    request.setAttribute("status", "Success");
                }
                else{
                    request.setAttribute("status", "Failed");
                }
                rd.forward(request, response);
            }
            catch(Exception e){
                e.printStackTrace();
            }   
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
