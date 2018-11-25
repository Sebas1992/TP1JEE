/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Utilisateur
 */
public class DeconnectionAction extends AbstractAction {

    @Override
    public String execute() {
        HttpSession session = request.getSession();
        session.invalidate();
        System.out.println("Session détruite!!!!!!");
        return "connection";
    }
}
