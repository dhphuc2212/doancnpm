/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlymonphu;
import java.util.*;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
public class monphuDAO {
               Connectiondb con;
   public monphuDAO()
   {
       
   }
   public ArrayList readDB()
   {
       con=new Connectiondb();
       ArrayList<monphu> dsmp=new ArrayList<>();
       try
       {
           String query="Select * from monphu";
           ResultSet r=con.sqlres(query);
          if(r!=null)
          {
              while(r.next())
              {
                  monphu t=new monphu();
                  t.setIdmonphu(r.getInt("idmonphu"));
                  t.setTenmonphu(r.getString("tenmonphu"));
                  t.setIdloaimonphu(r.getInt("idloaimonphu"));
                  t.setGiatien(r.getFloat("giatien"));
                 dsmp.add(t);
              }
          }
          
       }
       catch(SQLException e)
       {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu trong bảng món phụ.");
       }
       finally
       {
           con.closeconnect();
       }
       return dsmp;
   }
    public ArrayList<monphu> search(String columnname,String value)
    {
        con=new Connectiondb();
        ArrayList<monphu> t=new ArrayList<>();
        try
        {
            String query="select * from monphu where "+columnname+"="+value;
            ResultSet r=con.sqlres(query);
             if(r!=null)
                {
                    while(r.next())
                    {
                        int idmonphu=r.getInt("idmonphu");
                        String tenmonphu=r.getString("tenmonphu");
                        int idloaimonphu=r.getInt("idloaimonphu");
                        float giatien=r.getFloat("giatien");
                        t.add(new monphu(idmonphu,tenmonphu,giatien,idloaimonphu));
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
     public Boolean addmonphu(monphu t)
    {
        con=new Connectiondb();
        String query="Insert into `monphu` values('"+t.getIdmonphu()+"','"+t.getTenmonphu()+"','"+t.getGiatien()+"','"+t.getIdloaimonphu()+"')";
        Boolean yup=con.checkupdate(query);
        con.closeconnect();
        return yup;
      }
     public Boolean del(int idmonphu)
{
    con=new Connectiondb();
    String query="DELETE FROM `monphu` where `monphu`.`idmonphu`='"+idmonphu+"'";
    Boolean yay=con.checkupdate(query);
    return yay;
}
     public Boolean update(int idmonphu,String tenmonphu,int idloaimonphu,float giatien)
{
    con=new Connectiondb();
    String query="Update `monphu` set tenmonphu='"+tenmonphu+"',idloaimonphu='"+idloaimonphu+"',giatien='"+giatien+"'where idmonphu='"+idmonphu+"'";
   Boolean yay=con.checkupdate(query);
   return yay;
}
public void close()
{
    con.closeconnect();
}
}
