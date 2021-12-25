/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlychitiethoadon;
import java.util.*;
public class chitiethoadon {
    
    private String idchitiethoadon;
    private String idhoadon;
    private int idto;
    private String tenmonphu;
    private String loaito;
    private double dongia;
    private double dongiamonphu;
    private int soluongmp;
   public chitiethoadon()
   {
       
   }
   public chitiethoadon(String idchitiethoadon,String idhoadon,int idto,String loaito,double dongia,String tenmonphu,int soluongmp,double dongiamonphu)
   {
       this.idchitiethoadon=idchitiethoadon;
       this.idhoadon=idhoadon;
       this.idto=idto;
       this.loaito=loaito;
       this.dongia=dongia;
       this.tenmonphu=tenmonphu;
       this.dongiamonphu=dongiamonphu;
       this.soluongmp=soluongmp;
   }

    /**
     * @return the idchitiethoadon
     */
    public String getIdchitiethoadon() {
        return idchitiethoadon;
    }

    /**
     * @param idchitiethoadon the idchitiethoadon to set
     */
    public void setIdchitiethoadon(String idchitiethoadon) {
        this.idchitiethoadon = idchitiethoadon;
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
     * @return the idto
     */
    public int getIdto() {
        return idto;
    }

    /**
     * @param idto the idto to set
     */
    public void setIdto(int idto) {
        this.idto = idto;
    }

    /**
     * @return the tenmonphu
     */
    public String getTenmonphu() {
        return tenmonphu;
    }

    /**
     * @param tenmonphu the tenmonphu to set
     */
    public void setTenmonphu(String tenmonphu) {
        this.tenmonphu = tenmonphu;
    }

    /**
     * @return the loaito
     */
    public String getLoaito() {
        return loaito;
    }

    /**
     
     */
    public void setLoaito(String loaito) {
        this.loaito = loaito;
    }

    /**
     * @return the dongiato
     */
    public double getDongiato() {
        return dongia;
    }

    /**
     * @param dongiato the dongiato to set
     */
    public void setDongiato(double dongiato) {
        this.dongia = dongiato;
    }

    /**
     * @return the dongiamonphu
     */
    public double getDongiamonphu() {
        return dongiamonphu;
    }

    /**
     * @param dongiamonphu the dongiamonphu to set
     */
    public void setDongiamonphu(double dongiamonphu) {
        this.dongiamonphu = dongiamonphu;
    }

    /**
     * @return the soluongmp
     */
    public int getSoluongmp() {
        return soluongmp;
    }

    /**
     * @param soluongmp the soluongmp to set
     */
    public void setSoluongmp(int soluongmp) {
        this.soluongmp = soluongmp;
    }


   
}
