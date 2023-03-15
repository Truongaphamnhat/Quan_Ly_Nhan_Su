/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author HP
 */
public class BangLuong {
    private int ma, SoNgayNghi, SoGioLamThem;    
   private String  MaNhanVien, HoTenNV,Thang;
   private float LuongCoBan, TinhLuong;
    public BangLuong() {
    }

    public BangLuong(int ma, int SoNgayNghi, int SoGioLamThem, String MaNhanVien, String HoTenNV, String Thang, float LuongCoBan, float TinhLuong) {
        this.ma = ma;
        this.SoNgayNghi = SoNgayNghi;
        this.SoGioLamThem = SoGioLamThem;
        this.MaNhanVien = MaNhanVien;
        this.HoTenNV = HoTenNV;
        this.Thang = Thang;
        this.LuongCoBan = LuongCoBan;
        this.TinhLuong = TinhLuong;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public int getSoNgayNghi() {
        return SoNgayNghi;
    }

    public void setSoNgayNghi(int SoNgayNghi) {
        this.SoNgayNghi = SoNgayNghi;
    }

    public int getSoGioLamThem() {
        return SoGioLamThem;
    }

    public void setSoGioLamThem(int SoGioLamThem) {
        this.SoGioLamThem = SoGioLamThem;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getHoTenNV() {
        return HoTenNV;
    }

    public void setHoTenNV(String HoTenNV) {
        this.HoTenNV = HoTenNV;
    }

    public String getThang() {
        return Thang;
    }

    public void setThang(String Thang) {
        this.Thang = Thang;
    }

    public float getLuongCoBan() {
        return LuongCoBan;
    }

    public void setLuongCoBan(float LuongCoBan) {
        this.LuongCoBan = LuongCoBan;
    }

    public float getTinhLuong() {
        return TinhLuong;
    }

    public void setTinhLuong(float TinhLuong) {
        this.TinhLuong = TinhLuong;
    }

   


}
