/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlythuckhach;
import java.util.*;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.time.LocalTime;
public class thuckhachDAO {
   Connectiondb con;
   public thuckhachDAO()
   {
       
   }
   public ArrayList readDB()
   {
       con=new Connectiondb();
       ArrayList<thuckhach> dstk=new ArrayList<>();
       try
       {
           String query="Select * from thuckhach";
           ResultSet r=con.sqlres(query);
          if(r!=null)
          {
              while(r.next())
              {
                  thuckhach t=new thuckhach();
                  t.setIdthuckhach(r.getString("idthuckhach"));
                  t.setIdban(r.getInt("idban"));
                  t.setLoaithuckhach(r.getString("loaithuckhach"));
                  t.setGiovao(r.getTime("giovao").toLocalTime());
                 dstk.add(t);
              }
          }
          
       } 
       catch(SQLException e)
       {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu trong bảng thực khách.");
       }
       finally
       {
           con.closeconnect();
       }
       return dstk;
   }
    public ArrayList<thuckhach> search(String columnname,String value)
    {
        con=new Connectiondb();
        ArrayList<thuckhach> t=new ArrayList<>();
        try
        {
            String query="select * from thuckhach where "+columnname+"="+value;
            ResultSet r=con.sqlres(query);
             if(r!=null)
                {
                    while(r.next())
                    {
                        String idthuckhach=r.getString("idthuckhach");
                        int idban=r.getInt("idban");
                        String loaithuckhach=r.getString("loaithuckhach");
                        LocalTime giovao=r.getTime("giovao").toLocalTime();
                        t.add(new thuckhach(idthuckhach,idban,loaithuckhach,giovao));
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
     public Boolean addthuckhach(thuckhach t)
    {
        con=new Connectiondb();
        String query="Insert into `thuckhach` values('"+t.getIdthuckhach()+"','"+t.getIdban()+"','"+t.getLoaithuckhach()+"','"+t.getGiovao()+"')";
        Boolean yup=con.checkupdate(query);
        con.closeconnect();
        return yup;
      }
     public Boolean del(String idthuckhach)
{
    con=new Connectiondb();
    String query="DELETE FROM `thuckhach` where `thuckhach`.`idthuckhach`='"+idthuckhach+"'";
    Boolean yay=con.checkupdate(query);
    return yay;
}
     public Boolean update(String idthuckhach,int idban,String loaithuckhach,LocalTime giovao)
{
    con=new Connectiondb();
    String query="Update `thuckhach` set idban='"+idban+"',loaithuckhach='"+loaithuckhach+"',giovao='"+giovao+"'where idthuckhach='"+idthuckhach+"'";
   Boolean yay=con.checkupdate(query);
   return yay;
}
public void close()
{
    con.closeconnect();
}

}
