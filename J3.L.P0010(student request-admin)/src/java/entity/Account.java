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
public class Account {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private String shortname;
    
    public Account() {
    }

    public Account(String username, String password, String fullname, String shortname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.shortname = shortname;
    }

    public Account(int id, String username, String password, String fullname, String shortname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.shortname = shortname;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }
    
}
