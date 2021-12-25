/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlyphanquyen;

import java.util.*;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import quanlytiempho.model.backend.quanlytaikhoan.taikhoan;
public class phanquyenDAO {
         Connectiondb con;
   public phanquyenDAO()
   {
       
   }
   public ArrayList readDB()
   {
       con=new Connectiondb();
       ArrayList<phanquyen> dspq=new ArrayList<>();
       try
       {
           String query="Select * from phanquyen";
           ResultSet r=con.sqlres(query);
          if(r!=null)
          {
              while(r.next())
              {
                  phanquyen t=new phanquyen();
                  t.setMaquyen(r.getInt("id"));
                  t.setTenquyen(r.getString("tenquyen"));
                  t.setGhichu(r.getString("ghichu"));
                  
  
                 dspq.add(t);
              }
          }
          
       }
       catch(SQLException e)
       {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu trong phân quyền.");
       }
       finally
       {
           con.closeconnect();
       }
       return dspq;
   }
  
     public Boolean addquyen(phanquyen t)
    {
        con=new Connectiondb();
        String query="Insert into `phanquyen` values('"+t.getMaquyen()+"','"+t.getTenquyen()+"','"+t.getGhichu()+"')";
        Boolean yup=con.checkupdate(query);
        con.closeconnect();
        return yup;
      }
     public Boolean del(int id)
{
    con=new Connectiondb();
    String query="DELETE FROM `phanquyen` where `phanquyen`.`id`='"+id+"'";
    Boolean yay=con.checkupdate(query);
    return yay;
}
     public Boolean update(int maquyen,String tenquyen,String ghichu)
{
    con=new Connectiondb();
    String query="Update `phanquyen` set tenquyen='"+tenquyen+"',ghichu='"+ghichu+"'where id='"+maquyen+"'";
   Boolean yay=con.checkupdate(query);
   return yay;
}
public void close()
{
    con.closeconnect();
}
}
