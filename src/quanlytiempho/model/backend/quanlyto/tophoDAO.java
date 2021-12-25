/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlyto;
import java.util.*;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.time.LocalTime;
public class tophoDAO {
    Connectiondb con;
    public tophoDAO()
            {
            }
    public ArrayList<topho> getDB()
    {
        
       
            con=new Connectiondb();
            ArrayList<topho> t=new ArrayList<>();
            try
            {
                String query="Select * from topho";
                ResultSet r=con.sqlres(query);
                if(r!=null)
                {
                    while(r.next())
                    {
                        int idto=r.getInt("idto");
                        String loaithit=r.getString("loaithit");
                        String loaito=r.getString("loaito");
                        String idthuckhach=r.getString("idthuckhach");
                        double giatien=r.getDouble("giatien");
                        LocalTime giodat=r.getTime("giodat").toLocalTime();
                        t.add(new topho(idto,loaithit,loaito,idthuckhach,giatien,giodat));
                    }
                }
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,"Khong the doc du lieu tu bang table trong co so du lieu");
            }
            finally
                    {
                        con.closeconnect();
                    }
        return t;
    }
    public ArrayList<topho> search(String columnname,String value)
    {
        con=new Connectiondb();
        ArrayList<topho> t=new ArrayList<>();
        try
        {
            String query="select * from topho where "+columnname+"="+value;
            ResultSet r=con.sqlres(query);
             if(r!=null)
                {
                    while(r.next())
                    {
                        int idto=r.getInt("idto");
                        String loaithit=r.getString("idloaithit");
                        String loaito=r.getString("loaito");
                        String idthuckhach=r.getString("idmonphu");
                        double giatien=r.getDouble("giatien");
                        LocalTime giodat=r.getTime("giodat").toLocalTime();
                        t.add(new topho(idto,loaithit,loaito,idthuckhach,giatien,giodat));
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
    public Boolean addto(topho t)
    {
        con=new Connectiondb();
        String query="Insert into `topho` values('"+t.getIdto()+"','"+t.getloaithit()+"','"+t.getLoaito()+"','"+t.getIdthuckhach()+"','"+t.getGiatien()+"','"+t.getgiodat()+"');";
        Boolean yup=con.checkupdate(query);
        con.closeconnect();
        return yup;
      }
public Boolean del(int idto)
{
    con=new Connectiondb();
    String query="DELETE FROM `topho` where `topho`.`idto`='"+idto+"'";
    Boolean yay=con.checkupdate(query);
    return yay;
}
public Boolean update(int Idto,String loaithit,String Loaito,int Idthuckhach,double Giatien,LocalTime giodat)
{
    con=new Connectiondb();
    String query="Update `topho` set loaithit='"+loaithit+"',loaito='"+Loaito+"',idthuckhach='"+Idthuckhach+"',giatien='"+Giatien+"',giodat='"+giodat+"'where idto='"+Idto+"'";
   Boolean yay=con.checkupdate(query);
   return yay;
}
public void close()
{
    con.closeconnect();
}


}
