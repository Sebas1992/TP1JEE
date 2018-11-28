/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.DAO;

import com.GestionStage.Entites.Etudiant;
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
 * @author Nicolas
 */
public class DaoEtudiant {
    
    public boolean create(Etudiant etu){
        Connection cnx = DbConnexion.getConnexion();
        boolean res=false;
        try{
            PreparedStatement stm=cnx.prepareStatement("INSERT INTO etudiant VALUES (?,?) ");
            stm.setString(1,etu.getId_etudiant());
            stm.setString(2,etu.getStatus());          
            res = stm.execute();
            stm.close();
        }catch(SQLException ex){
            Logger.getLogger(DaoEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;    
    }
    
    public boolean update(Etudiant etu){
        Connection cnx = DbConnexion.getConnexion();
        boolean res=false;
        try{
            PreparedStatement stm=cnx.prepareStatement("UPDATE etudiant SET STATUS_RECHERCHE=? WHERE ID_ETUDIANT=? ");
            stm.setString(1,etu.getStatus());
            stm.setString(2,etu.getId_etudiant());
            res = stm.execute();
            stm.close();
        }catch(SQLException ex){
            Logger.getLogger(DaoEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    //ajouter delete
    
    public List<Etudiant> findAll() {
        List<Etudiant> liste = new LinkedList<>();
        String query = "Select * FROM etudiant";
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Etudiant etu = new Etudiant();
                etu.setId_etudiant(rs.getString("id_etudiant"));
                etu.setStatus(rs.getString("statut_recherche"));
                liste.add(etu);
            }
        }catch(SQLException e){
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        DbConnexion.close();
        return liste;
    }
}
