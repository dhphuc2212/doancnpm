/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlytaikhoan;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Acer
 */
public class taikhoanBUS {
      public ArrayList<taikhoan> dstk=new ArrayList<>();
    taikhoanDAO tkDAO=new taikhoanDAO();
    public taikhoanBUS()
    {
        dstk=tkDAO.readDB();
    }
    public void displayConsole()
    {
        dstk.forEach((tp)->{
        System.out.print(tp.getIdtaikhoan()+" ");
        System.out.print(tp.getTentaikhoan()+" ");
        System.out.print(tp.getMatkhau()+" ");
        System.out.print(tp.getIdnhanvien()+" ");
        System.out.print(tp.getIdquyen());
                });
    }

    public taikhoan gettaikhoan(String idtaikhoan)
    {
        for(taikhoan t:dstk)
        {
            if(t.getIdtaikhoan().equals(idtaikhoan))
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
    public ArrayList<taikhoan> getdstk()
    {
        return dstk;
    }
      public String getNextID() {
        return "TAK"+String.valueOf((this.dstk.size()+ 1));
    }
       public ArrayList<taikhoan> search(String type, String value) {
        ArrayList<taikhoan> result = new ArrayList<>();

        dstk.forEach((nv) -> {
            if (type.equals("Tất cả")) {
                if (nv.getIdtaikhoan().toLowerCase().contains(value.toLowerCase())
                        || nv.getTentaikhoan().toLowerCase().contains(value.toLowerCase())
                        || nv.getMatkhau().toLowerCase().contains(value.toLowerCase())
                        || nv.getIdnhanvien().toLowerCase().contains(value)
                        ||String.valueOf(nv.getIdquyen()).contains(value)
                        ) {
                    result.add(nv);
                }
            } else {
                switch (type) {
                    case "Mã tài khoản":
                        if (nv.getIdtaikhoan().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Tên tài khoản":
                        if (nv.getTentaikhoan().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Mật khẩu":
                        if (nv.getMatkhau().toString().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Mã nhân viên":
                        if (nv.getIdnhanvien().toString().contains(value)) {
                            result.add(nv);
                        }
                        break;
                    case "Mã quyền":
                        if(String.valueOf(nv.getIdquyen()).contains(value))
                        {
                            result.add(nv);
                        }
                       break;
                }
            }
        });
        return result;
    }
      public String hashpass(String t) throws NoSuchAlgorithmException
      {  
          try {
              byte[] passw=t.getBytes("UTF-8");
              MessageDigest md=MessageDigest.getInstance("MD5");
              byte[] respw=md.digest(passw);
              BigInteger num=new BigInteger(1,respw);
              String res=num.toString(16);
              return res;
                      } catch (UnsupportedEncodingException ex) {
              Logger.getLogger(taikhoanBUS.class.getName()).log(Level.SEVERE, null, ex);
          }
          return null;
      }
       public void addtaikhoan(taikhoan t)
       {
           tkDAO.addtaikhoan(t);
       }
       public void update(String idtaikhoan,String tentaikhoan,String matkhau,String idnhanvien,int maquyen)
       {
           tkDAO.update(idtaikhoan,tentaikhoan,matkhau,maquyen,idnhanvien);
       }
       public void del(String idtaikhoan)
       {
           tkDAO.del(idtaikhoan);
       }
       
}
