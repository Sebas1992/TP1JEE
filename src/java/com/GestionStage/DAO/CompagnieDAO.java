/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.DAO;

import com.GestionStage.Entites.Compagnie;
import com.GestionStage.Singleton.DbConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebas
 */
public class CompagnieDAO {
    public boolean create(Compagnie x)
    {        
        int rowsAffected = 0;
        String query = "INSERT INTO compagnie (id_compagnie, nom, site_web, id_adresse)"
                + "     VALUES(?, ?, ?, ?)";
        
        Connection cnx = DbConnexion.getConnexion();        
        try {            
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, x.getId_compagnie());
            stm.setString(2, x.getNom());
            stm.setString(3, x.getSite_web());
            stm.setString(4, x.get_IDAdresse());
            
            rowsAffected = stm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rowsAffected != 0;
    }
    
    public boolean exists(String nomCompagnie)
    {
        boolean res = true;
        String query = "Select nom FROM compagnie WHERE nom=?";
        Connection cnx = DbConnexion.getConnexion();
        try {
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, nomCompagnie);
            
            ResultSet rs = stm.executeQuery();
            res = rs.next() ? true : false;
            
        } catch (SQLException ex) {
            Logger.getLogger(CompagnieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return res;
    }
}
