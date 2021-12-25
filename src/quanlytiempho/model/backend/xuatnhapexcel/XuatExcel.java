/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.xuatnhapexcel;
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
import quanlytiempho.model.backend.quanlyhoadon.hoadonBUS;
import quanlytiempho.model.backend.quanlyhoadon.hoadon;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
public class XuatExcel {
    FileDialog fd=new FileDialog(new JFrame(),"Xuất Excel",FileDialog.LOAD);
    private String getFile()
    {   fd.setDirectory("C:\\xampp\\htdocs\\Quanlytiempho\\quanlytiempho\\src");
        fd.setFile("phobo.xls");
        fd.setVisible(true);
        String url=fd.getDirectory()+fd.getFile();
        if(url.equals("nullnull")||url.equals("null"))
        {
            return null;
        }
        return url;
    }
    //XUẤT FILE EXCEL monanphu//
    public void xuatfileExcelmonanphu()
    {
        fd.setTitle("Xuất dữ liệu món ăn phụ");
        String url=getFile();
        if(url==null)
        {
            return;
        }
        FileOutputStream outs=null;
        try{
            HSSFWorkbook workbook=new HSSFWorkbook();
            HSSFSheet sheet=workbook.createSheet("Món ăn phụ");
            monphuBUS qlmp=new monphuBUS();
            ArrayList<monphu> ds=qlmp.getma();
            int rownum=0;
            Row row=sheet.createRow(rownum);
            row.createCell(0,CellType.NUMERIC).setCellValue("Mã món phụ");
            row.createCell(1,CellType.STRING).setCellValue("Tên món phụ");
            row.createCell(2,CellType.NUMERIC).setCellValue("Mã loại");
            row.createCell(3, CellType.STRING).setCellValue("Gía tiền");
            for(monphu mp : ds)
            {
                rownum++;
                row=sheet.createRow(rownum);
                 row.createCell(0,CellType.NUMERIC).setCellValue(mp.getIdmonphu());
            row.createCell(1,CellType.STRING).setCellValue(mp.getTenmonphu());
            row.createCell(2,CellType.NUMERIC).setCellValue(mp.getIdloaimonphu());
            row.createCell(3, CellType.STRING).setCellValue(String.valueOf((int)mp.getGiatien())+"đ");            
        }
            for(int i=0;i<rownum;i++)
            {
                sheet.autoSizeColumn(i);
            }
            File file=new File(url);
            file.getParentFile().mkdir();
            outs=new FileOutputStream(file);
            workbook.write(outs);
            JOptionPane.showMessageDialog(null,"Ghi file thành công ở "+file.getAbsolutePath());
                }catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outs != null) {
                    outs.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        
    }
    public void xuatfileExcelquanlyquyen()
    {
        fd.setTitle("Xuất file quản lý quyền");
        String url=getFile();
        if(url==null)
        {
            return;
        }
        FileOutputStream outs=null;
        try
        {   phanquyenBUS qlpq=new phanquyenBUS();
             ArrayList<phanquyen> ds=qlpq.getdspq();
            HSSFWorkbook workbook=new HSSFWorkbook();
            HSSFSheet sheet=workbook.createSheet("Quyền");
            int rownum=0;
            Row row=sheet.createRow(rownum);
            row.createCell(0,CellType.NUMERIC).setCellValue("Mã quyền");
            row.createCell(1, CellType.STRING).setCellValue("Tên quyền");
            row.createCell(2, CellType.STRING).setCellValue("Ghi chú");
          for(phanquyen q:ds)
          {
              rownum++;
              row=sheet.createRow(rownum);
               row.createCell(0,CellType.NUMERIC).setCellValue(q.getMaquyen());
            row.createCell(1, CellType.STRING).setCellValue(q.getTenquyen());
            row.createCell(2, CellType.STRING).setCellValue(q.getGhichu());
            
          }
          for(int i=0;i<rownum;i++)
          {
              sheet.autoSizeColumn(i);
          }
          File file=new File(url);
          file.getParentFile().mkdir();
          outs=new FileOutputStream(file);
          workbook.write(outs);
         JOptionPane.showMessageDialog(null,"Đã tạo file ở: "+file.getAbsolutePath());
        }catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outs != null) {
                    outs.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void xuatfilequanlytaikhoan()
    {
         fd.setTitle("Xuất file quản lý tài khoản");
        String url=getFile();
        if(url==null)
        {
            return;
        }
        FileOutputStream outs=null;
        try
        {   taikhoanBUS qltk=new taikhoanBUS();
             ArrayList<taikhoan> ds=qltk.getdstk();
            HSSFWorkbook workbook=new HSSFWorkbook();
            HSSFSheet sheet=workbook.createSheet("Tài khoản");
            int rownum=0;
            Row row=sheet.createRow(rownum);
            row.createCell(0,CellType.STRING).setCellValue("Mã tài khoản");
            row.createCell(1, CellType.STRING).setCellValue("Tên tài khoản");
            row.createCell(2, CellType.STRING).setCellValue("Mật khẩu");
            row.createCell(3,CellType.STRING).setCellValue("Mã nhân viên");
            row.createCell(4,CellType.NUMERIC).setCellValue("Mã quyền");
            
          for(taikhoan q:ds)
          {
              rownum++;
              row=sheet.createRow(rownum);
               row.createCell(0,CellType.STRING).setCellValue(q.getIdtaikhoan());
            row.createCell(1, CellType.STRING).setCellValue(q.getTentaikhoan());
            row.createCell(2, CellType.STRING).setCellValue(q.getMatkhau());
            row.createCell(3,CellType.STRING).setCellValue(q.getIdnhanvien());
            row.createCell(4,CellType.NUMERIC).setCellValue(q.getIdquyen());
            
          }
          for(int i=0;i<rownum;i++)
          {
              sheet.autoSizeColumn(i);
          }
          File file=new File(url);
          file.getParentFile().mkdir();
          outs=new FileOutputStream(file);
          workbook.write(outs);
         JOptionPane.showMessageDialog(null,"Đã tạo file ở: "+file.getAbsolutePath());
        }catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outs != null) {
                    outs.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void xuatfilequanlyloaimon()
    {
         fd.setTitle("Xuất file quản lý loại món");
        String url=getFile();
        if(url==null)
        {
            return;
        }
        FileOutputStream outs=null;
        try
        {   loaimonphuBUS lm=new loaimonphuBUS();
             ArrayList<loaimonphu> ds=lm.getlma();
            HSSFWorkbook workbook=new HSSFWorkbook();
            HSSFSheet sheet=workbook.createSheet("Loại món");
            int rownum=0;
            Row row=sheet.createRow(rownum);
            row.createCell(0,CellType.NUMERIC).setCellValue("Mã quyền");
            row.createCell(1, CellType.STRING).setCellValue("Tên loại");
           
          for(loaimonphu q:ds)
          {
              rownum++;
              row=sheet.createRow(rownum);
               row.createCell(0,CellType.NUMERIC).setCellValue(q.getId());
            row.createCell(1, CellType.STRING).setCellValue(q.getTenloai());
          
            
          }
          for(int i=0;i<rownum;i++)
          {
              sheet.autoSizeColumn(i);
          }
          File file=new File(url);
          file.getParentFile().mkdir();
          outs=new FileOutputStream(file);
          workbook.write(outs);
         JOptionPane.showMessageDialog(null,"Đã tạo file ở: "+file.getAbsolutePath());
        }catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outs != null) {
                    outs.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void xuatfilequanlynhanvien()
    {
         fd.setTitle("Xuất file quản lý nhân viên");
        String url=getFile();
        if(url==null)
        {
            return;
        }
        FileOutputStream outs=null;
        try
        {   nhanvienBUS qlnv=new nhanvienBUS();
             ArrayList<nhanvien> ds=qlnv.getdsnv();
            HSSFWorkbook workbook=new HSSFWorkbook();
            HSSFSheet sheet=workbook.createSheet("Nhân viên");
            int rownum=0;
            Row row=sheet.createRow(rownum);
            row.createCell(0,CellType.STRING).setCellValue("Mã nhân viên");
            row.createCell(1, CellType.STRING).setCellValue("Tên nhân viên");
            row.createCell(2, CellType.STRING).setCellValue("Điện thoại");
            row.createCell(3, CellType.STRING).setCellValue("Điện thoại");
            row.createCell(4, CellType.STRING).setCellValue("Ngày sinh");
            row.createCell(5, CellType.STRING).setCellValue("Địa chỉ");
          for(nhanvien q:ds)
          {
              rownum++;
              row=sheet.createRow(rownum);
               row.createCell(0,CellType.NUMERIC).setCellValue(q.getIdnhanvien());
            row.createCell(1, CellType.STRING).setCellValue(q.getTen());
            row.createCell(2, CellType.STRING).setCellValue(q.getSdt());
            row.createCell(3, CellType.STRING).setCellValue(String.valueOf(q.getNgaysinh()));
            row.createCell(4, CellType.STRING).setCellValue(q.getDiachi());
          }
          for(int i=0;i<rownum;i++)
          {
              sheet.autoSizeColumn(i);
          }
          File file=new File(url);
          file.getParentFile().mkdir();
          outs=new FileOutputStream(file);
          workbook.write(outs);
         JOptionPane.showMessageDialog(null,"Đã tạo file ở: "+file.getAbsolutePath());
        }catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outs != null) {
                    outs.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void xuatfilequanlythuckhach()
    {
          fd.setTitle("Xuất file quản lý thực khách");
        String url=getFile();
        if(url==null)
        {
            return;
        }
        FileOutputStream outs=null;
        try
        {   nhanvienBUS qlnv=new nhanvienBUS();
             ArrayList<nhanvien> ds=qlnv.getdsnv();
            HSSFWorkbook workbook=new HSSFWorkbook();
            HSSFSheet sheet=workbook.createSheet("Nhân viên");
            int rownum=0;
            Row row=sheet.createRow(rownum);
            row.createCell(0,CellType.STRING).setCellValue("Mã nhân viên");
            row.createCell(1, CellType.STRING).setCellValue("Tên nhân viên");
            row.createCell(2, CellType.STRING).setCellValue("Điện thoại");
            row.createCell(3, CellType.STRING).setCellValue("Điện thoại");
            row.createCell(4, CellType.STRING).setCellValue("Ngày sinh");
            row.createCell(5, CellType.STRING).setCellValue("Địa chỉ");
          for(nhanvien q:ds)
          {
              rownum++;
              row=sheet.createRow(rownum);
               row.createCell(0,CellType.NUMERIC).setCellValue(q.getIdnhanvien());
            row.createCell(1, CellType.STRING).setCellValue(q.getTen());
            row.createCell(2, CellType.STRING).setCellValue(q.getSdt());
            row.createCell(3, CellType.STRING).setCellValue(String.valueOf(q.getNgaysinh()));
            row.createCell(4, CellType.STRING).setCellValue(q.getDiachi());
          }
          for(int i=0;i<rownum;i++)
          {
              sheet.autoSizeColumn(i);
          }
          File file=new File(url);
          file.getParentFile().mkdir();
          outs=new FileOutputStream(file);
          workbook.write(outs);
         JOptionPane.showMessageDialog(null,"Đã tạo file ở: "+file.getAbsolutePath());
        }catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outs != null) {
                    outs.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }
    public void xuatfilequanlyhoadon()
    {
        fd.setTitle("Xuất file quản lý hóa đơn");
        String url=getFile();
        if(url==null)
        {
            return;
        }
        FileOutputStream outs=null;
        try
        {   hoadonBUS qlhd=new hoadonBUS();
             ArrayList<hoadon> ds=qlhd.gethoadon();
            HSSFWorkbook workbook=new HSSFWorkbook();
            HSSFSheet sheet=workbook.createSheet("Hóa đơn");
            int rownum=0;
            Row row=sheet.createRow(rownum);
            row.createCell(0,CellType.STRING).setCellValue("Mã hóa đơn");
            row.createCell(1, CellType.NUMERIC).setCellValue("Mã bàn");
            row.createCell(2, CellType.STRING).setCellValue("Ngày xuất");
            row.createCell(3, CellType.STRING).setCellValue("Mã thực khách");
            row.createCell(4, CellType.STRING).setCellValue("Giờ xuất");
            row.createCell(5, CellType.STRING).setCellValue("Mã nhân viên");  
          row.createCell(6,CellType.NUMERIC).setCellValue("Tổng tiền");
          for(hoadon q:ds)
          {
              rownum++;
              row=sheet.createRow(rownum);
               row.createCell(0,CellType.STRING).setCellValue(q.getIdhoadon());
            row.createCell(1, CellType.NUMERIC).setCellValue(q.getIdban());
            row.createCell(2, CellType.STRING).setCellValue(String.valueOf(q.getNgayxuat()));
            row.createCell(3, CellType.STRING).setCellValue(q.getIdthuckhach());
            row.createCell(4, CellType.STRING).setCellValue(String.valueOf(q.getGioxuat()));
            row.createCell(5,CellType.STRING).setCellValue(q.getIdnhanvien());
            row.createCell(6,CellType.NUMERIC).setCellValue(q.getTongtien());
          }
          for(int i=0;i<rownum;i++)
          {
              sheet.autoSizeColumn(i);
          }
          File file=new File(url);
          file.getParentFile().mkdir();
          outs=new FileOutputStream(file);
          workbook.write(outs);
         JOptionPane.showMessageDialog(null,"Đã tạo file ở: "+file.getAbsolutePath());
        }catch (IOException ex) {
            Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (outs != null) {
                    outs.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(XuatExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
