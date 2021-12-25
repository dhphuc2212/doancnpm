/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlyhoadon;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;
import java.time.LocalTime;
import quanlytiempho.model.backend.quanlymonphu.monphu;
import quanlytiempho.model.backend.quanlymonphu.monphuBUS;
import quanlytiempho.model.backend.quanlymonphu.monphuDAO;
public class hoadonBUS {
    public ArrayList<hoadon> dshd=new ArrayList<>();
    hoadonDAO hdDAO=new hoadonDAO();
    Connectiondb con=new Connectiondb();
    public hoadonBUS()
    {
        dshd=hdDAO.readDB();
    }
    public hoadon gethoadon(String id)
    {
        for(hoadon t:dshd)
        {
            if(t.getIdhoadon().equals(id))
            {
                return t;
            }
        }
        return null;
    }
     public String getnextid() 
    {
       return "HD"+dshd.size()+1;
    }
     public ArrayList<hoadon> search(String type, String value,int giatu,int giaden,LocalDate ngaytu,LocalDate ngayden) {
        ArrayList<hoadon> result = new ArrayList<>();

        dshd.forEach((nv) -> {
            if (type.equals("Tất cả")) {
                if (nv.getIdhoadon().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(nv.getIdban()).contains(value.toLowerCase())||
                        String.valueOf(nv.getNgayxuat()).toLowerCase().contains(value.toLowerCase())||
                        nv.getIdthuckhach().toLowerCase().contains(value.toLowerCase())||
                        String.valueOf(nv.getGioxuat()).contains(value.toLowerCase())||
                        nv.getIdnhanvien().toLowerCase().contains(value.toLowerCase())||
                        String.valueOf(nv.getTongtien()).contains(value)
                      
                        ) {
                    result.add(nv);
                }
            } else {
                switch (type) {
                    case "Mã hóa đơn":
                        if (nv.getIdhoadon().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Mã bàn":
                        if (String.valueOf(nv.getIdban()).contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Ngày xuất":
                        if(String.valueOf(nv.getNgayxuat()).contains(value))
                        {
                            result.add(nv);
                        }
                        break;
                    case "Mã thực khách":
                        if(nv.getIdthuckhach().toLowerCase().contains(value.toLowerCase()))
                        {
                            result.add(nv);
                        }
                        break;
                    case "Giờ xuất":
                        if(String.valueOf(nv.getGioxuat()).contains(value))
                            {
                                result.add(nv);
                            }
                        break;
                    case "Mã nhân viên":
                        if(nv.getIdnhanvien().toLowerCase().contains(value.toLowerCase()))
                        {
                            result.add(nv);
                        }
                        break;
                    case "Tổng tiền":
                        if(String.valueOf(nv.getTongtien()).contains(value))
                        {
                            result.add(nv);
                        }
                        break;
                }
            }
        });
        if(giatu!=0||giaden!=0)
        {
        for(int i=result.size()-1;i>=0;i--)
        {  
            hoadon t=result.get(i);
            int gia=(int)(t.getTongtien());
           
            boolean giakhongthoa=((gia<giatu)||(gia>giaden));
            if(giakhongthoa)
            {
                result.remove(t);
            }
        }
        }
        if(ngaytu!=null||ngayden!=null)
        {
            for(int i=result.size()-1;i>=0;i--)
            {
                hoadon t=result.get(i);
                LocalDate ngayxuat=t.getNgayxuat();
                boolean t1=(ngaytu.isBefore(ngayxuat)||ngayden.isAfter(ngayxuat));
                if(t1)
                {
                    result.remove(t);
                }
            }
        }
            
        return result;
     }
     public ArrayList<hoadon> gethoadon()
     {
         return dshd;
     }
     public void del(String id)
     {
         hdDAO.del(id);
     }
     public void add(hoadon t)
     {
        hdDAO.addhoadon(t);
     }
       public void readlmp()
        {
            this.dshd=hdDAO.readDB();
        }
     public void update(String idhoadon,int idban,LocalDate ngayxuat,String idthuckhach,LocalTime gioxuat,String idnhanvien,double tongtien)
     {
         hdDAO.update(idhoadon, idban, ngayxuat, idthuckhach, gioxuat, idnhanvien, tongtien);
     }
 public int getidban(String idhoadon)
 {
    return hdDAO.idban(idhoadon);
 }
 public LocalDate getngayxuat(String idhoadon)
 {
     return hdDAO.ngayxuat(idhoadon);
 }
 public String getidthuckhach(String idhoadon)
 {
     return hdDAO.idthuckhach(idhoadon);
 }
 public LocalTime getgioxuat(String idhoadon)
 {
     return hdDAO.gioxuat(idhoadon);
 }
 public String getidnhanvien(String idhoadon)
 {
     return hdDAO.idnhanvien(idhoadon);
 }
 public double gettongtien(String idhoadon)
 {
     return hdDAO.tongtien(idhoadon);
 } 
 
}
