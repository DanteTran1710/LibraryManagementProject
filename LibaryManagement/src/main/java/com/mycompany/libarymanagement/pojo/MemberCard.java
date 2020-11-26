/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.libarymanagement.pojo;

/**
 *
 * @author hp
 */
public class MemberCard {

    /**
     * @return the stateCard
     */

    private String idMC;
    private String memberName;
    private String DOB;
    private String object;
    private String stateCard;

    public MemberCard(String idMC, String memberName, String DOB, String object, String stateCard) {
        this.idMC = idMC;
        this.memberName = memberName;
        this.DOB = DOB;
        this.object = object;
        this.stateCard = stateCard;
    }
    
    /**
     * @return the idMC
     */
    public String getIdMC() {
        return idMC;
    }

    /**
     * @param idMC the idMC to set
     */
    public void setIdMC(String idMC) {
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
    public String getDOB() {
        return DOB;
    }

    /**
     * @param DOB the DOB to set
     */
    public void setDOB(String DOB) {
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

    public String getStateCard() {
        return stateCard;
    }

    /**
     * @param stateCard the stateCard to set
     */
    public void setStateCard(String stateCard) {
        this.stateCard = stateCard;
    }
}
