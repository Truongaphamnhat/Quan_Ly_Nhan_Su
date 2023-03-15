/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Helper.CSDL_NhanVien;
import Model.NguoiDung;
import Model.NhanVien;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
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
public class NhanVienDao {
     public boolean insert (NhanVien nv) throws Exception{       
 
            String sql="  INSERT INTO dbo.NhanVien (MaNhanVien, HoTen, NgaySinh, GioiTinh, NgayVaoLam, ChucVu, SDT, DiaChi, ChuThich, Hinh) "
                    + "  values(?,?,?,?,?,?,?,?,?,?)";
           try(
                    Connection con = CSDL_NhanVien.openConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql);
                   ){
                            pstmt.setString(1, nv.getMaNhanVien() );
                            pstmt.setString(2, nv.getHoTen());
                             pstmt.setString(3,  nv.getNgaySinh());
                             pstmt.setInt(4, nv.getGioiTinh());
                            pstmt.setString(5,  nv.getNgayVaoLam());
                           pstmt.setString(6, nv.getChucVu());
                            pstmt.setString(7, nv.getSDT());
                             pstmt.setString(8, nv.getDiaChi());
                              pstmt.setString(9, nv.getChuThich());
                            
                            if (nv.getHinh() != null)   {
                         // Tạo Đối Tượng Blog thiết lập cho tham số
                                Blob hinh = new SerialBlob(nv.getHinh());
                                pstmt.setBlob(10, hinh);
                            } else{
                                    Blob hinh = null;
                                    pstmt.setBlob(10, hinh);
                                    }                                                     
                            
                                  return pstmt.executeUpdate()>0;
                     } 
           
        
        }
     
      public boolean update (NhanVien nv) throws Exception{       
 
          
            String sql="UPDATE dbo.NhanVien\n" +
                            "   SET  HoTen = ?, NgaySinh = ?, GioiTinh = ?, NgayVaoLam = ?, ChucVu = ?, SDT = ?, DiaChi = ?, ChuThich = ?, Hinh = ?" + 
                            "    where MaNhanVien = ?";
           try(
                    Connection con = CSDL_NhanVien.openConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql);
                   ){
                            pstmt.setString(10, nv.getMaNhanVien());
                            pstmt.setString(1, nv.getHoTen());
                             pstmt.setString(2,  nv.getNgaySinh());
                             pstmt.setInt(3, nv.getGioiTinh());
                            pstmt.setString(4,  nv.getNgayVaoLam());
                           pstmt.setString(5, nv.getChucVu());
                            pstmt.setString(6, nv.getSDT());
                             pstmt.setString(7, nv.getDiaChi());
                              pstmt.setString(8, nv.getChuThich());
                            
                            if (nv.getHinh() != null)   {
                         // Tạo Đối Tượng Blog thiết lập cho tham số
                                Blob hinh = new SerialBlob(nv.getHinh());
                                pstmt.setBlob(9, hinh);
                            } else{
                                    Blob hinh = null;
                                    pstmt.setBlob(9, hinh);
                                    }                        
                                    
                            
                                  return pstmt.executeUpdate()>0;
                     }
           
        
        }
      
       public boolean delete (String MaNhanVien) throws Exception{       
 
          
            String sql="delete from NhanVien" +
                    "  where MaNhanVien = ?";
           try(
                    Connection con = CSDL_NhanVien.openConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql);
                   ){
                            pstmt.setString(1, MaNhanVien );
                                                    
                             return pstmt.executeUpdate()>0;
                     }
           }
       
       public NhanVien findById (String MaNhanVien) throws Exception{       
 
          
            String sql= " SELECT *  from NhanVien where MaNhanVien =?";
           try(
                    Connection con = CSDL_NhanVien.openConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql);
                   ){
                            pstmt.setString(1, MaNhanVien );
                                                    
                            try(ResultSet rs = pstmt.executeQuery();){
                                if(rs.next()){
                                    NhanVien NV = TaoNhanVien(rs);
                                    return NV;
                                }
                            }
                            return null;
                     }
           }

    private NhanVien TaoNhanVien(final ResultSet rs) throws SQLException {
        NhanVien NV = new NhanVien();
        NV.setMaNhanVien(rs.getString("manhanvien"));
        NV.setHoTen(rs.getString("hoten"));
        NV.setNgaySinh(rs.getString("ngaysinh"));
        NV.setNgayVaoLam(rs.getString("ngayvaolam"));
        NV.setChucVu(rs.getString("chucvu"));
        NV.setChuThich(rs.getString("chuthich"));
        NV.setSDT(rs.getString("SDT"));
        NV.setDiaChi(rs.getString("diachi"));
        NV.setGioiTinh(rs.getInt("gioitinh"));
        Blob blob = rs.getBlob("hinh");
        
        if(blob != null){
                NV.setHinh(blob.getBytes(1, (int)  blob.length()));
        }
        return NV;
    }
      

        public List< NhanVien> findAll () throws Exception{       
 
          
            String sql=  " SELECT  *  from NhanVien";
           try(
                    Connection con = CSDL_NhanVien.openConnection();
                    PreparedStatement pstmt = con.prepareStatement(sql);
                   ){
                                                                           
                            try(ResultSet rs = pstmt.executeQuery();){
                                List <NhanVien> list = new ArrayList<>();
                                while   (rs.next()){
                                    NhanVien NV = TaoNhanVien(rs);
                                    list.add(NV);
                                }
                                return list;
                            }
                            
                     }
           }
}
