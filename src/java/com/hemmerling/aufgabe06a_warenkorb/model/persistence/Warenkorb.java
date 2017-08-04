/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe06a_warenkorb.model.persistence;

import com.hemmerling.aufgabe06a_warenkorb.model.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author rhemmerling
 */
public class Warenkorb {

    private static Warenkorb instance = null;
    List<Artikel> artikelListe = new LinkedList<Artikel>();

    {        
        //artikelListe.add(new Artikel("Apfel.Warenkorb", 0.40));
        //artikelListe.add(new Artikel("Birne.Warenkorb", 0.50));
    }
    
    public void add(Artikel artikel){
         artikelListe.add(artikel);
    }
    
    public List<Artikel> get() {
        return artikelListe;
    }

    public Warenkorb() {
        // Exists only to defeat instantiation.
    }

    public static Warenkorb getInstance() {
        if (instance == null) {
            instance = new Warenkorb();
        }
        return instance;
    }

}
