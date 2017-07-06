package autoEvaluation;

import java.time.LocalDate;

import javax.naming.InitialContext;

import autoEvaluation.entity.AutoEvaluation;
import competence.entity.Competence;
import exception.DateNullException;
import exception.NullException;
import exception.UnfoundException;
import facade.FacadeSuiviStagiaireRemote;
import module.entity.Module;
import niveauAcquisition.entity.NiveauAcquisition;
import sequence.entity.Sequence;
import stagiaire.entity.Stagiaire;

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
	
	private String stringCompetence;
	private String stringNiveauAcquisition;
	private String identifiantAutoEvaluation;
	private String ressenti;

	
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
		String retour = Action.SUCCESS;
		
		//Stagiaire creer en dure avant gestion des comptes
		Stagiaire stagiaire = new Stagiaire("13111384", "Password", "Harlé", "Aurélien", null, null, null, null, null, null);
		
		//Creation et recupération d'une competence depuis un string
		Competence competence = selectCompetenceFromString();
		
		//Creation et recupération d'un niveauAcquisition depuis un string
		NiveauAcquisition niveauAcquisition = selectNiveauAcquisitionFromString();
		
		//Date du jour
		LocalDate dateAutoEvaluation = LocalDate.now();
		
		//Creation autoEvaluation et insertion
		AutoEvaluation autoEvaluation = new AutoEvaluation(competence, niveauAcquisition, stagiaire, dateAutoEvaluation, getRessenti());
		
		try {
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluation);
		} catch (NullException | DateNullException e) {
			retour = Action.ERROR;
			e.printStackTrace();
		}
		
		return retour;
		
	}

	/**
	 * Méthode qui est lancer une fois le formulaire de modification lancer,
	 *  
	 * @return MODIFIER String
	 * 
	 */
	public String modifier(){
		
		init();
		String retour = Action.SUCCESS;
		System.out.println("modifier");
		
		System.out.println(getStringCompetence());
		System.out.println(getStringNiveauAcquisition());
		System.out.println(getIdentifiantAutoEvaluation());
		System.out.println(getRessenti());
		
		
		//Stagiaire creer en dure avant gestion des comptes
		Stagiaire stagiaire = new Stagiaire("13111384", "Password", "Harlé", "Aurélien", null, null, null, null, null, null);
		
		//Creation et recupération d'une competence depuis un string
		Competence competence = selectCompetenceFromString();
		
		//Creation et recupération d'un niveauAcquisition depuis un string
		NiveauAcquisition niveauAcquisition = selectNiveauAcquisitionFromString();
		
		//Date du jour
		LocalDate dateAutoEvaluation = LocalDate.now();
		
		//Creation autoEvaluation et insertion
		AutoEvaluation autoEvaluation = new AutoEvaluation(Integer.parseInt(identifiantAutoEvaluation),competence, niveauAcquisition, stagiaire, dateAutoEvaluation, getRessenti());
		
		facadeSuiviStagiaireRemote.updateAutoEvaluation(autoEvaluation);
		
		return retour;
		
	}
	
	/**
	 * Méthode qui est lancer une fois le formulaire de suppression lancer,
	 *  
	 * @return MODIFIER String
	 * 
	 */
	public String supprimer(){
		
		init();
		String retour = Action.SUCCESS;
		System.out.println("supprimer");
		
		AutoEvaluation autoEvaluation = new AutoEvaluation(Integer.parseInt(identifiantAutoEvaluation));
		autoEvaluation = facadeSuiviStagiaireRemote.selectAutoEvaluation(autoEvaluation);
		facadeSuiviStagiaireRemote.deleteAutoEvaluation(autoEvaluation);
		
		return retour;
		
	}
	
	/**
	 * Méthode qui est lancer une fois le formulaire de recherche lancer,
	 *  
	 * @return RECHERCHER String
	 * 
	 */
	public String rechercher(){
		
		init();
		String retour = Action.SUCCESS;
		System.out.println("rechercher");
		
		return retour;
		
	}
	
	/**
	 * Méthode qui est lancer une fois le formulaire de listage lancer,
	 *  
	 * @return LISTER String
	 * 
	 */
	public String lister(){
		
		init();
		String retour = Action.SUCCESS;
		System.out.println("lister");
		
		return retour;
		
	}

	/**
	 * @return the ressentie
	 */
	public String getRessenti() {
		return ressenti;
	}

	/**
	 * @param ressentie the ressentie to set
	 */
	public void setRessenti(String ressenti) {
		this.ressenti = ressenti;
	}

	/**
	 * @return the stringNiveauAcquisition
	 */
	public String getStringNiveauAcquisition() {
		return stringNiveauAcquisition;
	}

	/**
	 * @param stringNiveauAcquisition the stringNiveauAcquisition to set
	 */
	public void setStringNiveauAcquisition(String stringNiveauAcquisition) {
		this.stringNiveauAcquisition = stringNiveauAcquisition;
	}

	/**
	 * @return the stringCompetence
	 */
	public String getStringCompetence() {
		return stringCompetence;
	}

	/**
	 * @param stringCompetence the stringCompetence to set
	 */
	public void setStringCompetence(String stringCompetence) {
		this.stringCompetence = stringCompetence;
	}

	private NiveauAcquisition selectNiveauAcquisitionFromString() {
		
		String identifiant = getStringNiveauAcquisition();
		NiveauAcquisition niveauAcquisition = new NiveauAcquisition(identifiant,null);
		try {
			niveauAcquisition = facadeSuiviStagiaireRemote.selectNiveauAcquisition(niveauAcquisition);
		} catch (UnfoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(niveauAcquisition);
		return niveauAcquisition;
	}

	private Competence selectCompetenceFromString() {

		String stringIdentifiantCompetence = getStringCompetence();
		
		String[] tabStringIdentifiantCompetence = stringIdentifiantCompetence.split(",");
		
		Module module = new Module(tabStringIdentifiantCompetence[0],null,null);
		Sequence sequence = new Sequence(tabStringIdentifiantCompetence[1],module,null,null);
		Competence competence = new Competence(tabStringIdentifiantCompetence[2],sequence,null,null);
		
		try {
			competence = facadeSuiviStagiaireRemote.selectCompetence(competence);
		} catch (UnfoundException e) {
			
			e.printStackTrace();
			
		}
		System.out.println(competence);
		return competence;
	}

	public String getIdentifiantAutoEvaluation() {
		return identifiantAutoEvaluation;
	}

	public void setIdentifiantAutoEvaluation(String identifiantAutoEvaluation) {
		this.identifiantAutoEvaluation = identifiantAutoEvaluation;
	}

}
