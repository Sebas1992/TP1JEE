/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

import com.GestionStage.Services.EmployeurService;

/**
 *
 * @author sebas
 */
public class EmployeurRechercherCandidatsAction extends AbstractAction {

    @Override
    public String execute() {
        EmployeurService es = new EmployeurService();
        this.request.setAttribute("listeEtudiants", es.rechercherEtudiant());
        
        return "employeurRechercheEtudiant";
    }
    
}
