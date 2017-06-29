package autoEvaluation;

import javax.naming.InitialContext;

import autoEvaluation.entity.AutoEvaluation;
import facade.FacadeSuiviStagiaire;

/**
 * Classe qui permet de naviguer entre les différente partie concernant les {@link AutoEvaluation}
 * et aussi d'initié les données utile a la page a atteindre.
 * 
 * @author Aurélien Harlé
 * @version 1 
 * @since 28/06/2017
 *
 */
public class Navigation extends ApplicationSupport {

	private static final long serialVersionUID = 1L;
	private InitialContext context;
	private FacadeSuiviStagiaire facadeSuiviStagiaire;
	private static final String FACADE = "ejb:/server-SuiviStagiaire/FacadeSuiviStagiaire!facade.FacadeSuiviStagiaireRemote";
	private static final String CREATION = "creation";
	private static final String MODIFICATION = "modification";
	private static final String SUPPRESSION = "suppression";
	private static final String RECHERCHER = "rechercher";
	private static final String LISTER = "lister";
	
	
	
	public Navigation() {
		
	}
	
	private void init() {

		try {

			context = new InitialContext();
			facadeSuiviStagiaire = (FacadeSuiviStagiaire) context.lookup(FACADE);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Récupère la liste des competences pour integration, a la page de creation d'auto-evaluation
	 * 
	 * @return
	 */
	public String creation(){
		
		System.out.println("Bonjour");
		
		//Récupération de la liste de competence et set de celle ci
		
		return CREATION;
	}
}
