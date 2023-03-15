/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class KTra_DuLieu {
    
  /*
         Ktra dữ liệu nhập vào textfiled
        */      
    public static void validateEmpty(JTextField field, StringBuilder sb,  String errorMessage){
   
        if(field.getText().equals("")){ 
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
             field.setBackground(Color.white);
        }
        
    }
    
    /*
    Ktra dữ liệu vào TextArea
    */
    public static void validateEmpty(JTextArea field, StringBuilder sb,  String errorMessage){
   
        if(field.getText().equals("")){ 
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
             field.setBackground(Color.white);
        }
        
    }
 /*
         Ktra dữ liệu nhập vào passwordFiled
        */      
    public static void validateEmpty(JPasswordField field, StringBuilder sb,  String errorMessage){
        String password = new String(field.getPassword());
        if(password.equals("")){ 
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
             field.setBackground(Color.white);
        }
    }
     /*
         Ktra dữ liệu SDT  nhập vào
        */      
    public static void KTraSDT(JTextField field, StringBuilder sb,  String errorMessage){
        String SDT = new String(field.getText());
        if(!SDT.matches("\\d{10}")){ 
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
             field.setBackground(Color.white);
        }
    }
         /*
         Ktra dữ liệu ngày tháng  nhập vào
        */      
    public static void KTraNgayThang(JTextField field, StringBuilder sb,  String errorMessage){
        String NgayThang = new String(field.getText());
        if(!NgayThang.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")){ 
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
             field.setBackground(Color.white);
        }
    }
    
    /*
    Ktra dữ liệu ràng buộc mã nhân viên
    */
     public static void KTraRangBuocMaNV(JTextField field, StringBuilder sb,  String errorMessage){
        String MaNV = new String(field.getText());
        if(!MaNV.matches("[NV]{2}\\d{3}") && !MaNV.matches("[TP]{2}\\d{3}") ){ 
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        }else{
             field.setBackground(Color.white);
        }
    }
}
