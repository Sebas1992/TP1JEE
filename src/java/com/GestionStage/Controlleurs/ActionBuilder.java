
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
            case("show"):
                action = new ShowViewAction();
                break;
            case("etudiantConsulterStage"):
                action = new EtudiantConsulterStageAction();
                break;
            case("profilEtudiant"):
                action = new EtudiantProfilAction();
                break;
            case("etudiantModifierProfil"):
                action = new EtudiantModifierProfilAction();
                break;
            case("etudiantInscription"):
                action = new EtudiantInscriptionAction();
                break;
            case("etudiantPostule"):
                action = new EtudiantPostulerAction();
                break;
            case("coordonnateurConsulterCom"):
                action = new CoordonnateurConsulterComAction();
                break;
            case("coordonnateurConsulterCand"):
                action = new CoordonnateurConsulterCandidatureAction();
                break;
            case("coordonnateurUploadFile"):
                action = new CoordonnateurUploadFileAction();
                break;
            case("employeurRechercherEtudiant"):
                action = new EmployeurRechercherCandidatsAction();
                break;
            case("employeurContacterEtudiant"):
                action = new EmployeurContacterEtudiantAction();
                break;
            case("employeurPublierOffreStage"):
                action = new EmployeurPublierOffreStage();
                break;
            case("employeurInscription"):
                action = new EmployeurInscriptionAction();
                break;
            case("profilEmployeur"):
                action = new EmployeurProfilAction();
                break;
            case("deconnection"):
                action = new DeconnectionAction();
                break;
            case("connection"):
                action = new ConnectionAction();
                break;
            default :
//                action = new DefaultAction();
                action = new ConnectionAction();
        }        
        return action;
    }
    
}
