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
public class Image {
    private int id;
    private int stt;
    private String image;

    public Image() {
    }
    
    public Image(int id, String image) {
        this.id = id;
        this.image = image;
    }

    public Image(int id, int stt, String image) {
        this.id = id;
        this.stt = stt;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
