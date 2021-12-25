/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlyphanquyen;

import java.util.*;
public class phanquyen {
    
   private int maquyen;
   private String tenquyen;
   private String ghichu;
   public phanquyen()
   {
       
   }
   public phanquyen(int maquyen,String tenquyen,String ghichu)
   {
       this.maquyen=maquyen;
       this.tenquyen=tenquyen;
       this.ghichu=ghichu;
   }

    /**
     * @return the maquyen
     */
    public int getMaquyen() {
        return maquyen;
    }

    /**
     * @param maquyen the maquyen to set
     */
    public void setMaquyen(int maquyen) {
        this.maquyen = maquyen;
    }

    /**
     * @return the tenquyen
     */
    public String getTenquyen() {
        return tenquyen;
    }

    /**
     * @param tenquyen the tenquyen to set
     */
    public void setTenquyen(String tenquyen) {
        this.tenquyen = tenquyen;
    }

    /**
     * @return the ghichu
     */
    public String getGhichu() {
        return ghichu;
    }

    /**
     * @param ghichu the ghichu to set
     */
    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }
   
}
