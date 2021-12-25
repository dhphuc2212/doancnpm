/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlyto;
import java.util.*;
import java.time.LocalTime;
public class topho {
    private int idto;
    private String loaithit;
    private String loaito;
    private String idthuckhach;
    private double giatien;
    private LocalTime giodat;
    public topho(int idto,String loaithit,String loaito,String idthuckhach,double giatien,LocalTime giodat)
    {
        this.idto=idto;
        this.loaithit=loaithit;
        this.loaito=loaito;
        this.idthuckhach=idthuckhach;
        this.giatien=giatien;
        this.giodat=giodat;
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
     * @return the idloaithit
     */
    public String getloaithit() {
        return loaithit;
    }

    /**
     * @param idloaithit the idloaithit to set
     */
    public void setloaithit(String loaithit) {
        this.loaithit = loaithit;
    }

    /**
     * @return the loaito
     */
    public String getLoaito() {
        return loaito;
    }

    /**
     * @param loaito the loaito to set
     */
    public void setLoaito(String loaito) {
        this.loaito = loaito;
    }

    /**
     * @return the idmonphu
     */
    public String getIdthuckhach() {
        return idthuckhach;
    }

    /**
     * @param idmonphu the idmonphu to set
     */
    public void setIdthuckhach(String idthuckhach) {
        this.idthuckhach = idthuckhach;
    }

    /**
     * @return the giatien
     */
    public double getGiatien() {
        return giatien;
    }

    /**
     * @param giatien the giatien to set
     */
    public void setGiatien(double giatien) {
        this.giatien = giatien;
    }
    public LocalTime getgiodat()
    {
        return giodat;
    }
    public void setgiodat(LocalTime giodat)
    {
        this.giodat=giodat;
    }
    
}
