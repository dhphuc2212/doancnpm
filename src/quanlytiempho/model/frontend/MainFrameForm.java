/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.frontend;

import com.itextpdf.text.DocumentException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.*;
import javax.swing.JTable;
import java.awt.Button;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import quanlytiempho.model.backend.quanlynhanvien.nhanvien;
import quanlytiempho.model.backend.quanlynhanvien.nhanvienBUS;
import quanlytiempho.model.backend.quanlythuckhach.thuckhach;
import quanlytiempho.model.backend.quanlythuckhach.thuckhachBUS;
import quanlytiempho.model.backend.quanlythuckhach.thuckhach;
import quanlytiempho.model.backend.quanlyloaimonphu.loaimonphuBUS;
import quanlytiempho.model.backend.quanlyloaimonphu.loaimonphu;
import quanlytiempho.model.backend.quanlytaikhoan.taikhoan;
import quanlytiempho.model.backend.quanlytaikhoan.taikhoanBUS;
import quanlytiempho.model.backend.quanlyphanquyen.phanquyenBUS;
import quanlytiempho.model.backend.quanlyphanquyen.phanquyen;
import quanlytiempho.model.backend.quanlymonphu.monphuBUS;
import quanlytiempho.model.backend.quanlymonphu.monphu;
import quanlytiempho.model.backend.xuatnhapexcel.XuatExcel;
import quanlytiempho.model.backend.quanlyban.banBUS;
import quanlytiempho.model.backend.quanlyban.ban;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import quanlytiempho.model.backend.quanlyto.topho;
import quanlytiempho.model.backend.quanlyto.tophoBUS;
import quanlytiempho.model.backend.quanlychitietmonphu.chitietmonphu;
import quanlytiempho.model.backend.quanlychitietmonphu.chitietmonphuBUS;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import quanlytiempho.model.backend.quanlyhoadon.hoadonBUS;
import quanlytiempho.model.backend.quanlyhoadon.hoadon;
import quanlytiempho.model.backend.quanlychitiethoadon.chitiethoadon;
import quanlytiempho.model.backend.quanlychitiethoadon.chitiethoadonBUS;
import quanlytiempho.model.backend.writePDF.xuatfilePDF;

public class MainFrameForm extends javax.swing.JFrame {

    /**
     * Creates new form MainFrameForm
     * @throws java.sql.SQLException
     */
  private String username;  
    public MainFrameForm() throws SQLException {
        initComponents();
        this.setSize(840,750);
        this.setLocationRelativeTo(null);
        this.username=username;
       dynamicclock();
       qlnv.readdb();
       qltk.readtk();
       int size=qlnv.getdsnv().size();
       System.out.println(size);
       qlnv.displayConsole();
       addtable(qlnv.getdsnv(),jTable1);
       addtable1(qltk.getdstk(),jTable2);
       addtable2(qllmp.getlma());
       addtable3(qltk1.getdstk());
       addtable4(qlpq.getdspq());
       addtable5(qlmp.getma());
       addDocumentListener(jte5,jte2,jte3);
       addDocumentListener1();
       addDocumentListener2();
       addDocumentListener3();
       addDocumentListener4();
       addDocumentListener5();
       addDocumentListener6();
       addban(qlb.getdsban());
       addmato(qlt.getdst());
       addtable6(qlhd.gethoadon());
       ArrayList<ban> t=new ArrayList<>();
       t=qlb.getdsban();
       System.out.println(t.size());
       System.out.print(t.get(1).getLoaiban());
      this.setVisible(true);
    }
     public MainFrameForm(String username) throws SQLException {
        initComponents();
        this.setSize(840,570);
        this.username=username;
        String query="Select tennhanvien from nhanvien,taikhoan where nhanvien.idnhanvien=taikhoan.idnhanvien and taikhoan.tentaikhoan='"+username+"'";
       
        ResultSet r=con.sqlres(query);
        while(r.next())
        {
        String tennhanvien=r.getString("tennhanvien");
        jLabel94.setText(tennhanvien);
        jLabel94.setForeground(Color.WHITE);
        jLabel94.setFont(new Font("Serif",Font.BOLD,18));
        }
        
        this.setLocationRelativeTo(null);
       dynamicclock();
       qlnv.readdb();
       qltk.readtk();
       int size=qlnv.getdsnv().size();
       System.out.println(size);
       qlnv.displayConsole();
       addtable(qlnv.getdsnv(),jTable1);
       addtable1(qltk.getdstk(),jTable2);
       addtable2(qllmp.getlma());
       addtable3(qltk1.getdstk());
       addtable4(qlpq.getdspq());
       addtable5(qlmp.getma());
       addDocumentListener(jte5,jte2,jte3);
       addDocumentListener1();
       addDocumentListener2();
       addDocumentListener3();
       addDocumentListener4();
       addDocumentListener5();
       addDocumentListener6();
       addDocumentListener8();
       addban(qlb.getdsban());
       addmato(qlt.getdst());
       addtable6(qlhd.gethoadon());
       addtable7(qlhd.gethoadon());
       addmathuckhach(qltk.getdstk());
       ArrayList<ban> t=new ArrayList<>();
       t=qlb.getdsban();
       System.out.println(t.size());
       System.out.print(t.get(1).getLoaiban());
      this.setVisible(true);
      JButton j=new JButton();
      DatePickerSettings setting=new DatePickerSettings();
      setting.setVisibleDateTextField(false);
      d1=new DatePicker(setting);
      d1.setDateToToday();
       String query1="Select maquyen from taikhoan where tentaikhoan='"+username+"'";
       r=con.sqlres(query1);
       while(r.next())
       {
         maquyen=r.getInt("maquyen");
       }
      if(maquyen==2)
      {
          jLabel94.setText("Admin");
        jLabel94.setForeground(Color.WHITE);
        jLabel94.setFont(new Font("Serif",Font.BOLD,18));
      }
      if(maquyen==3)
      {
          jLabel94.setText("Manager");
        jLabel94.setForeground(Color.WHITE);
        jLabel94.setFont(new Font("Serif",Font.BOLD,18));
      }
      d1.addDateChangeListener((dc)->{jte2.setText(d1.getDateStringOrEmptyString());});
      String query2="Select count(idnhanvien) as slnv from nhanvien";
      String query3="Select count(idban) as slbanlon from ban where loaiban='Lớn'";
      String query4="Select count(idthuckhach) as slthuckhach from thuckhach";
      String query5="Select count(idtaikhoan) as slql from taikhoan where maquyen=3";
      String query6="Select count(idban) as slbannho from ban where loaiban='Nhỏ'";
      int sl1,sl2,sl3,sl4,sl5;
      sl1=0;
      sl2=0;
      sl3=0;
      sl4=0;
      sl5=0;
      r=con.sqlres(query2);
      while(r.next())
      {
          sl1=r.getInt("slnv");
      }
      r=con.sqlres(query3);
      while(r.next())
      {
          sl2=r.getInt("slbanlon");
      }
      r=con.sqlres(query4);
      while(r.next())
      {
          sl3=r.getInt("slthuckhach");
      }
      r=con.sqlres(query5);
      while(r.next())
      {
          sl4=r.getInt("slql");
      }
      r=con.sqlres(query6);
      while(r.next())
      {
          sl5=r.getInt("slbannho");
      }
     jLabel100.setText(String.valueOf(sl1));
     jLabel100.setForeground(Color.YELLOW);
     jLabel100.setFont(new Font("Tahoma",Font.PLAIN,25));
     
     jLabel108.setText(String.valueOf(sl2));
     jLabel108.setForeground(Color.YELLOW);
     jLabel108.setFont(new Font("Tahoma",Font.PLAIN,25));
     jLabel104.setText(String.valueOf(sl3));
     jLabel104.setForeground(Color.YELLOW);
     jLabel104.setFont(new Font("Tahoma",Font.PLAIN,25));
     jLabel112.setText(String.valueOf(sl4));
     jLabel112.setForeground(Color.YELLOW);
     jLabel112.setFont(new Font("Tahoma",Font.PLAIN,25));
      jLabel118.setText(String.valueOf(sl5));
     jLabel118.setForeground(Color.YELLOW);
     jLabel118.setFont(new Font("Tahoma",Font.PLAIN,25));
     }
     DatePicker d1;
     int maquyen=0;
    nhanvien nv;
    nhanvienBUS qlnv=new nhanvienBUS();
    thuckhachBUS qltk=new thuckhachBUS();
    loaimonphuBUS qllmp=new loaimonphuBUS();
    taikhoanBUS qltk1=new taikhoanBUS();
    phanquyenBUS qlpq=new phanquyenBUS();
    monphuBUS qlmp=new monphuBUS();
    banBUS qlb=new banBUS();
    tophoBUS qlt=new tophoBUS();
    chitietmonphuBUS ctmp=new chitietmonphuBUS();
    Connectiondb con=new Connectiondb();
    hoadonBUS qlhd=new hoadonBUS();
    chitiethoadonBUS cthd=new chitiethoadonBUS();
 
    public void addtable(ArrayList<nhanvien> data,JTable table)
    {  
        DefaultTableModel tb=(DefaultTableModel)table.getModel();
        tb.setRowCount(0);
        for(nhanvien n:data)
        {
            tb.addRow(new Object[]{
             n.getIdnhanvien(),
              n.getTen(),
              n.getSdt(),
               n.getNgaysinh().toString(),
                n.getDiachi()});
            
        }
   
    }
    public void addmato(ArrayList<topho> data)
    {   jComboBox5.removeAllItems();
        for(topho t : data)
        {
            jComboBox5.addItem(String.valueOf(t.getIdto()));
        }
       jComboBox5.addItem(String.valueOf(qlt.getNextID()));
    }
     public void addtable1(ArrayList<thuckhach> data,JTable table)
    {  
        DefaultTableModel tb=(DefaultTableModel)table.getModel();
        tb.setRowCount(0);
        for(thuckhach n:data)
        {
            tb.addRow(new Object[]{
             n.getIdthuckhach(),
              n.getIdban(),
              n.getLoaithuckhach(),
               n.getGiovao().toString(),
                });
            
        }
   
    }
     public void addtable2(ArrayList<loaimonphu> data)
     {
         DefaultTableModel tb=(DefaultTableModel)jTable5.getModel();
        tb.setRowCount(0);
        for(loaimonphu n:data)
        {
            tb.addRow(new Object[]{
              n.getId(),
              n.getTenloai()
                });
            
        }
     }
     public void addtable3(ArrayList<taikhoan> data)
     {
         DefaultTableModel tb=(DefaultTableModel)jTable7.getModel();
        tb.setRowCount(0);
        for(taikhoan n:data)
        {
            tb.addRow(new Object[]{
              n.getIdtaikhoan(),
              n.getTentaikhoan(),
              n.getMatkhau(),
              n.getIdnhanvien(),
              n.getIdquyen()
                });
            
        }
     }
     public void addtable4(ArrayList<phanquyen> data)
     {
         DefaultTableModel tb=(DefaultTableModel)jTable8.getModel();
        tb.setRowCount(0);
        for(phanquyen n:data)
        {
            tb.addRow(new Object[]{
              n.getMaquyen(),
              n.getTenquyen(),
              n.getGhichu()
                });
            
        }
     }
    public void addtable5(ArrayList<monphu> data)
     {
                  DefaultTableModel tb=(DefaultTableModel)jTable9.getModel();
        tb.setRowCount(0);
        for(monphu n:data)
        {
            tb.addRow(new Object[]{
              n.getIdmonphu(),
              n.getTenmonphu(),
              n.getIdloaimonphu(),
              n.getGiatien()+"đ"
                });
        }
     }
    
