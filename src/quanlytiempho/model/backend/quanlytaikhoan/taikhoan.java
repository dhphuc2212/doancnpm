/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlytaikhoan;
import java.util.*;
public class taikhoan {
    private String idtaikhoan;
    private String tentaikhoan;
    private String matkhau;
    private String idnhanvien;
    private int idquyen;
    public taikhoan()
    {
        
    }
    public taikhoan(String idtaikhoan,String tentaikhoan,String matkhau,String idnhanvien,int idquyen)
    {
        this.idtaikhoan=idtaikhoan;
        this.tentaikhoan=tentaikhoan;
        this.idnhanvien=idnhanvien;
        this.idquyen=idquyen;
        this.matkhau=matkhau;
    }

    /**
     * @return the idtaikhoan
     */
    public String getIdtaikhoan() {
        return idtaikhoan;
    }

    /**
     * @param idtaikhoan the idtaikhoan to set
     */
    public void setIdtaikhoan(String idtaikhoan) {
        this.idtaikhoan = idtaikhoan;
    }

    /**
     * @return the tentaikhoan
     */
    public String getTentaikhoan() {
        return tentaikhoan;
    }

    /**
     * @param tentaikhoan the tentaikhoan to set
     */
    public void setTentaikhoan(String tentaikhoan) {
        this.tentaikhoan = tentaikhoan;
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
     * @return the idquyen
     */
    public int getIdquyen() {
        return idquyen;
    }

    /**
     * @param idquyen the idquyen to set
     */
    public void setIdquyen(int idquyen) {
        this.idquyen = idquyen;
    }

    /**
     * @return the matkhau
     */
    public String getMatkhau() {
        return matkhau;
    }
    public void setMatkhau(String matkhau)
    {
        this.matkhau=matkhau;
    }
    
}
