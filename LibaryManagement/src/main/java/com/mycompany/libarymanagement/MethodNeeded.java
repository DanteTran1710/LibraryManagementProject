package com.mycompany.libarymanagement;


import java.time.format.DateTimeFormatter;
import java.util.UUID;
import javafx.scene.control.DatePicker;
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
}
