/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlychitiethoadon;

/**
 *
 * @author Acer
 */import java.time.LocalDate;
import quanlytiempho.model.backend.quanlymonphu.monphu;
import quanlytiempho.model.backend.quanlymonphu.monphuBUS;
import java.time.LocalTime;
import java.util.*;
import javax.swing.JOptionPane;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import quanlytiempho.model.backend.quanlyhoadon.hoadon;
import quanlytiempho.model.backend.quanlyhoadon.hoadonDAO;
public class chitiethoadonBUS {
       public ArrayList<chitiethoadon> dscthd=new ArrayList<>();
    chitiethoadonDAO cthdDAO=new chitiethoadonDAO();
    Connectiondb con=new Connectiondb();
    public chitiethoadonBUS()
    {
        dscthd=cthdDAO.readDB();
    }
    public chitiethoadon gethoadon(String id)
    {
        for(chitiethoadon t:dscthd)
        {
            if(t.getIdchitiethoadon().equals(id))
            {
                return t;
            }
        }
        return null;
    }
    public ArrayList<chitiethoadon> gethoadon1(String idhoadon)
    {  
        ArrayList<chitiethoadon> t1=new ArrayList<>();
        for(chitiethoadon t: dscthd)
        {
            if(t.getIdhoadon().equals(idhoadon))
            {
                t1.add(t);
            }
        }
        return t1;
    }
     public String getnextid() 
    {
       return "CTHD"+dscthd.size()+1;
    }
    /*public ArrayList<chitiethoadon> search(String type, String value,int sltu,int slden,int slmonphutu,int slmonphuden) {
        ArrayList<chitiethoadon> result = new ArrayList<>();

        dscthd.forEach((nv) -> {
            if (type.equals("Tất cả")) {
                if (
                        String.valueOf(nv.getIdto()).toLowerCase().contains(value.toLowerCase())||
                        String.valueOf(nv.getSoluong()).toLowerCase().contains(value.toLowerCase())||
                        String.valueOf(nv.getSoluongmp()).contains(value.toLowerCase())
                        ) {
                    result.add(nv);
                }
            } else {
                switch (type) {
                    case "Mã tô":
                        if (String.valueOf(nv.getIdto()).contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Số lượng tô":
                        if (String.valueOf(nv.getSoluong()).contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Số lượng món phụ":
                        if(String.valueOf(nv.getSoluongmp()).contains(value))
                        {
                            result.add(nv);
                        }
                        break;
                }
            }
        });
        if(sltu!=0||slden!=0)
        {
        for(int i=result.size()-1;i>=0;i--)
        {  
            chitiethoadon t=result.get(i);
            int sl=t.getSoluong();
           
            boolean slkhongthoa=((sltu<sl)||(sl>slden));
            if(slkhongthoa)
            {
                result.remove(t);
            }
        }
        }
        if(slmonphutu!=0||slmonphuden!=0)
        {
          for(int i=result.size()-1;i>=0;i--)
          {
              chitiethoadon t=result.get(i);
              int slmp=t.getSoluongmp();
              boolean slmpkhongthoa=((slmonphutu<slmp)||(slmp>slmonphuden));
              if(slmpkhongthoa)
              {
                  result.remove(t);
              }
          }
        }
               
        return result;
     }*/
     public ArrayList<chitiethoadon> getcthoadon()
     {
         return dscthd;
     }
     public void del(String id)
     {
         cthdDAO.del(id);
     }
     public void add(chitiethoadon t)
     {
        cthdDAO.addcthd(t);
     }
       public void readlmp()
        {
            this.dscthd=cthdDAO.readDB();
        }
     
}
