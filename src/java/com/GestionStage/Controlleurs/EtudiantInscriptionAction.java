/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

import com.GestionStage.DAO.DaoEtudiant;
import com.GestionStage.DAO.UtilisateurDAO;
import com.GestionStage.Entites.Etudiant;
import com.GestionStage.Entites.Utilisateur;

/**
 *
 * @author Nicolas
 */
public class EtudiantInscriptionAction extends AbstractAction  implements RequirePRG{
    @Override
    public String execute() {
        
//        if (super.getRequest().getParameter("id_etu")==null || super.getRequest().getParameter("id_etu").equals("")){
//            return "etudiantInscription";
//        }
        //preparation dao
        DaoEtudiant edao = new DaoEtudiant();
        UtilisateurDAO udao = new UtilisateurDAO();
        
        //preparation objets
        String id_etu = super.getRequest().getParameter("id_etu"),
                courriel = super.getRequest().getParameter("email"),
                mdp = super.getRequest().getParameter("mdp"),
                nom = super.getRequest().getParameter("nom"),
                prenom = super.getRequest().getParameter("prenom"),
                role = super.getRequest().getParameter("role");
        
        //creation des objets
        Etudiant etu = new Etudiant(id_etu);
        Etudiant etudiant = new Etudiant(id_etu,courriel,mdp,nom,prenom,role);
        
        //creation de l'etudiant dans la bd
        boolean req1=edao.create(etu);
        boolean req2=udao.create(etudiant);
        System.out.println(req1+""+req2);
        if(req1 && req2){
            super.getRequest().setAttribute("message","Votre inscription est complète!");
        }
        else{
            super.getRequest().setAttribute("message","Votre inscription n'a pas fonctionné!");
        }
                
        return "etudiantInscription";
    }
    
}
