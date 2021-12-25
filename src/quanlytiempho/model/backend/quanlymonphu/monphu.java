/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlymonphu;

import java.util.*;
public class monphu {
    private int idmonphu;
    private String tenmonphu;
    private float giatien;
    private int idloaimonphu;
    public monphu()
    {
        
    }
    public monphu(int idmonphu,String tenmonphu,float giatien,int idloaimonphu)
    {
        this.idloaimonphu=idmonphu;
        this.tenmonphu=tenmonphu;
        this.giatien=giatien;
        this.idloaimonphu=idloaimonphu;
    }

    /**
     * @return the idmonphu
     */
    public int getIdmonphu() {
        return idmonphu;
    }

    /**
     * @param idmonphu the idmonphu to set
     */
    public void setIdmonphu(int idmonphu) {
        this.idmonphu = idmonphu;
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
     * @return the giatien
     */
    public float getGiatien() {
        return giatien;
    }

    /**
     * @param giatien the giatien to set
     */
    public void setGiatien(float giatien) {
        this.giatien = giatien;
    }

    /**
     * @return the idloaimonphu
     */
    public int getIdloaimonphu() {
        return idloaimonphu;
    }

    /**
     * @param idloaimonphu the idloaimonphu to set
     */
    public void setIdloaimonphu(int idloaimonphu) {
        this.idloaimonphu = idloaimonphu;
    }
    
}
