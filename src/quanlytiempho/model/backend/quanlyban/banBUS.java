package quanlytiempho.model.backend.quanlyban;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import quanlytiempho.model.backend.quanlythuckhach.thuckhach;
import quanlytiempho.model.backend.quanlythuckhach.thuckhachBUS;
import java.sql.SQLException;
import java.util.*;
public class banBUS {
     public ArrayList<ban> dsb=new ArrayList<>();
    banDAO bDAO=new banDAO();
    Connectiondb con=new Connectiondb();
    public banBUS()
    {
        dsb=bDAO.readDB();
    }
    public void displayConsole()
    {
        dsb.forEach((tp)->{
        System.out.print(tp.getIdban()+" ");
        System.out.print(tp.getLoaiban()+" ");
       
        System.out.print(tp.getTrangthai());
                });
    }
    public String[] getHeaders()
    {
        return new String[]{"Mã bàn","Loại bàn","Số bàn lớn","Số bàn nhỏ","Trạng thái"};
    }
    public ban getban(int idban)
    {
        for(ban t:dsb)
        {
            if(t.getIdban()==idban)
            {
                return t;
            }
        }
        return null;
    }
    public ArrayList<ban> getdsban()
    {
        this.dsb=bDAO.readDB();
        return dsb;
    }
     public int getNextID() throws SQLException {
        String query="Select idban from ban";
        
        ResultSet r=con.sqlres(query);
        int max1=0;
        if(r!=null)
        {
            while(r.next())
            {
                if(r.getInt("idban")>max1)
                {
                    max1=r.getInt("idban");
                }
            }
        }
        return max1+1;
    }
    public void addban(ban t)
    {
        bDAO.addban(t);
    }
    public void updateban(int idban,String loaiban,String trangthai)
    {
        bDAO.update(idban, loaiban, trangthai);
    }
    public void delban(int idban)
    {
       bDAO.del(idban);
    }
    public void readb()
    {
        this.dsb=bDAO.readDB();
    }
    public boolean checkbooked(ban t) throws SQLException
    {
        String query="Select * from ban,thuckhach where '"+t.getIdban()+"'=thuckhach.idban and ban.idban='"+t.getIdban()+"'";
        ResultSet r=con.sqlres(query);
        while(r.next())
        {
                String lb=r.getString("Loaiban");
                String ltk=r.getString("Loaithuckhach");
               
                if(ltk.equals("Nhiều người") && lb.equals("Nhỏ"))
                {
                    JOptionPane.showMessageDialog(null,"Loại bàn không phù hợp với loại thực khách '"+r.getString("idthuckhach")+"'");
                       t.setTrangthai("Trống");
        bDAO.update(t.getIdban(),t.getLoaiban(),"Trống");
                    return false;
                }
                else if(ltk.equals("Một người") && lb.equals("Lớn"))
                {
                    JOptionPane.showMessageDialog(null,"Loại bàn không phù hợp với loại thực khách '"+r.getString("idthuckhach")+"' ");
                       t.setTrangthai("Trống");
        bDAO.update(t.getIdban(),t.getLoaiban(),"Trống");
                    return false;
                }
                else
                {                t.setTrangthai("Có người");

               bDAO.update(t.getIdban(),t.getLoaiban(),"Có người");
             return true;
                }
        }
        t.setTrangthai("Trống");
        bDAO.update(t.getIdban(),t.getLoaiban(),"Trống");
         return false;
    }
   
}
