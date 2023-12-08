package DataObj;

import java.sql.*;

import javaClasses.Admin;

public class AdminObj {
    
    public Admin adminLogin(String email, String password){
        Admin admin = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx", "root", "");
                 PreparedStatement ps = con.prepareStatement("SELECT * FROM `admintbl` WHERE email=? AND password=?")) {
                ps.setString(1, email);
                ps.setString(2, password);
                
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        admin = new Admin();
                        admin.setAdm_id(rs.getInt("adm_id"));
                        admin.setName(rs.getString("name"));
                        admin.setEmail(rs.getString("email"));
                    }
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return admin;
    }
    
}
