package org.example.demo.ticket.webapp.action;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.example.demo.ticket.model.exception.FunctionalException;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.example.demo.ticket.model.exception.TechnicalException;
import org.example.demo.ticket.webapp.WebappHelper;

import com.opensymphony.xwork2.ActionSupport;

public class GestionProjetAction extends ActionSupport {

    // ===== Attributs ==============
    // ----- Paramètres en entrée
    private Integer id;

    // -----Éléments en sortie
    private List<Projet> listProjet;
    private List<Utilisateur> listUtilisateur;
    private Projet projet;

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public List<Projet> getListProjet() {
        return listProjet;
    }

    public List<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    // ======= Méthodes ========================
    /**
     * Action listant les Projet
     * @return success
     */
    public String doList() {
        listProjet = WebappHelper.getManagerFactory().getProjetManager().getListProjet();
        return ActionSupport.SUCCESS;
    }

    /**
     * Action affichant les détails d'un {@link Projet}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.project.missing.id"));
        } else {
            try {
                projet = WebappHelper.getManagerFactory().getProjetManager().getProjet(id);
            } catch (NotFoundException e) {
                //this.addActionError("Projet non trouvé. ID = " + id);
                this.addActionError(getText("error.project.notfound", Collections.singletonList(id)));
            }
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    /**
     * Action permettant de créer un nouveau {@link Projet}
     * return input / success / error
     */
    public String doCreate() {
        // Si (this.projet == null) c'est que l'on entre dans l'ajout de projet
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout.

        // Par defaut le result est "input"
        String vResult = ActionSupport.INPUT;

        // ==== Validation de l'ajout de projet (projet != null)
        if (this.projet != null) {
            // Récupération du responsable
            if (this.projet.getResponsable() == null
                    || this.projet.getResponsable().getId() == null) {
                this.addFieldError("projet.responsable.id", "ne doit pas être vide");
            } else {
                try {
                    Utilisateur vResponsable =
                            WebappHelper.getManagerFactory()
                                .getUtilisateurManager()
                                .getUtilisateur(
                                    this.projet
                                        .getResponsable()
                                        .getId());
                    this.projet.setResponsable(vResponsable);
                } catch (NotFoundException e) {
                    this.addFieldError("projet.responsable.id", e.getMessage());
                }
            }
            // Date de création
            this.projet.setDateCreation(new Date());

            // Si pas d'erreur, ajout du projet...
            if (!this.hasErrors()) {
                try {
                    WebappHelper.getManagerFactory()
                        .getProjetManager()
                        .insertProjet(this.projet);
                    // Si ajout avec succès -> Result "success"
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Projet ajouté avec succès");
                } catch (FunctionalException e) {
                    // Sur erreur fonctionnelle, on reste sur la page 
                    // de saisie et on affiche un message d'erreur
                    this.addActionError(e.getMessage());
                } catch (TechnicalException e) {
                    // Sur erreur technique, on part sur le result "error"
                    this.addActionError(e.getMessage());
                    vResult = ActionSupport.ERROR;
                }
            }
        }

        // Si on doit aller sur le formulaire de saisie, 
        // il faut ajouter les infos necessaires
        if (vResult.equals(ActionSupport.INPUT)) {
            this.listUtilisateur = WebappHelper.getManagerFactory()
                .getUtilisateurManager()
                .getListUtilisateur();
        }
        return vResult;
    }

}
