/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.CSDL_NhanVien;
import Model.BangLuong;
import Model.NhanVien;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author HP
 */
public class BangLuongDao {
     public boolean insert (BangLuong bl) throws Exception{       
        
            String sql="INSERT INTO dbo.BangLuong  (MaNhanVien, HoTenNV, Thang,  SoGioLamThem, SoNgayNghi, LuongCoBan, TinhLuong) values (?,?,?,?,?,?,?)";
           try(
                    Connection con = CSDL_NhanVien.openConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql);
                   ){
                            pstmt.setString(1, bl.getMaNhanVien());
                            pstmt.setString(2, bl.getHoTenNV());
                            pstmt.setString(3, bl.getThang());
                            
                            pstmt.setInt(4, bl.getSoGioLamThem());
                            pstmt.setInt(5, bl.getSoNgayNghi());
                            
                            pstmt.setFloat(6, bl.getLuongCoBan());
                            pstmt.setFloat(7, bl.getTinhLuong());
                                         
                            
                             return pstmt.executeUpdate()>0;
                        }
           }
     
      public boolean update (BangLuong bl) throws Exception{ 
                         
            String sql = "UPDATE dbo.BangLuong " +
                     " SET HoTenNV = ?, Thang = ?,  SoGioLamThem = ?, SoNgayNghi = ?, LuongCoBan = ?, TinhLuong = ?" +
                     " where MaNhanVien = ?";
            
           try(
                    Connection con = CSDL_NhanVien.openConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql);
                   ){
                            pstmt.setString(7, bl.getMaNhanVien());
                            pstmt.setString(1, bl.getHoTenNV());
                            pstmt.setString(2, bl.getThang());
                            
                            pstmt.setInt(3, bl.getSoGioLamThem());
                            pstmt.setInt(4, bl.getSoNgayNghi());
                            
                            pstmt.setFloat(5, bl.getLuongCoBan());
                            pstmt.setFloat(6, bl.getTinhLuong());
                          
                                         
                            return pstmt.executeUpdate()>0;
                        }
           }
      
      public boolean deleteByMaNhanVien (String MaNhanVien) throws Exception{ 
                         
            String sql="DELETE from BangLuong "
                      + "  WHERE MaNhanVien = ?";
            
           try(
                    Connection con = CSDL_NhanVien.openConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql);
                   ){
                            pstmt.setString(1, MaNhanVien);

                             return pstmt.executeUpdate()>0;
                        }
           }
      
      public BangLuong findByMaNhanVien (String MaNhanVien) throws Exception{ 
                         
            String sql=" SELECT * from BangLuong WHERE MaNhanVien = ?";
            
           try(
                    Connection con = CSDL_NhanVien.openConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql);
                   ){
                            pstmt.setString(1, MaNhanVien);
                              
                            try(ResultSet rs = pstmt.executeQuery();){
                                if(rs.next()){
                                    BangLuong BL = TaoBangLuong(rs);                                 
                                       
                                    return BL;
                                }
                            }
                            return null;
                             
                        }
           }
      
        public List<BangLuong> findAll () throws Exception{ 
                         
            String sql="SELECT * from BangLuong";
            
           try(
                    Connection con = CSDL_NhanVien.openConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql);
                   ){
                            
                                List <BangLuong> list = new ArrayList<>();
                          
                            try(ResultSet rs = pstmt.executeQuery();){
                                while   (rs.next()){
                                    BangLuong BL = TaoBangLuong(rs);                                 
                                    
                                    list.add(BL);                                    
                                }
                                return list;
                            }
                           
                             
                        }
           }

    private BangLuong TaoBangLuong(final ResultSet rs) throws SQLException {
        BangLuong BL = new BangLuong();
        NhanVien NV = new NhanVien();
        NV.setChucVu("ChucVu");
        BL.setMa(rs.getInt("Ma"));
        BL.setMaNhanVien(rs.getString("MaNhanVien"));
        BL.setHoTenNV(rs.getString("HoTenNV"));
        BL.setSoNgayNghi(rs.getInt("SoNgayNghi"));
        BL.setSoGioLamThem(rs.getInt("SoGioLamThem"));
        BL.setThang(rs.getString("Thang"));
        BL.setLuongCoBan(rs.getFloat("LuongCoBan"));
        BL.setTinhLuong(rs.getFloat("TinhLuong"));
        
   
        return BL;
    }

         public List<BangLuong> findTop ( int top) throws Exception{ 
                         
            String sql="select top "+  top +"   *, Thang  as thang  " + 
                                " from BangLuong order by (RIGHT(Thang, 4)) desc, (LEFT(Thang, 2)) desc  ";
            
           try(
                    Connection con = CSDL_NhanVien.openConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql);
                   ){
                            
                                List <BangLuong> list = new ArrayList<>();
                          
                            try(ResultSet rs = pstmt.executeQuery();){
                                while   (rs.next()){
                                    BangLuong BL = TaoBangLuong(rs);                                 
                                    
                                    list.add(BL);                                    
                                }
                                return list;
                            }
                           
                             
                        }
           }
}
