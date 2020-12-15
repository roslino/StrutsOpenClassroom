package org.example.demo.ticket.webapp.action;

import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.example.demo.ticket.webapp.WebappHelper;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Action de gestion des utilisateurs
 * @author Guy-Ross ASSOUMOU
 *
 */
public class GestionUtilisateurAction extends ActionSupport {

    // ======== Attributs ====================
    // ------- Paramètres en entrée
    private Integer id;

    //------- Éléments en sortie
    Utilisateur utilisateur;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    // ====== Méthodes =========
    /**
     * Action affichant les détails d'un {@link Utilisateur}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id d'utilisateur");
        } else {
            try {
                utilisateur = WebappHelper.getManagerFactory().getUtilisateurManager().getUtilisateur(id);
            } catch (NotFoundException e) {
                this.addActionError("Utilisateur non trouvé. ID = " + id);
            }
        }
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}
