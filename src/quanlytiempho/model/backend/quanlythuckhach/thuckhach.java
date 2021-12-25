/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlythuckhach;
import java.util.*;
import java.time.LocalTime;
public class thuckhach {
    private String idthuckhach;
    private int idban;
    private String loaithuckhach;
    private LocalTime giovao;
    public thuckhach()
    {
        giovao=LocalTime.now();
    }
    public thuckhach(String idthuckhach,int idban,String loaithuckhach,LocalTime giovao)
    {
        this.idthuckhach=idthuckhach;
        this.idban=idban;
        this.loaithuckhach=loaithuckhach;
        this.giovao=giovao;
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
     * @return the loaithuckhach
     */
    public String getLoaithuckhach() {
        return loaithuckhach;
    }

    /**
     * @param loaithuckhach the loaithuckhach to set
     */
    public void setLoaithuckhach(String loaithuckhach) {
        this.loaithuckhach = loaithuckhach;
    }

    /**
     * @return the giovao
     */
    public LocalTime getGiovao() {
        return giovao;
    }

    /**
     * @param giovao the giovao to set
     */
    public void setGiovao(LocalTime giovao) {
        this.giovao = giovao;
    }
    
}
