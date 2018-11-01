/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.DAO;

import com.GestionStage.Entites.Message;
import com.GestionStage.Singleton.DbConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebas
 */
public class MessageDAO implements Dao<Message> 
{
    @Override
    public boolean create(Message x) {
        int rowsAffected = 0;
        String query = "INSERT INTO message (titre, message, vu, date, heure, id_expediteur)"
                + "VALUES(?, ?, ?, ?, ?, ?)";
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);
            stm.setString(1, x.getTitre());
            stm.setString(2, x.getMessage());
            stm.setInt(3, x.getVu());
            stm.setDate(4, x.getDate());
            stm.setTime(5, x.getHeure());
            stm.setString(6, x.getId_expediteur());
            rowsAffected = stm.executeUpdate();
        }catch(SQLException e){
             Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        DbConnexion.close();
        return rowsAffected != 0;
    }

    @Override
    public List<Message> findAll() {
        List<Message> liste = new LinkedList<Message>();
        String query = "Select * FROM message";
        try{
            Connection cnx = DbConnexion.getConnexion();
            PreparedStatement stm = cnx.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                Message message = new Message();
                message.setDate(rs.getDate("date"));
                message.setHeure(rs.getTime("heure"));
                message.setId_expediteur(rs.getString("id_expediteur"));
                message.setId_message(rs.getString("message"));
                message.setTitre(rs.getString("titre"));
                message.setVu(rs.getInt("vu"));                
                liste.add(message);
            }
        }catch(SQLException e){
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        DbConnexion.close();
        return liste;
    }

    @Override
    public boolean update(Message x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Message x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message find(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message find(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
