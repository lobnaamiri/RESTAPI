/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import entities.Invitation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilitaire.Util;

/**
 *
 * @author admin
 */
public class EnregistrerReponseInvitationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int idPersonne = Integer.parseInt(request.getParameter("idPersonne"));
            int idProjet = Integer.parseInt(request.getParameter("idProjet"));
            boolean reponse = Boolean.parseBoolean(request.getParameter("reponse"));
            Util.AnswerInvitation(idPersonne, idProjet, reponse);
            
            int i = Integer.parseInt(request.getParameter("idPersonne"));
          
        String reponse2;
          reponse2 = Util.GetInvitations(i);
          Gson gson = new Gson();
            java.lang.reflect.Type type = new TypeToken<List<Invitation>>(){}.getType();
    List<Invitation> invitationList = new LinkedList();
            invitationList = gson.fromJson(reponse2, type);
           
      request.setAttribute("DetailsInvitations",invitationList);
            RequestDispatcher rd = request.getRequestDispatcher("afficherDetailsInvitations.jsp");
       
        rd.forward(request, response);
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
