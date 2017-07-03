package autoEvaluation;

import javax.naming.InitialContext;

import autoEvaluation.entity.AutoEvaluation;
import competence.technique.Competences;
import facade.FacadeSuiviStagiaireRemote;
import niveauAcquisition.technique.NiveauAcquisitions;

/**
 * Classe qui permet de naviguer entre les différentes partie concernant les {@link AutoEvaluation}
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
	private FacadeSuiviStagiaireRemote facadeSuiviStagiaireRemote;

	private static final String FACADE = "ejb:/server-SuiviStagiaire/FacadeSuiviStagiaire!facade.FacadeSuiviStagiaireRemote";
	private static final String CREATION = "creation";
	private static final String MODIFICATION = "modification";
	private static final String SUPPRESSION = "suppression";
	private static final String RECHERCHER = "recherche";
	private static final String LISTER = "listage";
	
	public Competences competences;
	public NiveauAcquisitions niveauAcquisitions;
	
	
	
	public Navigation() {
		
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
	 * Méthode lancer avant l'arriver sur la page, de creation d'une auto-évaluation, 
	 * elle permet de récupérer la liste des competences pour integration, a la page de creation d'auto-evaluation
	 * 
	 * @return
	 */
	public String creation(){
		
		init();
		
		competences = facadeSuiviStagiaireRemote.selectCompetences();
		
		niveauAcquisitions = facadeSuiviStagiaireRemote.selectNiveauAcquisitions();
		
		return CREATION;
		
	}
	
	/**
	 * Méthode lancer avant l'arriver sur la page, de modification d'une auto-évaluation, 
	 * 
	 * @return
	 */
	public String modification(){
		
		init();
		
		System.out.println("Modification");
		
		return MODIFICATION;
		
	}
	
	/**
	 * Méthode lancer avant l'arriver sur la page, de suppression d'une auto-évaluation, 
	 * 
	 * @return
	 */
	public String suppression(){
		
		init();
		
		System.out.println("suppression");
		
		return SUPPRESSION;
		
	}
	
	/**
	 * Méthode lancer avant l'arriver sur la page, de rechercher d'une auto-évaluation, 
	 * 
	 * @return
	 */
	public String rechercher(){
		
		init();
		
		System.out.println("rechercher");
		
		return RECHERCHER;
		
	}
	
	/**
	 * Méthode lancer avant l'arriver sur la page, de lister d'une auto-évaluation, 
	 * 
	 * @return
	 */
	public String lister(){
		
		init();
		
		System.out.println("lister");
		
		return LISTER;
		
	}
	

	/**
	 * @return the competences
	 */
	public Competences getCompetences() {
		return competences;
	}

	/**
	 * @param competences the competences to set
	 */
	public void setCompetences(Competences competences) {
		this.competences = competences;
	}

	/**
	 * @return the niveauAcquisitions
	 */
	public NiveauAcquisitions getNiveauAcquisitions() {
		return niveauAcquisitions;
	}

	/**
	 * @param niveauAcquisitions the niveauAcquisitions to set
	 */
	public void setNiveauAcquisitions(NiveauAcquisitions niveauAcquisitions) {
		this.niveauAcquisitions = niveauAcquisitions;
	}
}
