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
public class Question {

    private int id;
    private String question;
    private String date;
    private int creator;
   
    
    public Question() {
    }
    
    public Question(String question, String date, int creator) {
        this.question = question;
        this.date = date;
        this.creator = creator;
    }

    public Question(int id, String question, String date, int creator) {
        this.id = id;
        this.question = question;
        this.date = date;
        this.creator = creator;
    }

    

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }
    
}
