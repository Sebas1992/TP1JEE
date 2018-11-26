/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.DAO;

import com.GestionStage.Entites.Critere;
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
 * @author Utilisateur
 */
public class CritereDao {
    
    public boolean create(Critere critere){
        Connection cnx = DbConnexion.getConnexion();
        boolean res=false;
        try{
            PreparedStatement stm=cnx.prepareStatement("INSERT INTO critere VALUES (?,?) ");
            stm.setString(1,critere.getIdCritere());
            stm.setString(2,critere.getNom());          
            res = stm.execute();
            stm.close();
        }catch(SQLException ex){
            Logger.getLogger(DaoEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;    
    }
    
    public List<Critere> findAll() {
        List<Critere> liste = new LinkedList<>();
        String query = "Select * FROM critere";
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Critere critere = new Critere();
                critere.setIdCritere(rs.getString("id_critere"));
                critere.setNom(rs.getString("nom"));
                liste.add(critere);
            }
        }catch(SQLException e){
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        DbConnexion.close();
        return liste;
    }
    
    public boolean delete(Critere c) {
        String query = "DELETE FROM critere WHERE id_critere=?";
        int resultat = 0;
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, c.getIdCritere());
            resultat = stm.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return resultat != 0;
    }
}
