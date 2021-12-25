/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlynhanvien;
import java.util.*;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.time.LocalDate;
import quanlytiempho.model.backend.quanlychitietmonphu.chitietmonphu;
public class nhanvienDAO {
            Connectiondb con;
   public nhanvienDAO()
   {
       
   }
   public ArrayList readDB()
   {
       con=new Connectiondb();
       ArrayList<nhanvien> dsnv=new ArrayList<>();
       try
       {
           String query="Select * from nhanvien";
           ResultSet r=con.sqlres(query);
          if(r!=null)
          {
              while(r.next())
              {
                  nhanvien t=new nhanvien();
                  t.setIdnhanvien(r.getString("idnhanvien"));
                  t.setTen(r.getString("tennhanvien"));
                  t.setSdt(r.getString("dienthoai"));
                  t.setNgaysinh(r.getDate("ngaysinh").toLocalDate());
                  t.setDiachi(r.getString("diachi"));
                  dsnv.add(t);
              }
          }
          
       }
       catch(SQLException e)
       {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu trong bảng nhân viên.");
       }
       finally
       {
           con.closeconnect();
       }
       return dsnv;
   }
    public ArrayList<nhanvien> search(String columnname,String value)
    {
        con=new Connectiondb();
        ArrayList<nhanvien> t=new ArrayList<>();
        try
        {
            String query="select * from nhanvien where '"+columnname+"'='"+value+"'";
            ResultSet r=con.sqlres(query);
             if(r!=null)
                {
                    while(r.next())
                    {
                        String idnhanvien=r.getString("idnhanvien");
                        String tennhanvien=r.getString("tennhanvien");
                        String sodienthoai=r.getString("dienthoai");
                        LocalDate ngaysinh=r.getDate("ngaysinh").toLocalDate();
                        String diachi=r.getString("diachi");
                       
                        t.add(new nhanvien(idnhanvien,tennhanvien,sodienthoai,ngaysinh,diachi));
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
    public ArrayList<nhanvien> searchngaysinh(LocalDate ngaysinh1)
    {
        con=new Connectiondb();
        ArrayList<nhanvien> t=new ArrayList<>();
        try
        {
            String query="Select * from nhanvien where ngaysinh='"+ngaysinh1+"'";
            ResultSet r=con.sqlres(query);
            if(r!=null)
            {
                while(r.next())
                {
                       String idnhanvien=r.getString("idnhanvien");
                        String tennhanvien=r.getString("tennhanvien");
                        String sodienthoai=r.getString("dienthoai");
                        LocalDate ngaysinh=r.getDate("ngaysinh").toLocalDate();
                        String diachi=r.getString("diachi");
                        t.add(new nhanvien(idnhanvien,tennhanvien,sodienthoai,ngaysinh,diachi));
                }
            }
        }
        catch(SQLException e)
        {
                        JOptionPane.showMessageDialog(null,"Loi tim du lieu ngaysinh co '"+ngaysinh1+"trong bang");

        }
        finally
        {
            con.closeconnect();
        }
        return t;
                }
      public ArrayList<nhanvien> searchall(String value)
    {
        con=new Connectiondb();
        ArrayList<nhanvien> t=new ArrayList<>();
     
        try
        {  
            String query="select * from nhanvien where idnhanvien='"+value+"'or tennhanvien='"+value+"'or dienthoai='"+value+"'or ngaysinh='"+value+"' or diachi='"+value+"'";
            ResultSet r=con.sqlres(query);
             if(r!=null)
                {
                    while(r.next())
                    {
                        String idnhanvien1=r.getString("idnhanvien");
                        String tennhanvien1=r.getString("tennhanvien");
                        String sodienthoai=r.getString("dienthoai");
                        LocalDate ngaysinh1=r.getDate("ngaysinh").toLocalDate();
                        String diachi1=r.getString("diachi");
                       
                        t.add(new nhanvien(idnhanvien1,tennhanvien1,sodienthoai,ngaysinh1,diachi1));
                    }
                }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Loi tim du lieu trong bang");
        }
        finally
        {
            con.closeconnect();
        }
        return t;
    }
     public Boolean addnhanvien(nhanvien t)
    {
        con=new Connectiondb();
        String query="Insert into `nhanvien` values('"+t.getIdnhanvien()+"','"+t.getTen()+"','"+t.getSdt()+"','"+t.getNgaysinh()+"','"+t.getDiachi()+"')";
        Boolean yup=con.checkupdate(query);
        con.closeconnect();
        return yup;
      }
     public Boolean del(String id)
{
    con=new Connectiondb();
    String query="DELETE FROM `nhanvien` where `nhanvien`.`idnhanvien`='"+id+"'";
    Boolean yay=con.checkupdate(query);
    return yay;
}
     public Boolean update(String idnhanvien,String tennhanvien,String sdt,LocalDate ngaysinh,String diachi)
{
    con=new Connectiondb();
    String query="Update `nhanvien` set tennhanvien='"+tennhanvien+"',dienthoai='"+sdt+"',ngaysinh='"+ngaysinh+"',diachi='"+diachi+"' where idnhanvien='"+idnhanvien+"'";
   Boolean yay=con.checkupdate(query);
   return yay;
}
public void close()
{
    con.closeconnect();
}
}
