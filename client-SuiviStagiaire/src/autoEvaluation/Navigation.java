package autoEvaluation;

import java.time.LocalDate;

import javax.naming.InitialContext;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import competence.technique.Competences;
import facade.FacadeSuiviStagiaireRemote;
import niveauAcquisition.technique.NiveauAcquisitions;
import stagiaire.entity.Stagiaire;

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
	
	private Competences competences;
	private NiveauAcquisitions niveauAcquisitions;
	private AutoEvaluations autoEvaluations;
	private LocalDate dateJour;
	private String identifiantAutoEvaluation;
	private AutoEvaluation autoEvaluation;
	
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

		niveauAcquisitions = facadeSuiviStagiaireRemote.selectNiveauAcquisitions();
		
		if(identifiantAutoEvaluation!=null){
			
			autoEvaluation = new AutoEvaluation(Integer.parseInt(identifiantAutoEvaluation));
			autoEvaluation = facadeSuiviStagiaireRemote.selectAutoEvaluation(autoEvaluation);
			
		}
		
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
	public String listage(){
		
		init();
		
		//Stagiaire creer en dure avant gestion des comptes
		Stagiaire stagiaire = new Stagiaire("13111384", "Password", "Harlé", "Aurélien", null, null, null, null, null, null);
		
		AutoEvaluation autoEvaluation = new AutoEvaluation(null, null, stagiaire, null, null);
		
		autoEvaluations = facadeSuiviStagiaireRemote.selectAutoEvaluationByStag(autoEvaluation);
		dateJour = LocalDate.now();
		
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

	public AutoEvaluations getAutoEvaluations() {
		return autoEvaluations;
	}

	public void setAutoEvaluations(AutoEvaluations autoEvaluations) {
		this.autoEvaluations = autoEvaluations;
	}

	/**
	 * @return the dateJour
	 */
	public LocalDate getDateJour() {
		return dateJour;
	}

	/**
	 * @param dateJour the dateJour to set
	 */
	public void setDateJour(LocalDate dateJour) {
		this.dateJour = dateJour;
	}

	public String getIdentifiantAutoEvaluation() {
		return identifiantAutoEvaluation;
	}

	public void setIdentifiantAutoEvaluation(String identifiantAutoEvaluation) {
		this.identifiantAutoEvaluation = identifiantAutoEvaluation;
	}

	public AutoEvaluation getAutoEvaluation() {
		return autoEvaluation;
	}

	public void setAutoEvaluation(AutoEvaluation autoEvaluation) {
		this.autoEvaluation = autoEvaluation;
	}
}
