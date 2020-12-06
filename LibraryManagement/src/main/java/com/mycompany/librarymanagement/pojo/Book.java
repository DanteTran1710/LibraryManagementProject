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
    private String Description;
    private String release;
    private String releasePlace;
    private String state;
    private String category;

    public Book(String idB, String nameB, String authorName, String Description, String release, String releasePlace, String state, String category) {
        this.idB = idB;
        this.nameB = nameB;
        this.authorName = authorName;
        this.Description = Description;
        this.release = release;
        this.releasePlace = releasePlace;
        this.state = state;
        this.category = category;
    }

    public Book(String idB, String nameB, String authorName) {
        this.idB = idB;
        this.nameB = nameB;
        this.authorName = authorName;
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
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
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

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
}