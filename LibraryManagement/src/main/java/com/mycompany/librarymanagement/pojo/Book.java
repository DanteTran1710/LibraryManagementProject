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
public class Book {
    private String idB;
    private String nameB;
    private String authorName;
    private String Decriptions;
    private String release;
    private String releasePlace;
    private String state;

    public Book(String idB, String nameB, String authorName, String Decriptions, String release, String releasePlace, String state) {
        this.idB = idB;
        this.nameB = nameB;
        this.authorName = authorName;
        this.Decriptions = Decriptions;
        this.release = release;
        this.releasePlace = releasePlace;
        this.state = state;
    }

    /**
     * @return the idB
     */
    public String getIdB() {
        return idB;
    }

    /**
     * @param idB the idB to set
     */
    public void setIdB(String idB) {
        this.idB = idB;
    }

    /**
     * @return the nameB
     */
    public String getNameB() {
        return nameB;
    }

    /**
     * @param nameB the nameB to set
     */
    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    /**
     * @return the authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName the authorName to set
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /**
     * @return the Descriptions
     */
    public String getDecriptions() {
        return Decriptions;
    }

    /**
     * @param Descriptions the Descriptions to set
     */
    public void setDecriptions(String Descriptions) {
        this.Decriptions = Descriptions;
    }

    /**
     * @return the release
     */
    public String getRelease() {
        return release;
    }

    /**
     * @param release the release to set
     */
    public void setRelease(String release) {
        this.release = release;
    }

    /**
     * @return the releasePlace
     */
    public String getReleasePlace() {
        return releasePlace;
    }

    /**
     * @param releasePlace the releasePlace to set
     */
    public void setReleasePlace(String releasePlace) {
        this.releasePlace = releasePlace;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

}
