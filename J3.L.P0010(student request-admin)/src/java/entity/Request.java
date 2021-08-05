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
public class Request {

    private int id;
    private int did;
    private String dname;
    private String studentID;
    private String studentName;
    private String dateCreate;
    private String title;
    private String content;
    private int state;
    private String closeDate;
    private String solved;
    private String attached;
    private String solution;
    private int status;
    private int countRequest;

    public Request() {
    }

    public Request(int did, String dname, int countRequest) {
        this.did = did;
        this.dname = dname;
        this.countRequest = countRequest;
    }
    
    public Request(int id, String dname, String studentID, String studentName, String dateCreate, String title, String content, int state, String closeDate, String solved,String attached, String solution, int status) {
        this.id = id;
        this.dname = dname;
        this.studentID = studentID;
        this.studentName = studentName;
        this.dateCreate = dateCreate;
        this.title = title;
        this.content = content;
        this.state = state;
        this.closeDate = closeDate;
        this.solved = solved;
        this.attached = attached;
        this.solution = solution;
        this.status = status;
    }

    public String getAttached() {
        return attached;
    }

    public void setAttached(String attached) {
        this.attached = attached;
    }

    
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }
    
    public int getCountRequest() {
        return countRequest;
    }

    public void setCountRequest(int countRequest) {
        this.countRequest = countRequest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getSolved() {
        return solved;
    }

    public void setSolved(String solved) {
        this.solved = solved;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
