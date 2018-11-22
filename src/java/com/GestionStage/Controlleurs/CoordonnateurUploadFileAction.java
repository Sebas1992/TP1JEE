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
public class CoordonnateurUploadFileAction extends AbstractAction implements RequirePRG{

    @Override
    public String execute() {
        CoordonnateurService coordServ = new CoordonnateurService();
        coordServ.UploadFile(request);
        return "coordTest";
    }    
}
