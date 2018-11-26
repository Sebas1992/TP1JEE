/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.DAO;

import com.GestionStage.Entites.Candidature;
import com.GestionStage.Entites.Etudiant;
import com.GestionStage.Entites.Utilisateur;
import com.GestionStage.Singleton.DbConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebas
 */
public class CandidatureDAO {
    
    public boolean create(Candidature candidature,String ido){
        Connection cnx = DbConnexion.getConnexion();
        boolean res=false;
        try{
            PreparedStatement stm=cnx.prepareStatement("INSERT INTO candidature VALUES (?,?,?,?) ");
            stm.setString(1,candidature.getEtudiant().getId_utilisateur());
            stm.setString(2,ido);
            stm.setTimestamp(3,candidature.getDate());
            stm.setString(4,candidature.getStatut());
            res = stm.execute();
            stm.close();
        }catch(SQLException ex){
            Logger.getLogger(DaoEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;    
    }
    
    public List<Candidature> findCandidatures()    
    {        
        List<Candidature> listeCand = new LinkedList();
        String query = " select os.titre, os.description, os.lien_web, os.lien_document, os.nb_vues, os.active, c.date, c.statut, u.nom, u.prenom, u.courriel " +
                " from candidature as c join offrestage as os on c.id_offre=os.id_offre " +
                " join utilisateur as u on c.id_etudiant=u.id_utilisateur";
        try 
        {
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);            
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Candidature cd = new Candidature();
                cd.setActive(rs.getString("active"));
                cd.setDate(rs.getTimestamp("date"));
                cd.setDescription(rs.getString("description"));
                cd.setEtudiant(new Utilisateur(rs.getString("nom"), rs.getString("prenom")));
                cd.setLien_document(rs.getString("lien_document"));
                cd.setLien_web(rs.getString("lien_web"));
                cd.setNb_vues(rs.getInt("nb_vues"));
                cd.setStatut(rs.getString("statut"));
                cd.setTitre(rs.getString("titre"));
                
                listeCand.add(cd);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(CandidatureDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeCand;
    }
}
