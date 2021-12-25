/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlynhanvien;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
public class nhanvienBUS {
          public ArrayList<nhanvien> dsnv=new ArrayList<>();
    public nhanvienDAO nvDAO=new nhanvienDAO();
    public nhanvienBUS()
    {
        dsnv=nvDAO.readDB();
    }
    public void displayConsole()
    {
        dsnv.forEach((tp)->{
        System.out.print(tp.getIdnhanvien()+" ");
        System.out.print(tp.getTen()+" ");
        System.out.print(tp.getSdt()+" ");
        System.out.print(tp.getNgaysinh()+" ");
        System.out.print(tp.getDiachi());
                });
    }
    public String[] getHeaders()
    {
        return new String[]{"Mã nhân viên","Tên nhân viên","Số điện thoại","Ngày sinh","Địa chỉ"};
    }
    public nhanvien getnhanvien(String idnhanvien)
    {
        for(nhanvien t:dsnv)
        {
            if(t.getIdnhanvien().equals(idnhanvien))
            {
                return t;
            }
        }
        return null;
    }
    public String getNextID()
    {
        return "NV"+String.valueOf(this.dsnv.size()+1);
    }
    public void readdb()
    {
        dsnv=nvDAO.readDB();
    }
    public ArrayList<nhanvien> getdsnv()
    {
        return dsnv;
    }
    public ArrayList<nhanvien> getdsnvtheogiatri(String columnname,String value)
    {
        dsnv=nvDAO.search(columnname, value);
        return dsnv;
    }
    public ArrayList<nhanvien> getdsnvtheongaysinh(LocalDate ngaysinh1)
    {
        dsnv=nvDAO.searchngaysinh(ngaysinh1);
        return dsnv;
    }
    public ArrayList<nhanvien> getall(String value)
    {
        dsnv=nvDAO.searchall(value);
        return dsnv;
    }
     public ArrayList<nhanvien> search(String type, String value, LocalDate _ngay1, LocalDate _ngay2) {
        ArrayList<nhanvien> result = new ArrayList<>();

        dsnv.forEach((nv) -> {
            if (type.equals("Tất cả")) {
                if (nv.getIdnhanvien().toLowerCase().contains(value.toLowerCase())
                        || nv.getTen().toLowerCase().contains(value.toLowerCase())
                        || nv.getSdt().toLowerCase().contains(value.toLowerCase())
                        || nv.getNgaysinh().toString().toLowerCase().contains(value.toLowerCase())
                        || nv.getDiachi().toLowerCase().contains(value.toLowerCase())
                        ) {
                    result.add(nv);
                }
            } else {
                switch (type) {
                    case "Mã nhân viên":
                        if (nv.getIdnhanvien().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Tên nhân viên":
                        if (nv.getTen().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Ngày sinh":
                        if (nv.getNgaysinh().toString().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Địa chỉ":
                        if (nv.getDiachi().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                    case "Số điện thoại":
                        if (nv.getSdt().toLowerCase().contains(value.toLowerCase())) {
                            result.add(nv);
                        }
                        break;
                   
                }
            }
        });
        for (int i = result.size() - 1; i >= 0; i--) {
            nhanvien nv = result.get(i);
            LocalDate ngaysinh = nv.getNgaysinh();

            Boolean ngayKhongThoa = (_ngay1 != null && ngaysinh.isBefore(_ngay1)) || (_ngay2 != null && ngaysinh.isAfter(_ngay2));

            if (ngayKhongThoa) {
                result.remove(nv);
            }
        }

        return result;
    }
     public void delete(String id)
     {
       nvDAO.del(id);
     }
  public void addnhanvien(nhanvien t)
  {
      nvDAO.addnhanvien(t);
  }
  public void update(String idnhanvien,String tennhanvien,String dienthoai,LocalDate ngaysinh,String diachi)
  {
      nvDAO.update(idnhanvien, tennhanvien, dienthoai, ngaysinh, diachi);
  }
}
     
