/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

import com.GestionStage.DAO.OffreStageDao;

/**
 *
 * @author Utilisateur
 */
public class EtudiantConsulterStageAction extends AbstractAction {

    @Override
    public String execute() {
        OffreStageDao of = new OffreStageDao();
        request.setAttribute("offreStages", of.findAll());
        return "etudiantOffreStage";
    }
}
