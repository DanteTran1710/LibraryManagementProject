/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement.pojo;

/**
 *
 * @author thinh
 */
public class User {
    private String maDocGia;
    private String tenDocGia;
    private String Gmail;
    private String diaChi;
    private String gioiTinh;
    private String SDT;
    private String boPhan;
    private String doiTuong;

    public User(String maDocGia, String tenDocGia, String Gmail, String diaChi, String gioiTinh, String SDT, String boPhan, String doiTuong) {
        this.maDocGia = maDocGia;
        this.tenDocGia = tenDocGia;
        this.Gmail = Gmail;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.boPhan = boPhan;
        this.doiTuong= doiTuong;
    }

    /**
     * @return the maDocGia
     */
    public String getMaDocGia() {
        return maDocGia;
    }

    /**
     * @param maDocGia the maDocGia to set
     */
    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    /**
     * @return the tenDocGia
     */
    public String getTenDocGia() {
        return tenDocGia;
    }

    /**
     * @param tenDocGia the tenDocGia to set
     */
    public void setTenDocGia(String tenDocGia) {
        this.tenDocGia = tenDocGia;
    }

    /**
     * @return the Gmail
     */
    public String getGmail() {
        return Gmail;
    }

    /**
     * @param Gmail the Gmail to set
     */
    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the SDT
     */
    public String getSDT() {
        return SDT;
    }

    /**
     * @param SDT the SDT to set
     */
    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    /**
     * @return the boPhan
     */
    public String getBoPhan() {
        return boPhan;
    }

    /**
     * @param boPhan the boPhan to set
     */
    public void setBoPhan(String boPhan) {
        this.boPhan = boPhan;
    }

    /**
     * @return the doiTuong
     */
    public String getDoiTuong() {
        return doiTuong;
    }

    /**
     * @param doiTuong the doiTuong to set
     */
    public void setDoiTuong(String doiTuong) {
        this.doiTuong = doiTuong;
    }
    
}
