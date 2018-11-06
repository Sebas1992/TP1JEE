/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.DAO;

import com.GestionStage.Entites.Coordonnateur;
import com.GestionStage.Singleton.DbConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebas
 */
public class CoordonnateurDAO implements Dao<Coordonnateur>{

    @Override
    public boolean create(Coordonnateur x) {
        int rowsAffectedUtil = 0;
        int rowsAffectedCoord = 0;
        String queryUtil = "INSERT INTO utilisateur (id_utilisateur, courriel, mot_de_passe, nom, prenom, type_utilisateur)"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        String queryCoord = "Insert INTO coordonnateur (id_coordonnateur)"
                + "VALUES(?)";
        try{
            Connection cnx = DbConnexion.getConnexion();
            
            // Insertion des valeurs dans la table utilisateur
            PreparedStatement stm = cnx.prepareStatement(queryUtil);
            stm.setString(1, x.getId_utilisateur());
            stm.setString(2, x.getCourriel());
            stm.setString(3, x.getMot_de_passe());
            stm.setString(4, x.getNom());
            stm.setString(5, x.getPrenom());
            stm.setString(6, x.getType_utilisateur());
            rowsAffectedUtil = stm.executeUpdate();
            
            // Insertion des valeurs dans la table coordonnateur
            stm = cnx.prepareStatement(queryCoord);
            stm.setString(1, x.getId_coordonnateur());
            rowsAffectedCoord = stm.executeUpdate();
            
        }catch(SQLException e){
             Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        DbConnexion.close();
        return rowsAffectedUtil != 0 && rowsAffectedCoord != 0;
    }

    @Override
    public Coordonnateur find(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Coordonnateur find(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Coordonnateur> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Coordonnateur x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Coordonnateur x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
