package org.example.demo.ticket.webapp;

import org.example.demo.ticket.business.contract.ManagerFactory;


/**
 * Classe de helper temporaire pour la webapp...
 */
public abstract class WebappHelper {

    private static ManagerFactory managerFactory;

    public static ManagerFactory getManagerFactory() {
        return managerFactory;
    }
    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }
}
