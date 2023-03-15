/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Graphics2D;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;


/**
 *
 * @author HP
 */
public class XuLyHinhAnh {
    /*
    Cho phép điều chỉnh kích thước hình ảnh
    */
    public static Image KichThuoc_HinhAnh ( Image HinhAnh,  int ChieuRong, int ChieuCao){
        Image KQ_Anh = HinhAnh.getScaledInstance(ChieuRong, ChieuCao, Image.SCALE_SMOOTH);
        
        return KQ_Anh;
    }
    
    /*
    Chuyển hình ảnh thành mảng kí tự byte
    */
    public static  byte[] TaoMangKyTu( Image Anh, String Kieu) throws  IOException{
            BufferedImage bimage = new BufferedImage(Anh.getWidth(null), Anh.getHeight(null), BufferedImage.TYPE_INT_RGB );
            Graphics2D g = bimage.createGraphics();
            g.drawImage(Anh, 0, 0, null);
            g.dispose();
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bimage, Kieu, baos);
            byte[]  imageInByte = baos.toByteArray();
            
            return imageInByte;
    }
    
    /*
    Chuyển mảng kí tự byte về đối tượng hình ảnh
    */
    public static Image TaoAnhTuKiTuMang (byte [] DuLieu, String  Kieu) throws IOException{
        ByteArrayInputStream bais = new ByteArrayInputStream(DuLieu);
        BufferedImage bImages2 = ImageIO.read(bais);
        
        Image img = bImages2.getScaledInstance(bImages2.getWidth(), bImages2.getHeight(), Image.SCALE_SMOOTH);
        return img;
    }
}
