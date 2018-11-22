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
public class EmployeurService {
    public boolean inscrireEmployeur(Employeur x)
    {
        // Preparation des DAO
        UtilisateurDAO uDao = new UtilisateurDAO(); 
        EmployeurDAO eDao = new EmployeurDAO();
        
        // On entre les donnees dans la table utilisateur et employeur
        return uDao.create(x) && eDao.create(x) ? true : false;
    }
}
