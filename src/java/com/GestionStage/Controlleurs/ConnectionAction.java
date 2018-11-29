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
        System.out.println("Email :"+request.getParameter("email"));
        System.out.println("MDP :"+request.getParameter("password"));
        
        if (session.getAttribute("connected")!=null){
            System.out.println("deuxieme condition!!!");
            Utilisateur utilisateur = (Utilisateur)session.getAttribute("connected");
            switch (utilisateur.getType_utilisateur()){
            case("etudiant"):
                return "profilEtudiant";
            case("Employeur"):
                return "profilEmployeur";
            case("coordonnateur"):
                return "profilCoord";                
            default:
                return "connection";
            }
        }
        
        if (request.getParameter("email")==null || "".equals(request.getParameter("email"))){
            System.out.println("premiere condition!!!");
            return "connection";
        }
        
        String identifiant= request.getParameter("email"), mdp=request.getParameter("password");
        Utilisateur utilisateur = new Utilisateur();
        UtilisateurDAO udao = new UtilisateurDAO();
        utilisateur=udao.findByCourriel(request.getParameter("email"));
        

        if (!identifiant.equals(utilisateur.getCourriel())){
            request.setAttribute("erreur", "Information non valide");
            System.out.println("trois condition!!!");
            return "connection";
        }
        if (!mdp.equals(utilisateur.getMot_de_passe())){
            request.setAttribute("erreur", "Information non valide");
            System.out.println("quatre condition!!!");
            return "connection";
        }
        utilisateur.setMot_de_passe("");
        session.setAttribute("connected", utilisateur);
        
        switch (utilisateur.getType_utilisateur()){
            case("etudiant"):
                return "profilEtudiant";
            case("Employeur"):
                return "profilEmployeur";
            case("coordonnateur"):
                return "profilCoord";
            default:
                return "connection";
        }
    }    
}
