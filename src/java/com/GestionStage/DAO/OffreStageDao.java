/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.DAO;

import com.GestionStage.Entites.OffreStage;
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
 * @author Utilisateur
 */
public class OffreStageDao {
    public boolean create(OffreStage o) {
        int rowsAffected = 0;
        String query = "INSERT INTO offreStage (id_offre, titre, description, lien_web, lien_document, date, nb_vues, active, id_employeur)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, o.getIdOffre());
            stm.setString(2, o.getTitre());
            stm.setString(3, o.getDescription());
            stm.setString(4, o.getLienWeb());
            stm.setString(5, o.getLienDocument());
            stm.setTimestamp(6, o.getDate());
            stm.setInt(7,o.getNbVues());
            stm.setInt(8,o.getActive());
            stm.setString(9,o.getIdEmployeur());
            rowsAffected = stm.executeUpdate();
        }catch(SQLException e){
             Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        DbConnexion.close();
        return rowsAffected != 0;
    }
    
    public List<OffreStage> findAll() {
        List<OffreStage> liste = new LinkedList<>();
        String query = "Select * FROM offreStage";
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                OffreStage stage = new OffreStage();
                stage.setIdOffre(rs.getString("id_offre"));
                stage.setTitre(rs.getString("titre"));
                stage.setDescription(rs.getString("description"));
                stage.setLienWeb(rs.getString("lien_web"));
                stage.setLienDocument(rs.getString("lien_document"));
                stage.setDate(rs.getTimestamp("date"));
                stage.setNbVues(rs.getInt("nb_vues"));
                stage.setActive(rs.getInt("active"));
                stage.setIdEmployeur(rs.getString("id_employeur"));
                liste.add(stage);
            }
        }catch(SQLException e){
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        DbConnexion.close();
        return liste;
    }
    
    public boolean delete(OffreStage o) {
        String query = "DELETE FROM offreStage WHERE id_offre=?";
        int resultat = 0;
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, o.getIdOffre());
            resultat = stm.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return resultat != 0;
    }

}
