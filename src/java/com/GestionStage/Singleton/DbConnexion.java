package com.GestionStage.Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnexion {
    
    private static Connection laConnexion = null;
    private static String chainePilote = "";
    private static String urlBD = "";
    private static String user = "", password = "";
    
    private DbConnexion() {
    }
    public static void loadDriver(String driverString){
        try {
            Class.forName(driverString);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void setChainePilote(String chainePilote) {
        DbConnexion.chainePilote = chainePilote;
    }
    public static void setUrlBD(String urlBD) {
        DbConnexion.urlBD = urlBD;
    }

    public static void setUser(String user) {
        DbConnexion.user = user;
    }

    public static void setPassword(String password) {
        DbConnexion.password = password;
    }
    
    public static Connection getConnexion() {
        try {
            if (laConnexion == null || laConnexion.isClosed()) {
                    System.out.println("Chaine du pilote : "+chainePilote);
                    DbConnexion.loadDriver(chainePilote);
                    //Ouvrir la connexion à la BD.
                    if ("".equals(user)){
                        laConnexion = DriverManager.getConnection(urlBD);
                        System.out.println("URL: " + DbConnexion.urlBD);
                        System.out.println("chaine: " + DbConnexion.chainePilote);
                    }else
                        laConnexion = DriverManager.getConnection(urlBD,user,password);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return laConnexion;
    }
    public static void close() {
        if (laConnexion != null)
            try {
                laConnexion.close();
        } catch (SQLException ex) {
            //Logger.getLogger(DbConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}