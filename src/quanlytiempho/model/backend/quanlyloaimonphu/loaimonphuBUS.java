/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlyloaimonphu;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import quanlytiempho.model.backend.quanlynhanvien.nhanvien;
public class loaimonphuBUS {
      public ArrayList<loaimonphu> dslmp=new ArrayList<>();
     Connectiondb con=new Connectiondb();
    loaimonphuDAO lmpDAO=new loaimonphuDAO();
    public loaimonphuBUS()
    {
        dslmp=lmpDAO.readDB();
    }
    public void displayConsole()
    {
        dslmp.forEach((tp)->{
        System.out.print(tp.getId()+" ");
        System.out.print(tp.getTenloai());
                });
    }
    public String[] getHeaders()
    {
        return new String[]{"Mã loại món phụ","Tên loại"};
    }
    public loaimonphu getloaimonphu(int id)
    {
        for(loaimonphu t:dslmp)
        {
            if(t.getId()==id)
            {
                return t;
            }
        }
        return null;
    }
    public int getnextid() 
    {
        String query="Select id from loaimonphu";
        ResultSet r=con.sqlres(query);
        int max1=0;
        if(r!=null)
        {   try{
            while(r.next())
            {
                if(max1<r.getInt("id"))
                {
                    max1=r.getInt("id");
                }
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"sao");
        }
        }
        else
        {
            max1=0;
        }
        return max1+1;
    }
     public ArrayList<loaimonphu> search(String type, String value) {
        ArrayList<loaimonphu> result = new ArrayList<>();

        dslmp.forEach((nv) -> {
            if (type.equals("Tất cả")) {
                if (String.valueOf(nv.getId()).contains(value)
                        || nv.getTenloai().toLowerCase().contains(value.toLowerCase())
                        ) {
                    result.add(nv);
                
                }
            } else {
                switch (type) {
                    case "Mã loại":
                        if (String.valueOf(nv.getId()).contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Tên loại món":
                        if (nv.getTenloai().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                }
            }
        });
        return result;
     }
     public ArrayList<loaimonphu> getlma()
     {
         return dslmp;
     }
     public void del(int id)
     {
         lmpDAO.del(id);
     }
     public void add(loaimonphu t)
     {
        lmpDAO.addloaimonphu(t);
     }
       public void readlmp()
        {
            this.dslmp=lmpDAO.readDB();
        }
     public void update(int id,String tenloai)
     {
         lmpDAO.update(id, tenloai);
     }
}
