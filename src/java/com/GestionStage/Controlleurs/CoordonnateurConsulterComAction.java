/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

import com.GestionStage.DAO.CoordonnateurDAO;
import com.GestionStage.Entites.Coordonnateur;
import java.util.LinkedList;
import java.util.List;
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
        coord.setId_utilisateur(id_etu);
        
        if(coordDao.create(coord)){
            request.setAttribute("message", "Coordonnateur bien creer");
        }else{
            request.setAttribute("message", "Coordonnateur pas creer");
        }
        
        // Traitement pour tester la recherche par cle
        Coordonnateur coord1 = coordDao.find(request.getParameter("id_etu"));
        if(coord != null){
            request.setAttribute("coordonnateur", coord1);
        }
        
        // Traitement pour tester findAll()
        List<Coordonnateur> listeCoord = new LinkedList();
        listeCoord = coordDao.findAll();        
        if(!listeCoord.isEmpty()){
            request.setAttribute("listeCoord", listeCoord);
        }else{
            request.setAttribute("erreurFA", "Impossible de trouver la liste de coordonnateurs");
        }
             
        // Traitement pour tester UPDATE
        coord.setCourriel(courriel);
        coord.setId_coordonnateur(id_etu);
        coord.setMot_de_passe(mdp);
        coord.setNom(nom);
        coord.setPrenom(prenom);
        coord.setType_utilisateur(role);
        if(coordDao.update(coord)){
            request.setAttribute("messageUpdate", "Succes de l'update");
        }else{
            request.setAttribute("messageUpdate", "Echec de l'update");
        }
        /*
        //Traitement pour tester DELETE
        if(coordDao.delete(coord)){
            request.setAttribute("deleteUpdate", "Succes du delete");
        }else{
            request.setAttribute("deleteUpdate", "Echec du delete");
        }
        */
        return "coordConsulterCom";
    }
}
