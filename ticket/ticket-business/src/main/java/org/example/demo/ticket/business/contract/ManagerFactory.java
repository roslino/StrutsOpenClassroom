package org.example.demo.ticket.business.contract;

import org.example.demo.ticket.business.contract.manager.ProjetManager;
import org.example.demo.ticket.business.contract.manager.UtilisateurManager;


/**
 * Factory des Managers
 */
public interface ManagerFactory {

    ProjetManager getProjetManager();

    UtilisateurManager getUtilisateurManager();
}
