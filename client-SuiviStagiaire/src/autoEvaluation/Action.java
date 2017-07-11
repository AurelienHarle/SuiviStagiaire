package autoEvaluation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.naming.InitialContext;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
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
	private static final String CREER = "creer";
	private static final String MODIFIER = "modifier";
	private static final String SUPPRIMER = "supprimer";
	private static final String RECHERCHER = "rechercher";
	
	private String stringCompetence;
	private String stringSequence;
	private String stringModule;
	private String stringNiveauAcquisition;
	private String identifiantAutoEvaluation;
	private String ressenti;
	private String dateRecherche;
	private AutoEvaluations autoEvaluations;
	private LocalDate dateJour;
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
		String retour = CREER;
		
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
		String retour = MODIFIER;		
		
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
		String retour = SUPPRIMER;
		//System.out.println("supprimer");
		
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
		String retour = RECHERCHER;
		final String MOIN_UN = "-1";
		
		AutoEvaluation autoEvaluationDater = null;
		AutoEvaluation autoEvaluationNoter = null;		
		Module moduleRechercher = null;
		Sequence sequenceRechercher = null;
		Competence competenceRechercher = null;
		NiveauAcquisition niveauAcquisition = null;
		
		if(getDateRecherche().length() > 0){
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dateRechercher = LocalDate.parse(dateRecherche, dtf);			
			autoEvaluationDater = new AutoEvaluation(null,null,null,dateRechercher,null);
		}
		
		if(!getStringModule().contains(MOIN_UN)){
			moduleRechercher = selectModuleFromString();
		}
		
		if(!getStringSequence().contains(MOIN_UN)){
			sequenceRechercher = selectSequenceFromString();
		}
		
		if(!getStringCompetence().contains(MOIN_UN)){
			competenceRechercher = selectCompetenceFromString();
		}
		
		if(getStringNiveauAcquisition() != null){
			niveauAcquisition = selectNiveauAcquisitionFromString();
			autoEvaluationNoter = new AutoEvaluation(null, niveauAcquisition, null, null, null);
		}
		
		dateJour = LocalDate.now();
		autoEvaluations = facadeSuiviStagiaireRemote.selectAutoEvaluationsByMultipleCritere(autoEvaluationDater,moduleRechercher,sequenceRechercher,competenceRechercher,autoEvaluationNoter);
		
		return retour;
		
	}

	private NiveauAcquisition selectNiveauAcquisitionFromString() {
		
		String identifiant = getStringNiveauAcquisition();
		NiveauAcquisition niveauAcquisition = new NiveauAcquisition(identifiant,null);
		try {
			niveauAcquisition = facadeSuiviStagiaireRemote.selectNiveauAcquisition(niveauAcquisition);
		} catch (UnfoundException e) {
			e.printStackTrace();
		}
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
	
		return competence;
	}

	private Sequence selectSequenceFromString() {
	
		String stringIdentifiantSequence = getStringSequence();
		
		String[] tabStringIdentifiantSequence = stringIdentifiantSequence.split(",");
		
		Module module = new Module(tabStringIdentifiantSequence[0],null,null);
		Sequence sequence = new Sequence(tabStringIdentifiantSequence[1],module,null,null);
		
		try {
			sequence = facadeSuiviStagiaireRemote.selectSequence(sequence);
		} catch (UnfoundException e) {
			
			e.printStackTrace();
			
		}
	
		return sequence;
	}

	private Module selectModuleFromString() {
		
		Module module = new Module(getStringModule(),null,null);
		
		try {
			module = facadeSuiviStagiaireRemote.selectModule(module);
		} catch (UnfoundException e) {
			
			e.printStackTrace();
			
		}
	
		return module;
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

	public String getIdentifiantAutoEvaluation() {
		return identifiantAutoEvaluation;
	}

	public void setIdentifiantAutoEvaluation(String identifiantAutoEvaluation) {
		this.identifiantAutoEvaluation = identifiantAutoEvaluation;
	}

	public String getDateRecherche() {
		return dateRecherche;
	}

	public void setDateRecherche(String dateRecherche) {
		this.dateRecherche = dateRecherche;
	}

	public String getStringSequence() {
		return stringSequence;
	}

	public void setStringSequence(String stringSequence) {
		this.stringSequence = stringSequence;
	}

	public String getStringModule() {
		return stringModule;
	}

	public void setStringModule(String stringModule) {
		this.stringModule = stringModule;
	}

	public AutoEvaluations getAutoEvaluations() {
		return autoEvaluations;
	}

	public void setAutoEvaluations(AutoEvaluations autoEvaluations) {
		this.autoEvaluations = autoEvaluations;
	}

	public LocalDate getDateJour() {
		return dateJour;
	}

	public void setDateJour(LocalDate dateJour) {
		this.dateJour = dateJour;
	}

}
