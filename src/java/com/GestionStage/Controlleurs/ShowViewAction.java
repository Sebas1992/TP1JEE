/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

/**
 *
 * @author Sebas
 */
public class ShowViewAction extends AbstractAction {
    @Override
    public String execute() {
        String vue = request.getParameter("vue");
        if (vue!=null) {
            return vue;
        }
        return "index";
    }
    
}

