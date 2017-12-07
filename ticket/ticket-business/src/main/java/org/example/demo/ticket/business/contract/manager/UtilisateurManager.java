package org.example.demo.ticket.business.contract.manager;

import java.util.List;

import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.example.demo.ticket.model.exception.NotFoundException;


/**
 * Manager du package « utilisateur »
 */
public interface UtilisateurManager {

    /**
     * Renvoie la liste des {@link Utilisateur}
     *
     * @return List
     */
    List<Utilisateur> getListUtilisateur();

    /**
     * Renvoie l'{@link Utilisateur} demandé
     *
     * @param pId l'identifiant de l'Utilisateur
     * @return Le {@link Utilisateur}
     * @throws NotFoundException Si l'Utilisateur n'est pas trouvé
     */
    Utilisateur getUtilisateur(Integer pId) throws NotFoundException;


    /**
     * Renvoie l'{@link Utilisateur} correspondant au couple login / mot de passe
     *
     * @param pLogin le login de l'Utilisateur
     * @param pPassword le mot de passe de l'Utilisateur
     * @return Le {@link Utilisateur}
     * @throws NotFoundException Si l'Utilisateur n'est pas trouvé
     */
    Utilisateur getUtilisateur(String pLogin, String pPassword) throws NotFoundException;
}
