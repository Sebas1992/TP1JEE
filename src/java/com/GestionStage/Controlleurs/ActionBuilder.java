
package com.GestionStage.Controlleurs;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Nicolas.F
 */
public class ActionBuilder {
    public static Action getAction(HttpServletRequest request) {
        Action action;
        String actionAFaire = request.getParameter("action");
        //je crois que le if est optionnel, a tester plus tard
        if (actionAFaire == null) {
            actionAFaire = "";
        }
        // Toutes nos actions devront être ajouté ici
        switch (actionAFaire) {
            default :
                action = new DefaultAction();
        }        
        return action;
    }
    
}