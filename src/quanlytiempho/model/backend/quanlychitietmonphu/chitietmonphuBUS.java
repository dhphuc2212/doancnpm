/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlychitietmonphu;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.*;
import quanlytiempho.model.backend.quanlymonphu.monphu;
import quanlytiempho.model.backend.quanlymonphu.monphuDAO;
public class chitietmonphuBUS {
      public ArrayList<chitietmonphu> dsctmp=new ArrayList<>();
    chitietmonphuDAO ctmpDAO=new chitietmonphuDAO();
    public chitietmonphuBUS()
    {
        dsctmp=ctmpDAO.readDB();
    }
    public void displayConsole()
    {
        dsctmp.forEach((tp)->{
        System.out.print(tp.getId()+" ");
        System.out.print(tp.getIdmonphu()+" ");
        System.out.print(tp.getIdto());
                });
    }
    public String[] getHeaders()
    {
        return new String[]{"Mã chi tiết món phụ","Mã món phụ","Mã tô"};
    }
    public chitietmonphu getchitietmonphu(int id)
    {
        for(chitietmonphu t:dsctmp)
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
        return dsctmp.size()+1;
    }
    public void addctmp(chitietmonphu t)
    {
        ctmpDAO.addchitietmonphu(t);
    }
    public void readdb()
    {
        this.dsctmp=ctmpDAO.readDB();
    }
    public void delctmp(int id)
    {
        ctmpDAO.del(id);
    }
}
