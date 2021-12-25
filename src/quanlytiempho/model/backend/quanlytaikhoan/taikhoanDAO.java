/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlytaikhoan;
import java.util.*;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.time.LocalTime;
import quanlytiempho.model.backend.quanlythuckhach.thuckhach;
public class taikhoanDAO {
       Connectiondb con;
   public taikhoanDAO()
   {
       
   }
   public ArrayList readDB()
   {
       con=new Connectiondb();
       ArrayList<taikhoan> dstk=new ArrayList<>();
       try
       {
           String query="Select * from taikhoan";
           ResultSet r=con.sqlres(query);
          if(r!=null)
          {
              while(r.next())
              {
                  taikhoan t=new taikhoan();
                  t.setMatkhau(r.getString("matkhau"));
                  t.setIdnhanvien(r.getString("idnhanvien"));
                  t.setTentaikhoan(r.getString("tentaikhoan"));
                  t.setIdtaikhoan(r.getString("idtaikhoan"));
                  t.setIdquyen(r.getInt("maquyen"));
  
                 dstk.add(t);
              }
          }
          
       }
       catch(SQLException e)
       {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu trong bảng tài khoản.");
       }
       finally
       {
           con.closeconnect();
       }
       return dstk;
   }
  
     public Boolean addtaikhoan(taikhoan t)
    {
        con=new Connectiondb();
        String query="Insert into `taikhoan` values('"+t.getIdtaikhoan()+"','"+t.getTentaikhoan()+"','"+t.getMatkhau()+"','"+t.getIdnhanvien()+"','"+t.getIdquyen()+"')";
        Boolean yup=con.checkupdate(query);
        con.closeconnect();
        return yup;
      }
     public Boolean del(String idtaikhoan)
{
    con=new Connectiondb();
    String query="DELETE FROM `taikhoan` where `taikhoan`.`idtaikhoan`='"+idtaikhoan+"'";
    Boolean yay=con.checkupdate(query);
    return yay;
}
     public Boolean update(String idtaikhoan,String tentaikhoan,String matkhau,int maquyen,String idnhanvien)
{
    con=new Connectiondb();
    String query="Update `taikhoan` set tentaikhoan='"+tentaikhoan+"',matkhau='"+matkhau+"',maquyen='"+maquyen+"'where idtaikhoan='"+idtaikhoan+"'";
   Boolean yay=con.checkupdate(query);
   return yay;
}
public void close()
{
    con.closeconnect();
}
}

