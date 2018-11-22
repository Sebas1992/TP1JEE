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
import com.GestionStage.Entites.Adresse;
import com.GestionStage.Entites.Employeur;

/**
 *
 * @author sebas
 */
public class AdresseService {
    public boolean inscrireAdresse(Adresse x)
    {
        // Preparation du DAO
        AdresseDAO aDao = new AdresseDAO();   
        
        // On entre les donnees dans la table utilisateur
        return aDao.create(x) ? true : false;
    }
}
