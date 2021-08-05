/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Digital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hùng
 */
public class DAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Digital getNewDigital() {
        try {
            String sql = "Select top 1 * from digital order by dateCreate desc";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Digital(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println("Loi getNewDigital" + e.getMessage());
        }
        return null;
    }
    public Digital getMostDigital() {
        try {
            String sql = "Select top 1 * from digital order by dateCreate desc";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Digital(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println("Loi getMostDigital" + e.getMessage());
        }
        return null;
    }

    public List<Digital> getTop5Digital() {
        List<Digital> list = new ArrayList<>();
        try {
            String sql = "Select top 5 * from digital order by dateCreate desc";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Digital(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
            System.out.println("Loi getTop5Digital" + e.getMessage());

        }
        return list;
    }

    public List<Digital> getDigitalBySearch(String s, int index, int page) {
        List<Digital> list = new ArrayList<>();
        try {
            String sql = "with x as (select ROW_NUMBER() over(order by id) as r, * from Digital where title like ?)\n"
                    + "select * from x where r between ? and ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,"%" +s+"%");
            ps.setInt(2, page * (index - 1) + 1);
            ps.setInt(3, page * index);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Digital(rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println("Loi getDigitalBySearch" + e.getMessage());

        }
        return list;
    }

    public Digital getDigitalById(String id) {
        try {
            String sql = "select * from digital where id = ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Digital(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
            System.out.println("Loi getDigitalById" + e.getMessage());
        }
        return null;
    }

    public int getAllNumDigitalBySearch(String s) {

        try {
            String sql = "select COUNT(*) from digital where title like ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + s + "%");
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Loi getAllNumDigitalBySearch " + e.getMessage());
        }
        return 0;
    }
}
