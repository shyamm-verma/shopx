package DataObj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javaClasses.User;

/**
 *
 * @author raj94
 */
public class UserObj {
    
    
    public User userLogin(String email, String password){
        User user = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx","root","");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM shopx_users WHERE email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setContactNum(rs.getInt("contactNum"));
                user.setGender(rs.getString("gender"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return user;
    }
    
    public void insertUser(User user){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx","root","");
            PreparedStatement ps = con.prepareStatement("INSERT INTO shopx_users(name,gender,address,contactNum,email,password) VALUES(?,?,?,?,?,?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getGender());
            ps.setString(3, user.getAddress());
            ps.setInt(4, user.getContactNum());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPassword());
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public User selectUser(int uid){
        User user = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx","root","");
            PreparedStatement ps = con.prepareStatement("SELECT uid,name,gender,address,contactNum,email FROM shopx_users where uid=?");
            ps.setInt(1, uid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user = new User();
                user.setName(rs.getString("name"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                user.setContactNum(rs.getInt("contactNum"));
                user.setEmail(rs.getString("email"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
    
    public static List<User> selectAllUsers(){
        List<User> user = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx","root","");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM shopx_users");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User row = new User();
                row.setUid(rs.getInt("uid"));
                row.setName(rs.getString("name"));
                row.setGender(rs.getString("gender"));
                row.setAddress(rs.getString("address"));
                row.setContactNum(rs.getInt("contactNum"));
                row.setEmail(rs.getString("email"));
                
                user.add(row);   
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return user;
    }
    
    public boolean updateUser(User user){
        boolean rowsUpdated = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx","root","");
            PreparedStatement ps = con.prepareStatement("UPDATE shopx_users SET name=?, gender=?, address=?, contactNum=? where uid=?");
            ps.setString(1, user.getName());
            ps.setString(2, user.getGender());
            ps.setString(3, user.getAddress());
            ps.setInt(4, user.getContactNum());
            ps.setInt(5, user.getUid());
            if(ps.executeUpdate() > 0){
                rowsUpdated = true ;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return rowsUpdated;
    }
    
    public boolean deleteUser(int uid){
        boolean rowDeleted = false;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx","root","");
            PreparedStatement ps = con.prepareStatement("DELETE FROM shopx_users where uid=?");
            ps.setInt(1, uid);
            if(ps.executeUpdate()>0){
                rowDeleted = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return rowDeleted;
    }
    
    public boolean updateAddress(String uid, String address){
        boolean updateAdd = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/shopx","root","");
            PreparedStatement ps = con.prepareStatement("UPDATE shopx_users SET address=? where uid=?");
            ps.setString(1,address);
            ps.setString(2, uid);
            if(ps.executeUpdate()>0){
                return updateAdd = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return updateAdd;
    }
    
}
