/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@XmlRootElement
public class DetailsProjet implements Serializable {
    
    private int idprojet;
    private String nomProjet;
    private String descriptionProjet;
    private String nomMembre;
    private int idMembre;
    private int idCreateurProjet;
    
    public DetailsProjet(){}

    public DetailsProjet(int idprojet, String nomProjet, String descriptionProjet, String nomMembre, int idMembre, int idCreateurProjet) {
        this.idprojet = idprojet;
        this.nomProjet = nomProjet;
        this.descriptionProjet = descriptionProjet;
        this.nomMembre = nomMembre;
        this.idMembre = idMembre;
        this.idCreateurProjet = idCreateurProjet;
    }

     public DetailsProjet(int idprojet, String nomProjet, String descriptionProjet, String nomMembre, int idMembre) {
        this.idprojet = idprojet;
        this.nomProjet = nomProjet;
        this.descriptionProjet = descriptionProjet;
        this.nomMembre = nomMembre;
        this.idMembre = idMembre;
        this.idCreateurProjet = idCreateurProjet;
    }
    public int getIdprojet() {
        return idprojet;
    }

    public void setIdprojet(int idprojet) {
        this.idprojet = idprojet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public String getDescriptionProjet() {
        return descriptionProjet;
    }

    public void setDescriptionProjet(String descriptionProjet) {
        this.descriptionProjet = descriptionProjet;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public int getIdCreateurProjet() {
        return idCreateurProjet;
    }

    public void setIdCreateurProjet(int idCreateurProjet) {
        this.idCreateurProjet = idCreateurProjet;
    }
    
    
    
    
}
