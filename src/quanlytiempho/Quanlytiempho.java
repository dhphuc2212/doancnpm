/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JOptionPane;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
public class Quanlytiempho {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       Connectiondb con=new Connectiondb();
       System.out.println("Connecting...");
       System.out.print(con.checkconnect());
       String query="Select * from nhanvien";
       ResultSet r=con.sqlres(query);
       if(r!=null)
       {
           while(r.next())
           {
               System.out.println(r.getString("idnhanvien"));
               System.out.println(r.getString("tennhanvien"));
               System.out.println(r.getString("dienthoai"));
               System.out.println(r.getDate("ngaysinh").toString());
               System.out.println(r.getString("diachi"));
           }
       }
    }
    
}
