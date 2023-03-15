/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class CSDL_NhanVien {
    public static Connection openConnection() throws  Exception{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
                      String connectionUrl = "jdbc:sqlserver://localhost:1433;database=Quan_Li_Nhan_Su;"  ;
                      String username = "QuanLi";
                      String password = "969158";
                      Connection con = DriverManager.getConnection(connectionUrl,username,password);
                      
                      return con;
    }
}
