/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement.pojo;

import java.util.Date;

/**
 *
 * @author hp
 */
public class LibaryCard {
    private int idLC;
    private int idB;
    private int idMC;
    private Date returnDate;
    private int lateDay;
    private float lateDateMoney; 

    public LibaryCard(int idLC, int idB, int idMC, Date returnDate, int lateDay, float lateDateMoney) {
        this.idLC = idLC;
        this.idB = idB;
        this.idMC = idMC;
        this.returnDate = returnDate;
        this.lateDay = lateDay;
        this.lateDateMoney = lateDateMoney;
    }

    /**
     * @return the idLC
     */
    public int getIdLC() {
        return idLC;
    }

    /**
     * @param idLC the idLC to set
     */
    public void setIdLC(int idLC) {
        this.idLC = idLC;
    }

    /**
     * @return the idB
     */
    public int getIdB() {
        return idB;
    }

    /**
     * @param idB the idB to set
     */
    public void setIdB(int idB) {
        this.idB = idB;
    }

    /**
     * @return the idMC
     */
    public int getIdMC() {
        return idMC;
    }

    /**
     * @param idMC the idMC to set
     */
    public void setIdMC(int idMC) {
        this.idMC = idMC;
    }

    /**
     * @return the returnDate
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * @return the lateDay
     */
    public int getLateDay() {
        return lateDay;
    }

    /**
     * @param lateDay the lateDay to set
     */
    public void setLateDay(int lateDay) {
        this.lateDay = lateDay;
    }

    /**
     * @return the lateDateMoney
     */
    public float getLateDateMoney() {
        return lateDateMoney;
    }

    /**
     * @param lateDateMoney the lateDateMoney to set
     */
    public void setLateDateMoney(float lateDateMoney) {
        this.lateDateMoney = lateDateMoney;
    }
}
