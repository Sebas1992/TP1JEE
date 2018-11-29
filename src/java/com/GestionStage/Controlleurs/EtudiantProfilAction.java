/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

/**
 *
 * @author Utilisateur
 */
public class EtudiantProfilAction extends AbstractAction  implements RequirePRG{

    @Override
    public String execute() {
        
        // Si le profil a ete modifier
        if("oui".equals(request.getParameter("modifier"))){
            
            //Preparation des objets
            
            request.setAttribute("message","Votre profil a ete modifier");
            return "profilEtudiant";            
        }
 
        return "profilEtudiant";
    }
    
}
