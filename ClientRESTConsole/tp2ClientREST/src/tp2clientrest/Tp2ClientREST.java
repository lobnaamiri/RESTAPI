/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2clientrest;

import com.sun.security.ntlm.Client;
import entites.Invitation;
import entites.Membres;
import entites.Personne;
import entites.Projet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import util.Utilitaire;



/**
 *
 * @author admin
 */
public class Tp2ClientREST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        
        
        
      //  **Creer une personne 
        
        Personne personne = new Personne();
        personne.setNom("clair");
        personne.setPrenom("clairclair");
        personne.setEmail("clair@clair.com");
        personne.setPassword("1234");
       
        Utilitaire.AddPerson(personne);
        
        
 //** Se connecter
        Personne personne2 = new Personne();
        personne2 = Utilitaire.ConnectPersonne("clair@clair.com", "1234");
        System.out.println(" votre id est :" +personne2.getIdPersonne());
        System.out.println("votre nom est :" +personne2.getNom());
        System.out.println("votre prenom est :" +personne2.getPrenom());



//** Creer un projet

 Projet projet = new Projet();
  projet.setIdPersonne(1);
  projet.setNom("Projet Service web");
  projet.setDescription("Creer un service web");
        
  Utilitaire.AddProject(projet);


//** Creer une invitation

    Invitation invitation = new Invitation();
    
    invitation.setIdPersonne(1);
    invitation.setIdProjet(8);
    invitation.setDescription("Rejoindre une equipe services web");
    
    Utilitaire.AddInvitation(invitation);
    
    String liste = null;
    
    liste = Utilitaire.GetInvitations(1);
        System.out.println(liste);
    

  invitation.setReponse(true);
  
//** Repondre a une invitation
  Utilitaire.AnswerInvitation(1, 8,true);

  
 // ** Voir tous les projets
  
  String s = Utilitaire.GetAllProjects();
        System.out.println(s);
 // **Details des projets d un utisateurs      
        String s2 = Utilitaire.DetailsProject(1);
        
        System.out.println(s2);

//** supprimer un membre de mon projet
Utilitaire.deleteMembre(1, 3);
    }
    
}
