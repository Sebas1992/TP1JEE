/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

import com.GestionStage.Entites.Candidature;
import com.GestionStage.Entites.Utilisateur;

/**
 *
 * @author Utilisateur
 */
public class EtudiantPostulerAction extends AbstractAction {

    @Override
    public String execute() {
        
        String id_offre_stage=request.getParameter("ido");
        Candidature candidature = new Candidature();
        Utilisateur utilisateur = new Utilisateur();
        
        return "etudiantOffreStage";
    }
}
