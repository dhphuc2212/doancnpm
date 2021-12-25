/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.connectiondb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JOptionPane;
public class Connectiondb {
    static int countConnection=0;
    static int countquery=0;
    static int countupdate=0;
    Connection con=null;
    Statement stm=null;
    ResultSet res=null;
    String db_name=null;
    String user=null;
    String pass=null;
    String ipaddress="localhost";
    public Connectiondb()
    {
        checkdriver();
        db_name="quanlytiempho";
        user="root";
        pass="";
        setupConnect();
    }
    public Connectiondb(String db_name)
    {
        checkdriver();
        this.db_name=db_name;
    }
      public Connectiondb(String DB_Name, String user_Name, String pass) {
        checkdriver();
        this.db_name = DB_Name;
        this.user = user_Name;
        this.pass = pass;
        setupConnect();
    }
    private void setupConnect()
    {
        try
        {
            String url="jdbc:mysql://"+ipaddress+"/"+db_name;
            con=DriverManager.getConnection(url,user,pass);
            stm=con.createStatement();
            System.out.println("Da ket noi thanh cong vao database "+db_name);
        }
        catch(SQLException e)
        {
            System.err.print("Khong the ket noi toi"+db_name);
            JOptionPane.showMessageDialog(null,"Khong the ket noi toi "+db_name);
        }
    }
    public ResultSet sqlres(String query)
    {
        if(checkconnect())
        {
            try
            {
                res=stm.executeQuery(query);
                countquery++;
                System.out.println(countquery+"Da thuc hien cau truy van thanh cong");
                return res;
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,"Khong the thuc hien cau truy van tu"+db_name+"\n"+e.getLocalizedMessage());
            }
        }
        return null;
        
    }
    public Boolean checkconnect()
    {
        if(con==null||stm==null)
        {
            JOptionPane.showMessageDialog(null,"Chua thiet lap ket noi toi "+db_name);
            return false;
        }
        else
        {
            return true;
        }
        
    }
    public Boolean checkupdate(String qry)
    {
        if(checkconnect())
        {
            try
            {
                stm.executeUpdate(qry);
                countupdate++;
                System.out.println("Da cap nhat du lieu thanh cong");
                return true;
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,"Khong the ghi du lieu trong "+db_name+"\n"+e.getLocalizedMessage());
                return false;
            }
        }
        return false;
        
    }
    public void closeconnect()
    {
        try
        {
            if(con!=null)
            {
                con.close();
            }
            if(stm!=null)
            {
                stm.close();
            }
            System.out.println("Da dong thanh cong");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Khong the ket noi toi co so du lieu "+db_name);
        }
    }
    public void checkdriver()
    {try
    {
        Class.forName("com.mysql.jdbc.Driver");
        
    }
    catch(ClassNotFoundException e)
    {
        JOptionPane.showMessageDialog(null,"Khong the tim thay driver cho co so du lieu nay");
    }
        
    }
    
    

}
 
