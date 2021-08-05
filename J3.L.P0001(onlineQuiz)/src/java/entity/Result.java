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
public class Result {
    private int id ;
    private int bool;

    public Result() {
    }

    public Result(int id, int bool) {
        this.id = id;
        this.bool = bool;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBool() {
        return bool;
    }

    public void setBool(int bool) {
        this.bool = bool;
    }
    
    
}
