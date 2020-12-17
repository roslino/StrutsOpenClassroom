package org.example.demo.ticket.webapp.action;

import java.util.Collections;
import java.util.List;

import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.example.demo.ticket.webapp.WebappHelper;

import com.opensymphony.xwork2.ActionSupport;

public class GestionProjetAction extends ActionSupport {

    // ===== Attributs ==============
    // ----- Paramètres en entrée
    private Integer id;

    // -----Éléments en sortie
    private List<Projet> listProjet;
    private Projet projet;

    public Projet getProjet() {
        return projet;
    }

    public List<Projet> getListProjet() {
        return listProjet;
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

}
