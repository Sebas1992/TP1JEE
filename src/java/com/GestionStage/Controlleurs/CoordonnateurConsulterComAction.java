/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

import com.GestionStage.DAO.CoordonnateurDAO;
import com.GestionStage.Entites.Coordonnateur;
import com.GestionStage.Services.CoordonnateurService;
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
    
        // Preparation Service
        CoordonnateurService service = new CoordonnateurService();
        request.setAttribute("listeCom", service.getCommunications());
                
        return "coordTest";
    }
}
