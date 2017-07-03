package autoEvaluation;

import javax.naming.InitialContext;

import autoEvaluation.entity.AutoEvaluation;
import competence.entity.Competence;
import facade.FacadeSuiviStagiaireRemote;
import niveauAcquisition.entity.NiveauAcquisition;

/**
 * Classe qui permet de réalisé des action concernant l' {@link AutoEvaluation}.
 * 
 * @author Aurélien Harlé
 * @version 1
 * @since 03/07/2017
 *
 */
public class Action extends ApplicationSupport {

	private static final long serialVersionUID = 1L;
	private InitialContext context;
	private FacadeSuiviStagiaireRemote facadeSuiviStagiaireRemote;
	private static final String FACADE = "ejb:/server-SuiviStagiaire/FacadeSuiviStagiaire!facade.FacadeSuiviStagiaireRemote";
	
	private static final String CREER = "creer";
	private static final String MODIFIER = "modifier";
	private static final String SUPPRIMER = "supprimer";
	private static final String RECHERCHER = "rechercher";
	private static final String LISTER = "lister";
	
	public Competence competence;
	public String ressenti;
	public NiveauAcquisition niveauAcquisition;
	
	public Action() {
		
	}
	
	/**
	 * Initialise la connection vers le serveur EJB.
	 */
	private void init() {

		try {

			context = new InitialContext();
			facadeSuiviStagiaireRemote = (FacadeSuiviStagiaireRemote) context.lookup(FACADE);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Méthode qui est lancer une fois le formulaire de creation lancer,
	 *  
	 * @return CREER String
	 * 
	 */
	public String creer(){
		
		init();
		
		System.out.println("Creer");
		
		return CREER;
		
	}
	
	/**
	 * Méthode qui est lancer une fois le formulaire de modification lancer,
	 *  
	 * @return MODIFIER String
	 * 
	 */
	public String modifier(){
		
		init();
		
		System.out.println("modifier");
		
		return MODIFIER;
		
	}
	
	/**
	 * Méthode qui est lancer une fois le formulaire de suppression lancer,
	 *  
	 * @return MODIFIER String
	 * 
	 */
	public String supprimer(){
		
		init();
		
		System.out.println("supprimer");
		
		return SUPPRIMER;
		
	}
	
	/**
	 * Méthode qui est lancer une fois le formulaire de recherche lancer,
	 *  
	 * @return RECHERCHER String
	 * 
	 */
	public String rechercher(){
		
		init();
		
		System.out.println("rechercher");
		
		return RECHERCHER;
		
	}
	
	/**
	 * Méthode qui est lancer une fois le formulaire de listage lancer,
	 *  
	 * @return LISTER String
	 * 
	 */
	public String lister(){
		
		init();
		
		System.out.println("lister");
		
		return LISTER;
		
	}

}
