/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.frontend;

/**
 *
 * @author Acer
 */
import java.util.*;
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
import quanlytiempho.model.backend.quanlyto.topho;
import quanlytiempho.model.backend.quanlyto.tophoBUS;
import quanlytiempho.model.backend.quanlychitietmonphu.chitietmonphu;
import quanlytiempho.model.backend.quanlychitietmonphu.chitietmonphuBUS;
import quanlytiempho.model.backend.connectiondb.Connectiondb;
import quanlytiempho.model.backend.quanlyhoadon.hoadonBUS;
import quanlytiempho.model.backend.quanlyhoadon.hoadon;
import quanlytiempho.model.backend.quanlychitiethoadon.chitiethoadon;
import quanlytiempho.model.backend.quanlychitiethoadon.chitiethoadonBUS;
public class thanhtoanhoadon extends javax.swing.JFrame {

    /**
     * Creates new form thanhtoanhoadon
     */
    String idthuckhach;
    String mahoadon;
    String username;
    public thanhtoanhoadon() {
        initComponents();
    }
    public thanhtoanhoadon(String idthuckhach,String mahoadon,String username)
    {
        try {
            initComponents();
            this.setSize(1100,800);
            this.setLocationRelativeTo(null);
            this.idthuckhach=idthuckhach;
            this.mahoadon=mahoadon;
            this.username=username;
            j1.setText(this.mahoadon);
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
            String query2="select sum(monphu.giatien) as tongtienphu from thuckhach,topho,chitietmonphu,monphu where thuckhach.idthuckhach='"+idthuckhach+"' and topho.idto=chitietmonphu.idto and monphu.idmonphu=chitietmonphu.idmonphu and topho.idthuckhach='"+idthuckhach+"' ";
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
            j2.setText(String.valueOf(ngayxuat));
            j3.setText(String.valueOf(gioxuat));
            j4.setText(String.valueOf(idban));
            j5.setText(idnhanvien);
            j6.setText(String.valueOf(tongtien0));
            DefaultTableModel table=(DefaultTableModel)jTable1.getModel();
               table.setRowCount(0);
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
            chitiethoadon cthd1=new chitiethoadon(idcthd,mahoadon,idto,loaito,giatien3,tenmonphu,slmp,giatien4);
            table.addRow(new Object[]{idto,loaito,giatien3,tenmonphu,slmp,giatien4});
        }
        
       
        } catch (SQLException ex) {
            Logger.getLogger(thanhtoanhoadon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                  
    }
    chitiethoadonBUS cthd=new chitiethoadonBUS();
  Connectiondb con=new Connectiondb();
   thuckhachBUS qltk=new thuckhachBUS();
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        j1 = new javax.swing.JTextField();
        j4 = new javax.swing.JTextField();
        j2 = new javax.swing.JTextField();
        j3 = new javax.swing.JTextField();
        j5 = new javax.swing.JTextField();
        j6 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Hóa đơn");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(402, 13, 99, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã hóa đơn:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 100, 77, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mã bàn:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(22, 155, 49, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tổng tiền:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(648, 164, 63, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ngày xuất:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(276, 100, 69, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Giờ xuất:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(655, 100, 56, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Mã nhân viên:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(276, 155, 86, 17);

        j1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j1ActionPerformed(evt);
            }
        });
        getContentPane().add(j1);
        j1.setBounds(94, 98, 112, 22);

        j4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j4ActionPerformed(evt);
            }
        });
        getContentPane().add(j4);
        j4.setBounds(89, 153, 117, 22);

        j2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j2ActionPerformed(evt);
            }
        });
        getContentPane().add(j2);
        j2.setBounds(402, 98, 113, 22);

        j3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j3ActionPerformed(evt);
            }
        });
        getContentPane().add(j3);
        j3.setBounds(746, 98, 101, 22);

        j5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j5ActionPerformed(evt);
            }
        });
        getContentPane().add(j5);
        j5.setBounds(402, 153, 110, 22);
        getContentPane().add(j6);
        j6.setBounds(746, 162, 100, 22);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tô", "Loại tô", "Gía tiền", "Tên món phụ", "Số lượng món phụ", "Gía tiền món phụ"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 220, 942, 320);

        jButton1.setText("Xác nhận");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(410, 620, 100, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void j2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j2ActionPerformed

    private void j1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j1ActionPerformed

    private void j4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j4ActionPerformed

    private void j5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j5ActionPerformed

    private void j3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_j3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       qltk.del(idthuckhach);
       JOptionPane.showMessageDialog(this,"Đã thanh toán thành công.");
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(thanhtoanhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(thanhtoanhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(thanhtoanhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(thanhtoanhoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new thanhtoanhoadon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField j1;
    private javax.swing.JTextField j2;
    private javax.swing.JTextField j3;
    private javax.swing.JTextField j4;
    private javax.swing.JTextField j5;
    private javax.swing.JTextField j6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
