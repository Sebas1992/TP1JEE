/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.DAO;

import com.GestionStage.Entites.Employeur;
import com.GestionStage.Singleton.DbConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebas
 */
public class EmployeurDAO {
    public boolean create(Employeur x)
    {
        int rowsAffectedEmployeur = 0;
        String queryEmployeur = "INSERT INTO employeur (id_employeur, tel, id_compagnie)"
                + "              VALUES(?, ?, ?)";        
        try {
            Connection cnx = DbConnexion.getConnexion();
            
            // Insertion dans la table employeur
            PreparedStatement stm = cnx.prepareStatement(queryEmployeur);
            stm.setString(1, x.getId_employeur());
            stm.setString(2, x.getTel());
            stm.setString(3, x.get_IDCompagnie());
            
            rowsAffectedEmployeur = stm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsAffectedEmployeur != 0;
    }
}
