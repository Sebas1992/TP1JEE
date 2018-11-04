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
    public static void loadDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
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
                    DbConnexion.loadDriver();
                    //Ouvrir la connexion à la BD.
                    if ("".equals(user)){
                        laConnexion = DriverManager.getConnection("jdbc:mysql://localhost/stageo?user=root&password=root&serverTimezone=UTC");

                    }else
                        laConnexion = DriverManager.getConnection(urlBD,user,password);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur get connection");
        }
        System.out.println("Connexion:"+laConnexion);
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