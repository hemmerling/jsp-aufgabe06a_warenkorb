/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe06a_warenkorb.model.persistence;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class SessionListe {

    private static SessionListe instance = null;
    private ArrayList<HttpSession> sessionListe = new ArrayList<HttpSession>();

    protected SessionListe() {
        // Exists only to defeat instantiation.
    }

    public static SessionListe getInstance() {
        if (instance == null) {
            instance = new SessionListe();
        }
        return instance;
    }

    public void add(HttpSession session) {
        sessionListe.add(session);
    }

    public void remove(HttpSession session) {
        sessionListe.remove(session);
    }

    public ArrayList<HttpSession> get() {
        return sessionListe;
    }

}
