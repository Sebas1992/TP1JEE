/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Services;

import com.GestionStage.DAO.CommunicationsDAO;
import com.GestionStage.DAO.CoordonnateurDAO;
import com.GestionStage.Entites.Communication;
import java.util.List;

/**
 *
 * @author sebas
 */
public class CoordonnateurService {
    public List<Communication> getCommunications()
    {
        CommunicationsDAO comDao = new CommunicationsDAO();
        return comDao.findCommunications();
    }
}
