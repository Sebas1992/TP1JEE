/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GestionStage.Services;

import com.GestionStage.DAO.CandidatureDAO;
import com.GestionStage.DAO.CommunicationsDAO;
import com.GestionStage.DAO.CoordonnateurDAO;
import com.GestionStage.Entites.Candidature;
import com.GestionStage.Entites.Communication;
import com.GestionStage.Entites.Document;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
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
        try {
            ServletFileUpload sfu = new ServletFileUpload(new DiskFileItemFactory());
            List<FileItem> fichiers = sfu.parseRequest(new ServletRequestContext(request));
            for(FileItem doc : fichiers)
            {
                /*
                doc.write(new File(request.getContextPath()));
                Document document = new Document(doc.getName(), );                          
*/                
                System.out.println(request.getContextPath());
            }
            
        } catch (FileUploadException ex) {
            Logger.getLogger(CoordonnateurService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
