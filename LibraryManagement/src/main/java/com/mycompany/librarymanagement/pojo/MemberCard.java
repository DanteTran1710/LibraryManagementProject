/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.pojo;

/**
 *
 * @author hp
 */
public class MemberCard {

    /**
     * @return the stateCard
     */

    private String userName;
    private String passWord;
    private String memberName;
    private String DOB;
    private String object;
    private String stateCard;
    private String gmail;
    private String sex;
    private String phoneNum;
    private String major;

    public MemberCard(String userName, String passWord, String memberName, String DOB, String object, String stateCard, String gmail, String sex, String phoneNum, String major) {
        this.userName = userName;
        this.passWord = passWord;
        this.memberName = memberName;
        this.DOB = DOB;
        this.object = object;
        this.stateCard = stateCard;
        this.gmail = gmail;
        this.sex = sex;
        this.phoneNum = phoneNum;
        this.major = major;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the passWord
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * @param passWord the passWord to set
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
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

    /**
     * @return the stateCard
     */
    public String getStateCard() {
        return stateCard;
    }

    /**
     * @param stateCard the stateCard to set
     */
    public void setStateCard(String stateCard) {
        this.stateCard = stateCard;
    }

    /**
     * @return the gmail
     */
    public String getGmail() {
        return gmail;
    }

    /**
     * @param gmail the gmail to set
     */
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the phoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * @param phoneNum the phoneNum to set
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

}
