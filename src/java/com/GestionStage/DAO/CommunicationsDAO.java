/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.DAO;

import com.GestionStage.Entites.Communication;
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
public class CommunicationsDAO {
       public List<Communication> findCommunications(){        
        List<Communication> listeCom = new LinkedList();
        UtilisateurDAO userDAO = new UtilisateurDAO();
        
        String query=" select titre, message, exp.nom, exp.prenom, dest.nom, dest.prenom" +
                     " from utilisateurmessage join message on utilisateurmessage.id_message=message.id_message" +
                     " join utilisateur as dest on utilisateurmessage.id_destinataire=dest.id_utilisateur" +
                     " join utilisateur as exp on message.id_expediteur=exp.id_utilisateur;";
        try {
            Connection cnx = DbConnexion.getConnexion();            
            PreparedStatement stm = cnx.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                // On va chercher l'expediteur 
                Utilisateur exp = new Utilisateur(rs.getString("exp.nom"), rs.getString("exp.prenom"));
                // On va chercher le destinataire
                Utilisateur dest = new Utilisateur(rs.getString("dest.nom"), rs.getString("dest.prenom"));
                
                Communication com = new Communication();
                com.setTitre(rs.getString("titre"));
                com.setMessage(rs.getString("message"));
                com.setDestinataire(dest);
                com.setExpediteur(exp);
                
                listeCom.add(com);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CoordonnateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeCom;
    }
}
