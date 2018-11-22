/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Services;

import com.GestionStage.DAO.AdresseDAO;
import com.GestionStage.DAO.CompagnieDAO;
import com.GestionStage.DAO.EmployeurDAO;
import com.GestionStage.DAO.UtilisateurDAO;
import com.GestionStage.Entites.Compagnie;
import com.GestionStage.Entites.Employeur;

/**
 *
 * @author sebas
 */
public class CompagnieService {
    public boolean inscrireCompagnie(Compagnie x)
    {
        // Preparation du DAO
        CompagnieDAO cDao = new CompagnieDAO();   
        
        // On entre les donnees dans la table utilisateur
        return cDao.create(x) ? true : false;
    
    }
    
    public boolean estInscris(String nomCompagnie)
    {
        CompagnieDAO cDao = new CompagnieDAO();
        // Si la compagnie existe deja, on retourne false
        return cDao.exists(nomCompagnie); 
    }
}
