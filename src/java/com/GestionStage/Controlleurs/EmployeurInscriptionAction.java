/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

import com.GestionStage.Entites.Adresse;
import com.GestionStage.Entites.Compagnie;
import com.GestionStage.Entites.Employeur;
import com.GestionStage.Services.AdresseService;
import com.GestionStage.Services.CompagnieService;
import com.GestionStage.Services.EmployeurService;
import java.util.UUID;

/**
 *
 * @author sebas
 */
public class EmployeurInscriptionAction extends AbstractAction implements RequirePRG{
    @Override
    public String execute() {
        // Preparation des services
        EmployeurService eService = new EmployeurService();
        CompagnieService cService = new CompagnieService();
        AdresseService aService = new AdresseService();        
                
        // On verifie si la compagnie existe deja
        if(cService.estInscris(request.getParameter("nomComp")))
        {
            request.setAttribute("message", "La compagnie existe déjà");
            return "employeurInscription";
        }
        
        // Preparation des id
        String idEmp = UUID.randomUUID().toString();
        String idComp = UUID.randomUUID().toString();
        String idAdress = UUID.randomUUID().toString();
        
        // Preparation de l'employeur
        Employeur emp = new Employeur();        
        emp.setId_employeur(idEmp);
        emp.setCourriel(request.getParameter("courriel"));
        emp.setId_utilisateur(idEmp);
        emp.setMot_de_passe(request.getParameter("mot_de_passe"));
        emp.setNom(request.getParameter("nomEmp"));
        emp.setPrenom(request.getParameter("prenomEmp"));
        emp.setTel(request.getParameter("tel"));
        emp.setType_utilisateur("Employeur");
        emp.set_IDCompagnie(idComp);
        
        // Preparation de la compagnie
        Compagnie comp = new Compagnie();
        comp.setId_compagnie(idComp);
        comp.setNom(request.getParameter("nomComp"));
        comp.setSite_web("site_web");
        comp.set_IDAdresse(idAdress);
        
        // Preparation de l'adresse
        Adresse adresse = new Adresse();
        adresse.setId_adresse(idAdress);
        adresse.setBureau(request.getParameter("bureau"));
        adresse.setCode_postal(request.getParameter("code_postal"));
        adresse.setNumero_civique(request.getParameter("numero_civique"));
        adresse.setPays(request.getParameter("pays"));
        adresse.setProvince(request.getParameter("province"));
        adresse.setRue(request.getParameter("rue"));
        adresse.setTel("tel");
        adresse.setVille(request.getParameter("ville"));
        
        // On insere les donnees dans les tables
        if(eService.inscrireEmployeur(emp) && cService.inscrireCompagnie(comp) && aService.inscrireAdresse(adresse))
        {
            // Si tout s'est bien deroule, on envoie un message l'utilisateur
            request.setAttribute("message", "Compagnie bien cree");
            return "profilEmployeur";
        }
        else
        {
            // Sinon on lui envoie un message lui disant que linsertion a echoue
            request.setAttribute("message", "Impossible de creer la compagnie");
            return "employeurInscription"; // A changer quand on va implementer les vues
        }
    }
    
}
