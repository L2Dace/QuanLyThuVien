/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class SQLconnection {
    
    public static Connection getConnection() {
        String url = "jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=QuanLyThuVien2";
        String userName = "sa";
        String password = "blackace71202";
    
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, userName, password);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
//            System.out.println("Khong thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        }
}
