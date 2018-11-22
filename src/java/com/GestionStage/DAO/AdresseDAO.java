/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.DAO;

import com.GestionStage.Entites.Adresse;
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
public class AdresseDAO {
    public boolean create(Adresse x)
    {
        int rowsAffected = 0;
        String query = "INSERT INTO adresse (id_adresse, numero_civique, rue, bureau, ville, code_postal, province, pays, tel)"
                + "     VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection cnx = DbConnexion.getConnexion();
        try {
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, x.getId_adresse());
            stm.setString(2, x.getNumero_civique());
            stm.setString(3, x.getRue());
            stm.setString(4, x.getBureau());
            stm.setString(5, x.getVille());
            stm.setString(6, x.getCode_postal());
            stm.setString(7, x.getProvince());
            stm.setString(8, x.getPays());
            stm.setString(9, x.getTel());
            
            rowsAffected = stm.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AdresseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rowsAffected != 0;
    }
}
