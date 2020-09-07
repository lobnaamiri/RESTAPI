/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entites.Invitation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.DataBase;

/**
 *
 * @author admin
 */
public class InvitationDAO {
    
     public static int creerIntivation(Invitation invitation)
    {
        int res=0;
        
        String requete =  "INSERT INTO invitation (idpersonne, idprojet, description)"
                    + " VALUES (?,?,?)";
        
        
        try {
            PreparedStatement stm = DataBase.getConnection().prepareStatement(requete);
            stm.setInt(1, invitation.getIdPersonne());
            stm.setInt(2, invitation.getIdProjet());
            stm.setString(3, invitation.getDescription());
//            stm.setBoolean(4, invitation.isReponse());
            res = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(InvitationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
        
    
    }
    
    
     public static List<Invitation> RecevoirInvitation(int id){
         
          List<Invitation> liste = new LinkedList();
        Invitation invitation;
        try {
            String requete = "SELECT invitation.idinvitation, invitation.idpersonne,"
                    + " invitation.idprojet, invitation.description,invitation.reponse,projet.nom"
                    + " FROM invitation INNER JOIN projet ON"
                    + " invitation.idprojet = projet.idprojet WHERE "
                    + "invitation.idpersonne = ? "
                    + " GROUP BY projet.idpersonne";
            PreparedStatement stm = DataBase.getConnection().prepareStatement(requete);
            stm.setInt(1, id);
            ResultSet resultats = stm.executeQuery();
        
            while (resultats.next()) {
                invitation = new Invitation();
               invitation.setIdInvitation(resultats.getInt("invitation.idinvitation"));
               invitation.setIdPersonne(resultats.getInt("invitation.idpersonne"));
               invitation.setIdProjet(resultats.getInt("invitation.idprojet"));
               invitation.setDescription(resultats.getString("invitation.description"));
               invitation.setNomProjet(resultats.getString("projet.nom"));
               invitation.setReponse(resultats.getBoolean("invitation.reponse"));
               
                liste.add(invitation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
     
     }
     

     public static int repondreInvitation(Invitation invitation)
     {   int res = 0;
         try {
         
         
         String requete = "UPDATE invitation SET reponse=? WHERE idpersonne=? AND idprojet=?";
         PreparedStatement stm = DataBase.getConnection().prepareStatement(requete);
         stm.setBoolean(1, invitation.isReponse());
         stm.setInt(2, invitation.getIdPersonne());
          stm.setInt(3, invitation.getIdProjet());
         
         res = stm.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(InvitationDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
            return res;
     }
}
