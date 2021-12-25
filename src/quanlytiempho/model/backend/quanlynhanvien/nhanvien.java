/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlytiempho.model.backend.quanlynhanvien;

import java.util.*;
import java.time.LocalDate;
public class nhanvien {
    private String idnhanvien;
    private String ten;
    private String sdt;
    private LocalDate ngaysinh;
    private String diachi;
    public nhanvien()
    {
        
    }
    public nhanvien(String idnhanvien,String ten,String sdt,LocalDate ngaysinh,String diachi)
    {
        this.idnhanvien=idnhanvien;
        this.ten=ten;
        this.sdt=sdt;
        this.ngaysinh=ngaysinh;
        this.diachi=diachi;
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
     * @return the ten
     */
    public String getTen() {
        return ten;
    }

    /**
     * @param ten the ten to set
     */
    public void setTen(String ten) {
        this.ten = ten;
    }

    /**
     * @return the sdt
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * @param sdt the sdt to set
     */
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    /**
     * @return the ngaysinh
     */
    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    /**
     * @param ngaysinh the ngaysinh to set
     */
    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    /**
     * @return the diachi
     */
    public String getDiachi() {
        return diachi;
    }

    /**
     * @param diachi the diachi to set
     */
    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
