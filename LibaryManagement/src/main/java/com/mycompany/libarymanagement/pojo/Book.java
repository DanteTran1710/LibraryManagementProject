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
public class Book {
    private int idB;
    private String nameB;
    private String authorName;
    private String Descriptions;
    private Date release;
    private String releasePlace;

    public Book(int idB, String nameB, String authorName, String Descriptions, Date release, String releasePlace) {
        this.idB = idB;
        this.nameB = nameB;
        this.authorName = authorName;
        this.Descriptions = Descriptions;
        this.release = release;
        this.releasePlace = releasePlace;
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
    public String getDescriptions() {
        return Descriptions;
    }

    /**
     * @param Descriptions the Descriptions to set
     */
    public void setDescriptions(String Descriptions) {
        this.Descriptions = Descriptions;
    }

    /**
     * @return the release
     */
    public Date getRelease() {
        return release;
    }

    /**
     * @param release the release to set
     */
    public void setRelease(Date release) {
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
}
