/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe06a_warenkorb.model.persistence;

/**
 *
 * @author rhemmerling
 */
public class Artikel {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Artikel(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
}
