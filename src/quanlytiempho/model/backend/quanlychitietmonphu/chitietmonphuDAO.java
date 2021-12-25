/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlychitietmonphu;

import java.util.*;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import quanlytiempho.model.backend.quanlymonphu.monphu;
public class chitietmonphuDAO {
          Connectiondb con;
   public chitietmonphuDAO()
   {
       
   }
   
   public ArrayList readDB()
   {
       con=new Connectiondb();
       ArrayList<chitietmonphu> dsctmp=new ArrayList<>();
       try
       {
           String query="Select * from chitietmonphu";
           ResultSet r=con.sqlres(query);
          if(r!=null)
          {
              while(r.next())
              {
                  chitietmonphu t=new chitietmonphu();
                  t.setId(r.getInt("id"));
                  t.setIdmonphu(r.getInt("idmonphu"));
                  t.setIdto(r.getInt("idto"));
                 dsctmp.add(t);
              }
          }
          
       }
       catch(SQLException e)
       {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu trong bảng danh sách món phụ.");
       }
       finally
       {
           con.closeconnect();
       }
       return dsctmp;
   }
    public ArrayList<chitietmonphu> search(String columnname,String value)
    {
        con=new Connectiondb();
        ArrayList<chitietmonphu> t=new ArrayList<>();
        try
        {
            String query="select * from chitietmonphu where "+columnname+"="+value;
            ResultSet r=con.sqlres(query);
             if(r!=null)
                {
                    while(r.next())
                    {
                        int id=r.getInt("id");
                        int idmonphu=r.getInt("idmonphu");
                        int idto=r.getInt("idto");
                       
                        t.add(new chitietmonphu(id,idmonphu,idto));
                    }
                }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Loi tim du lieu "+columnname+"="+value+"trong bang");
        }
        finally
        {
            con.closeconnect();
        }
        return t;
    }
     public Boolean addchitietmonphu(chitietmonphu t)
    {
        con=new Connectiondb();
        String query="Insert into chitietmonphu values('"+t.getId()+"','"+t.getIdto()+"','"+t.getIdmonphu()+"')";
        Boolean yup=con.checkupdate(query);
        con.closeconnect();
        return yup;
      }
     public Boolean del(int id)
{
    con=new Connectiondb();
    String query="DELETE FROM `chitietmonphu` where `chitietmonphu`.`id`='"+id+"'";
    Boolean yay=con.checkupdate(query);
    return yay;
}
     public Boolean update(int id,int idmonphu,int idto)
{
    con=new Connectiondb();
    String query="Update `chitietmonphu` set idmonphu='"+idmonphu+"',idto='"+idto+"'where id='"+id+"'";
   Boolean yay=con.checkupdate(query);
   return yay;
}
public void close()
{
    con.closeconnect();
}
}
