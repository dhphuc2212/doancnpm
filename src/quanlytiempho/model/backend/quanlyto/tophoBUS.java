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
public class tophoBUS {
    public ArrayList<topho> dstp=new ArrayList<>();
    tophoDAO tpDAO=new tophoDAO();
    public tophoBUS()
    {
        dstp=tpDAO.getDB();
    }
    public void displayConsole()
    {
        dstp.forEach((tp)->{
        System.out.print(tp.getIdto()+" ");
        System.out.print(tp.getLoaito()+" ");
        System.out.print(tp.getloaithit()+" ");
        System.out.print(tp.getIdthuckhach()+" ");
        System.out.print(tp.getGiatien()+" ");
        System.out.print(tp.getgiodat());
                });
    }
    public String[] getHeaders()
    {
        return new String[]{"Mã tô","Loại tô","Loại thịt","Mã loại thịt","Mã thực khách","Giá tiền","Giờ đặt"};
    }
    public topho getto(int idto)
    {
        for(topho t:dstp)
        {
            if(t.getIdto()==idto)
            {
                return t;
            }
        }
        return null;
    }
     public int getNextID() {
        return this.dstp.size() + 1;
    }
     public ArrayList<topho> getdst()
     {
         return this.dstp;
     }
   public void addtopho(topho t)
   {
       tpDAO.addto(t);
   }
   
   public void del(int id)
   {
       tpDAO.del(id);
   }
   public void update(int Idto,String loaithit,String Loaito,int Idthuckhach, double Giatien,LocalTime giodat)
   {
       tpDAO.update(Idto, loaithit, Loaito, Idthuckhach, Giatien, giodat);
   }
   public boolean checkexistid(int id)
   {
       for(int i=0;i<dstp.size();i++)
       {
           if(id==dstp.get(i).getIdto())
           {
               return true;
           }
       }
       return false;
   }
   public void readdb()
   {
       this.dstp=tpDAO.getDB();
   }
}
