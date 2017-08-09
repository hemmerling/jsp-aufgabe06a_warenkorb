/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe06a_warenkorb.listener;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.hemmerling.aufgabe06a_warenkorb.model.persistence.*;

/**
 * Web application lifecycle listener.
 *
 * @author hemmerling@gmx.net
 */
@WebListener
public class WarenkorbSessionListener implements HttpSessionListener {

    private static final String WARENKORB = "warenkorb";
    private static final String SESSIONS = "sessions";

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("Warenkorb wird für den Benutzer angelegt");
        HttpSession session = event.getSession();

        addWarenkorb(session); // Warenkorb als Session-Attribut anlegen

        addToSessionList(session);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        removeFromSessionList(session);
    }

    private void addToSessionList(HttpSession session) {
        ServletContext application = session.getServletContext();
        SessionListe sessionListe = (SessionListe) application.getAttribute(SESSIONS);
        System.out.println("Sessionliste-Größe=" + sessionListe.get().size());
        sessionListe.add(session);
    }

    private void addWarenkorb(HttpSession session) {
        session.setAttribute(WARENKORB, new Warenkorb());
    }

    private void removeFromSessionList(HttpSession session) {
        ServletContext application = session.getServletContext();
        SessionListe sessionListe = (SessionListe) application.getAttribute(SESSIONS);
        sessionListe.remove(session);
    }
}
