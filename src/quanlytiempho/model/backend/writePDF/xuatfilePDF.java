/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.writePDF;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import static com.itextpdf.text.pdf.PdfFileSpecification.url;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
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
import java.awt.FileDialog;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
public class xuatfilePDF {
    Document document;
    FileOutputStream ous;
    Font fontdata;
    Font fonttitle;
    Font fontheader;
    FileDialog fd = new FileDialog(new JFrame(), "Xu???t pdf", FileDialog.LOAD);
    public xuatfilePDF()
    {
         try {
            fontdata = new Font(BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
            fonttitle = new Font(BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontheader = new Font(BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 13, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(xuatfilePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setTitle(String title)
    {
        try
        {
            Paragraph pdftitle=new Paragraph(new Phrase(title,fonttitle));
            pdftitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdftitle);
            document.add(Chunk.NEWLINE); 
        }
        catch (DocumentException ex) {
//            JOptionPane.showMessageDialog(null, "Khong goi duoc document !");
            ex.printStackTrace();
        }
    }
   private String getfile()
   {   fd.setDirectory("C:\\xampp\\htdocs\\Quanlytiempho\\quanlytiempho\\src");
       fd.setFile("file.pdf");
       fd.setVisible(true);
       String url=fd.getDirectory()+fd.getFile();
       if(url.equals("nullnull"))
       {
           return null;
       }
       return url;
   }
   public void writehoadon(String mahd) throws DocumentException, FileNotFoundException
   {
       
       String url="";
       fd.setTitle("In file pdf h??a ????n");
       url=getfile();
       if(url.equals("null"))
       {
           return;
       }
       ous=new FileOutputStream(url);
       document=new Document();
       
       PdfWriter writer = PdfWriter.getInstance(document,ous);
       document.open();
       setTitle("Hi???n th??? th??ng tin h??a ????n");
       hoadonBUS qlhd=new hoadonBUS();
       hoadon h=qlhd.gethoadon(mahd);
       chitiethoadonBUS cthd=new chitiethoadonBUS();
       Chunk chunk=new Chunk(new VerticalPositionMark());
       Paragraph idhoadon=new Paragraph(new Phrase("M?? h??a ????n:"+mahd,fontdata));
       Paragraph maban=new Paragraph();
       maban.setFont(fontdata);
       maban.add(String.valueOf("M?? b??n:"+String.valueOf(h.getIdban())));
       maban.add(chunk);
       maban.add(String.valueOf("Ng??y xu???t:"+String.valueOf(h.getNgayxuat())));
       Paragraph idnhanvien=new Paragraph();
       idnhanvien.setFont(fontdata);
       idnhanvien.add(String.valueOf("M?? nh??n vi??n:"+String.valueOf(h.getIdnhanvien())));
       idnhanvien.add(chunk);
       idnhanvien.add(String.valueOf("Gi??? xu???t:")+String.valueOf(h.getGioxuat()));
       Paragraph idthuckhach=new Paragraph();
       idthuckhach.setFont(fontdata);
       idthuckhach.add(String.valueOf("M?? th???c kh??ch:"+String.valueOf(h.getIdthuckhach())));
       idthuckhach.add(chunk);
       idthuckhach.add(String.valueOf("T???ng ti???n:"+String.valueOf((int)h.getTongtien())+"??"));
       document.add(idhoadon);
       document.add(maban);
       document.add(idnhanvien);
       document.add(idthuckhach);
       document.add(Chunk.NEWLINE);
       PdfPTable table=new PdfPTable(6);
       table.addCell(new PdfPCell(new Phrase("M?? t??",fontheader)));
       table.addCell(new PdfPCell(new Phrase("Lo???i t??",fontheader)));
       table.addCell(new PdfPCell(new Phrase("????n gi??",fontheader)));
       table.addCell(new PdfPCell(new Phrase("T??n m??n ph???",fontheader)));
       table.addCell(new PdfPCell(new Phrase("S??? l?????ng m??n ph???",fontheader)));
       table.addCell(new PdfPCell(new Phrase("????n gi?? m??n ph???",fontheader)));
       for(int i=0;i<6;i++)
       {
           table.addCell(new PdfPCell(new Phrase("")));
       }
       for (chitiethoadon t : cthd.gethoadon1(mahd))
       {
           int mato=t.getIdto();
           String loaito=t.getLoaito();
           double dongia=t.getDongiato();
           String tenmonphu=t.getTenmonphu();
           int slmp=t.getSoluongmp();
           double dgmp=t.getDongiamonphu();
         table.addCell(new PdfPCell(new Phrase(String.valueOf(mato),fontdata)));
         table.addCell(new PdfPCell(new Phrase(loaito,fontdata)));
         table.addCell(new PdfPCell(new Phrase(String.valueOf((int)dongia)+"??",fontdata)));
         table.addCell(new PdfPCell(new Phrase(tenmonphu,fontdata)));
         table.addCell(new PdfPCell(new Phrase(String.valueOf(slmp),fontdata)));
         table.addCell(new PdfPCell(new Phrase(String.valueOf((int)dgmp)+"??",fontdata)));
       }
       document.add(table);
       document.add(Chunk.NEWLINE);
       document.close();
       JOptionPane.showMessageDialog(null,"Ghi file th??nh c??ng ???:"+url);

   }
       public void closeFile() {
        document.close();
    }
   
   
}

