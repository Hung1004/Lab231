/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Answer;
import entity.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hùng
 */
public class QuizDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

// MakeQuiz
    public void addQuiz(Question q) {
        try {
            String sql = "insert into Question(question,date,creator) values(?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, q.getQuestion());
            ps.setString(2, q.getDate());
            ps.setInt(3, q.getCreator());
            ps.execute();
        } catch (Exception e) {
            System.out.println("addQuiz " + e.getMessage());
        }
    }

    public void addAnswer(Answer a) {
        try {
            String sql = "insert into Answer values(?,?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, a.getIdQuestion());
            ps.setString(2, a.getOption());
            ps.setInt(3, a.getAnswer());
            ps.setInt(4, a.getIdAnswer());

            ps.execute();
        } catch (Exception e) {
            System.out.println("addAnswer " + e.getMessage());
        }
    }

    public int getIdQuiz() {
        try {
            String sql = "select top 1 id from Question order by id desc";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("addQuiz " + e.getMessage());
        }
        return -1;
    }

//ManageQuiz
    public List<Question> getQuestion(int a) {
        List<Question> list = new ArrayList<>();
        try {
            String sql = "Select * from Question where creator = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, a);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Question(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                ));
            }
        } catch (Exception e) {
            System.out.println("Loi getQestion " + e.getMessage());
        }
        return list;
    }

    public int countQuestionByCreator(int a) {
        try {
            String sql = "Select count(*) from Question where creator = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, a);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Loi countQuestionByCreator " + e.getMessage());
        }
        return -1;
    }
// Take Quiz

    public int countQuestion() {
        try {
            String sql = "Select count(*) from Question";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Loi countQuestion " + e.getMessage());
        }
        return -1;
    }

    public List<Question> getListQuestionToTakeQuiz(int a) {
        List<Question> list = new ArrayList<>();
        try {
            String sql = "Select top " + a + " * from Question order by NEWID()";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Question(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                ));
            }
        } catch (Exception e) {
            System.out.println("Loi getListQuestionToTakeQuiz " + e.getMessage());
        }
        return list;
    }

    public List<Answer> getListAnswerByQuestionID(int a) {
        List<Answer> list = new ArrayList<>();
        try {
            String sql = "Select * from Answer where id = ? order by idAnswer";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, a);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Answer(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4)
                ));
            }
        } catch (Exception e) {
            System.out.println("Loi getListAnswerByQuestionID " + e.getMessage());
        }
        return list;
    }
}
