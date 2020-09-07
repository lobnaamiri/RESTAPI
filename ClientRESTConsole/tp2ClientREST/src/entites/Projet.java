/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */

@XmlRootElement

public class Projet implements Serializable{
    
    private int idProjet;
    private String nom;
    private String description;
    private int idPersonne;
    
    
    public Projet(){}

    public Projet(int idProjet, String nom, String description, int idPersonne) {
        this.idProjet = idProjet;
        this.nom = nom;
        this.description = description;
        this.idPersonne = idPersonne;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }
    
    
    
    
}
