/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

import com.GestionStage.Services.CoordonnateurService;

/**
 *
 * @author sebas
 */
public class CoordonnateurConsulterCandidatureAction extends AbstractAction{

    @Override
    public String execute() {
        CoordonnateurService coordServ = new CoordonnateurService();
        request.setAttribute("listeCandidatures", coordServ.getCandidatures());
        
        return "coordConsulterCand";
    }
    
}
