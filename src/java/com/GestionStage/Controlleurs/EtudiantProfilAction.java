/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

import com.GestionStage.DAO.CritereDao;
import com.GestionStage.DAO.DaoEtudiant;
import com.GestionStage.DAO.UtilisateurDAO;
import com.GestionStage.Entites.Critere;
import com.GestionStage.Entites.Etudiant;
import com.GestionStage.Entites.Utilisateur;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Utilisateur
 */
public class EtudiantProfilAction extends AbstractAction{

    @Override
    public String execute() {
        
        //Retourner la liste des criteres
        CritereDao cdao = new CritereDao();
        request.setAttribute("criteres", cdao.findAll());
        
        // Si le profil a ete modifier
        if("oui".equals(request.getParameter("modifier"))){
            System.out.println("inside the if!!!!!!");
            //Preparation des objets utilisateur etudiant criteres
            HttpSession session = request.getSession(true);
            Utilisateur uti = new Utilisateur();
            Etudiant etu = new Etudiant();
            //Prep DAO
            UtilisateurDAO uDao = new UtilisateurDAO();
            DaoEtudiant eDao = new DaoEtudiant();
            
            //Utilisateur
            Utilisateur uti_session = (Utilisateur)session.getAttribute("connected");
            String id_uti = uti_session.getId_utilisateur();
            uti.setId_utilisateur(id_uti);
            uti.setNom(request.getParameter("nom"));
            uti.setPrenom(request.getParameter("prenom"));
            uti.setCourriel(request.getParameter("courriel"));
            uDao.updateP(uti);
            
            //Etudiant
            etu.setId_etudiant(id_uti);
            etu.setStatus(request.getParameter("statut_recherche"));
            eDao.update(etu);
            
            request.setAttribute("message","Votre profil a ete modifier");
            return "profilEtudiant";            
        }

        return "profilEtudiant";
    }
    
}
