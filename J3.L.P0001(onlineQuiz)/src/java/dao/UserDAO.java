/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hùng
 */
public class UserDAO {
    Connection conn =null;
    PreparedStatement ps = null;
    ResultSet rs =null;
    
    public void addUser(User u){
        try {
            String sql ="insert into [User](userName,passWord,email,role) values(?,?,?,?)";
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,u.getUserName());
            ps.setString(2,u.getPassWord());
            ps.setString(3,u.getEmail());
            ps.setInt(4, u.getRole());
            ps.execute();
        } catch (Exception e) {
            System.out.println("addUser "+e.getMessage());
        }
    }
    public User getUser(String name,String pass){
        try {
            String sql ="Select * from [User] where userName = ? and passWord = ?";
            conn=new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,pass);
            rs=ps.executeQuery();
            if(rs.next()){
                return new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)
                );
            }
        } catch (Exception e) {
            System.out.println("Loi getUser "+e.getMessage());
        }
        
        return null;
    }
}
