/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

import com.GestionStage.DAO.CoordonnateurDAO;
import com.GestionStage.Entites.Coordonnateur;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sebas
 */
public class CoordonnateurConsulterComAction extends AbstractAction{

    @Override
    public String execute() {
        
        // Preparation DAO
        CoordonnateurDAO coordDao = new CoordonnateurDAO();

        //preparation objets
        String id_etu = super.getRequest().getParameter("id_etu"),
                courriel = super.getRequest().getParameter("email"),
                mdp = super.getRequest().getParameter("mdp"),
                nom = super.getRequest().getParameter("nom"),
                prenom = super.getRequest().getParameter("prenom"),
                role = super.getRequest().getParameter("role");
        
        // Preparation Coordonnateur
        Coordonnateur coord = new Coordonnateur();
        coord.setCourriel(courriel);
        coord.setId_coordonnateur(id_etu);
        coord.setMot_de_passe(mdp);
        coord.setNom(nom);
        coord.setPrenom(prenom);
        coord.setType_utilisateur(role);
        
        if(coordDao.create(coord)){
            request.setAttribute("message", "Coordonnateur bien creer");
        }else{
            request.setAttribute("message", "Coordonnateur pas creer");
        }
        
        coord = coordDao.find(request.getParameter("id_etu"));
        if(coord != null){
            request.setAttribute("coordonnateur", coord);
        }
        
        return "coordConsulterCom";
    }
}
