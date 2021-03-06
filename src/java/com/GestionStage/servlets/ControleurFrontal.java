
package com.GestionStage.servlets;

import com.GestionStage.Controlleurs.AbstractAction;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.GestionStage.Controlleurs.ActionBuilder;
import com.GestionStage.Controlleurs.Action;
import com.GestionStage.Controlleurs.RequirePRG;
import com.GestionStage.Singleton.DbConnexion;
import java.sql.Connection;
import javax.servlet.annotation.MultipartConfig;

/**
 *
 * @author Utilisateur
 */
@MultipartConfig
public class ControleurFrontal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // Pour l'instant l'url pattern est / ( voir web.xml)
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Action action = ActionBuilder.getAction(request);
        action.setRequest(request);
        action.setResponse(response);
        
        String vue = action.execute();
        
        if(action instanceof RequirePRG)
        {
            response.sendRedirect("?action=show&vue=" + vue);
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/vues/"+vue+".jsp").forward(request, response);
        }
        
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
