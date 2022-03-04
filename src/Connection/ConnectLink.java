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
    
//Lay du lieu tu database
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
// lay ma tai lieu tu dong
    public String getIdNext(String x)
    {
        String truoc=x.substring(0, 2);
        String sau=x.substring(2, 5);
        int cong = Integer.parseInt(sau)+1;
        sau=String.valueOf(cong);
        if (sau.length() == 1)
                sau="00".concat(sau);
        else if (sau.length() == 2)
            sau="0".concat(sau);
        truoc=truoc.concat(sau);
        return truoc;
    }
//them du lieu
    public void addSach (sach Sach){
        
        Connection connection = SQLconnection.getConnection();
        
        String idnext="";
        try {
            String sqllastiid=  "select top 1 maTaiLieu \n" +
                                "from Sach\n" +
                                "order by maTaiLieu desc ";
            PreparedStatement lastid = connection.prepareStatement(sqllastiid);
            ResultSet rslastid = lastid.executeQuery();
            rslastid.next();
            idnext+=rslastid.getString(1);
        }
        catch(SQLException e)
        {
            System.out.println("ma tai lieu loi");
        }
        String getidnext=getIdNext(idnext);
           
        try{
            String sql = "INSERT INTO Sach (maTaiLieu,tenNXB,soBanPhatHanh,tenTacGia,soTrang)"
                + "values (?,?,?,?,?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1,getidnext);
            prepareStatement.setString(2, Sach.getTenNXB());
            prepareStatement.setInt(3, Sach.getSoBanPhatHanh());
            prepareStatement.setString(4, Sach.getTenTacGia());
            prepareStatement.setInt(5, Sach.getSoTrang());
            
            prepareStatement.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addTapChi (tapChi TapChi){
        Connection connection = SQLconnection.getConnection();
        
        String idnext="";
        try {
            String sqllastiid=  "select top 1 maTaiLieu \n" +
                                "from TapChi\n" +
                                "order by maTaiLieu desc ";
            PreparedStatement lastid = connection.prepareStatement(sqllastiid);
            ResultSet rslastid = lastid.executeQuery();
            rslastid.next();
            idnext+=rslastid.getString(1);
        }
        catch(SQLException e)
        {
            System.out.println("ma tai lieu loi");
        }
        String getidnext=getIdNext(idnext);
        
        try{
            String sql = "INSERT INTO TapChi (maTaiLieu,tenNXB,soBanPhatHanh,soPhatHanh,thangPhatHanh)"
                + "values (?,?,?,?,?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, getidnext);
            prepareStatement.setString(2, TapChi.getTenNXB());
            prepareStatement.setInt(3, TapChi.getSoBanPhatHanh());
            prepareStatement.setInt(4, TapChi.getSoPhatHanh());
            prepareStatement.setString(5, TapChi.getThangPhatHanh());
            
            prepareStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addBao (bao Bao){
        Connection connection = SQLconnection.getConnection();
        
        String idnext="";
        try {
            String sqllastiid=  "select top 1 maTaiLieu \n" +
                                "from Bao\n" +
                                "order by maTaiLieu desc ";
            PreparedStatement lastid = connection.prepareStatement(sqllastiid);
            ResultSet rslastid = lastid.executeQuery();
            rslastid.next();
            idnext+=rslastid.getString(1);
        }
        catch(SQLException e)
        {
            System.out.println("ma tai lieu loi");
        }
        String getidnext=getIdNext(idnext);
        
        try{
            String sql = "INSERT INTO Bao (maTaiLieu,tenNXB,soBanPhatHanh,ngayPhatHanh)"
                + "values (?,?,?,?)";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, getidnext);
            prepareStatement.setString(2, Bao.getTenNXB());
            prepareStatement.setInt(3, Bao.getSoBanPhatHanh());
            prepareStatement.setString(4, Bao.getNgayPhatHanh());
            
            prepareStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//xoa du lieu
    public void deleteSach(String maTaiLieu){
        Connection connection = SQLconnection.getConnection();
        
        String sql = "delete from Sach where maTaiLieu = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTaiLieu);
            
            int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteTapChi(String maTaiLieu){
        Connection connection = SQLconnection.getConnection();
        
        String sql = "delete from TapChi where maTaiLieu = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTaiLieu);
            
            int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteBao(String maTaiLieu){
        Connection connection = SQLconnection.getConnection();
        
        String sql = "delete from Bao where maTaiLieu = ?";
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, maTaiLieu);
            
            int rs = preparedStatement.executeUpdate();
                System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
