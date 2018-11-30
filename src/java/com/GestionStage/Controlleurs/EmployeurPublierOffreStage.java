/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Controlleurs;

import com.GestionStage.Entites.OffreStage;
import com.GestionStage.Entites.Utilisateur;
import com.GestionStage.Services.EmployeurService;
import java.sql.Timestamp;
import java.util.UUID;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author sebas
 */
public class EmployeurPublierOffreStage extends AbstractAction{

    @Override
    public String execute() {        
        // On prepare les objets
        EmployeurService es = new EmployeurService();
        Utilisateur user = (Utilisateur)this.request.getSession().getAttribute("connected");
        if(user == null)
        {            
            return "profilEmployeur";
        }
        OffreStage os = new OffreStage();
        /*
        // Si le document est bien uploader...
        if(es.UploadFile(request))
        {
            // On ajoute le lien
            os.setLienDocument(this.request.getParameter("lien_document"));
        }else{
            // Sinon on met le lien a null
            os.setLienDocument("");
        }
        */
        // On rempli notre objet offreDeStage
        os.setActive(1);
        os.setDate(new Timestamp(System.currentTimeMillis()));
        os.setDescription(this.request.getParameter("description"));
        os.setIdEmployeur(user.getId_utilisateur());
        os.setIdOffre(UUID.randomUUID().toString());
        os.setLienWeb(this.request.getParameter("lien_web"));
        // A changer si on est capable de faire fonctionner lupload de fichier pour ce form
        os.setLienDocument("./test"); 
        os.setNbVues(0);
        os.setTitre(this.request.getParameter("titre"));               
        
        // On appel le service et on met le message qui correspondant dans la session
        if(es.publierOffreStage(os))
        {
            this.request.getSession().setAttribute("messageOffreStage", "Offre de stage bien pulier");
        }else{
            this.request.getSession().setAttribute("messageOffreStage", "Erreur lors de la publication de l'offre de stage");
        }
        
        return "employeurPublierOffreStage";
    }
    
}
