/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entites.Membres;
import entites.Personne;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.DataBase;

/**
 *
 * @author admin
 */
public class MembresDAO {
    
       public static int delete(int idMembreEquipe, int idCreateurProjet) {
        int res = 0;
        try {
            
            
            
            String requete = "DELETE membres FROM membres   INNER JOIN projet ON"
                    + " membres.idprojet = projet.idprojet WHERE "
                    + " membres.idpersonne=? AND projet.idpersonne=?";
                    
            PreparedStatement stm = DataBase.getConnection().prepareStatement(requete);
            stm.setInt(1,idMembreEquipe );
            stm.setInt(2,idCreateurProjet);
            res = stm.executeUpdate();
            System.out.println("tototo :" +idMembreEquipe);
            System.out.println("tototo2 :" +idCreateurProjet);
        } catch (SQLException ex) {
            Logger.getLogger(MembresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
       
       public static Membres trouverMembre(int id) {
        Membres membre = null;
        try {
            String requete = "SELECT * FROM membres WHERE idpersonne=?";
            PreparedStatement stm = DataBase.getConnection().prepareStatement(requete);
            stm.setInt(1, id);
            ResultSet resultats = stm.executeQuery();
            if (resultats.next()) {
                membre = new Membres();
                membre.setIdMembre(resultats.getInt("idmembre"));
                membre.setIdPersonne(resultats.getInt("idpersonne"));
                membre.setIdProjet(resultats.getInt("idprojet"));
               
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return membre;
    }
}
