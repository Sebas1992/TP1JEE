/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.DAO;

import com.GestionStage.Singleton.DbConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas
 */
public class DaoEtudiant {
    public boolean create(Object obj){
        Connection cnx = DbConnexion.getConnexion();
        Object obj1 = obj;
        boolean res=false;
        try{
            PreparedStatement stm=cnx.prepareStatement("INSERT INTO etudiant VALUES (?,?) ");
            stm.setString(1,"1111111");
            stm.setString(2,"Trouvé");
            res = stm.execute();
        }catch(SQLException ex){
            Logger.getLogger(DaoEtudiant.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;    
    }
    
}
