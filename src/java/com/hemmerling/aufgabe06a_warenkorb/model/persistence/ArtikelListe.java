/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe06a_warenkorb.model.persistence;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rhemmerling
 */
public class ArtikelListe {

ArrayList<Artikel> artikelListe = new ArrayList<Artikel>();

    {
        artikelListe.add(new Artikel("Apfel.ArtikelListe", 0.45));
        artikelListe.add(new Artikel("Birne.ArtikelListe", 0.55));
    }
    
    public ArrayList<Artikel> get() {
        return artikelListe;
    }
    
    
}
