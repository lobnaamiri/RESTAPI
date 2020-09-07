/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.InvitationDAO;
import dao.MembresDAO;
import dao.PersonneDAO;
import dao.ProjetDAO;
import entites.DetailsProjet;
import entites.Invitation;
import entites.Membres;
import entites.Personne;
import entites.Projet;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author admin
 */
@Stateless
@Path("/projet")
public class ProjetResource {

 
    public ProjetResource() {
    }

    /**
     * Retrieves representation of an instance of services.ProjetResource
     * @return an instance of java.lang.String
     */
    
    // Get All projects
      @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Projet> findAllProjects() {
        System.out.println("Afficher tous les projets");
        return ProjetDAO.ListerProjets();
    }
    
     
    // create a new project
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public int createProject(Projet projet) {
       
        System.out.println("Creer un projet");
        return ProjetDAO.creerProjet( projet);
    }
    
    @GET
      @Path("/personne/{id1}/{id2}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Personne createPerson(@PathParam("id1")String email, @PathParam("id2")String motDePass) {
       
        System.out.println("Creer une personne");
        return PersonneDAO.seConnecter(email, motDePass);
    }
    
      @GET
      @Path("/personne")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Personne> findAllPersons(){
       
          System.out.println("Afficher toutes les personnes");
          return PersonneDAO.ListerPersonnes();
    }
    
 
      @POST
      @Path("/personne")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public int createPerson(Personne personne) {
       
        System.out.println("Creer une personne");
        return PersonneDAO.creerPersonne(personne);
    }
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<DetailsProjet> find(@PathParam("id") int id) {
        System.out.println("Details d'un projet cree par l'utilisateur");
        return ProjetDAO.ListerProjetsAvecDetails(id);
    }
   
    @GET
    @Path("/invitation/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Invitation> getInvitations(@PathParam("id") int id) {
        System.out.println("afficher les invitations ");
        return InvitationDAO.RecevoirInvitation(id);
    }

    
    @POST
    @Path("/invitation")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public int createInvitation(Invitation invitation) {
       
        System.out.println("Creer une invitation");
        return InvitationDAO.creerIntivation(invitation);
    }
    
      @DELETE
    @Path("/suppmembre/{idMembreProjet}/{idCreateurProjet}")
    public int removeMember( @PathParam("idMembreProjet")int id1, @PathParam("idCreateurProjet")int id2) {
       int res =0;
        System.out.println("Suppression d'un membre d'une equipe ");
//        Membres membre = MembresDAO.trouverMembre(id1);
//        Personne personne = PersonneDAO.trouverPersonne(id2);
        
        
        
        res = MembresDAO.delete(id1, id2);
        
          return res;  
        
    }
     @PUT
    @Path("/invitation/{idpersonne}/{idprojet}/{reponse}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public int editInvitation(@PathParam("idpersonne") int idpersonne,@PathParam("idprojet") int idprojet,@PathParam("reponse") boolean reponse) {
       int res=0;
       Invitation invitation = new Invitation();
        invitation.setIdPersonne(idpersonne);
        invitation.setIdProjet(idprojet);
        invitation.setReponse(reponse);
        res=InvitationDAO.repondreInvitation(invitation);
        return res;
    }
    }

