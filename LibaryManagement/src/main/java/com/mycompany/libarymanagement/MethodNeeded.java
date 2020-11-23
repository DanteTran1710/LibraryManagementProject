package com.mycompany.libarymanagement;


import java.util.UUID;

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
}
