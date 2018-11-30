/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Services;

import com.GestionStage.DAO.AdresseDAO;
import com.GestionStage.DAO.CompagnieDAO;
import com.GestionStage.DAO.DaoEtudiant;
import com.GestionStage.DAO.EmployeurDAO;
import com.GestionStage.DAO.UtilisateurDAO;
import com.GestionStage.Entites.Compagnie;
import com.GestionStage.Entites.Employeur;
import com.GestionStage.Entites.Etudiant;
import com.GestionStage.Entites.Utilisateur;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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
    
    public List<Etudiant> rechercherEtudiant()
    {
        UtilisateurDAO uDao = new UtilisateurDAO();
        
        return uDao.findEtudiants();
    }
}