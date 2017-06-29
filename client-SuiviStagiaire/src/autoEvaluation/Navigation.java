package autoEvaluation;

import javax.naming.InitialContext;

import autoEvaluation.entity.AutoEvaluation;
import facade.FacadeSuiviStagiaire;

/**
 * Classe qui permet de naviguer entre les diff�rente partie concernant les {@link AutoEvaluation}
 * et aussi d'initi� les donn�es utile a la page a atteindre.
 * 
 * @author Aur�lien Harl�
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
	 * R�cup�re la liste des competences pour integration, a la page de creation d'auto-evaluation
	 * 
	 * @return
	 */
	public String creation(){
		
		System.out.println("Bonjour");
		
		//R�cup�ration de la liste de competence et set de celle ci
		
		return CREATION;
	}
}
