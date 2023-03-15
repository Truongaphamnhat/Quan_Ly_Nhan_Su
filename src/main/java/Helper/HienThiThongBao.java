/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class HienThiThongBao {
    public static  void ThongBao(Component cha, String NoiDung, String TieuDe){
        JOptionPane.showMessageDialog(cha, NoiDung, TieuDe, JOptionPane.INFORMATION_MESSAGE);
    }
     public static  void ThongBaoLoi(Component cha, String NoiDung, String TieuDe){
        JOptionPane.showMessageDialog(cha, NoiDung, TieuDe, JOptionPane.ERROR_MESSAGE);
    }
      public static  int ThongBaoXacNhan(Component cha, String NoiDung, String TieuDe){
      int choose =    JOptionPane.showConfirmDialog(cha, NoiDung, TieuDe, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
      return choose;
    }
}
