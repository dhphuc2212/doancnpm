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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import quanlytiempho.model.backend.quanlynhanvien.nhanvien;
public class thuckhachBUS {
     public ArrayList<thuckhach> dstk=new ArrayList<>();
    thuckhachDAO tkDAO=new thuckhachDAO();
    public thuckhachBUS()
    {
        dstk=tkDAO.readDB();
    }
    public void displayConsole()
    {
        dstk.forEach((tp)->{
        System.out.print(tp.getIdthuckhach()+" ");
        System.out.print(tp.getIdban()+" ");
        System.out.print(tp.getLoaithuckhach()+" ");
        System.out.print(tp.getGiovao());
                });
    }
    public String[] getHeaders()
    {
        return new String[]{"Mã thực khách","Mã bàn","Loại thực khách","Giờ vào"};
    }
    public thuckhach getthuckhach(String idthuckhach)
    {
        for(thuckhach t:dstk)
        {
            if(t.getIdthuckhach().equals(idthuckhach))
            {
                return t;
            }
        }
        return null;
    }
    public void readtk()
    {
        this.dstk=tkDAO.readDB();
    }
    public ArrayList<thuckhach> getdstk()
    {
        return dstk;
    }
      public String getNextID() {
        return "TK"+String.valueOf((this.dstk.size()+ 1));
    }
       public ArrayList<thuckhach> search(String type, String value, LocalTime gio1, LocalTime gio2) {
        ArrayList<thuckhach> result = new ArrayList<>();

        dstk.forEach((nv) -> {
            if (type.equals("Tất cả")) {
                if (nv.getIdthuckhach().toLowerCase().contains(value.toLowerCase())
                        || String.valueOf(nv.getIdban()).toLowerCase().contains(value.toLowerCase())
                        || nv.getLoaithuckhach().toLowerCase().contains(value.toLowerCase())
                        || nv.getGiovao().toString().toLowerCase().contains(value)
                        ) {
                    result.add(nv);
                }
            } else {
                switch (type) {
                    case "Mã thực khách":
                        if (nv.getIdthuckhach().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Mã bàn":
                        if (String.valueOf(nv.getIdban()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Loại thực khách":
                        if (nv.getLoaithuckhach().toString().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Giờ vào":
                        if (nv.getGiovao().toString().contains(value)) {
                            result.add(nv);
                        }
                        break;
                }
            }
        });
        for (int i = result.size() - 1; i >= 0; i--) {
            thuckhach tk= result.get(i);
            LocalTime giovao = tk.getGiovao();
            
            Boolean ngayKhongThoa = (gio1 != null && giovao.isBefore(gio1)) || (gio2 != null && giovao.isAfter(gio2));

            if (ngayKhongThoa) {
                result.remove(tk);
            }
        }

        return result;
    }
       public void addthuckhach(thuckhach t)
       {
           tkDAO.addthuckhach(t);
       }
       public void update(String idthuckhach,int maban,String loaithuckhach,LocalTime giovao)
       {
           tkDAO.update(idthuckhach, maban, loaithuckhach, giovao);
       }
       public void del(String idthuckhach)
       {
           tkDAO.del(idthuckhach);
       }
       
}
