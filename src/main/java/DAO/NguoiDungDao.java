/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.CSDL_NhanVien;
import Model.NguoiDung;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public class NguoiDungDao {
      public  NguoiDung Ktra_DangNhap(String TenDangNhap, String MatKhau) throws Exception{
          
          // Câu lệnh kiểm tra lấy thông tin đăng nhập, mật khẩu, vai trò từ dữ liệu người dùng
            String sql=" select TenDangNhap, MatKhau from NguoiDung" + "   where TenDangNhap=? and MatKhau=?";
           try(
                    Connection con = CSDL_NhanVien.openConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql);
                   ){
                            pstmt.setString(1, TenDangNhap);
                            pstmt.setString(2, MatKhau);
                            
                            try(ResultSet rs = pstmt.executeQuery();){
                                if(rs.next()){
                                    NguoiDung nd = new NguoiDung();
                                     nd.setTenDangNhap(TenDangNhap);
                                    
                                     
                                     return nd;
                                }
                                
                            }
                                                                   
                     }
               return null;
        
        }
}
