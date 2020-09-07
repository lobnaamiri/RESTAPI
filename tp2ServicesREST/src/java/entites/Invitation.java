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
public class Invitation implements Serializable {
    
    
    private int idInvitation;
    private int idPersonne;
    private int idProjet;
    private String nomProjet;
    private String description;
    private boolean reponse;

    
    public Invitation(){}
    
    public Invitation(int idInvitation, int idPersonne, int idProjet, String nomProjet, String description, boolean reponse) {
        this.idInvitation = idInvitation;
        this.idPersonne = idPersonne;
        this.idProjet = idProjet;
        this.nomProjet = nomProjet;
        this.description = description;
        this.reponse = reponse;
    }

    public int getIdInvitation() {
        return idInvitation;
    }

    public void setIdInvitation(int idInvitation) {
        this.idInvitation = idInvitation;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isReponse() {
        return reponse;
    }

    public void setReponse(boolean reponse) {
        this.reponse = reponse;
    }
    
    
    
}
