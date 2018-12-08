/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

import com.GestionStage.DAO.UtilisateurDAO;
import com.GestionStage.Entites.Utilisateur;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Utilisateur
 */
public class ConnectionAction extends AbstractAction{

    @Override
    public String execute() {
        HttpSession session = request.getSession(true);
        
        if (session.getAttribute("connected")!=null){
            Utilisateur utilisateur = (Utilisateur)session.getAttribute("connected");
            switch (utilisateur.getType_utilisateur()){
            case("etudiant"):
                return "profilEtudiant";
            case("Employeur"):
                return "employeurPublierOffreStage";
            case("coordonnateur"):
                return "coordDocuments";               
            default:
                return "connection";
            }
        }
        
        if (request.getParameter("email")==null || "".equals(request.getParameter("email"))){
            return "connection";
        }
        
        String identifiant= request.getParameter("email"), mdp=request.getParameter("password");
        Utilisateur utilisateur = new Utilisateur();
        UtilisateurDAO udao = new UtilisateurDAO();
        utilisateur=udao.findByCourriel(request.getParameter("email"));
        

        if (!identifiant.equals(utilisateur.getCourriel())){
            request.setAttribute("erreur", "Information non valide");
            return "connection";
        }
        if (!mdp.equals(utilisateur.getMot_de_passe())){
            request.setAttribute("erreur", "Information non valide");
            return "connection";
        }
        utilisateur.setMot_de_passe("");
        session.setAttribute("connected", utilisateur);
        
        switch (utilisateur.getType_utilisateur()){
            case("etudiant"):
                return "profilEtudiant";

            case("Employeur"):
                return "employeurPublierOffreStage";
            case("coordonnateur"):
                return "coordDocuments";
            default:
                return "connection";
        }
    }    
}