     public void addban(ArrayList<ban> data) throws SQLException
     {   int x,y;
         x=y=0;
         jp22.removeAll();
         jp22.revalidate();
       
      
         int c1=1;
         for(ban t:data)
         {   c1++;
             JButton j=new JButton();
             j.setSize(new Dimension(80,80));
            
             boolean a=qlb.checkbooked(t);
             if(a==true)
             {
             j.setBackground(Color.pink);
             }
             else
             {
                 j.setBackground(Color.cyan);
             }
           
              j.setBounds(x,y,150,150);
             j.setText("<html>"+"Bàn "+t.getIdban()+"<br />"+t.getLoaiban()+"<br />"+t.getTrangthai()+"</html>");
             j.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e)
               { 
                   
                       DefaultTableModel table=(DefaultTableModel)jTable10.getModel();
                       table.setRowCount(0);
                      
                      String query="Select idthuckhach,loaithuckhach,giovao,loaiban from thuckhach,ban where thuckhach.idban='"+t.getIdban()+"'and ban.idban='"+t.getIdban()+"'";
                       ResultSet r=con.sqlres(query);
                          
                  
                   try {
                        r.next();
                          String idthuckhach=r.getString("idthuckhach");
                           String loaithuckhach=r.getString("loaithuckhach");
                           String loaiban=r.getString("loaiban");
           
                           LocalTime giovao=r.getTime("giovao").toLocalTime();
                       
                     
                     String query2="select distinct topho.idto,loaito,giodat,tenmonphu from topho,thuckhach,chitietmonphu,monphu where topho.idthuckhach='"+idthuckhach+"' and topho.idto=chitietmonphu.idto and monphu.idmonphu=chitietmonphu.idmonphu";
                    ResultSet r1=con.sqlres(query2);
                    Boolean tr=r1.next();
                   if(tr==true)
                   { 
                       r1.beforeFirst();
                    while(r1.next())
                     {   int mato=r1.getInt("idto");
                         String loaito=r1.getString("loaito");
                         LocalTime giodat=r1.getTime("giodat").toLocalTime();
                         String tenmonphu=r1.getString("tenmonphu");
                           if((loaithuckhach.equals("Nhiều người")&&loaiban.equals("Lớn"))||(loaithuckhach.equals("Một người")&&loaiban.equals("Nhỏ")))
                           {
                          table.addRow(new Object[]{idthuckhach,loaithuckhach,giovao,mato,loaito,giodat,tenmonphu});
                           }
                     }
                   }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Bàn này chưa gọi món.");
                    }
                    
                           
                       } 
                    catch (SQLException ex) {
                       Logger.getLogger(MainFrameForm.class.getName()).log(Level.SEVERE, null, ex);
                   }
                       }});
             
             jp22.add(j);
             if(c1<=4)
             {
             x+=160;
             }
             else
             {
                 x=0;
                 y+=160;
                 c1=1;
             }
             jp22.repaint();
         
     }
                     }
     
     public void addtable6(ArrayList<hoadon> data)
     {
         DefaultTableModel tb=(DefaultTableModel)jTable11.getModel();
        tb.setRowCount(0);
        for(hoadon n:data)
        {
            tb.addRow(new Object[]{
              n.getIdhoadon(),
              n.getIdban(),
              n.getNgayxuat(),
              n.getIdthuckhach(),
              n.getGioxuat(),
              n.getIdnhanvien(),
              n.getTongtien()+"đ"
              
                });
            
        }
     }
     public void addtable7(ArrayList<hoadon> data) throws SQLException
     {
         DefaultTableModel t1=(DefaultTableModel)jTable12.getModel();
         t1.setRowCount(0);
         ResultSet r=null;
         for(hoadon t:data)
         {
             String idhoadon=t.getIdhoadon();
             LocalDate ngayxuat=t.getNgayxuat();
             double tongtien=t.getTongtien();
             String idnhanvien=t.getIdnhanvien();
             String tennhanvien="";
             String query="select tennhanvien from nhanvien where nhanvien.idnhanvien='"+idnhanvien+"' ";
             r=con.sqlres(query);
             while(r.next())
             {
                 tennhanvien=r.getString("tennhanvien");
             }
             t1.addRow(new Object[]{idnhanvien,tennhanvien,idhoadon,ngayxuat,(int)tongtien+"đ"});
         }
}
     public void addmathuckhach(ArrayList<thuckhach> data)
     {
        jComboBox13.removeAllItems();
        for(thuckhach t : data)
        {
            jComboBox13.addItem(t.getIdthuckhach());
        }
        
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        jCheckBox11 = new javax.swing.JCheckBox();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox15 = new javax.swing.JCheckBox();
        jLabel44 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel45 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox<>();
        jLabel55 = new javax.swing.JLabel();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jCheckBox20 = new javax.swing.JCheckBox();
        jLabel56 = new javax.swing.JLabel();
        jComboBox11 = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox<>();
        jLabel58 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jp3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jp2 = new javax.swing.JPanel();
        j2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jp1 = new javax.swing.JPanel();
        j1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jp4 = new javax.swing.JPanel();
        j3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jp5 = new javax.swing.JPanel();
        j4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jp6 = new javax.swing.JPanel();
        j6 = new javax.swing.JLabel();
        j16 = new javax.swing.JLabel();
        jp7 = new javax.swing.JPanel();
        j7 = new javax.swing.JLabel();
        j17 = new javax.swing.JLabel();
        jp8 = new javax.swing.JPanel();
        j9 = new javax.swing.JLabel();
        j18 = new javax.swing.JLabel();
        jp9 = new javax.swing.JPanel();
        j10 = new javax.swing.JLabel();
        j19 = new javax.swing.JLabel();
        jp10 = new javax.swing.JPanel();
        j11 = new javax.swing.JLabel();
        j20 = new javax.swing.JLabel();
        jp11 = new javax.swing.JPanel();
        j12 = new javax.swing.JLabel();
        j21 = new javax.swing.JLabel();
        jp12 = new javax.swing.JPanel();
        j13 = new javax.swing.JLabel();
        j22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jl1 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        j95 = new javax.swing.JLabel();
        jt1 = new javax.swing.JTabbedPane();
        jPanel17 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jch1 = new javax.swing.JCheckBox();
        jch2 = new javax.swing.JCheckBox();
        jch3 = new javax.swing.JCheckBox();
        jch4 = new javax.swing.JCheckBox();
        jch5 = new javax.swing.JCheckBox();
        jLabel79 = new javax.swing.JLabel();
        jc2 = new javax.swing.JComboBox<>();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jCheckBox26 = new javax.swing.JCheckBox();
        jCheckBox27 = new javax.swing.JCheckBox();
        jc3 = new javax.swing.JCheckBox();
        jCheckBox29 = new javax.swing.JCheckBox();
        jCheckBox30 = new javax.swing.JCheckBox();
        jLabel91 = new javax.swing.JLabel();
        jComboBox17 = new javax.swing.JComboBox<>();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        j5 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jc1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jtext3 = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtext1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtext2 = new javax.swing.JTextField();
        jcb3 = new javax.swing.JComboBox<>();
        jButton38 = new javax.swing.JButton();
        jLabel84 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox13 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jcb2 = new javax.swing.JComboBox<>();
        jl5 = new javax.swing.JLabel();
        jte5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jb6 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jte2 = new javax.swing.JTextField();
        jte3 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jcb1 = new javax.swing.JComboBox<>();
        j8 = new javax.swing.JLabel();
        jtex1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jtex2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jtex3 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jb13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jcombobox1 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton28 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        j23 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jButton30 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jButton32 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jButton34 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jp22 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jButton37 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jButton41 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel24 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jLabel113 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jTextField22 = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();

        jPanel12.setToolTipText("");
        jPanel12.setName(""); // NOI18N
        jPanel12.setPreferredSize(new java.awt.Dimension(2000, 510));
        jPanel12.setLayout(null);

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel39.setText("Gọi món");
        jPanel12.add(jLabel39);
        jLabel39.setBounds(420, 10, 100, 29);

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(153, 153, 153));
        jLabel40.setText("Thông tin thức ăn:");
        jPanel12.add(jLabel40);
        jLabel40.setBounds(0, 70, 149, 22);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(153, 153, 153));
        jLabel41.setText("Thông tin khách hàng:");
        jPanel12.add(jLabel41);
        jLabel41.setBounds(0, 250, 180, 22);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setText("Loại tô:");
        jPanel12.add(jLabel42);
        jLabel42.setBounds(34, 123, 52, 17);

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn loại tô:", "Tô nhỏ", "Tô bình thường", "Tô lớn" }));
        jPanel12.add(jComboBox7);
        jComboBox7.setBounds(91, 121, 114, 22);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel43.setText("Loại thịt:");
        jPanel12.add(jLabel43);
        jLabel43.setBounds(261, 123, 61, 17);

        jCheckBox11.setText("Tái");
        jCheckBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox11ActionPerformed(evt);
            }
        });
        jPanel12.add(jCheckBox11);
        jCheckBox11.setBounds(334, 120, 47, 25);

        jCheckBox12.setText("Nạm");
        jPanel12.add(jCheckBox12);
        jCheckBox12.setBounds(413, 120, 55, 25);

        jCheckBox13.setText("Gân");
        jPanel12.add(jCheckBox13);
        jCheckBox13.setBounds(495, 120, 51, 25);

        jCheckBox14.setText("Gầu");
        jPanel12.add(jCheckBox14);
        jCheckBox14.setBounds(588, 120, 51, 25);

        jCheckBox15.setText("Bò vò viên");
        jPanel12.add(jCheckBox15);
        jCheckBox15.setBounds(676, 120, 87, 25);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel44.setText("Loại món ăn phụ:");
        jPanel12.add(jLabel44);
        jLabel44.setBounds(12, 202, 120, 17);

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn loại:", "Thức ăn", "Thức uống" }));
        jPanel12.add(jComboBox8);
        jComboBox8.setBounds(137, 200, 88, 22);

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText("Món ăn phụ:");
        jPanel12.add(jLabel45);
        jLabel45.setBounds(261, 202, 87, 17);

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel12.add(jComboBox9);
        jComboBox9.setBounds(374, 200, 64, 22);

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("Mã thực khách:");
        jPanel12.add(jLabel46);
        jLabel46.setBounds(23, 296, 106, 17);
        jPanel12.add(jTextField11);
        jTextField11.setBounds(141, 293, 111, 25);

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText("Loại thực khách:");
        jPanel12.add(jLabel47);
        jLabel47.setBounds(23, 344, 114, 17);
        jPanel12.add(jTextField12);
        jTextField12.setBounds(142, 342, 110, 22);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText("Mã bàn ăn:");
        jPanel12.add(jLabel48);
        jLabel48.setBounds(313, 296, 76, 17);
        jPanel12.add(jTextField13);
        jTextField13.setBounds(394, 293, 123, 25);

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setText("Giờ vào:");
        jPanel12.add(jLabel49);
        jLabel49.setBounds(333, 344, 56, 17);
        jPanel12.add(jTextField14);
        jTextField14.setBounds(394, 336, 123, 28);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setText("Tổng tiền:");
        jPanel12.add(jLabel50);
        jLabel50.setBounds(486, 202, 71, 17);

        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });
        jPanel12.add(jTextField15);
        jTextField15.setBounds(562, 200, 115, 22);

        jTable3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã thực khách", "Loại thực khách", "Mã bàn ăn", "Giờ vào", "Loại tô", "Loại thịt", "Món ăn phụ", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jPanel12.add(jScrollPane3);
        jScrollPane3.setBounds(0, 395, 1003, 110);

        jPanel13.setToolTipText("");
        jPanel13.setName(""); // NOI18N
        jPanel13.setPreferredSize(new java.awt.Dimension(2000, 510));
        jPanel13.setLayout(null);

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel51.setText("Gọi món");
        jPanel13.add(jLabel51);
        jLabel51.setBounds(420, 10, 100, 29);

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(153, 153, 153));
        jLabel52.setText("Thông tin thức ăn:");
        jPanel13.add(jLabel52);
        jLabel52.setBounds(0, 70, 149, 22);

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(153, 153, 153));
        jLabel53.setText("Thông tin khách hàng:");
        jPanel13.add(jLabel53);
        jLabel53.setBounds(0, 250, 180, 22);

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel54.setText("Loại tô:");
        jPanel13.add(jLabel54);
        jLabel54.setBounds(34, 123, 52, 17);

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn loại tô:", "Tô nhỏ", "Tô bình thường", "Tô lớn" }));
        jPanel13.add(jComboBox10);
        jComboBox10.setBounds(91, 121, 114, 22);

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel55.setText("Loại thịt:");
        jPanel13.add(jLabel55);
        jLabel55.setBounds(261, 123, 61, 17);

        jCheckBox16.setText("Tái");
        jCheckBox16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox16ActionPerformed(evt);
            }
        });
        jPanel13.add(jCheckBox16);
        jCheckBox16.setBounds(334, 120, 47, 25);

        jCheckBox17.setText("Nạm");
        jPanel13.add(jCheckBox17);
        jCheckBox17.setBounds(413, 120, 55, 25);

        jCheckBox18.setText("Gân");
        jPanel13.add(jCheckBox18);
        jCheckBox18.setBounds(495, 120, 51, 25);

        jCheckBox19.setText("Gầu");
        jPanel13.add(jCheckBox19);
        jCheckBox19.setBounds(588, 120, 51, 25);

        jCheckBox20.setText("Bò vò viên");
        jPanel13.add(jCheckBox20);
        jCheckBox20.setBounds(676, 120, 87, 25);

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel56.setText("Loại món ăn phụ:");
        jPanel13.add(jLabel56);
        jLabel56.setBounds(12, 202, 120, 17);

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn loại:", "Thức ăn", "Thức uống" }));
        jPanel13.add(jComboBox11);
        jComboBox11.setBounds(137, 200, 88, 22);

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel57.setText("Món ăn phụ:");
        jPanel13.add(jLabel57);
        jLabel57.setBounds(261, 202, 87, 17);

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel13.add(jComboBox12);
        jComboBox12.setBounds(374, 200, 64, 22);

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel58.setText("Mã thực khách:");
        jPanel13.add(jLabel58);
        jLabel58.setBounds(23, 296, 106, 17);
        jPanel13.add(jTextField16);
        jTextField16.setBounds(141, 293, 111, 25);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setText("Loại thực khách:");
        jPanel13.add(jLabel59);
        jLabel59.setBounds(23, 344, 114, 17);
        jPanel13.add(jTextField17);
        jTextField17.setBounds(142, 342, 110, 22);

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel60.setText("Mã bàn ăn:");
        jPanel13.add(jLabel60);
        jLabel60.setBounds(313, 296, 76, 17);
        jPanel13.add(jTextField18);
        jTextField18.setBounds(394, 293, 123, 25);

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel61.setText("Giờ vào:");
        jPanel13.add(jLabel61);
        jLabel61.setBounds(333, 344, 56, 17);
        jPanel13.add(jTextField19);
        jTextField19.setBounds(394, 336, 123, 28);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setText("Tổng tiền:");
        jPanel13.add(jLabel62);
        jLabel62.setBounds(486, 202, 71, 17);

        jTextField20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField20ActionPerformed(evt);
            }
        });
        jPanel13.add(jTextField20);
        jTextField20.setBounds(562, 200, 115, 22);

        jTable4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã thực khách", "Loại thực khách", "Mã bàn ăn", "Giờ vào", "Loại tô", "Loại thịt", "Món ăn phụ", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel13.add(jScrollPane4);
        jScrollPane4.setBounds(0, 395, 1003, 110);

        jPanel12.add(jPanel13);
        jPanel13.setBounds(280, 30, 915, 510);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1995, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        jPanel15.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel11.setText("Chào mừng bạn đến với hệ thống");
        jPanel15.add(jLabel11);
        jLabel11.setBounds(10, 200, 550, 44);

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel63.setText("quản lý tiệm phở.");
        jPanel15.add(jLabel63);
        jLabel63.setBounds(30, 250, 450, 60);

        jLabel64.setIcon(new javax.swing.ImageIcon("C:\\xampp\\htdocs\\Quanlytiempho\\quanlytiempho\\pho-bo-traditional-vietnamese-soup_185417-33.jpg")); // NOI18N
        jLabel64.setText("jLabel3");
        jPanel15.add(jLabel64);
        jLabel64.setBounds(0, 0, 620, 510);

        jPanel16.setLayout(null);

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel65.setText("Chào mừng bạn đến với hệ thống");
        jPanel16.add(jLabel65);
        jLabel65.setBounds(10, 200, 550, 44);

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel66.setText("quản lý tiệm phở.");
        jPanel16.add(jLabel66);
        jLabel66.setBounds(30, 250, 450, 60);

        jLabel67.setIcon(new javax.swing.ImageIcon("C:\\xampp\\htdocs\\Quanlytiempho\\quanlytiempho\\pho-bo-traditional-vietnamese-soup_185417-33.jpg")); // NOI18N
        jLabel67.setText("jLabel3");
        jPanel16.add(jLabel67);
        jLabel67.setBounds(0, 0, 620, 510);

        jPanel15.add(jPanel16);
        jPanel16.setBounds(0, 0, 0, 0);

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(2012, 580));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new java.awt.CardLayout());

        jp3.setToolTipText("");
        jp3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jp3.setFocusCycleRoot(true);
        jp3.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jp3ComponentAdded(evt);
            }
        });
        jp3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(0, 153, 102));
        jPanel9.setLayout(null);

        jp2.setBackground(new java.awt.Color(0, 153, 102));
        jp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jp2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jp2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jp2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jp2MouseReleased(evt);
            }
        });

        j2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        j2.setText("Nhân viên");

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\user (1) (1).png")); // NOI18N

        javax.swing.GroupLayout jp2Layout = new javax.swing.GroupLayout(jp2);
        jp2.setLayout(jp2Layout);
        jp2Layout.setHorizontalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(j2)
                .addGap(66, 66, 66))
        );
        jp2Layout.setVerticalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(j2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jp2);
        jp2.setBounds(0, 220, 220, 50);

        jp1.setBackground(new java.awt.Color(0, 153, 102));
        jp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jp1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jp1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jp1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jp1MouseReleased(evt);
            }
        });

        j1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        j1.setText("Home");

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\small-house (2).png")); // NOI18N

        javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jp1Layout);
        jp1Layout.setHorizontalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(j1)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jp1Layout.setVerticalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(j1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jp1);
        jp1.setBounds(0, 120, 220, 50);

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\download (4).png")); // NOI18N
        jPanel9.add(jLabel7);
        jLabel7.setBounds(0, 0, 220, 110);

        jp4.setBackground(new java.awt.Color(0, 153, 102));
        jp4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jp4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jp4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jp4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jp4MouseReleased(evt);
            }
        });

        j3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        j3.setText("Gọi món");

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\choices (1).png")); // NOI18N

        javax.swing.GroupLayout jp4Layout = new javax.swing.GroupLayout(jp4);
        jp4.setLayout(jp4Layout);
        jp4Layout.setHorizontalGroup(
            jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp4Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(j3)
                .addGap(75, 75, 75))
        );
        jp4Layout.setVerticalGroup(
            jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(j3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jp4);
        jp4.setBounds(0, 170, 220, 50);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel5);
        jPanel5.setBounds(0, 220, 220, 50);

        jp5.setBackground(new java.awt.Color(0, 153, 102));
        jp5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jp5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jp5MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jp5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jp5MouseReleased(evt);
            }
        });

        j4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        j4.setText("Thực khách");

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\customer (1).png")); // NOI18N

        javax.swing.GroupLayout jp5Layout = new javax.swing.GroupLayout(jp5);
        jp5.setLayout(jp5Layout);
        jp5Layout.setHorizontalGroup(
            jp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp5Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j4)
                .addGap(57, 57, 57))
        );
        jp5Layout.setVerticalGroup(
            jp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(j4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jp5);
        jp5.setBounds(0, 280, 220, 50);

        jp6.setBackground(new java.awt.Color(0, 153, 102));
        jp6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jp6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jp6MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jp6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jp6MouseReleased(evt);
            }
        });

        j6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        j6.setText("Bàn ăn");

        j16.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\chair (1).png")); // NOI18N

        javax.swing.GroupLayout jp6Layout = new javax.swing.GroupLayout(jp6);
        jp6.setLayout(jp6Layout);
        jp6Layout.setHorizontalGroup(
            jp6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(j16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(j6)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jp6Layout.setVerticalGroup(
            jp6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j16)
                    .addComponent(j6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jp6);
        jp6.setBounds(0, 340, 220, 50);

        jp7.setBackground(new java.awt.Color(0, 153, 102));
        jp7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jp7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jp7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jp7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jp7MouseReleased(evt);
            }
        });

        j7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        j7.setText("Hóa đơn");

        j17.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\invoices (1).png")); // NOI18N

        javax.swing.GroupLayout jp7Layout = new javax.swing.GroupLayout(jp7);
        jp7.setLayout(jp7Layout);
        jp7Layout.setHorizontalGroup(
            jp7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(j17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j7)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jp7Layout.setVerticalGroup(
            jp7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j17)
                    .addComponent(j7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jp7);
        jp7.setBounds(0, 390, 220, 50);

        jp8.setBackground(new java.awt.Color(0, 153, 102));
        jp8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jp8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jp8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jp8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jp8MouseReleased(evt);
            }
        });

        j9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        j9.setText("Loại món");

        j18.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\list (1).png")); // NOI18N

        javax.swing.GroupLayout jp8Layout = new javax.swing.GroupLayout(jp8);
        jp8.setLayout(jp8Layout);
        jp8Layout.setHorizontalGroup(
            jp8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(j18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j9)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jp8Layout.setVerticalGroup(
            jp8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j18)
                    .addComponent(j9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jp8);
        jp8.setBounds(0, 440, 220, 50);

        jp9.setBackground(new java.awt.Color(0, 153, 102));
        jp9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jp9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jp9MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jp9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jp9MouseReleased(evt);
            }
        });

        j10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        j10.setText("Tài khoản");

        j19.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\user (2) (1).png")); // NOI18N

        javax.swing.GroupLayout jp9Layout = new javax.swing.GroupLayout(jp9);
        jp9.setLayout(jp9Layout);
        jp9Layout.setHorizontalGroup(
            jp9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp9Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(j19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(j10)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jp9Layout.setVerticalGroup(
            jp9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j19)
                    .addComponent(j10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jp9);
        jp9.setBounds(0, 540, 220, 50);

        jp10.setBackground(new java.awt.Color(0, 153, 102));
        jp10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jp10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jp10MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jp10MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jp10MouseReleased(evt);
            }
        });

        j11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        j11.setText("Phân quyền");
        j11.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                j11ComponentRemoved(evt);
            }
        });
        j11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                j11MouseEntered(evt);
            }
        });

        j20.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\settings (1).png")); // NOI18N

        javax.swing.GroupLayout jp10Layout = new javax.swing.GroupLayout(jp10);
        jp10.setLayout(jp10Layout);
        jp10Layout.setHorizontalGroup(
            jp10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp10Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(j20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(j11)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jp10Layout.setVerticalGroup(
            jp10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j20)
                    .addComponent(j11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jp10);
        jp10.setBounds(0, 600, 220, 50);

        jp11.setBackground(new java.awt.Color(0, 153, 102));
        jp11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jp11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jp11MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jp11MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jp11MouseReleased(evt);
            }
        });

        j12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        j12.setText("Món ăn");
        j12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                j12MouseEntered(evt);
            }
        });

        j21.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\fork (1).png")); // NOI18N

        javax.swing.GroupLayout jp11Layout = new javax.swing.GroupLayout(jp11);
        jp11.setLayout(jp11Layout);
        jp11Layout.setHorizontalGroup(
            jp11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp11Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(j21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(j12)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jp11Layout.setVerticalGroup(
            jp11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j21)
                    .addComponent(j12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jp11);
        jp11.setBounds(0, 490, 220, 50);

        jp12.setBackground(new java.awt.Color(0, 153, 102));
        jp12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jp12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jp12MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jp12MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jp12MouseReleased(evt);
            }
        });

        j13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        j13.setText("Thống kê");
        j13.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                j13ComponentRemoved(evt);
            }
        });
        j13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                j13MouseEntered(evt);
            }
        });

        j22.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\bar-chart (1).png")); // NOI18N

        javax.swing.GroupLayout jp12Layout = new javax.swing.GroupLayout(jp12);
        jp12.setLayout(jp12Layout);
        jp12Layout.setHorizontalGroup(
            jp12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp12Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(j22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(j13)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jp12Layout.setVerticalGroup(
            jp12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j22)
                    .addComponent(j13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.add(jp12);
        jp12.setBounds(0, 660, 220, 50);

        jp3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 220, 760));

        jPanel4.setBackground(new java.awt.Color(0, 153, 102));
        jPanel4.setLayout(null);

        jl1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\menu (1).png")); // NOI18N
        jl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jl1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jl1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jl1MouseExited(evt);
            }
        });
        jPanel4.add(jl1);
        jl1.setBounds(188, 13, 30, 40);

        jLabel94.setText("jLabel94");
        jPanel4.add(jLabel94);
        jLabel94.setBounds(0, 20, 130, 30);

        jPanel23.setBackground(new java.awt.Color(0, 153, 102));
        jPanel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel23MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel23MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel23MouseReleased(evt);
            }
        });

        j95.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\settings (2) (1).png")); // NOI18N
        j95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j95MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                j95MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                j95MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(j95, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(j95)
                .addContainerGap())
        );

        jPanel4.add(jPanel23);
        jPanel23.setBounds(130, 10, 50, 40);

        jp3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 50));

        jt1.setPreferredSize(new java.awt.Dimension(2005, 580));
        jt1.setRequestFocusEnabled(false);

        jPanel17.setRequestFocusEnabled(false);
        jPanel17.setLayout(null);

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 0));
        jLabel68.setText("Welcome");
        jPanel17.add(jLabel68);
        jLabel68.setBounds(0, 450, 230, 44);

        jLabel70.setIcon(new javax.swing.ImageIcon("C:\\xampp\\htdocs\\Quanlytiempho\\quanlytiempho\\pho-bo-traditional-vietnamese-soup_185417-33.jpg")); // NOI18N
        jLabel70.setText("jLabel3");
        jPanel17.add(jLabel70);
        jLabel70.setBounds(-10, -50, 630, 600);

        jPanel18.setLayout(null);

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel71.setText("Chào mừng bạn đến với hệ thống");
        jPanel18.add(jLabel71);
        jLabel71.setBounds(10, 200, 550, 44);

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel72.setText("quản lý tiệm phở.");
        jPanel18.add(jLabel72);
        jLabel72.setBounds(30, 250, 450, 60);

        jLabel73.setIcon(new javax.swing.ImageIcon("C:\\xampp\\htdocs\\Quanlytiempho\\quanlytiempho\\pho-bo-traditional-vietnamese-soup_185417-33.jpg")); // NOI18N
        jLabel73.setText("jLabel3");
        jPanel18.add(jLabel73);
        jLabel73.setBounds(0, 0, 620, 510);

        jPanel17.add(jPanel18);
        jPanel18.setBounds(0, 0, 0, 0);

        jt1.addTab("tab1", null, jPanel17, "");

        jPanel19.setToolTipText("");
        jPanel19.setName(""); // NOI18N
        jPanel19.setPreferredSize(new java.awt.Dimension(2000, 510));
        jPanel19.setLayout(null);

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel74.setText("Gọi món");
        jPanel19.add(jLabel74);
        jLabel74.setBounds(420, 10, 100, 29);

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(153, 153, 153));
        jLabel75.setText("Thông tin thức ăn:");
        jPanel19.add(jLabel75);
        jLabel75.setBounds(0, 70, 149, 22);

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(153, 153, 153));
        jLabel76.setText("Thông tin khách hàng:");
        jPanel19.add(jLabel76);
        jLabel76.setBounds(0, 250, 180, 22);

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel77.setText("Loại tô:");
        jPanel19.add(jLabel77);
        jLabel77.setBounds(34, 123, 52, 17);

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel78.setText("Loại thịt:");
        jPanel19.add(jLabel78);
        jLabel78.setBounds(261, 123, 61, 17);

        jch1.setText("Tái");
        jch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jch1ActionPerformed(evt);
            }
        });
        jPanel19.add(jch1);
        jch1.setBounds(334, 120, 47, 25);

        jch2.setText("Nạm");
        jch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jch2ActionPerformed(evt);
            }
        });
        jPanel19.add(jch2);
        jch2.setBounds(413, 120, 55, 25);

        jch3.setText("Gân");
        jch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jch3ActionPerformed(evt);
            }
        });
        jPanel19.add(jch3);
        jch3.setBounds(495, 120, 51, 25);

        jch4.setText("Gầu");
        jch4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jch4ActionPerformed(evt);
            }
        });
        jPanel19.add(jch4);
        jch4.setBounds(588, 120, 51, 25);

        jch5.setText("Bò vò viên");
        jch5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jch5ActionPerformed(evt);
            }
        });
        jPanel19.add(jch5);
        jch5.setBounds(676, 120, 87, 25);

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel79.setText("Loại món ăn phụ:");
        jPanel19.add(jLabel79);
        jLabel79.setBounds(12, 202, 120, 17);

        jc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn loại:", "Thức ăn", "Thức uống" }));
        jc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc2ActionPerformed(evt);
            }
        });
        jPanel19.add(jc2);
        jc2.setBounds(137, 200, 100, 30);

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel80.setText("Món ăn phụ:");
        jPanel19.add(jLabel80);
        jLabel80.setBounds(261, 202, 87, 17);

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel81.setText("Mã thực khách:");
        jPanel19.add(jLabel81);
        jLabel81.setBounds(23, 296, 106, 17);

        jPanel20.setToolTipText("");
        jPanel20.setName(""); // NOI18N
        jPanel20.setPreferredSize(new java.awt.Dimension(2000, 510));
        jPanel20.setLayout(null);

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel86.setText("Gọi món");
        jPanel20.add(jLabel86);
        jLabel86.setBounds(420, 10, 100, 29);

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(153, 153, 153));
        jLabel87.setText("Thông tin thức ăn:");
        jPanel20.add(jLabel87);
        jLabel87.setBounds(0, 70, 149, 22);

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(153, 153, 153));
        jLabel88.setText("Thông tin khách hàng:");
        jPanel20.add(jLabel88);
        jLabel88.setBounds(0, 250, 180, 22);

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel89.setText("Loại tô:");
        jPanel20.add(jLabel89);
        jLabel89.setBounds(34, 123, 52, 17);

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel90.setText("Loại thịt:");
        jPanel20.add(jLabel90);
        jLabel90.setBounds(261, 123, 61, 17);

        jCheckBox26.setText("Tái");
        jCheckBox26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox26ActionPerformed(evt);
            }
        });
        jPanel20.add(jCheckBox26);
        jCheckBox26.setBounds(334, 120, 47, 25);

        jCheckBox27.setText("Nạm");
        jCheckBox27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox27ActionPerformed(evt);
            }
        });
        jPanel20.add(jCheckBox27);
        jCheckBox27.setBounds(413, 120, 55, 25);

        jc3.setText("Gân");
        jc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc3ActionPerformed(evt);
            }
        });
        jPanel20.add(jc3);
        jc3.setBounds(495, 120, 51, 25);

        jCheckBox29.setText("Gầu");
        jPanel20.add(jCheckBox29);
        jCheckBox29.setBounds(590, 120, 51, 25);

        jCheckBox30.setText("Bò vò viên");
        jPanel20.add(jCheckBox30);
        jCheckBox30.setBounds(676, 120, 87, 25);

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel91.setText("Loại món ăn phụ:");
        jPanel20.add(jLabel91);
        jLabel91.setBounds(12, 202, 120, 17);

        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn loại:", "Thức ăn", "Thức uống" }));
        jComboBox17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox17ActionPerformed(evt);
            }
        });
        jPanel20.add(jComboBox17);
        jComboBox17.setBounds(137, 200, 88, 22);

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel92.setText("Món ăn phụ:");
        jPanel20.add(jLabel92);
        jLabel92.setBounds(261, 202, 87, 17);

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel93.setText("Mã thực khách:");
        jPanel20.add(jLabel93);
        jLabel93.setBounds(23, 296, 106, 17);

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel96.setText("Giờ đặt");
        jPanel20.add(jLabel96);
        jLabel96.setBounds(330, 300, 49, 17);

        j5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j5ActionPerformed(evt);
            }
        });
        jPanel20.add(j5);
        j5.setBounds(390, 290, 123, 28);

        jTable6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thực khách", "Giờ đặt", "Loại tô", "Loại thịt", "Món ăn phụ", "Tổng tiền", "Mã tô"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable6);

        jPanel20.add(jScrollPane6);
        jScrollPane6.setBounds(10, 450, 1000, 170);

        jc1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn loại tô:", "Tô nhỏ", "Tô lớn", "Tô đặc biệt" }));
        jc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jc1ActionPerformed(evt);
            }
        });
        jPanel20.add(jc1);
        jc1.setBounds(90, 120, 140, 30);

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\order (1).png")); // NOI18N
        jButton1.setText("Đặt món");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton1);
        jButton1.setBounds(130, 390, 120, 40);

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\refresh (1).png")); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton2);
        jButton2.setBounds(340, 390, 110, 40);

        jtext3.setText("0đ");
        jtext3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtext3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtext3FocusLost(evt);
            }
        });
        jtext3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtext3ActionPerformed(evt);
            }
        });
        jPanel20.add(jtext3);
        jtext3.setBounds(790, 190, 140, 30);

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel85.setText("Tổng tiền:");
        jPanel20.add(jLabel85);
        jLabel85.setBounds(700, 200, 71, 17);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Đơn giá:");
        jPanel20.add(jLabel1);
        jLabel1.setBounds(790, 120, 70, 17);

        jtext1.setText("0đ");
        jtext1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtext1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtext1FocusLost(evt);
            }
        });
        jtext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtext1ActionPerformed(evt);
            }
        });
        jPanel20.add(jtext1);
        jtext1.setBounds(860, 110, 110, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Đơn giá:");
        jPanel20.add(jLabel2);
        jLabel2.setBounds(500, 200, 70, 20);

        jtext2.setText("0đ");
        jtext2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtext2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtext2FocusLost(evt);
            }
        });
        jtext2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtext2ActionPerformed(evt);
            }
        });
        jPanel20.add(jtext2);
        jtext2.setBounds(570, 200, 100, 30);

        jcb3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb3ActionPerformed(evt);
            }
        });
        jPanel20.add(jcb3);
        jcb3.setBounds(360, 200, 110, 30);

        jButton38.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\remove (1).png")); // NOI18N
        jButton38.setText("Xóa");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton38);
        jButton38.setBounds(550, 390, 100, 40);

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel84.setText("Mã tô:");
        jPanel20.add(jLabel84);
        jLabel84.setBounds(550, 300, 44, 17);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jPanel20.add(jComboBox5);
        jComboBox5.setBounds(600, 290, 70, 30);

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox13ActionPerformed(evt);
            }
        });
        jPanel20.add(jComboBox13);
        jComboBox13.setBounds(140, 290, 80, 30);

        jPanel19.add(jPanel20);
        jPanel20.setBounds(0, 0, 1210, 650);

        jt1.addTab("tab2", jPanel19);

        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Quản lý nhân viên");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(490, 13, 213, 29);

        jTable1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Điện thoại", "Ngày sinh", "Địa chỉ"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(0, 343, 1003, 316);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tìm kiếm:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(12, 278, 66, 17);

        jcb2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã nhân viên", "Tên nhân viên", "Điện thoại", "Ngày sinh", "Địa chỉ" }));
        jcb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb2ActionPerformed(evt);
            }
        });
        jPanel2.add(jcb2);
        jcb2.setBounds(83, 276, 108, 22);

        jl5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jl5.setText("Tất cả:");
        jPanel2.add(jl5);
        jl5.setBounds(393, 278, 47, 17);

        jte5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jte5ActionPerformed(evt);
            }
        });
        jPanel2.add(jte5);
        jte5.setBounds(445, 276, 118, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Ngày sinh:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(685, 242, 73, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Từ:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(628, 278, 24, 17);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Đến:");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(910, 280, 33, 17);

        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\add (1).png")); // NOI18N
        jButton3.setText("Thêm");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(119, 171, 99, 53);

        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\remove (1).png")); // NOI18N
        jButton4.setText("Xóa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(339, 178, 89, 39);

        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\wrench (1).png")); // NOI18N
        jButton5.setText("Sửa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(503, 173, 89, 49);

        jb6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\refresh (1).png")); // NOI18N
        jb6.setText("Làm mới");
        jb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb6ActionPerformed(evt);
            }
        });
        jPanel2.add(jb6);
        jb6.setBounds(657, 176, 115, 42);

        jButton26.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\excel (1).png")); // NOI18N
        jButton26.setText("Xuất Excel");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton26);
        jButton26.setBounds(846, 178, 125, 39);
        jPanel2.add(jte2);
        jte2.setBounds(660, 280, 100, 22);
        jPanel2.add(jte3);
        jte3.setBounds(960, 280, 100, 22);

        jt1.addTab("tab3", jPanel2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Quản lý thực khách");

        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\add (2).png")); // NOI18N
        jButton6.setText("Thêm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\remove (1).png")); // NOI18N
        jButton7.setText("Xóa");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\wrench (1).png")); // NOI18N
        jButton8.setText("Sửa");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\refresh (1).png")); // NOI18N
        jButton9.setText("Làm mới");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Tìm kiếm:");

        jcb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã thực khách", "Mã bàn", "Loại thực khách", "Giờ vào" }));
        jcb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb1ActionPerformed(evt);
            }
        });

        j8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        j8.setText("Tất cả:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thực khách", "Mã bàn", "Loại thực khách", "Giờ vào"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\payment-method (1).png")); // NOI18N
        jButton10.setText("Thanh toán");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Từ:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Đến:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jButton10))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(j8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtex1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel16))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                        .addGap(320, 320, 320)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtex2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(jLabel17))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jButton6)
                                .addGap(69, 69, 69)
                                .addComponent(jButton7)
                                .addGap(60, 60, 60)
                                .addComponent(jButton8)
                                .addGap(67, 67, 67)
                                .addComponent(jButton9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtex3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(492, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcb1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(j8)
                        .addComponent(jtex1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(jtex2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(jtex3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(306, Short.MAX_VALUE))
        );

        jt1.addTab("tab4", jPanel6);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setText("Quản lý loại món:");

        jButton11.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\add (2).png")); // NOI18N
        jButton11.setText("Thêm");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\wrench (1).png")); // NOI18N
        jButton12.setText("Sửa");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jb13.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\remove (1).png")); // NOI18N
        jb13.setText("Xóa");
        jb13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb13ActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\refresh (1).png")); // NOI18N
        jButton14.setText("Làm mới");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Tìm kiếm:");

        jcombobox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã loại", "Tên loại món" }));
        jcombobox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombobox1ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Tất cả:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã loại món", "Tên loại món"
            }
        ));
        jScrollPane5.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton28.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\excel (1).png")); // NOI18N
        jButton28.setText("Xuất Excel");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel18))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jButton11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jcombobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(jLabel20))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jButton12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jb13)
                                .addGap(106, 106, 106)
                                .addComponent(jButton14)
                                .addGap(51, 51, 51)
                                .addComponent(jButton28))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(453, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel18)
                .addGap(38, 38, 38)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb13)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11)
                    .addComponent(jButton14)
                    .addComponent(jButton28))
                .addGap(27, 27, 27)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jcombobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(330, Short.MAX_VALUE))
        );

        jt1.addTab("tab5", jPanel7);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setText("Quản lý tài khoản");

        jButton13.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\add (2).png")); // NOI18N
        jButton13.setText("Thêm");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\wrench (1).png")); // NOI18N
        jButton15.setText("Sửa");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\remove (1).png")); // NOI18N
        jButton16.setText("Xóa");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\refresh (1).png")); // NOI18N
        jButton17.setText("Làm mới");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Tìm kiếm:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã tài khoản", "Tên tài khoản", "Mật khẩu", "Mã nhân viên", "Mã quyền" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        j23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        j23.setText("Tất cả:");

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tài khoản", "Tên tài khoản", "Mật khẩu", "Mã nhân viên", "Mã quyền"
            }
        ));
        jScrollPane7.setViewportView(jTable7);

        jButton30.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\excel (1).png")); // NOI18N
        jButton30.setText("Xuất Excel");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jButton13)
                        .addGap(83, 83, 83)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jButton15)
                                .addGap(79, 79, 79)
                                .addComponent(jButton16)
                                .addGap(87, 87, 87)
                                .addComponent(jButton17)
                                .addGap(42, 42, 42)
                                .addComponent(jButton30))
                            .addComponent(jLabel21)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(j23)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(484, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel21)
                .addGap(35, 35, 35)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16)
                    .addComponent(jButton17)
                    .addComponent(jButton30))
                .addGap(41, 41, 41)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(j23)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(294, Short.MAX_VALUE))
        );

        jt1.addTab("tab6", jPanel8);

        jButton18.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\add (2).png")); // NOI18N
        jButton18.setText("Thêm");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\wrench (1).png")); // NOI18N
        jButton19.setText("Sửa");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\remove (1).png")); // NOI18N
        jButton20.setText("Xóa");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\refresh (1).png")); // NOI18N
        jButton21.setText("Làm mới");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã quyền", "Tên quyền", "Ghi chú"
            }
        ));
        jScrollPane8.setViewportView(jTable8);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Tìm kiếm:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Tất cả:");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã quyền", "Tên quyền", "Ghi chú", " " }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel30.setText("Quản lý quyền");

        jButton32.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\excel (1).png")); // NOI18N
        jButton32.setText("Xuất Excel");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jButton18)
                                .addGap(42, 42, 42))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jButton19)
                                .addGap(62, 62, 62)
                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jButton21)
                                .addGap(68, 68, 68)
                                .addComponent(jButton32))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jLabel30)))
                .addContainerGap(533, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel30)
                .addGap(31, 31, 31)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(jButton19)
                    .addComponent(jButton20)
                    .addComponent(jButton21)
                    .addComponent(jButton32))
                .addGap(42, 42, 42)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(444, Short.MAX_VALUE))
        );

        jt1.addTab("tab7", jPanel10);

        jButton22.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\add (2).png")); // NOI18N
        jButton22.setText("Thêm");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\wrench (1).png")); // NOI18N
        jButton23.setText("Sửa");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\remove (1).png")); // NOI18N
        jButton24.setText("Xóa");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\refresh (1).png")); // NOI18N
        jButton25.setText("Làm mới");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Tìm kiếm:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã món phụ", "Tên món phụ", "Mã loại món phụ", "Gía tiền" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Tất cả:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Gía từ:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Gía đến:");

        jTextField5.setText("0");
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.setText("0");
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã món phụ", "Tên món", "Mã loại món", "Gía tiền"
            }
        ));
        jScrollPane9.setViewportView(jTable9);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel29.setText("Quản lý món ăn");

        jButton34.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\excel (1).png")); // NOI18N
        jButton34.setText("Xuất Excel");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jButton22)
                                .addGap(51, 51, 51)
                                .addComponent(jButton23))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(2, 2, 2)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel26)))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel27)
                                .addGap(9, 9, 9)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel28))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jButton24)
                                .addGap(53, 53, 53)
                                .addComponent(jButton25)))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton34)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(580, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton23)
                    .addComponent(jButton22)
                    .addComponent(jButton24)
                    .addComponent(jButton25)
                    .addComponent(jButton34))
                .addGap(38, 38, 38)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jt1.addTab("tab8", jPanel11);

        jPanel21.setPreferredSize(new java.awt.Dimension(1800, 810));
        jPanel21.setVerifyInputWhenFocusTarget(false);
        jPanel21.setLayout(null);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel31.setText("Quản lý bàn ăn");
        jPanel21.add(jLabel31);
        jLabel31.setBounds(379, 23, 177, 29);

        javax.swing.GroupLayout jp22Layout = new javax.swing.GroupLayout(jp22);
        jp22.setLayout(jp22Layout);
        jp22Layout.setHorizontalGroup(
            jp22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        jp22Layout.setVerticalGroup(
            jp22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );

        jPanel21.add(jp22);
        jp22.setBounds(12, 114, 630, 630);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setText("Danh sách bàn ăn:");
        jPanel21.add(jLabel32);
        jLabel32.setBounds(12, 74, 148, 22);

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thực khách", "Loại thực khách", "Giờ vào", "Mã tô", "Loại tô", "Giờ đặt", "Tên món phụ"
            }
        ));
        jScrollPane10.setViewportView(jTable10);

        jPanel21.add(jScrollPane10);
        jScrollPane10.setBounds(650, 120, 690, 250);

        jButton37.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\add (2).png")); // NOI18N
        jButton37.setText("Thêm");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton37);
        jButton37.setBounds(130, 760, 110, 39);

        jButton39.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\remove (1).png")); // NOI18N
        jButton39.setText("Xóa");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton39);
        jButton39.setBounds(300, 760, 90, 40);

        jButton40.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\refresh (1).png")); // NOI18N
        jButton40.setText("Làm mới");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton40);
        jButton40.setBounds(450, 760, 120, 50);

        jt1.addTab("tab9", jPanel21);

        jPanel22.setLayout(null);

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel33.setText("Quản lý hóa đơn:");
        jPanel22.add(jLabel33);
        jLabel33.setBounds(340, 10, 202, 29);

        jButton41.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\excel (1).png")); // NOI18N
        jButton41.setText("Xuất Excel");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton41);
        jButton41.setBounds(120, 50, 125, 50);

        jButton43.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\pdf (1).png")); // NOI18N
        jButton43.setText("Xuất PDF");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton43);
        jButton43.setBounds(340, 50, 119, 50);

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Tìm kiếm:");
        jPanel22.add(jLabel34);
        jLabel34.setBounds(12, 133, 59, 17);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã hóa đơn", "Mã bàn", "Ngày xuất", "Mã thực khách", "Giờ xuất", "Mã nhân viên", "Tổng tiền" }));
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jPanel22.add(jComboBox4);
        jComboBox4.setBounds(76, 131, 110, 22);

        jLabel35.setText("Tất cả:");
        jPanel22.add(jLabel35);
        jLabel35.setBounds(210, 130, 70, 20);
        jPanel22.add(jTextField7);
        jTextField7.setBounds(290, 130, 78, 22);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("Ngày xuất:");
        jPanel22.add(jLabel36);
        jLabel36.setBounds(520, 110, 80, 17);
        jPanel22.add(jTextField8);
        jTextField8.setBounds(440, 130, 80, 22);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Đến:");
        jPanel22.add(jLabel37);
        jLabel37.setBounds(590, 130, 60, 20);
        jPanel22.add(jTextField9);
        jTextField9.setBounds(620, 130, 100, 30);

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Từ:");
        jPanel22.add(jLabel38);
        jLabel38.setBounds(410, 130, 48, 20);

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel69.setText("Tổng tiền:");
        jPanel22.add(jLabel69);
        jLabel69.setBounds(900, 110, 80, 20);

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel82.setText("Từ:");
        jPanel22.add(jLabel82);
        jLabel82.setBounds(790, 130, 30, 17);

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel83.setText("Đến:");
        jPanel22.add(jLabel83);
        jLabel83.setBounds(960, 130, 48, 17);

        jTextField10.setText("0");
        jPanel22.add(jTextField10);
        jTextField10.setBounds(820, 130, 70, 30);

        jTextField21.setText("0");
        jPanel22.add(jTextField21);
        jTextField21.setBounds(1000, 130, 90, 30);

        jButton44.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\refresh (1).png")); // NOI18N
        jButton44.setText("Làm mới");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton44);
        jButton44.setBounds(820, 50, 120, 50);

        jButton45.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\view (2).png")); // NOI18N
        jButton45.setText("Xem chi tiết");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton45);
        jButton45.setBounds(570, 50, 140, 50);

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Mã bàn", "Ngày xuất", "Mã thực khách", "Giờ xuất", "Mã nhân viên", "Tổng tiền"
            }
        ));
        jScrollPane11.setViewportView(jTable11);

        jPanel22.add(jScrollPane11);
        jScrollPane11.setBounds(0, 190, 920, 170);

        jt1.addTab("tab10", jPanel22);

        jPanel3.setLayout(null);

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel95.setText("Thống kê");
        jPanel3.add(jLabel95);
        jLabel95.setBounds(325, 37, 110, 29);

        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));

        jLabel97.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\employee (2).png")); // NOI18N

        jLabel98.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel98.setText("Nhân viên");

        jLabel99.setText("jLabel99");

        jLabel100.setText("jLabel100");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel99)
                .addGap(37, 37, 37))
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel97)
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel98)
                    .addComponent(jLabel100))
                .addGap(38, 38, 38))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel100))
                    .addComponent(jLabel97))
                .addGap(154, 154, 154)
                .addComponent(jLabel99)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));

        jLabel101.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\target (1).png")); // NOI18N

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel102.setText("Thực khách");

        jLabel103.setText("jLabel99");

        jLabel104.setText("jLabel100");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel103)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel102)
                            .addGroup(jPanel27Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel104)))
                        .addGap(83, 83, 83))))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel101))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel102, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel104)))
                .addGap(154, 154, 154)
                .addComponent(jLabel103)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));

        jLabel105.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\table (1).png")); // NOI18N

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel106.setText("Bàn lớn");

        jLabel107.setText("jLabel99");

        jLabel108.setText("jLabel100");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel107)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel106)
                            .addComponent(jLabel108))
                        .addGap(32, 32, 32))))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel108)
                        .addGap(16, 16, 16))
                    .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(154, 154, 154)
                .addComponent(jLabel107)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));

        jLabel109.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\manager (1).png")); // NOI18N

        jLabel110.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel110.setText("Quản lý");

        jLabel111.setText("jLabel99");

        jLabel112.setText("jLabel100");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel111)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel110))
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel112)))
                        .addGap(53, 53, 53))))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel109))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel112)))
                .addGap(154, 154, 154)
                .addComponent(jLabel111)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));

        jLabel115.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\table (1).png")); // NOI18N

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel116.setText("Bàn nhỏ");

        jLabel117.setText("jLabel99");

        jLabel118.setText("jLabel100");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jLabel117)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel116)
                            .addComponent(jLabel118))
                        .addGap(32, 32, 32))))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel118)
                        .addGap(16, 16, 16)))
                .addGap(154, 154, 154)
                .addComponent(jLabel117)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
                .addGap(252, 252, 252)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(165, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê tổng quát", jPanel24);

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Mã hóa đơn", "Ngày xuất", "Tổng tiền"
            }
        ));
        jScrollPane12.setViewportView(jTable12);

        jLabel113.setText("Tìm kiếm:");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã nhân viên", "Mã hóa đơn", "Ngày xuất", "Tổng tiền", " " }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });

        jLabel114.setText("Tất cả:");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel113)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jLabel114)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(388, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thống kê bán hàng của nhân viên", jPanel25);

        jPanel3.add(jTabbedPane1);
        jTabbedPane1.setBounds(50, 80, 800, 900);

        jt1.addTab("tab11", jPanel3);

        jp3.add(jt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, -40, 1390, 890));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jp3, javax.swing.GroupLayout.PREFERRED_SIZE, 2000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jp3, javax.swing.GroupLayout.PREFERRED_SIZE, 1800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card2");

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void dynamicclock()
{
    Timer t=new Timer();
    t.scheduleAtFixedRate(new TimerTask()
    {
        @Override
        public void run()
        {
            j5.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            
        }
    },0,1000);
                }

    private void jCheckBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox11ActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jCheckBox16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox16ActionPerformed

    private void jTextField20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField20ActionPerformed

    private void jp3ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jp3ComponentAdded

    }//GEN-LAST:event_jp3ComponentAdded

    private void jl1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl1MouseExited

    }//GEN-LAST:event_jl1MouseExited

    private void jl1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl1MouseEntered
        Color cor=new Color(0,102,102);
        jl1.setBackground(cor);
        jl1.setForeground(Color.WHITE);
    }//GEN-LAST:event_jl1MouseEntered

    private void jl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jl1MouseClicked
        if(x==180)
        {
            jPanel9.setSize(220,710);
            Thread t=new Thread(){
                @Override
                public void run()
                {
                    try
                    {
                        for(int i=220;i>=0;i--)
                        {
                            Thread.sleep(1);
                            jPanel9.setSize(i,710);
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainFrameForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            t.start();
            x=0;
        }
        else
        {
            if(x==0)
            {
                jPanel9.show();
                jPanel9.setSize(0,710);
                Thread t=new Thread()
                {
                    @Override
                    public void run()
                    {
                        try
                        {
                            for(int i=0;i<=220;i++)
                            {
                                Thread.sleep(1);
                                jPanel9.setSize(i,710);
                            }
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MainFrameForm.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                t.start();
                x=180;
            }
        }
    }//GEN-LAST:event_jl1MouseClicked

    private void jp1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp1MouseReleased
        Color cor=new Color(0,102,102);
        jp1.setBackground(cor);
        j1.setForeground(Color.white);
    }//GEN-LAST:event_jp1MouseReleased

    private void jp1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp1MousePressed
        Color cor=new Color(0,51,51);
        jp1.setBackground(cor);
        j1.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp1MousePressed

    private void jp1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp1MouseExited
        Color cor=new Color(0,153,102);
        jp1.setBackground(cor);
        j1.setForeground(Color.BLACK);
    }//GEN-LAST:event_jp1MouseExited

    private void jp1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp1MouseEntered
        Color cor=new Color(0,102,102);
        jp1.setBackground(cor);
        j1.setForeground(Color.white);
    }//GEN-LAST:event_jp1MouseEntered

    private void jp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp1MouseClicked
        jt1.setSelectedIndex(0);
        this.setSize(840,570);
    }//GEN-LAST:event_jp1MouseClicked

    private void jp2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp2MouseReleased
        Color cor=new Color(0,102,102);
        jp2.setBackground(cor);
        j2.setForeground(Color.white);
    }//GEN-LAST:event_jp2MouseReleased

    private void jp2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp2MousePressed
        Color cor=new Color(0,51,51);
        jp2.setBackground(cor);
        j2.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp2MousePressed

    private void jp2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp2MouseExited
        Color cor=new Color(0,153,102);
        jp2.setBackground(cor);
        j2.setForeground(Color.BLACK);
    }//GEN-LAST:event_jp2MouseExited

    private void jp2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp2MouseEntered
        Color cor=new Color(0,102,102);
        jp2.setBackground(cor);
        j2.setForeground(Color.white);
    }//GEN-LAST:event_jp2MouseEntered

    private void jp2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp2MouseClicked
       if(maquyen==2||maquyen==3)
       {
        jt1.setSelectedIndex(2);
       this.setSize(1250,820);
       }
       else
       {
           JOptionPane.showMessageDialog(this,"Chỉ có quản lý và admin có thể sử dụng chức năng này.");
       }
    }//GEN-LAST:event_jp2MouseClicked
