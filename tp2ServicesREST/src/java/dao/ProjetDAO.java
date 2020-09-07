/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entites.DetailsProjet;
import entites.Personne;
import entites.Projet;
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
public class ProjetDAO {
    
    
     public static int creerProjet( Projet projet)
    {
        int res=0;
        
        String requete =  "INSERT INTO projet (nom, description, idpersonne)"
                    + " VALUES (?,?,?)";
        
        
        try {
            PreparedStatement stm = DataBase.getConnection().prepareStatement(requete);
            stm.setString(1, projet.getNom());
            stm.setString(2, projet.getDescription());
            stm.setInt(3, projet.getIdPersonne());
            res = stm.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
        
    
    }
     
     
     
     
      public static List<Projet> ListerProjets() {
        List<Projet> liste = new LinkedList();
        Projet projet;
        try {
            String requete = "SELECT * FROM projet";
            Statement stm = DataBase.getConnection().createStatement();
            ResultSet resultats = stm.executeQuery(requete);
            while (resultats.next()) {
                projet = new Projet();
               projet.setIdProjet(resultats.getInt("idprojet"));
               projet.setNom(resultats.getString("nom"));
              projet.setDescription(resultats.getString("description"));
              projet.setIdPersonne(resultats.getInt("idpersonne"));
                liste.add(projet);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }    
     
      
      
      
      public static List<DetailsProjet> ListerProjetsAvecDetails(int id)
      {
          List<DetailsProjet> liste = new LinkedList();
             
             DetailsProjet detailsProjet;
         try {
             
             
             String requete = "select projet.idprojet, projet.nom, "
                     + " projet.description, personne.nom, membres.idpersonne "
                     + " FROM projet INNER JOIN membres on projet.idprojet = membres.idprojet "
                     + " INNER JOIN personne on membres.idpersonne = personne.idpersonne"
                     + " where projet.idpersonne=?";
             
             PreparedStatement stm = DataBase.getConnection().prepareStatement(requete);
            stm.setInt(1, id);
             
             ResultSet resultats = stm.executeQuery();
             
             while (resultats.next()) {
                 detailsProjet = new DetailsProjet();
                 
                 detailsProjet.setIdprojet(resultats.getInt("projet.idprojet"));
                 detailsProjet.setNomProjet(resultats.getString("projet.nom"));
                 detailsProjet.setDescriptionProjet(resultats.getString("projet.description"));
                detailsProjet.setNomMembre(resultats.getString("personne.nom"));

                  detailsProjet.setIdMembre(resultats.getInt("membres.idpersonne"));
                 
                
                 liste.add(detailsProjet);
             }
             
         } catch (SQLException ex) {
             Logger.getLogger(ProjetDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return liste;
      
      }
     public static int supprimerProjet(int idProjet,int idPersonne) {
        int res = 0;
        try {
            String requete = "DELETE FROM projet WHERE idprojet=? AND idpersonne=?";
            PreparedStatement stm = DataBase.getConnection().prepareStatement(requete);
            stm.setInt(1, idProjet);
            stm.setInt(2, idPersonne);
            res = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
     
      

}
