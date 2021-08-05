/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Contact;
import entity.Gallery;
import entity.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hùng
 */
public class daoPhoto {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Contact getDataContact() {
        String sql = "select * from contact";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Contact(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("loi getDataContact" + e.getMessage());
        }
        return null;
    }

    public Gallery getGalleryById(String id) {
        String sql = "select * from gallery where id = ?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Gallery(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            }
        } catch (Exception e) {
            System.out.println("loi getGalleryById" + e.getMessage());
        }
        return null;
    }

    public List<Gallery> getDataTop3Gallery() {
        List<Gallery> listGalery = new ArrayList();
        String sql = "select top 3 * from gallery ";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listGalery.add(new Gallery(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
        } catch (Exception e) {
            System.out.println("loi getGalleryById" + e.getMessage());
        }
        return listGalery;
    }

    public int getallNumGallery() {
        String sql = "select COUNT(*) from gallery ";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("loi getGalleryById" + e.getMessage());
        }
        return 0;
    }

    public List<Gallery> getGalleryByPage(int index, int page) {
        List<Gallery> list = new ArrayList<>();
        try {
            String sql = "with x as (select ROW_NUMBER() over(order by id) as r, * from Gallery)\n"
                    + "select * from x where r between ? and ?";
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, page * (index - 1) + 1);
            ps.setInt(2, page * index);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Gallery(rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
            }
        } catch (Exception e) {
            System.out.println("Loi getGalleryByPage" + e.getMessage());

        }
        return list;
    }

    public Gallery getDataTop1Gallery() {
        String sql = "select top 1 * from gallery ";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return (new Gallery(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
        } catch (Exception e) {
            System.out.println("loi getDataTop1Gallery" + e.getMessage());
        }
        return null;
    }

    public List<Image> getImgGalleryById(String id) {
        List<Image> listImage = new ArrayList();
        String sql = "select * from image where gallery_id=? ";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                listImage.add(new Image(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3)
                ));
            }
        } catch (Exception e) {
            System.out.println("loi getImgGalleryById" + e.getMessage());
        }
        return listImage;
    }

    public int getCountImgByID(String id) {
        int a = 0;
        String sql = "select COUNT(url_img) from image where gallery_id =?";
        try {
            con = new DBContext().getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                a = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("loi getImgGalleryById" + e.getMessage());
        }
        return a;
    }
}