public void giatien()
{
    String mp=jcb3.getSelectedItem().toString();
        int t=0;
        switch (mp) {
            case "Quẩy":
            case "Hột gà":
                t=5000;
                break;
            case "Bánh phở thêm":
            case "Tiết":
                t=10000;
                break;
            case "Tiết hột gà":
                t=15000;
                break;
            case "Coca":
            case "Xá xị":
            case "7 up":
            case "Lipton":
                t= 11000;
                break;
            default:
               t=0;
                break;
        }
        jtext2.setText(Integer.toString(t)+"đ");
}public void giatien1()
{
       String mp=jc1.getSelectedItem().toString();
        int t=0;
        switch (mp) {
            case "Tô nhỏ":
            
                t=45000;
                break;
            case "Tô lớn":
                t=60000;
                break;
            case "Tô đặc biệt":
                t=75000;
                break;
          
            default:
                break;
        }
        jtext1.setText(Integer.toString(t)+"đ");
}
public void tongtien()
{
            String t1=jtext1.getText();
        String t2=jtext2.getText();
        int len=t1.length();
        int len1=t2.length();
        t1=t1.replace("đ","");
        t2=t2.replace("đ","");
        int t3=Integer.parseInt(t1)+Integer.parseInt(t2);
        jtext3.setText(Integer.toString(t3)+"đ");
}
    private void jp4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp4MouseClicked
       jt1.setSelectedIndex(1);
       this.setSize(1220,820);
    }//GEN-LAST:event_jp4MouseClicked

    private void jp4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp4MouseEntered
       Color cor=new Color(0,102,102);
        jp4.setBackground(cor);
        j3.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp4MouseEntered

    private void jp4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp4MouseExited
            Color cor=new Color(0,153,102);
        jp4.setBackground(cor);
        j3.setForeground(Color.BLACK);
    }//GEN-LAST:event_jp4MouseExited

    private void jp4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp4MousePressed
        Color cor=new Color(0,51,51);
        jp4.setBackground(cor);
        j3.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp4MousePressed

    private void jp4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp4MouseReleased
            Color cor=new Color(0,102,102);
        jp4.setBackground(cor);
        j3.setForeground(Color.white);
    }//GEN-LAST:event_jp4MouseReleased

   public void textonchange()
   {
       LocalDate ngay1=null;
       LocalDate ngay2=null;
       try
       {
           ngay1=LocalDate.parse(jte2.getText());
       }
       catch(DateTimeParseException e)
       {
           jte2.setForeground(Color.red);
       }
       try
       {
           ngay2=LocalDate.parse(jte3.getText());
       }
       catch(DateTimeParseException e)
       {
           jte3.setForeground(Color.red);
       }
       String type=jcb2.getSelectedItem().toString();
       String value=jte5.getText();
      ArrayList<nhanvien> t1=qlnv.search(type, value, ngay1, ngay2);
      addtable(t1,jTable1);
   }
   public void textonchange1()
   {
       LocalTime gio1=null;
       LocalTime gio2=null;
       try
       {
           gio1=LocalTime.parse(jtex2.getText());
       }
       catch(DateTimeParseException e)
       {
           jtex2.setForeground(Color.red);
       }
       try
       {
           gio2=LocalTime.parse(jtex3.getText());
       }
       catch(DateTimeParseException e)
       {
           jtex3.setForeground(Color.red);
       }
       String type=jcb1.getSelectedItem().toString();
       String value=jtex1.getText();
       ArrayList<thuckhach> t=qltk.search(type, value, gio1, gio2);
      addtable1(t,jTable2);
   }
   public void textonchange2()
   {
       String type=jcombobox1.getSelectedItem().toString();
       String value=jTextField1.getText();
       ArrayList<loaimonphu> t=qllmp.search(type, value);
       addtable2(t);
   }
   public void addDocumentListener(JTextField textfield,JTextField t1,JTextField t2)
   {
       textfield.getDocument().addDocumentListener(new DocumentListener(){
           @Override
           public void insertUpdate(DocumentEvent de) {
               textonchange();
           }

           @Override
           public void removeUpdate(DocumentEvent de) {
             textonchange();
           }

           @Override
           public void changedUpdate(DocumentEvent de) {
              textonchange();
           }
           
       });
       t1.getDocument().addDocumentListener(new DocumentListener(){
           @Override
           public void insertUpdate(DocumentEvent de) {
               textonchange();
           }

           @Override
           public void removeUpdate(DocumentEvent de) {
             textonchange();
           }

           @Override
           public void changedUpdate(DocumentEvent de) {
              textonchange();
           }
           
       });
       t2.getDocument().addDocumentListener(new DocumentListener(){
           @Override
           public void insertUpdate(DocumentEvent de) {
               textonchange();
           }

           @Override
           public void removeUpdate(DocumentEvent de) {
             textonchange();
           }

           @Override
           public void changedUpdate(DocumentEvent de) {
              textonchange();
           }
           
       });
       
       
   }
      public void addDocumentListener1()
   {
       jtex1.getDocument().addDocumentListener(new DocumentListener(){
           @Override
           public void insertUpdate(DocumentEvent de) {
               textonchange1();
           }

           @Override
           public void removeUpdate(DocumentEvent de) {
             textonchange1();
           }

           @Override
           public void changedUpdate(DocumentEvent de) {
              textonchange1();
           }
           
       });
        jtex2.getDocument().addDocumentListener(new DocumentListener(){
           @Override
           public void insertUpdate(DocumentEvent de) {
               textonchange1();
           }

           @Override
           public void removeUpdate(DocumentEvent de) {
             textonchange1();
           }

           @Override
           public void changedUpdate(DocumentEvent de) {
              textonchange1();
           }
           
       });
         jtex3.getDocument().addDocumentListener(new DocumentListener(){
           @Override
           public void insertUpdate(DocumentEvent de) {
               textonchange1();
           }

           @Override
           public void removeUpdate(DocumentEvent de) {
             textonchange1();
           }

           @Override
           public void changedUpdate(DocumentEvent de) {
              textonchange1();
           }
           
       });
   
   }
   public void addDocumentListener2()
   {
       jTextField1.getDocument().addDocumentListener(new DocumentListener(){
           @Override
           public void insertUpdate(DocumentEvent de) {
               textonchange2();
           }

           @Override
           public void removeUpdate(DocumentEvent de) {
             textonchange2();
           }

           @Override
           public void changedUpdate(DocumentEvent de) {
              textonchange2();
           }
           
       });
   }
     public void addDocumentListener3()
   {
       jTextField2.getDocument().addDocumentListener(new DocumentListener(){
           @Override
           public void insertUpdate(DocumentEvent de) {
               textonchange3();
           }

           @Override
           public void removeUpdate(DocumentEvent de) {
             textonchange3();
           }

           @Override
           public void changedUpdate(DocumentEvent de) {
              textonchange3();
           }
           
       });
   }
     public void addDocumentListener4()
     {
          jTextField4.getDocument().addDocumentListener(new DocumentListener(){
           @Override
           public void insertUpdate(DocumentEvent de) {
               textonchange4();
           }

           @Override
           public void removeUpdate(DocumentEvent de) {
             textonchange4();
           }

           @Override
           public void changedUpdate(DocumentEvent de) {
              textonchange4();
           }
           
       });
     }
     public void addDocumentListener5()
     {
            jTextField3.getDocument().addDocumentListener(new DocumentListener(){
           @Override
           public void insertUpdate(DocumentEvent de) {
               textonchange5();
           }

           @Override
           public void removeUpdate(DocumentEvent de) {
             textonchange5();
           }

           @Override
           public void changedUpdate(DocumentEvent de) {
              textonchange5();
           }
           
       });
            jTextField5.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent de)
            {
                textonchange5();
            }
            @Override
            public void removeUpdate(DocumentEvent de)
            {
                textonchange5();
            }
            @Override
            public void changedUpdate(DocumentEvent de)
            {
                textonchange5();
            }
            });
            jTextField6.getDocument().addDocumentListener(new DocumentListener(){
             @Override
             public void insertUpdate(DocumentEvent de)
             {
                 textonchange5();
             }
             @Override
             public void removeUpdate(DocumentEvent de)
             {
                 textonchange5();
             }
             @Override
             public void changedUpdate(DocumentEvent de)
             {
                 textonchange5();
             }
            });
     }
     public void addDocumentListener6()
     {
         jTextField7.getDocument().addDocumentListener(new DocumentListener(){
          @Override
          public void insertUpdate(DocumentEvent de)
          {
              textonchange6();
          }
          @Override
          public void removeUpdate(DocumentEvent de)
          {
              textonchange6();
          }
          @Override
          public void changedUpdate(DocumentEvent de)
          {
              textonchange6();
          }
          
         });
           jTextField8.getDocument().addDocumentListener(new DocumentListener(){
          @Override
          public void insertUpdate(DocumentEvent de)
          {
              textonchange6();
          }
          @Override
          public void removeUpdate(DocumentEvent de)
          {
              textonchange6();
          }
          @Override
          public void changedUpdate(DocumentEvent de)
          {
              textonchange6();
          }
          
         });
             jTextField9.getDocument().addDocumentListener(new DocumentListener(){
          @Override
          public void insertUpdate(DocumentEvent de)
          {
              textonchange6();
          }
          @Override
          public void removeUpdate(DocumentEvent de)
          {
              textonchange6();
          }
          @Override
          public void changedUpdate(DocumentEvent de)
          {
              textonchange6();
          }
          
         });
               jTextField10.getDocument().addDocumentListener(new DocumentListener(){
          @Override
          public void insertUpdate(DocumentEvent de)
          {
              textonchange6();
          }
          @Override
          public void removeUpdate(DocumentEvent de)
          {
              textonchange6();
          }
          @Override
          public void changedUpdate(DocumentEvent de)
          {
              textonchange6();
          }
          
         });
                 jTextField21.getDocument().addDocumentListener(new DocumentListener(){
          @Override
          public void insertUpdate(DocumentEvent de)
          {
              textonchange6();
          }
          @Override
          public void removeUpdate(DocumentEvent de)
          {
              textonchange6();
          }
          @Override
          public void changedUpdate(DocumentEvent de)
          {
              textonchange6();
          }
          
         });
         
     }
     public void textonchange5()
     {   int giatu=0;
          int giaden=0;
         
          giatu=Integer.parseInt(jTextField5.getText());
         
       
          giaden=Integer.parseInt(jTextField6.getText());
        
        
         
                  String type=jComboBox3.getSelectedItem().toString();
         String value=jTextField3.getText();
         ArrayList<monphu> t=qlmp.search(type, value, giatu, giaden);
         addtable5(t);
     }
     
      public void textonchange3()
   {
       String type=jComboBox1.getSelectedItem().toString();
       String value=jTextField2.getText();
       ArrayList<taikhoan> t=qltk1.search(type, value);
       addtable3(t);
   }
      public void textonchange4()
      {
          String type=jComboBox2.getSelectedItem().toString();
          String value=jTextField4.getText();
          ArrayList<phanquyen> t=qlpq.search(type, value);
          addtable4(t);
      }
   public void textonchange6()
   {
       LocalDate ngaytu=null;
       LocalDate ngayden=null;
       int giatu=0;
       int giaden=0;
       try
       {
           ngaytu=LocalDate.parse(jTextField8.getText());
           ngayden=LocalDate.parse(jTextField9.getText());
       }
       catch(DateTimeParseException e)
       {
           jTextField8.setForeground(Color.red);
           jTextField9.setForeground(Color.red);
       }
       giatu=Integer.parseInt(jTextField10.getText());
       giaden=Integer.parseInt(jTextField21.getText());
      String type=jComboBox4.getSelectedItem().toString();
      String value=jTextField7.getText();
      ArrayList<hoadon> t=qlhd.search(type, value, giatu, giaden, ngaytu, ngayden);
      addtable6(t);
   }
    public void addDocumentListener7()
     {
         jTextField22.getDocument().addDocumentListener(new DocumentListener(){
          @Override
          public void insertUpdate(DocumentEvent de)
          {
              textonchange7();
          }
          @Override
          public void removeUpdate(DocumentEvent de)
          {
              textonchange7();
          }
          @Override
          public void changedUpdate(DocumentEvent de)
          {
              textonchange7();
          }
          
         });
          
         
     }
      public void textonchange7()
   {
       LocalDate ngaytu=null;
       LocalDate ngayden=null;
       int giatu=0;
       int giaden=0;
       try
       {
           ngaytu=LocalDate.parse(jTextField8.getText());
           ngayden=LocalDate.parse(jTextField9.getText());
       }
       catch(DateTimeParseException e)
       {
           jTextField8.setForeground(Color.red);
           jTextField9.setForeground(Color.red);
       }
       giatu=Integer.parseInt(jTextField10.getText());
       giaden=Integer.parseInt(jTextField21.getText());
      String type=jComboBox6.getSelectedItem().toString();
      String value=jTextField22.getText();
      ArrayList<hoadon> t=qlhd.search(type, value, giatu, giaden, ngaytu, ngayden);
     
   }
    public ArrayList<String> searchtable7(String type,String value)
    {      DefaultTableModel t=(DefaultTableModel) jTable12.getModel();
             int len=t.getRowCount();
             
            ArrayList<String> res=new ArrayList<String>();
       for(int i=0;i<len;i++)
       {
           String manhanvien=jTable12.getModel().getValueAt(i,0).toString();
           String tennhanvien=jTable12.getModel().getValueAt(i,1).toString();
           String idhoadon=jTable12.getModel().getValueAt(i,2).toString();
           String ngayxuat=jTable12.getModel().getValueAt(i,3).toString();
           String tongtien=jTable12.getModel().getValueAt(i,4).toString();
           if(type=="Tất cả")
           {
               if(manhanvien.toLowerCase().contains(value.toLowerCase())||tennhanvien.toLowerCase().contains(value.toLowerCase())||idhoadon.toLowerCase().contains(value.toLowerCase())||tongtien.toLowerCase().contains(value.toLowerCase())||ngayxuat.toLowerCase().contains(value.toLowerCase()))
               {
                 res.add(manhanvien);
                   res.add(tennhanvien);
                     res.add(idhoadon);
                       res.add(ngayxuat);
                         res.add(tongtien);
               }
           }
           else{
               if(type=="Mã nhân viên")
               {
                   if(manhanvien.toLowerCase().equals(value.toLowerCase()))
                   {
                        res.add(manhanvien);
                   res.add(tennhanvien);
                     res.add(idhoadon);
                       res.add(ngayxuat);
                         res.add(tongtien);
                   }
               }
               if(type=="Tên nhân viên")
               {
                   if(tennhanvien.toLowerCase().equals(value.toLowerCase()))
                   {
                        res.add(manhanvien);
                   res.add(tennhanvien);
                     res.add(idhoadon);
                       res.add(ngayxuat);
                         res.add(tongtien);
                   }
               }
               if(type=="Mã hóa đơn")
               {
                   if(idhoadon.toLowerCase().equals(value.toLowerCase()))
                   {
                        res.add(manhanvien);
                   res.add(tennhanvien);
                     res.add(idhoadon);
                       res.add(ngayxuat);
                         res.add(tongtien);
                   }
               }
               if(type=="Ngày xuất")
               {
                   if(ngayxuat.toLowerCase().equals(value.toLowerCase()))
                   {
                        res.add(manhanvien);
                   res.add(tennhanvien);
                     res.add(idhoadon);
                       res.add(ngayxuat);
                         res.add(tongtien);
                   }
               }
               if(type=="Tổng tiền")
               {
                   if(tongtien.toLowerCase().equals(value.toLowerCase()))
                   {
                        res.add(manhanvien);
                   res.add(tennhanvien);
                     res.add(idhoadon);
                       res.add(ngayxuat);
                         res.add(tongtien);
                   }
               }
           }
       }
       return res;
    }
    public void textonchange8() throws SQLException
    {
       LocalDate ngaytu=null;
       LocalDate ngayden=null;
       int giatu=0;
       int giaden=0;
       try
       {
           ngaytu=LocalDate.parse(jTextField8.getText());
           ngayden=LocalDate.parse(jTextField9.getText());
       }
       catch(DateTimeParseException e)
       {
           jTextField8.setForeground(Color.red);
           jTextField9.setForeground(Color.red);
       }
       giatu=Integer.parseInt(jTextField10.getText());
       giaden=Integer.parseInt(jTextField21.getText());
      String type=jComboBox6.getSelectedItem().toString();
      String value=jTextField22.getText();
      ArrayList<hoadon> t=qlhd.search(type, value, giatu, giaden, ngaytu, ngayden);
      addtable7(t);
    }
      public void addDocumentListener8()
     {
         jTextField22.getDocument().addDocumentListener(new DocumentListener(){
          @Override
          public void insertUpdate(DocumentEvent de)
          {
              try {
                  textonchange8();
              } catch (SQLException ex) {
                  Logger.getLogger(MainFrameForm.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          @Override
          public void removeUpdate(DocumentEvent de)
          {
              try {
                  textonchange8();
              } catch (SQLException ex) {
                  Logger.getLogger(MainFrameForm.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          @Override
          public void changedUpdate(DocumentEvent de)
          {
              try {
                  textonchange8();
              } catch (SQLException ex) {
                  Logger.getLogger(MainFrameForm.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
          
         });
          
         
     }
    private void jp5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp5MouseClicked
        jt1.setSelectedIndex(3);
        this.setSize(1220,820);
    }//GEN-LAST:event_jp5MouseClicked

    private void jp5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp5MouseEntered
               Color cor=new Color(0,102,102);
        jp5.setBackground(cor);
        j4.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp5MouseEntered

    private void jp5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp5MouseExited
          Color cor=new Color(0,153,102);
        jp5.setBackground(cor);
        j4.setForeground(Color.BLACK);
    }//GEN-LAST:event_jp5MouseExited

    private void jp5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp5MousePressed
              Color cor=new Color(0,51,51);
        jp5.setBackground(cor);
        j4.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp5MousePressed

    private void jp5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp5MouseReleased
        Color cor=new Color(0,102,102);
        jp5.setBackground(cor);
        j4.setForeground(Color.white);
    }//GEN-LAST:event_jp5MouseReleased

    private void jp6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp6MouseClicked
          jt1.setSelectedIndex(8);
          this.setSize(1650,1100);
    }//GEN-LAST:event_jp6MouseClicked

    private void jp6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp6MouseEntered
      Color cor=new Color(0,102,102);
        jp6.setBackground(cor);
        j6.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp6MouseEntered

    private void jp6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp6MouseExited
           Color cor=new Color(0,153,102);
        jp6.setBackground(cor);
        j6.setForeground(Color.BLACK);
    }//GEN-LAST:event_jp6MouseExited

    private void jp6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp6MousePressed
           Color cor=new Color(0,51,51);
        jp6.setBackground(cor);
        j6.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp6MousePressed

    private void jp6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp6MouseReleased
       Color cor=new Color(0,102,102);
        jp6.setBackground(cor);
        j6.setForeground(Color.white);
    }//GEN-LAST:event_jp6MouseReleased

    private void jp7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp7MouseClicked
      if(maquyen==2||maquyen==3)
      {
       jt1.setSelectedIndex(9);
      this.setSize(1450,820);
      }
      else
      {
          JOptionPane.showMessageDialog(this,"Chỉ có quản lý và admin có thể sử dụng chức năng này.");
      }
    }//GEN-LAST:event_jp7MouseClicked

    private void jp7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp7MouseEntered
         Color cor=new Color(0,102,102);
        jp7.setBackground(cor);
        j7.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp7MouseEntered

    private void jp7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp7MouseExited
        Color cor=new Color(0,153,102);
        jp7.setBackground(cor);
        j7.setForeground(Color.BLACK);
    }//GEN-LAST:event_jp7MouseExited

    private void jp7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp7MousePressed
           Color cor=new Color(0,51,51);
        jp7.setBackground(cor);
        j7.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp7MousePressed

    private void jp7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp7MouseReleased
          Color cor=new Color(0,102,102);
        jp7.setBackground(cor);
        j7.setForeground(Color.white);
    }//GEN-LAST:event_jp7MouseReleased

    private void jp8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp8MouseClicked
      if(maquyen==2||maquyen==3)
      {
        jt1.setSelectedIndex(4);
       this.setSize(1400,820);
      }
      else
      {
          JOptionPane.showMessageDialog(this,"Chỉ có quản lý và admin sử dụng được.");
      }
    }//GEN-LAST:event_jp8MouseClicked

    private void jp8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp8MouseEntered
        Color cor=new Color(0,102,102);
        jp8.setBackground(cor);
        j9.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp8MouseEntered

    private void jp8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp8MouseExited
         Color cor=new Color(0,153,102);
        jp8.setBackground(cor);
        j9.setForeground(Color.BLACK);
    }//GEN-LAST:event_jp8MouseExited

    private void jp8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp8MousePressed
       Color cor=new Color(0,51,51);
        jp8.setBackground(cor);
        j9.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp8MousePressed

    private void jp8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp8MouseReleased
    Color cor=new Color(0,102,102);
        jp8.setBackground(cor);
        j9.setForeground(Color.white);
    }//GEN-LAST:event_jp8MouseReleased

    private void jp9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp9MouseClicked
        if(maquyen==2)
        {
        jt1.setSelectedIndex(5);
        this.setSize(1400,820);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Chỉ có admin mới được sử dụng.");
        }
    }//GEN-LAST:event_jp9MouseClicked

    private void jp9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp9MouseEntered
           Color cor=new Color(0,102,102);
        jp9.setBackground(cor);
        j10.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp9MouseEntered

    private void jp9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp9MouseExited
           Color cor=new Color(0,153,102);
        jp9.setBackground(cor);
        j10.setForeground(Color.BLACK);
    }//GEN-LAST:event_jp9MouseExited

    private void jp9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp9MousePressed
           Color cor=new Color(0,51,51);
        jp9.setBackground(cor);
        j10.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp9MousePressed

    private void jp9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp9MouseReleased
       Color cor=new Color(0,102,102);
        jp9.setBackground(cor);
        j10.setForeground(Color.white);
    }//GEN-LAST:event_jp9MouseReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jcombobox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombobox1ActionPerformed
        String t=jcombobox1.getSelectedItem().toString();
        jLabel20.setText(t);
        addDocumentListener2();
    }//GEN-LAST:event_jcombobox1ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        qllmp.readlmp();
        jcombobox1.setSelectedIndex(0);
        jTextField1.setText("");
        addtable2(qllmp.getlma());
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jb13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb13ActionPerformed
       if(maquyen==2)
       {
        DefaultTableModel t=(DefaultTableModel)jTable5.getModel();
        int row=jTable5.getSelectedRow();
        int rowc=jTable5.getSelectedRowCount();
        if(rowc==0)
        {
            JOptionPane.showMessageDialog(this,"Không có hàng nào được chọn.");
        }
        else
        {
            int idlmp=Integer.parseInt(jTable5.getModel().getValueAt(row,0).toString());
            int input=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa loại món ăn này không?","Xóa loại món ăn",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(input==0)
            {
                qllmp.del(idlmp);
                t.removeRow(row);
                JOptionPane.showMessageDialog(this, "Đã xóa thành công.");
            }
        }
       }
       else
       {
           JOptionPane.showMessageDialog(this,"Chỉ có admin có thể xóa.");
       }
    }//GEN-LAST:event_jb13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       if(maquyen==2)
       {
        DefaultTableModel t=(DefaultTableModel)jTable5.getModel();
        int rowc=jTable5.getSelectedRowCount();
        int row=jTable5.getSelectedRow();
        if(rowc==0)
        {
            JOptionPane.showMessageDialog(this,"Không có hàng nào được chọn.");
        }
        else
        {
            int id=Integer.parseInt(jTable5.getModel().getValueAt(row,0).toString());
            String tenloai=jTable5.getModel().getValueAt(row,1).toString();
            new sualoaimonphu(id,tenloai).setVisible(true);
        }
       }
       else
       {
           JOptionPane.showMessageDialog(this,"Chỉ có admin có thể sửa.");
       }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(maquyen==2)
        {
        new themloaimonphu().setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Chỉ có admin có thể thêm.");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jcb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb1ActionPerformed
        String t=jcb1.getSelectedItem().toString();
        j8.setText(t);
        addDocumentListener1();
    }//GEN-LAST:event_jcb1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        qltk.readtk();
        jcb1.setSelectedIndex(0);
        jtex1.setText("");
        jtex2.setText("");
        jtex3.setText("");
        addtable1(qltk.getdstk(),jTable2);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        DefaultTableModel t=(DefaultTableModel)jTable2.getModel();
        int row=jTable2.getSelectedRow();
        int rowc=jTable2.getSelectedRowCount();
        if(rowc==0)
        {
            JOptionPane.showMessageDialog(this,"Không có thực khách nào được chọn.");
        }
        else
        {
            String idthuckhach=jTable2.getModel().getValueAt(row,0).toString();
            int maban=Integer.parseInt(jTable2.getModel().getValueAt(row,1).toString());
            String loaithuckhach=jTable2.getModel().getValueAt(row,2).toString();
            LocalTime giovao=LocalTime.parse(jTable2.getModel().getValueAt(row,3).toString());
            new suathuckhach(idthuckhach,maban,loaithuckhach,giovao).setVisible(true);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        DefaultTableModel t=(DefaultTableModel)jTable2.getModel();
        int row=jTable2.getSelectedRow();
        int rowc=jTable2.getSelectedRowCount();
        if(rowc==0)
        {
            JOptionPane.showMessageDialog(this,"Không có hàng nào được chọn.");
        }
        else
        {
            String idtk=jTable2.getModel().getValueAt(row,0).toString();
            int input=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa thực khách này không?","Xóa thực khách",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(input==0)
            {
                qltk.del(idtk);
                t.removeRow(row);
                JOptionPane.showMessageDialog(this, "Đã xóa thành công.");
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new themthuckhach().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jb6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb6ActionPerformed
        qlnv.readdb();
        jcb2.setSelectedIndex(0);
        jte5.setText("");
        jte2.setText("");
        jte3.setText("");
        addtable(qlnv.getdsnv(),jTable1);
    }//GEN-LAST:event_jb6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        DefaultTableModel t=(DefaultTableModel)jTable1.getModel();
        int row=jTable1.getSelectedRow();
        int rowc=jTable1.getSelectedRowCount();
        if(rowc==0)
        {
            JOptionPane.showMessageDialog(this,"Không có nhân viên nào được chọn.");
        }
        else{
            String idnhanvien=jTable1.getModel().getValueAt(row, 0).toString();
            String tennhanvien=jTable1.getModel().getValueAt(row, 1).toString();
            String dienthoai=jTable1.getModel().getValueAt(row, 2).toString();
            LocalDate ngaysinh=LocalDate.parse(jTable1.getModel().getValueAt(row, 3).toString());
            String diachi=jTable1.getModel().getValueAt(row, 4).toString();
            new suanhanvien(idnhanvien,tennhanvien,ngaysinh,dienthoai,diachi).setVisible(true);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DefaultTableModel t1=(DefaultTableModel)jTable1.getModel();
        int row=jTable1.getSelectedRow();
        int rowc=jTable1.getSelectedRowCount();

        if(rowc==0)
        {
            JOptionPane.showMessageDialog(this,"Không có hàng nào được chọn.");
        }
        String idnhanvien=jTable1.getModel().getValueAt(row,0).toString();
        int input=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa nhân viên này không?","Xóa nhân viên",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(rowc!=0)
        {
            if(input==0)
            {
                qlnv.delete(idnhanvien);
                JOptionPane.showMessageDialog(this,"Đã xóa nhân viên này khỏi cơ sở dữ liệu.");
                t1.removeRow(row);
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new themnhanvien().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jte5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jte5ActionPerformed

    }//GEN-LAST:event_jte5ActionPerformed

    private void jcb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb2ActionPerformed
        String text=jcb2.getSelectedItem().toString();
        jl5.setText(text+":");
        addDocumentListener(jte5,jte2,jte3);
    }//GEN-LAST:event_jcb2ActionPerformed

    private void jcb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb3ActionPerformed
        if ( !(jcb3.getSelectedIndex()==-1))
        {
            giatien();
            tongtien();
        }
    }//GEN-LAST:event_jcb3ActionPerformed

    private void jtext2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtext2ActionPerformed

    }//GEN-LAST:event_jtext2ActionPerformed

    private void jtext2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtext2FocusLost
        String mp=jcb3.getSelectedItem().toString();
        int t=0;
        switch (mp) {
            case "Quẩy":
            case "Hột gà":
            t=5000;
            break;
            case "Bánh phở thêm":
            case "Tiết":
            t=10000;
            break;
            case "Tiết hột gà":
            t=15000;
            break;
            case "Coca":
            case "Xá xị":
            case "7 up":
            case "Lipton":
            t= 11000;
            break;
            default:
            break;
        }
        jtext2.setText(Integer.toString(t)+"đ");
    }//GEN-LAST:event_jtext2FocusLost

    private void jtext2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtext2FocusGained
        String mp=jcb3.getSelectedItem().toString();
        int t=0;
        switch (mp) {
            case "Quẩy":
            case "Hột gà":
            t=5000;
            break;
            case "Bánh phở thêm":
            case "Tiết":
            t=10000;
            break;
            case "Tiết hột gà":
            t= 15000;
            break;
            case "Coca":
            case "Xá xị":
            case "7 up":
            case "Lipton":
            t=11000;
            break;
            default:
            break;
        }
    }//GEN-LAST:event_jtext2FocusGained

    private void jtext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtext1ActionPerformed

    }//GEN-LAST:event_jtext1ActionPerformed

    private void jtext1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtext1FocusLost
        String mp=jc1.getSelectedItem().toString();
        int t=0;
        switch (mp) {
            case "Tô nhỏ":

            t=45000;
            break;
            case "Tô lớn":
            t=60000;
            break;
            case "Tô đặc biệt":
            t=75000;
            break;

            default:
            break;
        }
        jtext1.setText(Integer.toString(t)+"đ");
    }//GEN-LAST:event_jtext1FocusLost

    private void jtext1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtext1FocusGained
        String mp=jc1.getSelectedItem().toString();
        int t=0;
        switch (mp) {
            case "Tô nhỏ":

            t=45000;
            break;
            case "Tô lớn":
            t=60000;
            break;
            case "Tô đặc biệt":
            t=75000;
            break;

            default:
            break;
        }
        jtext1.setText(Integer.toString(t)+"đ");
    }//GEN-LAST:event_jtext1FocusGained

    private void jtext3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtext3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtext3ActionPerformed

    private void jtext3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtext3FocusLost
        String t1=jtext1.getText();
        String t2=jtext2.getText();
        int len=t1.length();
        int len1=t2.length();
        while(t1.contains("đ"))
        {
            t1=t1.replace("đ","");
        }
        while(t2.contains("đ"))
        {
            t2=t2.replace("đ","");
        }
        int t3=Integer.parseInt(t1)+Integer.parseInt(t2);
        jtext3.setText(Integer.toString(t3)+"đ");
    }//GEN-LAST:event_jtext3FocusLost

    private void jtext3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtext3FocusGained
        String t1=jtext1.getText();
        String t2=jtext2.getText();
        int len=t1.length();
        int len1=t2.length();
        t1=t1.replace("đ","");
        t2=t2.replace("đ","");
        int t3=Integer.parseInt(t1)+Integer.parseInt(t2);
        jtext3.setText(Integer.toString(t3)+"đ");
    }//GEN-LAST:event_jtext3FocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jc1.setSelectedIndex(0);
        JCheckBox r1=jch1;
        JCheckBox r2=jch2;
        JCheckBox r3=jch3;
        JCheckBox r4=jch4;
        JCheckBox r5=jch5;
        JCheckBox[] a={r1,r2,r3,r4,r5};
        for(int i=0;i<5;i++)
        {
            if(!a[i].isEnabled())
            {
                a[i].setEnabled(true);
            }
        }
        jch1.setSelected(false);
        jch2.setSelected(false);
        jch3.setSelected(false);
        jch4.setSelected(false);
        jch5.setSelected(false);
        jc2.setSelectedIndex(0);
        jtext2.setText("0đ");
        jtext3.setText("0đ");
        jComboBox13.setSelectedIndex(0);
        
        jComboBox5.setSelectedIndex(0);
        qlt.readdb();
        qltk.readtk();
        addmathuckhach(qltk.getdstk());
        addmato(qlt.getdst());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc1ActionPerformed
        String lm=jc1.getSelectedItem().toString();
        if(lm.equals("Tô nhỏ"))
        {
            if(jch1.isSelected()&&jch2.isSelected())
            {
                jch3.setEnabled(false);
                jch4.setEnabled(false);
                jch5.setEnabled(false);
            }
            else if(jch1.isSelected()&&jch3.isSelected())
            {
                jch2.setEnabled(false);
                jch4.setEnabled(false);
                jch5.setEnabled(false);
            }
            else  if(jch1.isSelected()&&jch4.isSelected())
            {
                jch3.setEnabled(false);
                jch2.setEnabled(false);
                jch5.setEnabled(false);
            }
            else   if(jch1.isSelected()&&jch5.isSelected())
            {
                jch3.setEnabled(false);
                jch4.setEnabled(false);
                jch2.setEnabled(false);
            }
            else    if(jch2.isSelected()&&jch3.isSelected())
            {
                jch1.setEnabled(false);
                jch4.setEnabled(false);
                jch5.setEnabled(false);
            }
            else    if(jch2.isSelected()&&jch4.isSelected())
            {
                jch3.setEnabled(false);
                jch1.setEnabled(false);
                jch5.setEnabled(false);
            }
            else   if(jch2.isSelected()&&jch5.isSelected())
            {
                jch3.setEnabled(false);
                jch4.setEnabled(false);
                jch1.setEnabled(false);
            }
            else   if(jch3.isSelected()&&jch4.isSelected())
            {
                jch1.setEnabled(false);
                jch2.setEnabled(false);
                jch5.setEnabled(false);
            }
            else if(jch3.isSelected()&&jch5.isSelected())
            {
                jch1.setEnabled(false);
                jch4.setEnabled(false);
                jch2.setEnabled(false);
            }
            else if(jch4.isSelected()&&jch5.isSelected())
            {
                jch1.setEnabled(false);
                jch2.setEnabled(false);
                jch3.setEnabled(false);
            }

            else  if(jch1.isSelected())
            {
                jch2.setEnabled(true);
                jch3.setEnabled(true);
                jch4.setEnabled(true);
                jch5.setEnabled(true);

            }
            else if(jch2.isSelected())
            {
                jch1.setEnabled(true);
                jch3.setEnabled(true);
                jch4.setEnabled(true);
                jch5.setEnabled(true);

            }
            else if(jch3.isSelected())
            {
                jch2.setEnabled(true);
                jch1.setEnabled(true);
                jch4.setEnabled(true);
                jch5.setEnabled(true);

            }
            else  if(jch4.isSelected())
            {
                jch2.setEnabled(true);
                jch3.setEnabled(true);
                jch1.setEnabled(true);
                jch5.setEnabled(true);

            }
            else  if(jch5.isSelected())
            {
                jch2.setEnabled(true);
                jch3.setEnabled(true);
                jch4.setEnabled(true);
                jch1.setEnabled(true);

            }
        }
        else if(lm.equals("Tô lớn"))
        {
            if(jch1.isSelected()&&jch2.isSelected()&&jch3.isSelected())
            {
                jch4.setEnabled(false);
                jch5.setEnabled(false);
            }
            else   if(jch1.isSelected()&&jch2.isSelected()&&jch4.isSelected())
            {
                jch3.setEnabled(false);
                jch5.setEnabled(false);
            }
            else        if(jch1.isSelected()&&jch2.isSelected()&&jch5.isSelected())
            {
                jch4.setEnabled(false);
                jch3.setEnabled(false);
            }
            else  if(jch1.isSelected()&&jch3.isSelected()&&jch4.isSelected())
            {
                jch2.setEnabled(false);
                jch5.setEnabled(false);
            }
            else   if(jch1.isSelected()&&jch3.isSelected()&&jch5.isSelected())
            {
                jch4.setEnabled(false);
                jch2.setEnabled(false);
            }
            else   if(jch1.isSelected()&&jch4.isSelected()&&jch5.isSelected())
            {
                jch2.setEnabled(false);
                jch3.setEnabled(false);
            }
            else  if(jch2.isSelected()&&jch3.isSelected()&&jch4.isSelected())
            {
                jch1.setEnabled(false);
                jch5.setEnabled(false);
            }
            else  if(jch2.isSelected()&&jch3.isSelected()&&jch5.isSelected())
            {
                jch1.setEnabled(false);
                jch4.setEnabled(false);
            }
            else   if(jch2.isSelected()&&jch4.isSelected()&&jch5.isSelected())
            {
                jch1.setEnabled(false);
                jch3.setEnabled(false);
            }
            else  if(jch3.isSelected()&&jch4.isSelected()&&jch5.isSelected())
            {
                jch1.setEnabled(false);
                jch2.setEnabled(false);
            }

            else if(jch1.isSelected()&&jch2.isSelected())
            {
                jch3.setEnabled(true);
                jch4.setEnabled(true);
                jch5.setEnabled(true);
            }
            else if(jch1.isSelected()&&jch3.isSelected())
            {
                jch2.setEnabled(true);
                jch4.setEnabled(true);
                jch5.setEnabled(true);
            }
            else if(jch1.isSelected()&&jch4.isSelected())
            {
                jch3.setEnabled(true);
                jch3.setEnabled(true);
                jch5.setEnabled(true);
            }
            else if(jch1.isSelected()&&jch5.isSelected())
            {
                jch3.setEnabled(true);
                jch4.setEnabled(true);
                jch2.setEnabled(true);
            }
            else if(jch2.isSelected()&&jch3.isSelected())
            {
                jch1.setEnabled(true);
                jch4.setEnabled(true);
                jch5.setEnabled(true);
            }
            else if(jch2.isSelected()&&jch4.isSelected())
            {
                jch3.setEnabled(true);
                jch1.setEnabled(true);
                jch5.setEnabled(true);
            }
            else if(jch2.isSelected()&&jch5.isSelected())
            {
                jch3.setEnabled(true);
                jch4.setEnabled(true);
                jch1.setEnabled(true);
            }
            else if(jch3.isSelected()&&jch4.isSelected())
            {
                jch1.setEnabled(true);
                jch2.setEnabled(true);
                jch5.setEnabled(true);
            }
            else if(jch3.isSelected()&&jch5.isSelected())
            {
                jch1.setEnabled(true);
                jch4.setEnabled(true);
                jch2.setEnabled(true);
            }
            else if(jch4.isSelected()&&jch5.isSelected())
            {
                jch1.setEnabled(true);
                jch2.setEnabled(true);
                jch3.setEnabled(true);
            }
            else if(jch1.isSelected())
            {    jch2.setEnabled(true);
                jch3.setEnabled(true);
                jch4.setEnabled(true);
                jch5.setEnabled(true);
            }
            else  if(jch2.isSelected())
            {    jch1.setEnabled(true);
                jch3.setEnabled(true);
                jch4.setEnabled(true);
                jch5.setEnabled(true);
            }
            else  if(jch3.isSelected())
            {    jch2.setEnabled(true);
                jch1.setEnabled(true);
                jch4.setEnabled(true);
                jch5.setEnabled(true);
            }
            else  if(jch4.isSelected())
            {    jch1.setEnabled(true);
                jch3.setEnabled(true);
                jch2.setEnabled(true);
                jch5.setEnabled(true);
            }
            else if(jch5.isSelected())
            {   jch2.setEnabled(true);
                jch3.setEnabled(true);
                jch4.setEnabled(true);
                jch1.setEnabled(true);
            }

        }
        else if(lm.equals("Tô đặc biệt"))
        {
            if(jch1.isSelected()&&jch2.isSelected()&&jch3.isSelected()&&jch4.isSelected())
            {
                jch5.setEnabled(false);
            }
            else if(jch1.isSelected()&&jch2.isSelected()&&jch3.isSelected()&&jch5.isSelected())
            {
                jch4.setEnabled(false);
            }
            else if(jch5.isSelected()&&jch2.isSelected()&&jch3.isSelected()&&jch4.isSelected())
            {
                jch1.setEnabled(false);
            }
            else if(jch1.isSelected()&&jch3.isSelected()&&jch5.isSelected()&&jch4.isSelected())
            {
                jch2.setEnabled(false);
            }
            else
            {
                JCheckBox r1=jch1;
                JCheckBox r2=jch2;
                JCheckBox r3=jch3;
                JCheckBox r4=jch4;
                JCheckBox r5=jch5;
                JCheckBox[] a={r1,r2,r3,r4,r5};
                for(int i=0;i<5;i++)
                {
                    if(!a[i].isEnabled())
                    {
                        a[i].setEnabled(true);
                    }
                }
            }
        }
        giatien1();
    }//GEN-LAST:event_jc1ActionPerformed

    private void j5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j5ActionPerformed

    private void jComboBox17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox17ActionPerformed

    }//GEN-LAST:event_jComboBox17ActionPerformed

    private void jc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jc3ActionPerformed

    private void jCheckBox27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox27ActionPerformed

    private void jCheckBox26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox26ActionPerformed

    private void jc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jc2ActionPerformed
        String t=jc2.getSelectedItem().toString();
        if(t.equals("Thức ăn"))
        {  jcb3.removeAllItems();
            jcb3.addItem("Quẩy");
            jcb3.addItem("Hột gà");
            jcb3.addItem("Bánh phở thêm");
            jcb3.addItem("Tiết");
            jcb3.addItem("Tiết hột gà");

        }
        else if(t.equals("Thức uống"))
        {
            jcb3.removeAllItems();
            jcb3.addItem("Coca");
            jcb3.addItem("Xá xị");
            jcb3.addItem("7 up");
            jcb3.addItem("Lipton");

        }
        else
        {
            jcb3.removeAllItems();
        }
    }//GEN-LAST:event_jc2ActionPerformed

    private void jch5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jch5ActionPerformed

        int t=jc1.getSelectedIndex();
        jc1.setSelectedIndex(t);
    }//GEN-LAST:event_jch5ActionPerformed

    private void jch4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jch4ActionPerformed

        int t=jc1.getSelectedIndex();
        jc1.setSelectedIndex(t);
    }//GEN-LAST:event_jch4ActionPerformed

    private void jch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jch3ActionPerformed

        int t=jc1.getSelectedIndex();
        jc1.setSelectedIndex(t);
    }//GEN-LAST:event_jch3ActionPerformed

    private void jch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jch2ActionPerformed

        int t=jc1.getSelectedIndex();
        jc1.setSelectedIndex(t);
    }//GEN-LAST:event_jch2ActionPerformed

    private void jch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jch1ActionPerformed

        int t=jc1.getSelectedIndex();
        jc1.setSelectedIndex(t);
    }//GEN-LAST:event_jch1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String t=jComboBox1.getSelectedItem().toString();
        j23.setText(t+":");
        addDocumentListener3();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
         if(maquyen==2)
         {
             
         
         DefaultTableModel t=(DefaultTableModel)jTable7.getModel();
        int row=jTable7.getSelectedRow();
        int rowc=jTable7.getSelectedRowCount();
        if(rowc==0)
        {
            JOptionPane.showMessageDialog(this,"Không có hàng nào được chọn.");
        }
        else
        {
            String idtk=jTable7.getModel().getValueAt(row,0).toString();
            int input=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa tài khoản này không?","Xóa tài khoản",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(input==0)
            {
                qltk1.del(idtk);
                t.removeRow(row);
                JOptionPane.showMessageDialog(this, "Đã xóa thành công.");
            }
        }
         }
         else
         {
             JOptionPane.showMessageDialog(this,"Chỉ có admin có quyền xóa.");
         }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
       if(maquyen==2)
       {
        new themtaikhoan().setVisible(true);
       }
       else
       {
           JOptionPane.showMessageDialog(this,"Chỉ có admin có quyền thêm.");
       }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
   if(maquyen==2)
   {
        DefaultTableModel t=(DefaultTableModel)jTable5.getModel();
        int rowc=jTable7.getSelectedRowCount();
        int row=jTable7.getSelectedRow();
        if(rowc==0)
        {
            JOptionPane.showMessageDialog(this,"Không có hàng nào được chọn.");
        }
        else
        {
            String idtaikhoan=jTable7.getModel().getValueAt(row,0).toString();
            String tentaikhoan=jTable7.getModel().getValueAt(row,1).toString();
            String matkhau=jTable7.getModel().getValueAt(row,2).toString();
            String idnhanvien=jTable7.getModel().getValueAt(row,3).toString();
            int maquyen=Integer.parseInt(jTable7.getModel().getValueAt(row,4).toString());
            new suataikhoan1(idtaikhoan,tentaikhoan,matkhau,idnhanvien,maquyen).setVisible(true);
        }     
   }
   else
   {
       JOptionPane.showMessageDialog(this,"Chỉ có admin có quyền sửa.");
   }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
     qltk1.readtk();
     jComboBox1.setSelectedIndex(0);
    jTextField2.setText("");
    addtable3(qltk1.getdstk());
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jp10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp10MouseClicked
        if(maquyen==2)
        {
        jt1.setSelectedIndex(6);
        this.setSize(1400,850);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Chỉ có admin có thể sử dụng chức năng này.");
        }
    }//GEN-LAST:event_jp10MouseClicked

    private void jp10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp10MouseEntered
       Color cor=new Color(0,102,102);
        jp10.setBackground(cor);
        j11.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp10MouseEntered

    private void jp10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp10MouseExited
           Color cor=new Color(0,153,102);
        jp10.setBackground(cor);
        j11.setForeground(Color.BLACK);
    }//GEN-LAST:event_jp10MouseExited

    private void jp10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp10MousePressed
          Color cor=new Color(0,51,51);
        jp10.setBackground(cor);
        j11.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp10MousePressed

    private void jp10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp10MouseReleased
         Color cor=new Color(0,102,102);
        jp10.setBackground(cor);
        j11.setForeground(Color.white);
    }//GEN-LAST:event_jp10MouseReleased

    private void j11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j11MouseEntered
        Color cor=new Color(0,102,102);
        jp10.setBackground(cor);
        j11.setForeground(Color.WHITE);

    }//GEN-LAST:event_j11MouseEntered

    private void j12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j12MouseEntered

         Color cor=new Color(0,102,102);
        jp11.setBackground(cor);
        j12.setForeground(Color.WHITE);

    }//GEN-LAST:event_j12MouseEntered

    private void jp11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp11MouseClicked
        if(maquyen==2||maquyen==3)
        {
        this.setSize(1400,820);
        jt1.setSelectedIndex(7);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Chỉ có admin và quản lý có thể sử dụng.");
            
        }
        
    }//GEN-LAST:event_jp11MouseClicked

    private void jp11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp11MouseEntered
       Color cor=new Color(0,102,102);
        jp11.setBackground(cor);
        j12.setForeground(Color.WHITE);

    }//GEN-LAST:event_jp11MouseEntered

    private void jp11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp11MouseExited
           Color cor=new Color(0,153,102);
        jp11.setBackground(cor);
        j12.setForeground(Color.BLACK);
    }//GEN-LAST:event_jp11MouseExited

    private void jp11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp11MousePressed
         Color cor=new Color(0,51,51);
        jp11.setBackground(cor);
        j12.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp11MousePressed

    private void jp11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp11MouseReleased
         Color cor=new Color(0,102,102);
        jp11.setBackground(cor);
        j12.setForeground(Color.white);
    }//GEN-LAST:event_jp11MouseReleased

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String t=jComboBox2.getSelectedItem().toString();
        jLabel24.setText(t+":");
        addDocumentListener4();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
       qlpq.readpq();
       jComboBox2.setSelectedIndex(0);
       jTextField4.setText("");
       addtable4(qlpq.getdspq());
    }//GEN-LAST:event_jButton21ActionPerformed

    private void j11ComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_j11ComponentRemoved
        // TODO add your handling code here
    }//GEN-LAST:event_j11ComponentRemoved

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        if(maquyen==2)
        {
        DefaultTableModel t=(DefaultTableModel)jTable8.getModel();
        int row=jTable8.getSelectedRow();
        int rowc=jTable8.getSelectedRowCount();
        if(rowc==0)
        {
            JOptionPane.showMessageDialog(this,"Không có hàng nào được chọn.");
        }
        else
        {
            int idpq=Integer.parseInt(jTable8.getModel().getValueAt(row,0).toString());
            int input=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa loại quyền này không?","Xóa loại quyền",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(input==0)
            {
                qlpq.del(idpq);
                t.removeRow(row);
                JOptionPane.showMessageDialog(this, "Đã xóa thành công.");
            }
        }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Chỉ có admin có quyền xóa.");
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if(maquyen==2)
        {
        try {
            new themphanquyen().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrameForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Chỉ có admin có quyền thêm.");
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
      if(maquyen==2)
      {
        DefaultTableModel t=(DefaultTableModel)jTable8.getModel();
        int rowc=jTable8.getSelectedRowCount();
        int row=jTable8.getSelectedRow();
        if(rowc==0)
        {
            JOptionPane.showMessageDialog(this,"Không có hàng nào được chọn.");
        }
        else
        {
            int id=Integer.parseInt(jTable8.getModel().getValueAt(row,0).toString());
            String tenquyen=jTable8.getModel().getValueAt(row,1).toString();
            String ghichu=jTable8.getModel().getValueAt(row,2).toString();
           
            new suaquyen(id,tenquyen,ghichu).setVisible(true);
        }     
      }
      else
      {
          JOptionPane.showMessageDialog(this,"Chỉ có admin có quyền sửa.");
      }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        qlmp.readlmp();
        jComboBox3.setSelectedIndex(0);
        jTextField3.setText("");
        if(!jTextField5.getText().equals("0"))
        {
            jTextField5.setText("0");
        }
        if(!jTextField6.getText().equals("0"))
        {
           jTextField6.setText("0");
        }
        addtable5(qlmp.getma());
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        String t=jComboBox3.getSelectedItem().toString();
        jLabel26.setText(t+":");
        addDocumentListener5();
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
    
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked
     
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        if(maquyen==2)
        {
        DefaultTableModel t=(DefaultTableModel)jTable9.getModel();
        int row=jTable9.getSelectedRow();
        int rowc=jTable9.getSelectedRowCount();
        if(rowc==0)
        {
            JOptionPane.showMessageDialog(this,"Không có hàng nào được chọn.");
        }
        else
        {
            int idmp=Integer.parseInt(jTable8.getModel().getValueAt(row,0).toString());
            int input=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa món ăn này không?","Xóa món ăn",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(input==0)
            {
                qlmp.del(idmp);
                t.removeRow(row);
                JOptionPane.showMessageDialog(this, "Đã xóa thành công.");
            }
        }
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Chỉ có admin có thể xóa.");
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
      if(maquyen==2)
      {
        new themmonphu().setVisible(true);
      }
      else
      {
          JOptionPane.showMessageDialog(this,"Chỉ có admin có thể thêm.");
      }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
      if(maquyen==2)
      {
        DefaultTableModel t=(DefaultTableModel)jTable9.getModel();
        int rowc=jTable9.getSelectedRowCount();
        int row=jTable9.getSelectedRow();
        if(rowc==0)
        {
            JOptionPane.showMessageDialog(this,"Không có hàng nào được chọn.");
        }
        else
        {
            int idmonphu=Integer.parseInt(jTable9.getModel().getValueAt(row,0).toString());
            String tenmonphu=jTable9.getModel().getValueAt(row,1).toString();
            int maloai=Integer.parseInt(jTable9.getModel().getValueAt(row,2).toString());
            String t2=jTable9.getModel().getValueAt(row, 3).toString();
            t2=t2.replace("đ","");
            float giatien=Float.parseFloat(t2);
           
            new suamonphu(idmonphu,tenmonphu,maloai,giatien).setVisible(true);
        }     
      }
      else
      {
          JOptionPane.showMessageDialog(this,"Chỉ có admin có thể sửa.");
      }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        new XuatExcel().xuatfileExcelmonanphu();
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        new XuatExcel().xuatfileExcelquanlyquyen();
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
       new XuatExcel().xuatfilequanlynhanvien();
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        new XuatExcel().xuatfilequanlyloaimon();
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        new XuatExcel().xuatfilequanlytaikhoan();
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel t=(DefaultTableModel)jTable6.getModel();
        String loaito=jc1.getSelectedItem().toString();
        String loaithit="";
        JCheckBox r1=jch1;
        JCheckBox r2=jch2;
        JCheckBox r3=jch3;
        JCheckBox r4=jch4;
        JCheckBox r5=jch5;
        int mato1=Integer.parseInt(jComboBox5.getSelectedItem().toString());
        JCheckBox[] a={r1,r2,r3,r4,r5};
        for(int i=0;i<5;i++)
        {
            if(a[i].isSelected())
            {
                loaithit+=a[i].getText()+" ";
            }
        }
        String t6=jtext1.getText();
        t6=t6.replace("đ","");
        String t4=jtext3.getText();
        t4=t4.replace("đ","");
        double giatien=Double.parseDouble(t6);
        String monanphu=jcb3.getSelectedItem().toString();
        double tongtien=Double.parseDouble(t4);
        String mathuckhach=jComboBox13.getSelectedItem().toString();
        LocalTime giodat=LocalTime.parse(j5.getText());
        qlt.readdb();
        if(loaito==""||loaithit==""||mathuckhach=="")
        {
            JOptionPane.showMessageDialog(this,"Không được để trống thông tin.");
        }
       
        else
        {   if(!qlt.checkexistid(mato1))
        {   if(monanphu=="Item 1")
        {   
            
            topho t3=new topho(mato1,loaithit,loaito,mathuckhach,giatien,giodat);
            
            qlt.addtopho(t3);
            
            t.addRow(new Object[]{mathuckhach,giodat,loaito,loaithit,"",giatien,mato1});
            JOptionPane.showMessageDialog(this,"Đả thực hiện gọi món thành công.");
        }
          else
        {    topho t3=new topho(mato1,loaithit,loaito,mathuckhach,giatien,giodat);
            qlt.addtopho(t3);
            int idmonphu=0;
            switch (monanphu)
              {
                case "Quẩy":
                            idmonphu=1;
                             break;
                case "Hột gà":
                             idmonphu=2;
                             break;
                case "Bánh phở thêm":
                                     idmonphu=3;
                                     break;
                case "Tiết":
                           idmonphu=4;
                           break;
                case "Tiết hột gà":
                                   idmonphu=5;
                                   break;
                case "Coca":
                             idmonphu=6;
                             break;
                case "Xá xị":
                              idmonphu=7;
                              break;
                case "7 up":
                             idmonphu=8;
                             break;
                case "Lipton":
                              idmonphu=9;
                              break;
                
            }
            
            ctmp.readdb();
            int mato=qlt.getNextID();
            chitietmonphu t5=new chitietmonphu(ctmp.getnextid(),mato1,idmonphu);
            ctmp.addctmp(t5);
            t.addRow(new Object[]{mathuckhach,giodat,loaito,loaithit,monanphu,tongtien,mato1});
            
            JOptionPane.showMessageDialog(this,"Đã thực hiện gọi món thành công");
            System.out.println(qlt.checkexistid(mato1));
            
        }
                  }
        else
        {   int idmonphu=0;
             switch (monanphu)
              {
                case "Quẩy":
                            idmonphu=1;
                             break;
                case "Hột gà":
                             idmonphu=2;
                             break;
                case "Bánh phở thêm":
                                     idmonphu=3;
                                     break;
                case "Tiết":
                           idmonphu=4;
                           break;
                case "Tiết hột gà":
                                   idmonphu=5;
                                   break;
                case "Coca":
                             idmonphu=6;
                             break;
                case "Xá xị":
                              idmonphu=7;
                              break;
                case "7 up":
                             idmonphu=8;
                             break;
                case "Lipton":
                              idmonphu=9;
                              break;
                
                
            }
            ctmp.readdb();
            int mato=qlt.getNextID();
            chitietmonphu t5=new chitietmonphu(ctmp.getnextid(),mato1,idmonphu);
            ctmp.addctmp(t5);
            t.addRow(new Object[]{mathuckhach,giodat,loaito,loaithit,monanphu,tongtien,mato1});
           
            JOptionPane.showMessageDialog(this,"Đã thực hiện gọi món thành công");
             System.out.println(qlt.checkexistid(mato1));
             

        }
        }
         qlt.readdb();
         addmato(qlt.getdst());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        DefaultTableModel t1=(DefaultTableModel)jTable6.getModel();
        int row=jTable6.getSelectedRow();
        int rowc=jTable6.getSelectedRowCount();

        if(rowc==0)
        {
            JOptionPane.showMessageDialog(this,"Không có hàng nào được chọn.");
        }
        int mato =Integer.parseInt(jTable6.getModel().getValueAt(row,6).toString());
        int input=JOptionPane.showConfirmDialog(null,"Bạn có muốn xóa tô này không?","Xóa tô",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(rowc!=0)
        {
            if(input==0)
            {
                qlt.del(mato);
                JOptionPane.showMessageDialog(this,"Đã xóa tô này khỏi cơ sở dữ liệu.");
                t1.removeRow(row);
            }

        }
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
 
        try {
            qlb.readb();
            addban(qlb.getdsban());
        } catch (SQLException ex) {
            Logger.getLogger(MainFrameForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel t=(DefaultTableModel)jTable10.getModel();
        t.setRowCount(0);
        
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        try {
            new thembanan().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrameForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
      int id=Integer.parseInt(JOptionPane.showInputDialog(this,"Nhập vào mã bàn muốn xóa:"));
      qlb.delban(id);
      JOptionPane.showMessageDialog(this,"Đã xóa thành công");
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        new XuatExcel().xuatfilequanlyhoadon();
    }//GEN-LAST:event_jButton41ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
       String t=jComboBox4.getSelectedItem().toString();
       jLabel35.setText(t);
       addDocumentListener6();
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        qlhd.readlmp();
        jComboBox4.setSelectedIndex(0);
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        String giatu=jTextField10.getText();
        String giaden=jTextField21.getText();
        if(!giatu.equals("0")||!giaden.equals("0"))
        {
            jTextField10.setText("0");
            jTextField21.setText("0");
        }
        addtable6(qlhd.gethoadon());
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
      try {
          DefaultTableModel table=(DefaultTableModel)jTable2.getModel();
          int row=jTable2.getSelectedRow();
          int rowcount=jTable2.getSelectedRowCount();
          if(rowcount==0)
          {
              JOptionPane.showMessageDialog(this,"Không có thực khách nào được chọn.");
          }
          else
          {
          String idthuckhach=jTable2.getModel().getValueAt(row,0).toString();
          qlhd.readlmp();
          String mahoadon=qlhd.getnextid();
          String mhd=mahoadon;
          int idban=0;
          String query="Select idban from thuckhach where idthuckhach='"+idthuckhach+"'";
          ResultSet r=con.sqlres(query);
          while(r.next())
          {
              idban=r.getInt("idban");
          }
          LocalDate ngayxuat=LocalDate.now();
          LocalTime gioxuat=LocalTime.now();
          double tongtien=0;
          double tongtien1=0;
          String query1="select sum(giatien) as tongtien from topho,thuckhach where thuckhach.idthuckhach='"+idthuckhach+"' and topho.idthuckhach='"+idthuckhach+"'";
          String query2="select sum(monphu.giatien) as tongtienphu from thuckhach,topho,chitietmonphu,monphu where thuckhach.idthuckhach='"+idthuckhach+"' and topho.idto=chitietmonphu.idto and monphu.idmonphu=chitietmonphu.idmonphu and topho.idthuckhach='"+idthuckhach+"'";
          r=con.sqlres(query1);
          while(r.next())
          {
              tongtien=r.getDouble("tongtien");
          }
          r=con.sqlres(query2);
          while(r.next())
          {
              tongtien1=r.getDouble("tongtienphu");
          }
          String query3="Select idnhanvien from taikhoan where tentaikhoan='"+username+"'";
          r=con.sqlres(query3);
          String idnhanvien="";
          while(r.next())
          {
              idnhanvien=r.getString("idnhanvien");
          }
          double tongtien0=tongtien1+tongtien;
        hoadon h= new hoadon(mahoadon,idban,ngayxuat,idthuckhach,gioxuat,idnhanvien,tongtien0);
        qlhd.add(h);
        String query4="select DISTINCT topho.idto,loaito,topho.giatien,tenmonphu,COUNT(tenmonphu) as soluongmp,monphu.Giatien from thuckhach,topho,chitietmonphu,monphu where thuckhach.idthuckhach='"+idthuckhach+"' and topho.idthuckhach='"+idthuckhach+"' and chitietmonphu.idto=topho.idto and chitietmonphu.idmonphu=monphu.idmonphu group by loaito,tenmonphu,topho.idto,monphu.Giatien,topho.giatien";
        r=con.sqlres(query4);
       
        while(r.next())
        {   cthd.readlmp();
            String idcthd=cthd.getnextid();
            int idto=r.getInt("topho.idto");
            String loaito=r.getString("loaito");
            double giatien3=r.getDouble("topho.giatien");
            String tenmonphu=r.getString("tenmonphu");
            int slmp=r.getInt("soluongmp");
            double giatien4=r.getDouble("monphu.giatien");
            chitiethoadon cthd1=new chitiethoadon(idcthd,mhd,idto,loaito,giatien3,tenmonphu,slmp,giatien4);
            cthd.add(cthd1);
           
        }
        new thanhtoanhoadon(idthuckhach,mahoadon,username).setVisible(true);
          }
      } catch (SQLException ex) {
          Logger.getLogger(MainFrameForm.class.getName()).log(Level.SEVERE, null, ex);
      }
      
         
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        int row=jTable11.getSelectedRow();
        String mahoadon=jTable11.getModel().getValueAt(row,0).toString();
        int rowcount=jTable11.getRowCount();
        if(rowcount==0)
        {
            JOptionPane.showMessageDialog(this,"Không có hóa đơn nào được chọn.");
        }
        else
        {
            new Chitiethoadon(mahoadon).setVisible(true);
        }
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
      try {
         
          int rowcount=jTable11.getSelectedRowCount();
          if(rowcount==0)
          {
              JOptionPane.showMessageDialog(null,"Không có hóa đơn nào được chọn.");
          }
          else
          { int row=jTable11.getSelectedRow();
          
              String idhoadon=jTable11.getModel().getValueAt(row,0).toString();
          new xuatfilePDF().writehoadon(idhoadon);
          }
      } catch (DocumentException ex) {
          Logger.getLogger(MainFrameForm.class.getName()).log(Level.SEVERE, null, ex);
      } catch (FileNotFoundException ex) {
          Logger.getLogger(MainFrameForm.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jPanel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseEntered
         Color cor=new Color(0,102,102);
        jPanel23.setBackground(cor);
        j95.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel23MouseEntered

    private void j95MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j95MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_j95MouseExited

    private void j95MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j95MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_j95MousePressed

    private void jPanel23MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseReleased
          Color cor=new Color(0,102,102);
        jPanel23.setBackground(cor);
        j95.setForeground(Color.white);
    }//GEN-LAST:event_jPanel23MouseReleased

    private void jPanel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseClicked
       new menutuychon(username).setVisible(true);
    }//GEN-LAST:event_jPanel23MouseClicked

    private void jPanel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MouseExited
   Color cor=new Color(0,153,102);
        jPanel23.setBackground(cor);
        j95.setForeground(Color.BLACK);
    }//GEN-LAST:event_jPanel23MouseExited

    private void jPanel23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel23MousePressed
         Color cor=new Color(0,51,51);
        jPanel23.setBackground(cor);
        j95.setForeground(Color.WHITE);
    }//GEN-LAST:event_jPanel23MousePressed

    private void j95MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j95MouseClicked
        new menutuychon(username).setVisible(true);
    }//GEN-LAST:event_j95MouseClicked

    private void j13ComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_j13ComponentRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_j13ComponentRemoved

    private void j13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j13MouseEntered
       Color cor=new Color(0,102,102);
        jp12.setBackground(cor);
        j13.setForeground(Color.WHITE);

    }//GEN-LAST:event_j13MouseEntered

    private void jp12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp12MouseClicked
        if(maquyen==2)
        {
            jt1.setSelectedIndex(10);
            this.setSize(1200,880);
            
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Chỉ có admin mới có thể truy cập.");
        }
    }//GEN-LAST:event_jp12MouseClicked

    private void jp12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp12MouseEntered
             Color cor=new Color(0,102,102);
        jp12.setBackground(cor);
        j13.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp12MouseEntered

    private void jp12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp12MouseExited
Color cor=new Color(0,153,102);
        jp12.setBackground(cor);
        j13.setForeground(Color.BLACK);
    }//GEN-LAST:event_jp12MouseExited

    private void jp12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp12MousePressed
           Color cor=new Color(0,51,51);
        jp12.setBackground(cor);
        j13.setForeground(Color.WHITE);
    }//GEN-LAST:event_jp12MousePressed

    private void jp12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp12MouseReleased
       Color cor=new Color(0,102,102);
        jp12.setBackground(cor);
        j13.setForeground(Color.white);
    }//GEN-LAST:event_jp12MouseReleased

    private void j12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j12MouseClicked
          if(maquyen==2||maquyen==3)
        {
        this.setSize(1050,750);
        jt1.setSelectedIndex(7);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Chỉ có admin và quản lý có thể sử dụng.");
            
        }
    }//GEN-LAST:event_j12MouseClicked

    private void j11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j11MouseClicked
         if(maquyen==2)
        {
        jt1.setSelectedIndex(6);
        this.setSize(1400,820);
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Chỉ có admin có thể sử dụng chức năng này.");
        }
    }//GEN-LAST:event_j11MouseClicked

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
    String t=jComboBox6.getSelectedItem().toString();
    jLabel114.setText(t);
    addDocumentListener8();
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jComboBox13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox13ActionPerformed
      int x=180;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainFrameForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MainFrameForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel j1;
    private javax.swing.JLabel j10;
    private javax.swing.JLabel j11;
    private javax.swing.JLabel j12;
    private javax.swing.JLabel j13;
    private javax.swing.JLabel j16;
    private javax.swing.JLabel j17;
    private javax.swing.JLabel j18;
    private javax.swing.JLabel j19;
    private javax.swing.JLabel j2;
    private javax.swing.JLabel j20;
    private javax.swing.JLabel j21;
    private javax.swing.JLabel j22;
    private javax.swing.JLabel j23;
    private javax.swing.JLabel j3;
    private javax.swing.JLabel j4;
    private javax.swing.JTextField j5;
    private javax.swing.JLabel j6;
    private javax.swing.JLabel j7;
    private javax.swing.JLabel j8;
    private javax.swing.JLabel j9;
    private javax.swing.JLabel j95;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox29;
    private javax.swing.JCheckBox jCheckBox30;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox17;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton jb13;
    private javax.swing.JButton jb6;
    private javax.swing.JComboBox<String> jc1;
    private javax.swing.JComboBox<String> jc2;
    private javax.swing.JCheckBox jc3;
    private javax.swing.JComboBox<String> jcb1;
    private javax.swing.JComboBox<String> jcb2;
    private javax.swing.JComboBox<String> jcb3;
    private javax.swing.JCheckBox jch1;
    private javax.swing.JCheckBox jch2;
    private javax.swing.JCheckBox jch3;
    private javax.swing.JCheckBox jch4;
    private javax.swing.JCheckBox jch5;
    private javax.swing.JComboBox<String> jcombobox1;
    private javax.swing.JLabel jl1;
    private javax.swing.JLabel jl5;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp10;
    private javax.swing.JPanel jp11;
    private javax.swing.JPanel jp12;
    private javax.swing.JPanel jp2;
    private javax.swing.JPanel jp22;
    private javax.swing.JPanel jp3;
    private javax.swing.JPanel jp4;
    private javax.swing.JPanel jp5;
    private javax.swing.JPanel jp6;
    private javax.swing.JPanel jp7;
    private javax.swing.JPanel jp8;
    private javax.swing.JPanel jp9;
    private javax.swing.JTabbedPane jt1;
    private javax.swing.JTextField jte2;
    private javax.swing.JTextField jte3;
    private javax.swing.JTextField jte5;
    private javax.swing.JTextField jtex1;
    private javax.swing.JTextField jtex2;
    private javax.swing.JTextField jtex3;
    private javax.swing.JTextField jtext1;
    private javax.swing.JTextField jtext2;
    private javax.swing.JTextField jtext3;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
