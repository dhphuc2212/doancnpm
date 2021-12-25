/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlyban;
import java.util.*;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class banDAO {
       Connectiondb con;
   public banDAO()
   {
       
   }
   public ArrayList readDB()
   {
       con=new Connectiondb();
       ArrayList<ban> dsb=new ArrayList<>();
       try
       {
           String query="Select * from ban";
           ResultSet r=con.sqlres(query);
          if(r!=null)
          {
              while(r.next())
              {
                  ban t=new ban();
                  t.setIdban(r.getInt("idban"));
                  t.setLoaiban(r.getString("loaiban"));
                  t.setTrangthai(r.getString("trangthai"));
                 dsb.add(t);
              }
          }
          
       }
       catch(SQLException e)
       {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu trong bảng bàn.");
       }
       finally
       {
           con.closeconnect();
       }
       return dsb;
   }
    public ArrayList<ban> search(String columnname,String value)
    {
        con=new Connectiondb();
        ArrayList<ban> t=new ArrayList<>();
        try
        {
            String query="select * from ban where "+columnname+"="+value;
            ResultSet r=con.sqlres(query);
             if(r!=null)
                {
                    while(r.next())
                    {
                        int idban=r.getInt("idban");
                        String loaiban=r.getString("loaiban");
                        int sobanlon=r.getInt("sobanlon");
                        int sobannho=r.getInt("sobannho");
                        String trangthai=r.getString("trangthai");
                        t.add(new ban(idban,loaiban,trangthai));
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
     public Boolean addban(ban t)
    {
        con=new Connectiondb();
        String query="Insert into `ban` values('"+t.getIdban()+"','"+t.getLoaiban()+"','"+t.getTrangthai()+"')";
        Boolean yup=con.checkupdate(query);
        con.closeconnect();
        return yup;
      }
     public Boolean del(int idban)
{
    con=new Connectiondb();
    String query="DELETE FROM `ban` where `ban`.`idban`='"+idban+"'";
    Boolean yay=con.checkupdate(query);
    return yay;
}
     public Boolean update(int idban,String loaiban,String trangthai)
{
    con=new Connectiondb();
    String query="Update `ban` set loaiban='"+loaiban+"',trangthai='"+trangthai+"'where idban='"+idban+"'";
   Boolean yay=con.checkupdate(query);
   return yay;
}
public void close()
{
    con.closeconnect();
}
}
