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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author hp
 */
public class ReturnInfor {
    private String id;
    private String idMC;
    private String object;
    private String objectName;
    private int book;
    private String borrowDate;
    private String returnDate;
    private int stolenBook;
    private int tornBook;

    public ReturnInfor(String id, String idMC, String object, String objectName, int book, String borrowDate, String returnDate, int stolenBook, int tornBook) {
        this.id = id;
        this.idMC = idMC;
        this.object = object;
        this.objectName = objectName;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.stolenBook = stolenBook;
        this.tornBook = tornBook;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
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
     * @return the objectName
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * @param objectName the objectName to set
     */
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    /**
     * @return the book
     */
    public int getBook() {
        return book;
    }

    /**
     * @param book the book to set
     */
    public void setBook(int book) {
        this.book = book;
    }

    /**
     * @return the borrowDate
     */
    public String getBorrowDate() {
        return borrowDate;
    }

    /**
     * @param borrowDate the borrowDate to set
     */
    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    /**
     * @return the returnDate
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * @return the stolenBook
     */
    public int getStolenBook() {
        return stolenBook;
    }

    /**
     * @param stolenBook the stolenBook to set
     */
    public void setStolenBook(int stolenBook) {
        this.stolenBook = stolenBook;
    }

    /**
     * @return the tornBook
     */
    public int getTornBook() {
        return tornBook;
    }

    /**
     * @param tornBook the tornBook to set
     */
    public void setTornBook(int tornBook) {
        this.tornBook = tornBook;
    }

    /**
     * @return the fine
     */
}