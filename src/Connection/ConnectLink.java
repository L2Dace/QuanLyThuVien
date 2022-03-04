/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Type.bao;
import Type.sach;
import Type.tapChi;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ConnectLink {
    
    public List<sach> getAllSach() {
        List<sach> dssach = new ArrayList<sach>();
        Connection connection = SQLconnection.getConnection();
        
        String sql = "SELECT * FROM Sach";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while( rs.next()) {
                sach Sach = new sach();
                
                Sach.setMaTaiLieu(rs.getString("maTaiLieu"));
                Sach.setTenNXB(rs.getString("tenNXB"));
                Sach.setSoBanPhatHanh(rs.getInt("soBanPhatHanh"));
                Sach.setTenTacGia(rs.getString("tenTacGia"));
                Sach.setSoTrang(rs.getInt("soTrang"));
                
                dssach.add(Sach);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return dssach;
    }
    
    public List<tapChi> getAllTapChi() {
        List<tapChi> dsTapChi = new ArrayList<tapChi>();
        Connection connection = SQLconnection.getConnection();
        
        String sql = "SELECT * FROM TapChi";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while( rs.next()) {
                tapChi TapChi = new tapChi();
                
                TapChi.setMaTaiLieu(rs.getString("maTaiLieu"));
                TapChi.setTenNXB(rs.getString("tenNXB"));
                TapChi.setSoBanPhatHanh(rs.getInt("soBanPhatHanh"));
                TapChi.setSoPhatHanh(rs.getInt("soPhatHanh"));
                TapChi.setThangPhatHanh(rs.getString("thangPhatHanh"));
                
                dsTapChi.add(TapChi);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return dsTapChi;
    }
    
    public List<bao> getAllBao() {
        List<bao> dsBao = new ArrayList<bao>();
        Connection connection = SQLconnection.getConnection();
        
        String sql = "SELECT * FROM Bao";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while( rs.next()) {
                bao Bao = new bao();
                
                Bao.setMaTaiLieu(rs.getString("maTaiLieu"));
                Bao.setTenNXB(rs.getString("tenNXB"));
                Bao.setSoBanPhatHanh(rs.getInt("soBanPhatHanh"));
                Bao.setNgayPhatHanh(rs.getString("ngayPhatHanh"));
                
                dsBao.add(Bao);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return dsBao;
    }
    
    
    public void addSach (sach Sach){
        
        Connection connection = SQLconnection.getConnection();
        
        String sql = "INSERT INTO Sach (tenNXB,soBanPhatHanh,tenTacGia,soTrang)"
                + "values (?,?,?,?)";
        
        try{
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, Sach.getTenNXB());
            prepareStatement.setInt(2, Sach.getSoBanPhatHanh());
            prepareStatement.setString(3, Sach.getTenTacGia());
            prepareStatement.setInt(4, Sach.getSoTrang());
            
            prepareStatement.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addTapChi (tapChi TapChi){
        Connection connection = SQLconnection.getConnection();
        String sql = "INSERT INTO TapChi (tenNXB,soBanPhatHanh,soPhatHanh,thangPhatHanh)"
                + "values (?,?,?,?)";
        try{
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, TapChi.getTenNXB());
            prepareStatement.setInt(2, TapChi.getSoBanPhatHanh());
            prepareStatement.setInt(3, TapChi.getSoPhatHanh());
            prepareStatement.setString(4, TapChi.getThangPhatHanh());
            
            prepareStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addBao (bao Bao){
        Connection connection = SQLconnection.getConnection();
        String sql = "INSERT INTO Bao (tenNXB,soBanPhatHanh,ngayPhatHanh)"
                + "values (?,?,?)";
        try{
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, Bao.getTenNXB());
            prepareStatement.setInt(2, Bao.getSoBanPhatHanh());
            prepareStatement.setString(3, Bao.getNgayPhatHanh());
            
            prepareStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
