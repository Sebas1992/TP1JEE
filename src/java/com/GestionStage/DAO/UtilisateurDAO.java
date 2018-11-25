/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.DAO;

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
public class UtilisateurDAO implements Dao<Utilisateur>{

    @Override
    public boolean create(Utilisateur x) {
        int rowsAffected = 0;
        String query = "INSERT INTO utilisateur (id_utilisateur, courriel, mot_de_passe, nom, prenom, type_utilisateur)"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, x.getId_utilisateur());
            stm.setString(2, x.getCourriel());
            stm.setString(3, x.getMot_de_passe());
            stm.setString(4, x.getNom());
            stm.setString(5, x.getPrenom());
            stm.setString(6, x.getType_utilisateur());
            rowsAffected = stm.executeUpdate();
        }catch(SQLException e){
             Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        DbConnexion.close();
        return rowsAffected != 0;
    }

    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> liste = new LinkedList<>();
        String query = "Select * FROM utilisateur";
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setCourriel(rs.getString("courriel"));
                utilisateur.setId_utilisateur(rs.getString("id_utilisateur"));
                utilisateur.setMot_de_passe(rs.getString("mot_de_passe"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setType_utilisateur(rs.getString("type_utilisateur"));                
                liste.add(utilisateur);
            }
        }catch(SQLException e){
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        DbConnexion.close();
        return liste;
    }

    @Override
    public boolean update(Utilisateur x) {
        int rowsAffected = 0;
        String query = "UPDATE utilisateur SET courriel=?, mot_de_passe=?, "
                + "nom=?, prenom=?, type_utilisateur=? where id_utilisateur=?";
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);            
            stm.setString(1, x.getCourriel());
            stm.setString(2, x.getMot_de_passe());
            stm.setString(3, x.getNom());
            stm.setString(4, x.getPrenom());
            stm.setString(5, x.getType_utilisateur());
            stm.setString(6, x.getId_utilisateur());
            rowsAffected = stm.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        DbConnexion.close();
        return rowsAffected != 0;
    }

    @Override
    public boolean delete(Utilisateur x) {
        String query = "DELETE FROM utilisateur WHERE id_utilisateur=?";
        int resultat = 0;
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, x.getId_utilisateur());
            resultat = stm.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return resultat != 0;
    }

    @Override
    public Utilisateur find(int key) {
        String keyStr = Integer.toString(key);
        return this.find(keyStr);
    }

    @Override
    public Utilisateur find(String key) {
        Utilisateur utilisateur = new Utilisateur();
        String query = "SELECT * FROM utilisateur WHERE id_utilisateur=?";
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);            
            stm.setString(1, key);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                utilisateur.setCourriel(rs.getString("courriel"));
                utilisateur.setId_utilisateur(rs.getString("id_utilisateur"));
                utilisateur.setMot_de_passe(rs.getString("mot_de_passe"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setType_utilisateur(rs.getString("type_utilisateur"));                
                //return utilisateur;               
            }
        }catch(SQLException e){
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return utilisateur;
    }
    public Utilisateur findByCourriel(String key) {
        Utilisateur utilisateur = new Utilisateur();
        String query = "SELECT * FROM utilisateur WHERE courriel=?";
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);            
            stm.setString(1, key);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                utilisateur.setCourriel(rs.getString("courriel"));
                utilisateur.setId_utilisateur(rs.getString("id_utilisateur"));
                utilisateur.setMot_de_passe(rs.getString("mot_de_passe"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setType_utilisateur(rs.getString("type_utilisateur"));                
                //return utilisateur;               
            }
        }catch(SQLException e){
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return utilisateur;
    }
}
