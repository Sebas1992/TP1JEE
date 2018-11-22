/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Services;

import com.GestionStage.DAO.CandidatureDAO;
import com.GestionStage.DAO.CommunicationsDAO;
import com.GestionStage.DAO.CoordonnateurDAO;
import com.GestionStage.DAO.UploadFichierDAO;
import com.GestionStage.Entites.Candidature;
import com.GestionStage.Entites.Communication;
import com.GestionStage.Entites.Document;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

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
    
    public List<Candidature> getCandidatures()
    {
        CandidatureDAO candDAO = new CandidatureDAO();
        return candDAO.findCandidatures();
    }
    
    public boolean UploadFile(HttpServletRequest request)
    {
        // *******************************************
        // upload le fichier dans le dossier documents
        //********************************************
        Part filePart;
        try {
            filePart = request.getPart("fichier");                        
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
        
        request.setAttribute("message", "Fichier bien inscris");
        return true;
    }            
}
