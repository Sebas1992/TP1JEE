/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Services;

import com.GestionStage.DAO.AdresseDAO;
import com.GestionStage.DAO.CompagnieDAO;
import com.GestionStage.DAO.DaoEtudiant;
import com.GestionStage.DAO.EmployeurDAO;
import com.GestionStage.DAO.OffreStageDao;
import com.GestionStage.DAO.UploadFichierDAO;
import com.GestionStage.DAO.UtilisateurDAO;
import com.GestionStage.Entites.Compagnie;
import com.GestionStage.Entites.Document;
import com.GestionStage.Entites.Employeur;
import com.GestionStage.Entites.Etudiant;
import com.GestionStage.Entites.OffreStage;
import com.GestionStage.Entites.Utilisateur;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author sebas
 */
public class EmployeurService {
    public boolean inscrireEmployeur(Employeur x)
    {
        // Preparation des DAO
        UtilisateurDAO uDao = new UtilisateurDAO(); 
        EmployeurDAO eDao = new EmployeurDAO();
        
        // On entre les donnees dans la table utilisateur et employeur
        return uDao.create(x) && eDao.create(x) ? true : false;
    }
    
    public boolean publierOffreStage(OffreStage os)
    {
        OffreStageDao osDao = new OffreStageDao();
        
        return osDao.create(os);
    }
    
    public List<Etudiant> rechercherEtudiant()
    {
        UtilisateurDAO uDao = new UtilisateurDAO();
        
        return uDao.findEtudiants();
    }
    
    public boolean UploadFile(HttpServletRequest request)
    {
        // *******************************************
        // upload le fichier dans le dossier documents
        //********************************************
        Part filePart;
        try {
            filePart = request.getPart("document");                        
        } catch (IOException | ServletException ex) {
            Logger.getLogger(CoordonnateurService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        // Nom du fichier televerser
        String nomFichier = "";
        String[] t = filePart.getHeader("content-disposition").split(";");
        for (String content : t) {
        if (content.trim().startsWith("filename")) {
            String s = content.substring(content.indexOf('=') + 1).trim();
            nomFichier = s.substring(s.lastIndexOf(File.separator) + 1).replace("\"","");
        }
    }
        
        // Dossier de destination
        String path = request.getServletContext().getRealPath("") + "documents";
        
        try(
            OutputStream os = new FileOutputStream(new File(path + File.separator + nomFichier));
            InputStream is = filePart.getInputStream();
           )
        {
            int nbOctetsLus = 0;
            final byte[] bytes = new byte[1024];
            while((nbOctetsLus = is.read(bytes)) != -1)
            {
                os.write(bytes, 0, nbOctetsLus);
            }            
        }catch(IOException ex){
            Logger.getLogger(CoordonnateurService.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "Impossible d'uploader le fichier");
            return false;            
        }
        
        // ****************************
        // Upload le fichier dans la BD
        // ****************************
        UploadFichierDAO fichierDAO = new UploadFichierDAO();
        Document doc = new Document();
        doc.setId_document(UUID.randomUUID().toString());
        doc.setDate(new Timestamp(System.currentTimeMillis()));
        doc.setId_coordonnateur("test"); // A aller chercher dans la session quand la fonctionnalite sera implementer !
        String relPath = request.getServletContext().getContextPath() +File.separator + "build\\web\\documents"; // A revoir en equipe
        doc.setLien(relPath);
        doc.setNb_vues(0);
        doc.setType("cv");
        if(!fichierDAO.create(doc))
        {
            request.setAttribute("message", "Impossible d'uploader le fichier");
            return false;
        }
        request.setAttribute("lien_document", doc.getLien());
        request.setAttribute("message", "Fichier bien inscris");
        return true;
    }     
}