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
public class MemberCard {
    private int idMC;
    private String memberName;
    private Date DOB;
    private String object;

    public MemberCard(int idMC, String memberName, Date DOB, String object) {
        this.idMC = idMC;
        this.memberName = memberName;
        this.DOB = DOB;
        this.object = object;
    }

    @Override
    public String toString() {
        return this.object; //To change body of generated methods, choose Tools | Templates.
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
     * @return the memberName
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * @param memberName the memberName to set
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * @return the DOB
     */
    public Date getDOB() {
        return DOB;
    }

    /**
     * @param DOB the DOB to set
     */
    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    /**
     * @return the object
     */
    public String getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(String object) {
        this.object = object;
    }
}
