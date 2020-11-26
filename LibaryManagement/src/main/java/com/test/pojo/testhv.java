package com.test.pojo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thinh
 */
public class testhv {
    private int idhv;
    private String ten;
    private String sdt;
    public testhv(int idhv, String ten, String sdt){
        this.idhv = idhv;
        this.ten = ten;
        this.sdt = sdt;
    }

    /**
     * @return the idhv
     */
    public int getIdhv() {
        return idhv;
    }

    /**
     * @param idhv the idhv to set
     */
    public void setIdhv(int idhv) {
        this.idhv = idhv;
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
    
}
