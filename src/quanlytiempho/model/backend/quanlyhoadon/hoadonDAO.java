/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlyhoadon;
import java.util.*;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import quanlytiempho.model.backend.quanlyloaimonphu.loaimonphu;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
public class hoadonDAO {
               Connectiondb con;
   public hoadonDAO()
   {
       
   }
   public ArrayList readDB()
   {
       con=new Connectiondb();
       ArrayList<hoadon> dshd=new ArrayList<>();
       try
       {
           String query="Select * from hoadon";
           ResultSet r=con.sqlres(query);
          if(r!=null)
          {
              while(r.next())
              {
                  hoadon t=new hoadon();
                  t.setIdhoadon(r.getString("idhoadon"));
                  t.setIdban(r.getInt("idban"));
                  t.setNgayxuat(r.getDate("ngayxuat").toLocalDate());
                  t.setIdthuckhach(r.getString("idthuckhach"));
                  t.setGioxuat(r.getTime("gioxuat").toLocalTime());
                  t.setIdnhanvien(r.getString("idnhanvien"));
                  t.setTongtien(r.getDouble("tongtien"));
                 dshd.add(t);
              }
          }
          
       }
       catch(SQLException e)
       {
            JOptionPane.showMessageDialog(null, "Không đọc được dữ liệu trong bảng hóa đơn.");
       }
       finally
       {
           con.closeconnect();
       }
       return dshd;
   }
   
     public Boolean addhoadon(hoadon t)
    {
        con=new Connectiondb();
        String query="Insert into `hoadon` values('"+t.getIdhoadon()+"','"+t.getIdban()+"','"+t.getNgayxuat()+"','"+t.getIdthuckhach()+"','"+t.getGioxuat()+"','"+t.getIdnhanvien()+"','"+t.getTongtien()+"' )";
        Boolean yup=con.checkupdate(query);
        con.closeconnect();
        return yup;
      }
     public Boolean del(String id)
{
    con=new Connectiondb();
    String query="DELETE FROM `hoadon` where `hoadon`.`idhoadon`='"+id+"'";
    Boolean yay=con.checkupdate(query);
    return yay;
}
     public Boolean update(String idhoadon,int idban,LocalDate ngayxuat,String idthuckhach,LocalTime gioxuat,String idnhanvien,double tongtien )
{
    con=new Connectiondb();
    String query="Update `hoadon` set idban='"+idban+"',ngayxuat='"+ngayxuat+"',idthuckhach='"+idthuckhach+"',giozuat='"+gioxuat+"',idnhanvien='"+idnhanvien+"',tongtien='"+tongtien+"' where idhoadon='"+idhoadon+"'";
   Boolean yay=con.checkupdate(query);
   return yay;
}
     public int idban(String idhoadon)
     {
                   try {
                       String query="Select idban from hoadon where idhoadon='"+idhoadon+"'";
                       ResultSet r=con.sqlres(query);
                       int idban=0;
                       while(r.next())
                       {
                           idban=r.getInt("idban");
                         
                       } 
                   return idban;
                   } catch (SQLException ex) {
                       Logger.getLogger(hoadonDAO.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   return 0;
     }
     public LocalDate ngayxuat(String idhoadon)
     {
                   try {
                       String query="Select ngayxuat from hoadon where idhoadon='"+idhoadon+"'";
                       LocalDate ngayxuat=null;
                       ResultSet r=con.sqlres(query);
                       while(r.next())
                       {
                           ngayxuat=r.getDate("ngayxuat").toLocalDate();
                       }
                       return ngayxuat;
                   } catch (SQLException ex) {
                       Logger.getLogger(hoadonDAO.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   return null;
     }
     public String idthuckhach(String idhoadon)
     {
         try {
                       String query="Select idthuckhach from hoadon where idhoadon='"+idhoadon+"'";
                       String idthuckhach="";
                       ResultSet r=con.sqlres(query);
                       while(r.next())
                       {
                           idthuckhach=r.getString("idthuckhach");
                       }
                       return idthuckhach;
                   } catch (SQLException ex) {
                       Logger.getLogger(hoadonDAO.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   return null;
     }
     public LocalTime gioxuat(String idhoadon)
     {
         try {
                       String query="Select gioxuat from hoadon where idhoadon='"+idhoadon+"'";
                       LocalTime gioxuat=null;
                       ResultSet r=con.sqlres(query);
                       while(r.next())
                       {
                           gioxuat=r.getTime("gioxuat").toLocalTime();
                       }
                       return gioxuat;
                   } catch (SQLException ex) {
                       Logger.getLogger(hoadonDAO.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   return null;
     }
     public String idnhanvien(String idhoadon)
     {
         try {
                       String query="Select idnhanvien from hoadon where idhoadon='"+idhoadon+"'";
                       String idnhanvien="";
                       ResultSet r=con.sqlres(query);
                       while(r.next())
                       {
                           idnhanvien=r.getString("idnhanvien");
                       }
                       return idnhanvien;
                   } catch (SQLException ex) {
                       Logger.getLogger(hoadonDAO.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   return null;
     }
     public double tongtien(String idhoadon)
     {
         try {
                       String query="Select tongtien from hoadon where idhoadon='"+idhoadon+"'";
                       double tongtien=0;
                       ResultSet r=con.sqlres(query);
                       while(r.next())
                       {
                           tongtien=r.getDouble("tongtien");
                       }
                       return tongtien;
                   } catch (SQLException ex) {
                       Logger.getLogger(hoadonDAO.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   return 0;
     }
     
public void close()
{
    con.closeconnect();
}
}
