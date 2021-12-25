/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlyhoadon;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
public class hoadon {
    
    private String idhoadon;
    private int idban;
    private LocalDate ngayxuat;
    private String idthuckhach;
    private LocalTime gioxuat;
    private String idnhanvien;
    private double tongtien;
   
   public hoadon()
   {
       
   }
   public hoadon(String idhoadon,int idban,LocalDate ngayxuat,String idthuckhach,LocalTime gioxuat,String idnhanvien,double tongtien)
   {
       this.idhoadon=idhoadon;
       this.idban=idban;
       this.ngayxuat=ngayxuat;
       this.idthuckhach=idthuckhach;
       this.gioxuat=gioxuat;
       this.idnhanvien=idnhanvien;
       this.tongtien=tongtien;
   }

    /**
     * @return the idhoadon
     */
    public String getIdhoadon() {
        return idhoadon;
    }

    /**
     * @param idhoadon the idhoadon to set
     */
    public void setIdhoadon(String idhoadon) {
        this.idhoadon = idhoadon;
    }

    /**
     * @return the idban
     */
    public int getIdban() {
        return idban;
    }

    /**
     * @param idban the idban to set
     */
    public void setIdban(int idban) {
        this.idban = idban;
    }

    /**
     * @return the ngayxuat
     */
    public LocalDate getNgayxuat() {
        return ngayxuat;
    }

    /**
     * @param ngayxuat the ngayxuat to set
     */
    public void setNgayxuat(LocalDate ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    /**
     * @return the idthuckhach
     */
    public String getIdthuckhach() {
        return idthuckhach;
    }

    /**
     * @param idthuckhach the idthuckhach to set
     */
    public void setIdthuckhach(String idthuckhach) {
        this.idthuckhach = idthuckhach;
    }

    /**
     * @return the gioxuat
     */
    public LocalTime getGioxuat() {
        return gioxuat;
    }

    /**
     * @param gioxuat the gioxuat to set
     */
    public void setGioxuat(LocalTime gioxuat) {
        this.gioxuat = gioxuat;
    }

    /**
     * @return the idnhanvien
     */
    public String getIdnhanvien() {
        return idnhanvien;
    }

    /**
     * @param idnhanvien the idnhanvien to set
     */
    public void setIdnhanvien(String idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    /**
     * @return the tongtien
     */
    public double getTongtien() {
        return tongtien;
    }

    /**
     * @param tongtien the tongtien to set
     */
    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }
   
}
