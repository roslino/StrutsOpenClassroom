package org.example.demo.ticket.business.impl.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.example.demo.ticket.business.contract.manager.ProjetManager;
import org.example.demo.ticket.business.contract.manager.UtilisateurManager;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.projet.Version;
import org.example.demo.ticket.model.exception.FunctionalException;
import org.example.demo.ticket.model.exception.NotFoundException;


@Named
public class ProjetManagerImpl extends AbstractManager implements ProjetManager {

    @Inject
    private UtilisateurManager utilisateurManager;

    // Je stocke les projets en mémoire car je n'ai pas codé de persistance
    private final List<Projet> listProjet = new ArrayList<>();


    @Override
    public Projet getProjet(Integer pId) throws NotFoundException {
        // Je n'ai pas codé la DAO, je mets juste un code pour le cours...
        Projet vProjet
            = this.listProjet.stream()
                             .filter(p -> p.getId().equals(pId))
                             .findFirst()
                             .orElseThrow(() -> new NotFoundException("Projet non trouvé : ID=" + pId));
        return vProjet;
    }


    @Override
    public List<Projet> getListProjet() {
        // Je n'ai pas codé la DAO, je mets juste un code pour le cours...
        return this.listProjet;
    }


    /**
     * Initialise et peuple la liste de {@link Projet}
     */
    @PostConstruct
    private void initListProjet() {
        for (int vId = 0; vId < 9; vId++) {
            Projet vProjet = new Projet(vId);
            vProjet.setNom("Projet n°" + vId);
            vProjet.setCloture(false);
            vProjet.setDateCreation(new Date());
            try {
                vProjet.setResponsable(utilisateurManager.getUtilisateur(vId % 4));
            } catch (NotFoundException vEx) {
                vProjet.setResponsable(null);
            }

            this.listProjet.add(vProjet);
        }
    }


    @Override
    public void insertProjet(Projet pProjet) throws FunctionalException {
        if (pProjet == null) {
            throw new FunctionalException("L'objet Projet ne doit pas être null !");
        }

        Set<ConstraintViolation<Projet>> vViolations = getConstraintValidator().validate(pProjet);
        if (!vViolations.isEmpty()) {
            throw new FunctionalException("L'objet Projet est invalide",
                                          new ConstraintViolationException(vViolations));
        }

        // TODO Persistance
        pProjet.setId(999);
        this.listProjet.add(pProjet);
    }


    @Override
    public List<Version> getListVersion(Projet pProjet) {
        // Je n'ai pas codé la DAO, je mets juste un code pour le cours...
        List<Version> vListVersion = new ArrayList<>();
        Version vVersion;
        for (int vI = 0; vI < 5; vI++) {
            vVersion = new Version();
            vVersion.setProjet(pProjet);
            vVersion.setNumero("1." + pProjet.getId() + '.' + vI);
            vListVersion.add(vVersion);
        }
        return vListVersion;
    }


    @Override
    public void insertVersion(Version pVersion) throws FunctionalException {
        if (pVersion == null) {
            throw new FunctionalException("L'objet Version ne doit pas être null !");
        }

        Set<ConstraintViolation<Version>> vViolations = getConstraintValidator().validate(pVersion);
        if (!vViolations.isEmpty()) {
            throw new FunctionalException("L'objet Version est invalide",
                                          new ConstraintViolationException(vViolations));
        }

        // TODO Persistance
    }

}
