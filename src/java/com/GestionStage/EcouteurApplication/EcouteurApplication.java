/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.EcouteurApplication;

import com.GestionStage.Singleton.DbConnexion;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author sebas
 */
public class EcouteurApplication implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Application demarree");
        
        ServletContext application = sce.getServletContext();        
        DbConnexion.setChainePilote(application.getInitParameter("piloteJDBC"));
        DbConnexion.setUrlBD(application.getInitParameter("urlBD"));
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Application terminee");
    }
    
}
