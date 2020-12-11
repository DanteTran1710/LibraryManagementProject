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
    private String userName;
    private String object;
    private String objectName;
    private int book;
    private String borrowDate;
    private String returnDate;
    private int stolenBook;
    private int tornBook;
    private double fine;

    public ReturnInfor(String id, String userName, String object, String objectName, int book, String borrowDate, String returnDate, int stolenBook, int tornBook, double fine) {
        this.id = id;
        this.userName = userName;
        this.object = object;
        this.objectName = objectName;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.stolenBook = stolenBook;
        this.tornBook = tornBook;
        this.fine = fine;
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
    public double getFine() {
        return fine;
    }

    /**
     * @param fine the fine to set
     */
    public void setFine(double fine) {
        this.fine = fine;
    }
    

            
}
