/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlymonphu;
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
import quanlytiempho.model.backend.quanlyloaimonphu.loaimonphu;
public class monphuBUS {
       public ArrayList<monphu> dsmp=new ArrayList<>();
    monphuDAO mpDAO=new monphuDAO();
    Connectiondb con=new Connectiondb();
    public monphuBUS()
    {
        dsmp=mpDAO.readDB();
    }
    public void displayConsole()
    {
        dsmp.forEach((tp)->{
        System.out.print(tp.getIdmonphu()+" ");
        System.out.print(tp.getTenmonphu()+" ");
        System.out.print(tp.getIdloaimonphu()+" ");
        System.out.print(tp.getGiatien());
                });
    }
    public String[] getHeaders()
    {
        return new String[]{"Mã món phụ","Tên món phụ","Mã loại món phụ","Gía tiền"};
    }
    public monphu getloaimonphu(int id)
    {
        for(monphu t:dsmp)
        {
            if(t.getIdmonphu()==id)
            {
                return t;
            }
        }
        return null;
    }
     public int getnextid() 
    {
        String query="Select idmonphu from monphu";
        ResultSet r=con.sqlres(query);
        int max1=0;
        if(r!=null)
        {   try{
            while(r.next())
            {
                if(max1<r.getInt("idmonphu"))
                {
                    max1=r.getInt("idmonphu");
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
     public ArrayList<monphu> search(String type, String value,int giatu,int giaden) {
        ArrayList<monphu> result = new ArrayList<>();

        dsmp.forEach((nv) -> {
            if (type.equals("Tất cả")) {
                if (String.valueOf(nv.getIdmonphu()).contains(value)
                        || nv.getTenmonphu().toLowerCase().contains(value.toLowerCase())||
                        String.valueOf(nv.getIdloaimonphu()).toLowerCase().contains(value.toLowerCase())||
                        String.valueOf(nv.getGiatien()).contains(value)
                        ) {
                    result.add(nv);
                
                }
            } else {
                switch (type) {
                    case "Mã món phụ":
                        if (String.valueOf(nv.getIdmonphu()).contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Tên món phụ":
                        if (nv.getTenmonphu().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Mã loại món phụ":
                        if(String.valueOf(nv.getIdloaimonphu()).contains(value))
                        {
                            result.add(nv);
                        }
                        break;
                    case "Gía tiền":
                        if(String.valueOf(nv.getGiatien()).contains(value))
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
            monphu t=result.get(i);
            int gia=(int)(t.getGiatien());
           
            boolean giakhongthoa=((gia<giatu)||(gia>giaden));
            if(giakhongthoa)
            {
                result.remove(t);
            }
        }
        }
               
        return result;
     }
     public ArrayList<monphu> getma()
     {
         return dsmp;
     }
     public void del(int id)
     {
         mpDAO.del(id);
     }
     public void add(monphu t)
     {
        mpDAO.addmonphu(t);
     }
       public void readlmp()
        {
            this.dsmp=mpDAO.readDB();
        }
     public void update(int idmonphu,String tenmonphu,int idloaimonphu,float giatien)
     {
         mpDAO.update(idmonphu,tenmonphu,idloaimonphu,giatien);
     }
     public ArrayList<monphu> giatien(int giatu,int giaden)
     {
         String query="Select * from monphu";
         ArrayList<monphu> t=new ArrayList<>();
         ResultSet r=con.sqlres(query);
         if(r!=null)
         {
             try {
                 while(r.next())
                 {   float gia=r.getFloat("giatien");
                     boolean giakhongthoa=giatu<(int)gia||giaden>(int)gia;
                     if(!giakhongthoa)
                     {
                         int mamonphu=r.getInt("idmonphu");
                         String tenmon=r.getString("tenmonphu");
                         int idloaimon=r.getInt("idloaimonphu");
                         monphu t1=new monphu(mamonphu,tenmon,gia,idloaimon);
                         t.add(t1);
                     }
                     
                 }
             } catch (SQLException ex) {
                 Logger.getLogger(monphuBUS.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         return t;
     }
     
    
}
