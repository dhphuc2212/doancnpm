/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlychitietmonphu;

import java.util.*;
public class chitietmonphu {
    private int id;
    private int idto;
    private int idmonphu;
    public chitietmonphu()
    {
        
    }
    public chitietmonphu(int id,int idto,int idmonphu)
    {
        this.id=id;
        this.idto=idto;
        this.idmonphu=idmonphu;
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
    
}
