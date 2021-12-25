/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlyban;

import java.util.*;
public class ban {
    private int idban;
    private String loaiban;
    private String trangthai;
    public ban()
    {
        
    }
    public ban(int idban,String loaiban,String trangthai)
    {
        this.idban=idban;
        this.loaiban=loaiban;
        this.trangthai=trangthai;
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
     * @return the loaiban
     */
    public String getLoaiban() {
        return loaiban;
    }

    /**
     * @param loaiban the loaiban to set
     */
    public void setLoaiban(String loaiban) {
        this.loaiban = loaiban;
    }

    /**
     * @return the sobanlon
     */
   

    /**
     * @return the sobannho
     */
  

    /**
     * @return the trangthai
     */
    public String getTrangthai() {
        return trangthai;
    }

    /**
     * @param trangthai the trangthai to set
     */
    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    
}
