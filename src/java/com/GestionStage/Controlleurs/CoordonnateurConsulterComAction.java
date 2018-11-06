/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sebas
 */
public class CoordonnateurConsulterComAction extends AbstractAction{

    @Override
    public String execute() {
        return "coordConsulterCom";
    }
}
