package org.example.demo.ticket.model.bean.projet;

import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;


/**
 * Objet métier représentant un Projet
 *
 * @author lgu
 */
public class Projet {

    // ==================== Attributs ====================
    private Integer id;

    @NotNull
    @Size(min = 1, max = 100)
    private String nom;

    @NotNull
    private Date dateCreation;

    private Boolean cloture;

    @NotNull
    private Utilisateur responsable;


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public Projet() {
    }

    /**
     * Constructeur.
     *
     * @param pId -
     */
    public Projet(Integer pId) {
        id = pId;
    }


    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String pNom) {
        nom = pNom;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date pDateCreation) {
        dateCreation = pDateCreation;
    }
    public Boolean getCloture() {
        return cloture;
    }
    public void setCloture(Boolean pCloture) {
        cloture = pCloture;
    }
    public Utilisateur getResponsable() {
        return responsable;
    }
    public void setResponsable(Utilisateur pResponsable) {
        responsable = pResponsable;
    }


    // ==================== Méthodes ====================
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
            .append("id=").append(id)
            .append(vSEP).append("nom=\"").append(nom).append('"')
            .append(vSEP).append("dateCreation=").append(dateCreation)
            .append(vSEP).append("cloture=").append(cloture)
            .append("}");
        return vStB.toString();
    }
}
