/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entites.Personne;
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
public class PersonneDAO {
    
    public static int creerPersonne(Personne personne)
    {
        int res=0;
        
        String requete =  "INSERT INTO personne (nom, prenom, email,motdepass)"
                    + " VALUES (?,?,?,?)";
        
        
        try {
            PreparedStatement stm = DataBase.getConnection().prepareStatement(requete);
            stm.setString(1, personne.getNom());
            stm.setString(2, personne.getPrenom());
            stm.setString(3, personne.getEmail());
            stm.setString(4, personne.getPassword());
            res = stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
        
    
    }
    
         
      public static List<Personne> ListerPersonnes() {
        List<Personne> liste = new LinkedList();
        Personne personne;
        try {
            String requete = "SELECT idpersonne,nom FROM personne";
            Statement stm = DataBase.getConnection().createStatement();
            ResultSet resultats = stm.executeQuery(requete);
            while (resultats.next()) {
                personne = new Personne();
               personne.setIdPersonne(resultats.getInt("idpersonne"));
              personne.setNom(resultats.getString("nom"));
              
                liste.add(personne);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProjetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return liste;
    }    
     
    
    public static Personne seConnecter(String email, String motDePass){
        
        Personne personne = null;
        try {
            PreparedStatement stm = null;
            
            
            String requete = "SELECT idpersonne,nom,prenom FROM personne WHERE email=? AND motdepass=?";        
            
            
            stm = DataBase.getConnection().prepareStatement(requete);
        
            stm.setString(1, email);
            stm.setString(2, motDePass);
            ResultSet resultats = stm.executeQuery();
            
            
            if (resultats.next()) {
                personne = new Personne();
                personne.setIdPersonne(resultats.getInt("idpersonne"));
                personne.setNom(resultats.getString("nom"));
                personne.setPrenom(resultats.getString("prenom"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return personne;
    
    }
    
        public static Personne trouverPersonne(int id) {
        Personne personne = null;
        try {
            String requete = "SELECT * FROM personne WHERE idpersonne=?";
            PreparedStatement stm = DataBase.getConnection().prepareStatement(requete);
            stm.setInt(1, id);
            ResultSet resultats = stm.executeQuery();
            if (resultats.next()) {
                personne = new Personne();
               personne.setIdPersonne(resultats.getInt("idpersonne"));
                personne.setNom(resultats.getString("nom"));
                personne.setPrenom(resultats.getString("prenom"));
                personne.setPrenom(resultats.getString("prenom"));
                personne.setEmail(resultats.getString("email"));
                personne.setPassword(resultats.getString("motdepass"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PersonneDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personne;
    }
 
}

