/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.DAO;

import com.GestionStage.Entites.Document;
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
public class UploadFichierDAO {
    public boolean create(Document x)
    {         
            String query = "INSERT INTO document (id_document, lien, type, nb_vues, id_coordonnateur, date)"
                    + "     VALUES(?, ?, ?, ?, ?, ?)";
            int rowsAffected = 0;
        try {
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, x.getId_document());
            stm.setString(2, x.getLien());
            stm.setString(3, x.getType());
            stm.setInt(4, x.getNb_vues());
            stm.setString(5, x.getId_coordonnateur());
            stm.setTimestamp(6, x.getDate());
            rowsAffected = stm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UploadFichierDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsAffected != 0;
    }
}
