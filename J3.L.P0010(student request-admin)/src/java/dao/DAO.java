/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Department;
import entity.Request;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hùng
 */
public class DAO {

    Connection conn = null;
    PreparedStatement pre = null;
    ResultSet rs = null;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public Account getAccount(String username, String password) {
        String sql = "Select * from Account where username = ? and password = ?";
        try {
            conn = new DBContext().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);
            rs = pre.executeQuery();
            if (rs.next()) {
                Account acc = new Account(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
                return acc;
            }
        } catch (SQLException e) {
            System.out.println("loi getAccount " + e.getMessage());
        } finally {
            DBContext.closeConnection(conn);
            DBContext.closePreparedStatement(pre);
            DBContext.closeResultSet(rs);
        }
        return null;
    }

    public List<Department> getAllDepartment() {
        List<Department> list = new ArrayList<>();
        String sql = "Select * from Department ";
        try {
            conn = new DBContext().getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Department(
                        rs.getInt(1),
                        rs.getString(2)
                ));
            }
        } catch (SQLException e) {
            System.out.println("loi getAllDepartment" + e.getMessage());
        } finally {
            DBContext.closeConnection(conn);
            DBContext.closePreparedStatement(pre);
            DBContext.closeResultSet(rs);
        }
        return list;
    }

    public Request getRequestByID(String id) {
        String sql = "Select rid,c.name,d.studentId,d.studentName,dateCreate,title,content,state,closeDate,b.username,attached,solution,status from Request a\n"
                + "LEFT JOIN Account b ON a.solvedId=b.aid\n"
                + "LEFT JOIN Department c ON a.did = c.did\n"
                + "LEFT JOIN Student d ON a.studentId = d.studentId\n"
                + "Where rid = ?";
        try {
            conn = new DBContext().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, id);
            rs = pre.executeQuery();
            if (rs.next()) {
                Request req = new Request(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        sdf.format(rs.getDate(5)),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getInt(13)
                );
                return req;
            }
        } catch (SQLException e) {
            System.out.println("loi getRequestByID " + e.getMessage());
        } finally {
            DBContext.closeConnection(conn);
            DBContext.closePreparedStatement(pre);
            DBContext.closeResultSet(rs);
        }
        return null;
    }

    public List<Request> getRequestByDid(String did) {
        List<Request> list = new ArrayList<>();
        String sql = "Select rid,c.name,d.studentId,d.studentName,dateCreate,title,content,state,closeDate,b.username,attached,solution,status from Request a\n"
                + "LEFT JOIN Account b ON a.solvedId=b.aid\n"
                + "LEFT JOIN Department c ON a.did = c.did\n"
                + "LEFT JOIN Student d ON a.studentId = d.studentId\n"
                + "Where a.did = ? \n"
                + "order by dateCreate";
        try {
            conn = new DBContext().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, did);
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Request(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        sdf.format(rs.getDate(5)),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getInt(13)
                ));
            }
        } catch (SQLException e) {
            System.out.println("loi getRequestByDid" + e.getMessage());
        } finally {
            DBContext.closeConnection(conn);
            DBContext.closePreparedStatement(pre);
            DBContext.closeResultSet(rs);
        }
        return list;
    }

    public List<Request> getRequestByTitle(String str) {
        List<Request> list = new ArrayList<>();
        String sql = "Select rid,c.name,d.studentId,d.studentName,dateCreate,title,content,state,closeDate,b.username,attached,solution,status from Request a\n"
                + "LEFT JOIN Account b ON a.solvedId=b.aid\n"
                + "LEFT JOIN Department c ON a.did = c.did\n"
                + "LEFT JOIN Student d ON a.studentId = d.studentId\n"
                + "Where title like ?\n"
                + "order by dateCreate";
        try {
            conn = new DBContext().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, "%" + str + "%");
            rs = pre.executeQuery();
            while (rs.next()) {
                list.add(new Request(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        sdf.format(rs.getDate(5)),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getInt(13)
                ));
            }
        } catch (SQLException e) {
            System.out.println("loi getRequestByTitle" + e.getMessage());
        } finally {
            DBContext.closeConnection(conn);
            DBContext.closePreparedStatement(pre);
            DBContext.closeResultSet(rs);
        }
        return list;

    }

    public Request getRequestLast2days(int did, String name, String from, String to) {
        String sql = "select  COUNT( *) from Request \n"
                + "Where  did = ? and dateCreate between ? and ?";
        try {
            conn = new DBContext().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, did);
            pre.setString(2, from);
            pre.setString(3, to);
            rs = pre.executeQuery();
            if (rs.next()) {
                return (new Request(
                        did,
                        name,
                        rs.getInt(1)
                ));
            }
        } catch (SQLException e) {
            System.out.println("loi getRequestLast2days" + e.getMessage());
        } finally {
            DBContext.closeConnection(conn);
            DBContext.closePreparedStatement(pre);
            DBContext.closeResultSet(rs);
        }
        return null;
    }

    public Request getRequestToday(int did, String name, String to) {
        String sql = "select  COUNT( *) from Request \n"
                + "Where  did = ? and dateCreate = ?";
        try {
            conn = new DBContext().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, did);
            pre.setString(2, to);
            rs = pre.executeQuery();
            if (rs.next()) {
                return (new Request(
                        did,
                        name,
                        rs.getInt(1)
                ));
            }
        } catch (SQLException e) {
            System.out.println("loi getRequestToday" + e.getMessage());
        } finally {
            DBContext.closeConnection(conn);
            DBContext.closePreparedStatement(pre);
            DBContext.closeResultSet(rs);
        }
        return null;
    }
    public void updateRequest2(int rid, String solution) {
        String sql = "Update Request set solution = ? where rid = ?";
        try {
            conn = new DBContext().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, solution);
            pre.setInt(2, rid);
            pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi updateRequest" + e.getMessage());
        } finally {
            DBContext.closeConnection(conn);
            DBContext.closePreparedStatement(pre);
            DBContext.closeResultSet(rs);
        }
    }
    public void updateRequest(int rid, int state, String closeDate, int solvedID, String solution, int status) {
        String sql = "Update Request set \n"
                + "state = ?,"
                + "closeDate = ?,"
                + "solvedId= ?,"
                + "solution = ?,"
                + "status = ?\n"
                + "where rid = ?";
        try {
            conn = new DBContext().getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, state);
            pre.setString(2, closeDate);
            pre.setInt(3, solvedID);
            pre.setString(4, solution);
            pre.setInt(5, status);
            pre.setInt(6, rid);
            pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi updateRequest" + e.getMessage());
        } finally {
            DBContext.closeConnection(conn);
            DBContext.closePreparedStatement(pre);
            DBContext.closeResultSet(rs);
        }
    }
}


