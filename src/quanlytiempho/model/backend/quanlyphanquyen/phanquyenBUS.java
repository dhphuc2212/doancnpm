/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlyphanquyen;
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
public class phanquyenBUS {
       public ArrayList<phanquyen> dspq=new ArrayList<>();
    phanquyenDAO pqDAO=new phanquyenDAO();
    Connectiondb con=new Connectiondb();
    public phanquyenBUS()
    {
        dspq=pqDAO.readDB();
    }
    public void displayConsole()
    {
        dspq.forEach((tp)->{
        System.out.print(tp.getMaquyen()+" ");
        System.out.print(tp.getTenquyen()+" ");
        System.out.print(tp.getGhichu()+" ");
                });
    }

    public phanquyen getquyen(int id)
    {
        for(phanquyen t:dspq)
        {
            if(t.getMaquyen()==(id))
            {
                return t;
            }
        }
        return null;
    }
    public void readpq()
    {
        this.dspq=pqDAO.readDB();
    }
    public ArrayList<phanquyen> getdspq()
    {
        return dspq;
    }
      public int getNextID() throws SQLException {
        String query="Select id from phanquyen";
        
        ResultSet r=con.sqlres(query);
        int max1=0;
        if(r!=null)
        {
            while(r.next())
            {
                if(r.getInt("id")>max1)
                {
                    max1=r.getInt("id");
                }
            }
        }
        return max1+1;
    }
       public ArrayList<phanquyen> search(String type, String value) {
        ArrayList<phanquyen> result = new ArrayList<>();

        dspq.forEach((nv) -> {
            if (type.equals("Tất cả")) {
                if (String.valueOf(nv.getMaquyen()).toLowerCase().contains(value.toLowerCase())
                        || nv.getTenquyen().toLowerCase().contains(value.toLowerCase())
                        || nv.getGhichu().toLowerCase().contains(value.toLowerCase())
                        ) {
                    result.add(nv);
                }
            } else {
                switch (type) {
                    case "Mã quyền":
                        if (String.valueOf(nv.getMaquyen()).toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Tên quyền":
                        if (nv.getTenquyen().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Ghi chú":
                        if (nv.getGhichu().toString().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                }
            }
        });
        return result;
    }
       public void addquyen(phanquyen t)
       {
           pqDAO.addquyen(t);
       }
       public void update(int maquyen,String tenquyen,String ghichu)
       {
           pqDAO.update(maquyen,tenquyen,ghichu);
       }
       public void del(int id)
       {
           pqDAO.del(id);
       }
       
}
