/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Hùng
 */
public class User {
    
    private int id;
    private String userName;
    private String passWord;
    private String email;
    private int role;

    public User() {
    }

    public User(String userName, String passWord, String email, int role) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.role = role;
    }

    public User(int id, String userName, String passWord, String email, int role) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.role = role;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
