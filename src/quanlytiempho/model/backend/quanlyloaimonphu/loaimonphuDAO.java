/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlyloaimonphu;
import java.util.*;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
public class loaimonphuDAO {
           Connectiondb con;
   public loaimonphuDAO()
   {
       
   }
   public ArrayList readDB()
   {
       con=new Connectiondb();
       ArrayList<loaimonphu> dslmp=new ArrayList<>();
       try
       {
           String query="Select * from loaimonphu";
           ResultSet r=con.sqlres(query);
          if(r!=null)
          {
              while(r.next())
              {
                  loaimonphu t=new loaimonphu();
                  t.setId(r.getInt("id"));
                  t.setTenloai(r.getString("tenloai"));
                 dslmp.add(t);
              }
          }
          
       }
       catch(SQLException e)
       {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu trong bảng loại món phụ.");
       }
       finally
       {
           con.closeconnect();
       }
       return dslmp;
   }
    public ArrayList<loaimonphu> search(String columnname,String value)
    {
        con=new Connectiondb();
        ArrayList<loaimonphu> t=new ArrayList<>();
        try
        {
            String query="select * from loaimonphu where "+columnname+"="+value;
            ResultSet r=con.sqlres(query);
             if(r!=null)
                {
                    while(r.next())
                    {
                        int id=r.getInt("id");
                        String tenloai=r.getString("tenloai");
                        t.add(new loaimonphu(id,tenloai));
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
     public Boolean addloaimonphu(loaimonphu t)
    {
        con=new Connectiondb();
        String query="Insert into `loaimonphu` values('"+t.getId()+"','"+t.getTenloai()+"')";
        Boolean yup=con.checkupdate(query);
        con.closeconnect();
        return yup;
      }
     public Boolean del(int id)
{
    con=new Connectiondb();
    String query="DELETE FROM `loaimonphu` where `loaimonphu`.`id`='"+id+"'";
    Boolean yay=con.checkupdate(query);
    return yay;
}
     public Boolean update(int id,String tenloai)
{
    con=new Connectiondb();
    String query="Update `loaimonphu` set tenloai='"+tenloai+"'where id='"+id+"'";
   Boolean yay=con.checkupdate(query);
   return yay;
}
public void close()
{
    con.closeconnect();
}
}
