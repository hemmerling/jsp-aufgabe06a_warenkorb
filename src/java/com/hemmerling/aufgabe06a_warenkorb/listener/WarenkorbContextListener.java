/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hemmerling.aufgabe06a_warenkorb.listener;

import com.hemmerling.aufgabe06a_warenkorb.model.persistence.SessionListe;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Administrator
 */
@WebListener("WarenkorbListener")
public class WarenkorbContextListener implements ServletRequestListener, ServletContextListener {

    static {
        // statischer Initalisierungsblock
        System.out.println(WarenkorbContextListener.class.getName() +  " - Static initalisation block");
    }

    public WarenkorbContextListener(){}

    // @Override
//    public void init() throws ServletException {
//        System.out.println("init()");
//    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        SessionListe sessionListe = SessionListe.getInstance(); // Singleton 
        ServletContext context2 = event.getServletContext();
        context2.setAttribute("SESSIONS", sessionListe);
        System.out.println(WarenkorbContextListener.class.getName() +  " - contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }
    
    @Override
    public void requestInitialized(ServletRequestEvent event) {
        ServletRequest request = event.getServletRequest();
        System.out.println(request + ": initialized");
        request.setAttribute("SESSIONS", request.getClass());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {

    }
}