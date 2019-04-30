package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import DAO.*;
import Model.Demand;
import Model.Offer;
import Model.User;

/**
 * 
 * @author B3427
 */
public class Services {
    public Services(){
        
    }
    
    // TODO : compléter
    public static User connexion (String mail, String mdp) {
    	JpaUtil.createEntityManager();
    	
    	User user = UserDAO.verifyUserAccount(mail, mdp);
    	JpaUtil.closeEntityManager();
    }
    
    // TODO : A completer : Dans l'ActionServlet, le bouton radio
    // permet de savoir si c'est une demande ou une offre
    public static boolean createDemand (User user, Demand demand) {
    	JpaUtil.createEntityManager();
    	JpaUtil.openTransaction();
    	
    	// Traitement sur demand ? Date de début ?
    	
    	DemandDAO demandDAO = new DemandDAO();
    	demandDAO.persist(demand);
    	
    	try {
    		JpaUtil.validateTransaction();
    	} catch (RollbackException e) {
    		JpaUtil.cancelTransaction();
    	}
    	
    	JpaUtil.closeEntityManager();
    	return true;
    }
    
 // TODO : A completer
    public static boolean createOffer (User user, Offer offer) {
    	JpaUtil.createEntityManager();
    	JpaUtil.openTransaction();
    	
    	// Traitement sur offer ? Date de début ?
    	
    	OfferDAO offerDAO = new OfferDAO();
    	offerDAO.persist(offer);
    	
    	try {
    		JpaUtil.validateTransaction();
    	} catch (RollbackException e) {
    		JpaUtil.cancelTransaction();
    	}
    	
    	JpaUtil.closeEntityManager();
    	return true;
    }
    
    // TODO : A completer : permet de retourner toutes les demandes
    // en cours
    public static List<Demand> findAllDemands() {
    	JpaUtil.createEntityManager();
    	JpaUtil.openTransaction();
    	
    	List<Demand> listDemand = new ArrayList<>();
    	
    	
    	
    	JpaUtil.closeEntityManager();
    	return listDemand;
    }
    
    // Ajouter en parametre tous les critères des filtres afin de faire nos
    // comparaison
    // TODO : A completer : permet de retourner toutes les demandes
    // en cours avec les filtres mis
    public static List<Demand> findAllDemandsWithFilter(/*Add Filter*/) {
    	JpaUtil.createEntityManager();
    	JpaUtil.openTransaction();
    	
    	List<Demand> listDemand = new ArrayList<>();
    	
    	
    	
    	JpaUtil.closeEntityManager();
    	return listDemand;
    }
    
    // TODO : A completer : permet de retourner toutes les offres
    // en cours
    public static List<Offer> findAllOffers() {
    	JpaUtil.createEntityManager();
    	JpaUtil.openTransaction();
    	
    	List<Offer> listOffer = new ArrayList<>();
    	
    	
    	
    	JpaUtil.closeEntityManager();
    	return listOffer;
    }
    
    // Ajouter en parametre tous les critères des filtres afin de faire nos
    // comparaison
    // TODO : A completer : permet de retourner toutes les offres
    // en cours avec les filtres mis
    public static List<Offer> findAllOffers(/*Add Filter*/) {
    	JpaUtil.createEntityManager();
    	JpaUtil.openTransaction();
    	
    	List<Offer> listOffer = new ArrayList<>();
    	
    	
    	
    	JpaUtil.closeEntityManager();
    	return listOffer;
    }
}
