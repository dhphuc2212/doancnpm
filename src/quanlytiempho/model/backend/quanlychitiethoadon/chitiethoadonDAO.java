/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlychitiethoadon;
import java.util.*;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import quanlytiempho.model.backend.quanlyhoadon.hoadon;
/**
 *
 * @author Acer
 */
public class chitiethoadonDAO {
       Connectiondb con;
   public chitiethoadonDAO()
   {
       
   }
   public ArrayList readDB()
   {
       con=new Connectiondb();
       ArrayList<chitiethoadon> dscthd=new ArrayList<>();
       try
       {
           String query="Select * from chitiethoadon";
           ResultSet r=con.sqlres(query);
          if(r!=null)
          {
              while(r.next())
              {
                  chitiethoadon t=new chitiethoadon();
                  t.setIdchitiethoadon(r.getString("idchitiethoadon"));
                  t.setIdhoadon(r.getString("idhoadon"));
                  t.setIdto(r.getInt("idto"));
                  t.setLoaito(r.getString("loaito"));
                  t.setDongiato(r.getDouble("dongia"));
                  t.setTenmonphu(r.getString("tenmonphu"));
                  t.setSoluongmp(r.getInt("soluongmonphu"));
                  t.setDongiamonphu(r.getDouble("dongiamonphu"));
                 dscthd.add(t);
              }
          }
          
       }
       catch(SQLException e)
       {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu trong bảng chi tiết hóa đơn.");
       }
       finally
       {
           con.closeconnect();
       }
       return dscthd;
   }
   
     public Boolean addcthd(chitiethoadon t)
    {
        con=new Connectiondb();
        String query="Insert into `chitiethoadon` values('"+t.getIdchitiethoadon()+"','"+t.getIdhoadon()+"','"+t.getIdto()+"','"+t.getLoaito()+"','"+t.getDongiato()+"','"+t.getTenmonphu()+"','"+t.getSoluongmp()+"','"+t.getDongiamonphu()+"')";
        Boolean yup=con.checkupdate(query);
        con.closeconnect();
        return yup;
      }
     public Boolean del(String id)
{
    con=new Connectiondb();
    String query="DELETE FROM `chitiethoadon` where `chitiethoadon`.`idchitiethoadon`='"+id+"'";
    Boolean yay=con.checkupdate(query);
    return yay;
}
  
public void close()
{
    con.closeconnect();
}
}
