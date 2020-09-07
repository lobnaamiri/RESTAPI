/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import entities.Invitation;
import entities.Personne;
import entities.Projet;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author admin
 */
public class Util {
      public static void AddPerson(Personne p)
            
    {
        client.target(BASE_URI+"/personne")
            .request(MediaType.APPLICATION_JSON)
            .post(Entity.entity(p, MediaType.APPLICATION_JSON));
    
    }
    
      public static String GetAllProjects(){
          String response ;
         response = client.target(BASE_URI)
                .request(MediaType.APPLICATION_JSON).get(String.class);
        return response;
    }
      
      public static String GetAllPersons()
      {
          String response;
          response =  client.target(BASE_URI+"/personne")
                .request(MediaType.APPLICATION_JSON).get(String.class);
          return response;
      }
      
          public static void AddInvitation(Invitation i){
    
            client
          .target(BASE_URI+"/invitation")
          .request(MediaType.APPLICATION_JSON)
          .post(Entity.entity(i, MediaType.APPLICATION_JSON));   
            
          
    }
          
          public static String DetailsProject(int i)
          {
          String liste = null;
          liste = client
          .target(BASE_URI+"/"+i)
          .request(MediaType.APPLICATION_JSON).get(String.class);
          return liste;
          }
          
          public static String GetInvitations(int i)
          {String liste = null;
          liste =   client
          .target(BASE_URI+"/invitation"+"/"+i)
          .request(MediaType.APPLICATION_JSON).get(String.class);
          
          return liste;
          }
    
    public static void AddProject(Projet p)
    {client.target(BASE_URI)
            .request(MediaType.APPLICATION_JSON)
            .post(Entity.entity(p, MediaType.APPLICATION_JSON));
    }
    
    
    
    
    
    
    
    
    
    public static void deleteMembre(int m,int p)
    {
        client.target(BASE_URI+"/suppmembre/"+m+"/"+p)
                .request().delete();
                
        
               
  
    }
    
    public static void addPerson(Personne p)
    {  client.target(BASE_URI+"/personne").request(MediaType.APPLICATION_JSON).post(Entity.entity(p, MediaType.APPLICATION_JSON));
    
    }
    
    
    public static Personne ConnectPersonne(String e, String m)
    { Personne p = 
            client.target(BASE_URI+"/personne/"+e+"/"+m).request(MediaType.APPLICATION_JSON).get(Personne.class);

    
    
    return p;}
    
    public static void AnswerInvitation(int personne,int projet, boolean reponse)
    {
        client.target(BASE_URI+"/invitation/"+personne+"/"+projet+"/"+reponse).request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(new Invitation(), MediaType.APPLICATION_JSON));;
    
    }
     static final String BASE_URI = "http://localhost:9999/tp2ServicesREST/webresources/projet";
     
   static javax.ws.rs.client.Client client = javax.ws.rs.client.ClientBuilder.newClient();
}
