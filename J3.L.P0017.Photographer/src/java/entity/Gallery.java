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
public class Gallery {

     private int id;
    private String title;
    private String description;
    private String name;
    private String url_img;
    
    public Gallery() {
    }

    public Gallery(int id, String url_img) {
        this.id = id;
        this.url_img = url_img;
    }
    

    public Gallery(int id, String title, String description, String name, String url_img) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.name = name;
        this.url_img = url_img;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
