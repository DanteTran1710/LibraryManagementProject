package com.mycompany.librarymanagement.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */

// Tao ma id
public class MethodNeeded {
    public static String createUUID(){
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().substring(0,5);
        return id;
    }
    
    public static String editFormmatDate(DatePicker date){
        String format = "dd/MM/yyyy";
        date.setPromptText(format);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        StringConverter converter = new LocalDateStringConverter(dtf, null);
        date.setConverter(converter);
       
        return date.getEditor().getText();
    }
    public static void addSpinnerValue(Spinner s){
        SpinnerValueFactory<Integer> value = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        s.setValueFactory(value);
    }
    
    public static long caculateDate(String beginDate, String endDate){
        long result = 0;
                
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date borrowDate = dayFormat.parse(beginDate);
            Date returnDate;
            
            if(endDate.equals(""))
                returnDate = dayFormat.parse("01/01/2020");
            else 
                 returnDate = dayFormat.parse(endDate);
            
            long borrowDay = borrowDate.getTime();
            long returnDay = returnDate.getTime();
            
            result = Math.abs(returnDay - borrowDay)/(24*60*60*1000);
            
        } catch (ParseException ex) {
            Logger.getLogger(MethodNeeded.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public static String getDateNow(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        return format.format(date);
    }
}
