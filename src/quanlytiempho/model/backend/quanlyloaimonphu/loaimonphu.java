/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlyloaimonphu;

import java.util.*;
public class loaimonphu {
    private int id;
    private String tenloai;
    public loaimonphu()
    {
        
    }
    public loaimonphu(int id,String tenloai)
    {
        this.id=id;
        this.tenloai=tenloai;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tenloai
     */
    public String getTenloai() {
        return tenloai;
    }

    /**
     * @param tenloai the tenloai to set
     */
    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }
    
}
