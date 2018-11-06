/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.DAO;

import com.GestionStage.Entites.Coordonnateur;
import com.GestionStage.Entites.Utilisateur;
import com.GestionStage.Singleton.DbConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
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
            stm.setString(1, x.getId_coordonnateur());
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
        String keyStr = Integer.toString(key);
        return this.find(keyStr);
    }

    @Override
    public Coordonnateur find(String key) {
         Coordonnateur coord = new Coordonnateur();
        String query = "SELECT * FROM utilisateur inner join coordonnateur "
                + "on utilisateur.id_utilisateur=coordonnateur.id_coordonnateur WHERE id_utilisateur=?";
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);            
            stm.setString(1, key);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                coord.setCourriel(rs.getString("courriel"));
                coord.setId_coordonnateur(rs.getString("id_coordonnateur"));
                coord.setMot_de_passe(rs.getString("mot_de_passe"));
                coord.setNom(rs.getString("nom"));
                coord.setPrenom(rs.getString("prenom"));
                coord.setType_utilisateur(rs.getString("type_utilisateur"));                
                return coord;               
            }
        }catch(SQLException e){
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return coord;
    }

    @Override
    public List<Coordonnateur> findAll() {
        List<Coordonnateur> liste = new LinkedList<>();
        String query = "Select * FROM utilisateur where type_utilisateur='coordonnateur'";
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);            
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Coordonnateur coordonnateur = new Coordonnateur();
                coordonnateur.setCourriel(rs.getString("courriel"));
                coordonnateur.setId_coordonnateur(rs.getString("id_utilisateur"));
                coordonnateur.setMot_de_passe(rs.getString("mot_de_passe"));
                coordonnateur.setNom(rs.getString("nom"));
                coordonnateur.setPrenom(rs.getString("prenom"));
                coordonnateur.setType_utilisateur(rs.getString("type_utilisateur"));                
                liste.add(coordonnateur);
            }
        }catch(SQLException e){
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        DbConnexion.close();
        return liste;
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
