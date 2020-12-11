/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.librarymanagement.test;

import com.mycompany.librarymanagement.services.MethodNeeded;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author hp
 */
public class MethodNeededTester {

    @Test
    public void testCreateUUID() {
        String uuid = MethodNeeded.createUUID();

        Assert.assertNotNull(uuid);
        Assert.assertNotEquals("", uuid.trim());
        Assert.assertEquals(5, uuid.length());

        System.out.println("Test create uuid string successfully!");
    }

//    @Test
//    public void testEditDatePickerAsFormat(){
//        DatePicker day1 = new DatePicker();
//        day1.setValue(LocalDate.of(2000, 10, 17));
//        MethodNeeded.editFormmatDate(day1);
//        
//        Assert.assertEquals("10/17/2000", day1.getEditor().getText());
//        
//    }
    
    @Test
    public void testGetDayNowByFormat(){
        String day = MethodNeeded.getDateNow();
        
        Assert.assertNotNull(day);
        Assert.assertEquals("07/12/2020", day);
        System.out.println("Test day now by input format successfully!");
    }
    
    @Test
    public void testCaculateDateNullInDate() {
        long dayBetween = MethodNeeded.caculateDate("", "");

        Assert.assertEquals(365, dayBetween);
        System.out.println("Test day between by not input day successfully!");
    }

    @Test
    public void testCaculateDateNotNullInDate() {
        long dayBetween = MethodNeeded.caculateDate("01/10/2000", "17/10/2000");

        Assert.assertEquals(16, dayBetween);
        System.out.println("Test day between by input day successfully!");
    }
}
