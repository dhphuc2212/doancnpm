/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.frontend;
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
import quanlytiempho.model.backend.quanlychitiethoadon.chitiethoadonBUS;
import quanlytiempho.model.backend.quanlychitiethoadon.chitiethoadon;

public class Chitiethoadon extends javax.swing.JFrame {

    /**
     * Creates new form chitiethoadon
     */
    private String mahoadon;
    public Chitiethoadon() {
        initComponents();
    }
    public Chitiethoadon(String mahoadon)
    {   initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(1200,600);
        this.mahoadon=mahoadon;
        addtable(mahoadon);
    }
   public void addtable(String mahoadon)
   {
        try {
            DefaultTableModel t1=(DefaultTableModel)jTable1.getModel();
            t1.setRowCount(0);
            String query4="Select * from chitiethoadon where chitiethoadon.idhoadon='"+mahoadon+"'";
            ResultSet r=con.sqlres(query4);
            
            while(r.next())
            {  
            int idto=r.getInt("idto");
            String loaito=r.getString("loaito");
            double giatien3=r.getDouble("dongia");
            String tenmonphu=r.getString("tenmonphu");
            int slmp=r.getInt("soluongmonphu");
            double giatien4=r.getDouble("dongiamonphu");
            t1.addRow(new Object[]{idto,loaito,(int)giatien3+"đ",tenmonphu,slmp,(int)giatien4+"đ"});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Chitiethoadon.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   Connectiondb con=new Connectiondb();
   chitiethoadonBUS cthd=new chitiethoadonBUS();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Chi tiết hóa đơn");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(390, 0, 189, 29);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tìm kiếm:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 70, 70, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tất cả:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(200, 70, 60, 20);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(260, 70, 66, 22);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Số lượng tô");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(450, 40, 81, 17);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(400, 70, 79, 22);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Đến");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(510, 70, 25, 17);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(540, 70, 82, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Từ:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(650, 70, 22, 17);

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5);
        jTextField5.setBounds(680, 70, 74, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Từ:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(370, 70, 22, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Số lượng món phụ");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(710, 40, 128, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Đến:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(790, 70, 30, 17);
        getContentPane().add(jTextField6);
        jTextField6.setBounds(830, 70, 83, 22);

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Acer\\Downloads\\refresh (1).png")); // NOI18N
        jButton1.setText("Làm mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(940, 50, 120, 50);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã tô", "Loại tô", "Đơn giá tô", "Tên món phụ", "Số lượng món phụ", "Đơn giá món phụ"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 120, 1050, 230);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã tô", "Số lượng tô", "Số luống món phụ" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(100, 70, 70, 22);

        jButton2.setText("Xác nhận");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(430, 410, 110, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       String t=jComboBox1.getSelectedItem().toString();
       jLabel3.setText(t);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(chitiethoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chitiethoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chitiethoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chitiethoadon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chitiethoadon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
