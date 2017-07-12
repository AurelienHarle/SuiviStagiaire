package autoEvaluation;

import java.lang.reflect.Method;
import java.time.LocalDate;

import javax.naming.InitialContext;

import com.google.gson.Gson;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import competence.technique.Competences;
import exception.UnfoundException;
import facade.FacadeSuiviStagiaireRemote;
import module.entity.Module;
import module.technique.Modules;
import niveauAcquisition.technique.NiveauAcquisitions;
import sequence.entity.Sequence;
import sequence.technique.Sequences;
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
	private static final String RECHERCHE = "recherche";
	private static final String LISTER = "listage";
	
	private Competences competences;
	private Sequences sequences;
	private Modules modules;
	private NiveauAcquisitions niveauAcquisitions;
	private AutoEvaluations autoEvaluations;
	private LocalDate dateJour;
	private String identifiantAutoEvaluation;
	private AutoEvaluation autoEvaluation;
	private Module module;
	private String jsonData;
	private Sequence sequence;
	
	public Navigation() {
		
	}
	
	/**
	 * Initialise la connection vers le serveur EJB et instancie le lien vers la facade principal du projet.
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
	 * elle permet de récupérer la liste des {@link Competences} et les {@link NiveauAcquisitions} possible pour integration, a la page.
	 * 
	 * @return {@link String} d'erreur ou de success
	 */
	public String creation(){
		
		init();
		String retour = CREATION;
		
		try{
			competences = facadeSuiviStagiaireRemote.selectCompetences();
		}catch (Exception e) {
			retour = Action.ERROR;
		}
		
		try{
			niveauAcquisitions = facadeSuiviStagiaireRemote.selectNiveauAcquisitions();
		}catch (Exception e) {
			retour = Action.ERROR;
		}
		
		return retour;
		
	}
	
	/**
	 * Méthode lancer avant l'arriver sur la page, de modification d'une auto-évaluation, 
	 * elle permet de récupérer les {@link NiveauAcquisitions} possible pour integration a la page
	 * ainsi que d'instancier la liste d' {@link AutoEvaluations} ou une seul {@link AutoEvaluation} celons si le {@link Stagiaire} passe directement par la liste,
	 * d'auto-évaluation ou par le menu des auto-évaluation
	 * instancie aussi la date du jour pour contrôle de possibilité d'edition sur la liste.
	 * 
	 * @return {@link String}
	 */
	public String modification(){
		
		init();
		String retour = MODIFICATION;
		
		/* 
		 * TODO DELETE après creation fonctionnalité de gestion de compte utilisateur
		 * devrais etre remplacé par une select vers la base grace a la session utilisateur enregistré dans le context html "session"
		 */
		Stagiaire stagiaire = new Stagiaire("13111384", "Password", "Harlé", "Aurélien", null, null, null, null, null, null);
		
		try {
			niveauAcquisitions = facadeSuiviStagiaireRemote.selectNiveauAcquisitions();
		} catch (Exception e) {
			retour = Action.ERROR;
		}
		
		if(identifiantAutoEvaluation!=null){
			
			autoEvaluation = new AutoEvaluation(Integer.parseInt(identifiantAutoEvaluation));
			
			try {
				autoEvaluation = facadeSuiviStagiaireRemote.selectAutoEvaluation(autoEvaluation);
			} catch (Exception e) {
				retour = Action.ERROR;
			}
			
		}

		if(autoEvaluation == null){
			
			autoEvaluation = new AutoEvaluation(null, null, stagiaire, LocalDate.now(), null);
			
			try {
				autoEvaluations = facadeSuiviStagiaireRemote.selectAutoEvaluationsByStagDate(autoEvaluation);
			} catch (Exception e) {
				retour = Action.ERROR;
			}
			
		}
		
		dateJour = LocalDate.now();
		
		return retour;
		
	}
	
	/**
	 * Méthode lancer avant l'arriver sur la page, de suppression d'une auto-évaluation, 
	 * elle permet d'initié la liste des {@link AutoEvaluations} du {@link Stagiaire}, pour les intégrés a la page.
	 * instancie aussi la date du jour pour contrôle de possibilité d'edition.
	 * 
	 * @return {@link String}
	 */
	public String suppression(){
		
		init();
		String retour = SUPPRESSION;
		
		/* 
		 * TODO DELETE après creation fonctionnalité de gestion de compte utilisateur
		 * devrais etre remplacé par une select vers la base grace a la session utilisateur enregistré dans le context html "session"
		 */
		Stagiaire stagiaire = new Stagiaire("13111384", "Password", "Harlé", "Aurélien", null, null, null, null, null, null);
		
		AutoEvaluation autoEvaluation = new AutoEvaluation(null, null, stagiaire, null, null);
		
		try {
			autoEvaluations = facadeSuiviStagiaireRemote.selectAutoEvaluationByStag(autoEvaluation);
		} catch (Exception e) {
			retour = Action.ERROR;
		}
		dateJour = LocalDate.now();
		return retour;
		
	}
	
	/**
	 * Méthode lancer avant l'arriver sur la page, de rechercher d'une {@link AutoEvaluation}, 
	 * elle permet d'ininité les {@link Modules}, les {@link Sequences}, les {@link Competences} ainsi que les {@link NiveauAcquisitions}.
	 * afin de pouvoir les intégrés a la page.
	 * 
	 * @return {@link String}
	 */
	public String recherche(){
		
		init();
		String retour = RECHERCHE;
		
		try {
			competences = facadeSuiviStagiaireRemote.selectCompetences();
		} catch (Exception e) {
			retour = Action.ERROR;
		}
		
		try {
			sequences = facadeSuiviStagiaireRemote.selectSequences();
		} catch (Exception e) {
			retour = Action.ERROR;
		}
		
		try {
			modules = facadeSuiviStagiaireRemote.selectModules();
		} catch (Exception e) {
			retour = Action.ERROR;
		}
		
		try {
			niveauAcquisitions = facadeSuiviStagiaireRemote.selectNiveauAcquisitions();
		} catch (Exception e) {
			retour = Action.ERROR;
		}
		
		return retour;
		
	}
	
	/**
	 * Méthode lancer avant l'arriver sur la page, de lister d'une {@link AutoEvaluation}, 
	 * elle permet d'initié la liste des {@link AutoEvaluations} du {@link Stagiaire} pour pouvoir les intégrés a la page.
	 * instancie aussi la date du jour pour contrôle de possibilité d'edition.
	 * 
	 * @return {@link String}
	 */
	public String listage(){
		
		init();
		String retour = LISTER;
		
		/* 
		 * TODO DELETE après creation fonctionnalité de gestion de compte utilisateur
		 * devrais etre remplacé par une select vers la base grace a la session utilisateur enregistré dans le context html "session"
		 */
		Stagiaire stagiaire = new Stagiaire("13111384", "Password", "Harlé", "Aurélien", null, null, null, null, null, null);
		
		AutoEvaluation autoEvaluation = new AutoEvaluation(null, null, stagiaire, null, null);
		
		try {
			autoEvaluations = facadeSuiviStagiaireRemote.selectAutoEvaluationByStag(autoEvaluation);
		} catch (Exception e) {
			retour = Action.ERROR;
		}
		
		dateJour = LocalDate.now();
		
		return retour;
		
	}
	
	/**
	 * {@link Method} qui récupère un text JSon qui représente un {@link Module} avec son identifiant,
	 * Instancie ensuite un {@link Module} avec la librairie {@link Gson}, pour sélectionner dans la base de données
	 * les {@link Sequences} et les {@link Competences} compris dans ce {@link Module}.
	 */
	public String ajaxRecherche(){

		init();
		String retour = Action.SUCCESS;

		Gson gson = new Gson();
		if(jsonData.contains("all")){
			
			modules = facadeSuiviStagiaireRemote.selectModules();
			sequences = facadeSuiviStagiaireRemote.selectSequences();
			competences = facadeSuiviStagiaireRemote.selectCompetences();
		
		}else if (jsonData.contains("module")){

				sequence = gson.fromJson(jsonData, Sequence.class);

				try {
	
					sequence = facadeSuiviStagiaireRemote.selectSequence(sequence);
					competences = facadeSuiviStagiaireRemote.selectCompetenceBySequence(sequence);

				} catch (UnfoundException e) {
	
					retour = Action.ERROR;
					
				}
				
			}else{

				module = gson.fromJson(jsonData, Module.class);
				
				try {
					
					module = facadeSuiviStagiaireRemote.selectModule(module);
					sequences = facadeSuiviStagiaireRemote.selectSequenceByModule(module);					
					competences = facadeSuiviStagiaireRemote.selectCompetenceByModule(module);

				} catch (UnfoundException e) {
	
					retour = Action.ERROR;
	
				}
			}

		return retour;
	}

	/**
	 * getter/setter
	 * @return niveauAcquisitions {@link NiveauAcquisitions}
	 */
	public NiveauAcquisitions getNiveauAcquisitions() {
		return niveauAcquisitions;
	}

	/**
	 * getter/setter
	 * @param niveauAcquisitions {@link NiveauAcquisitions}
	 */
	public void setNiveauAcquisitions(NiveauAcquisitions niveauAcquisitions) {
		this.niveauAcquisitions = niveauAcquisitions;
	}

	/**
	 * getter/setter
	 * @return autoEvaluations {@link AutoEvaluations}
	 */
	public AutoEvaluations getAutoEvaluations() {
		return autoEvaluations;
	}

	/**
	 * getter/setter
	 * @param autoEvaluations {@link AutoEvaluations}
	 */
	public void setAutoEvaluations(AutoEvaluations autoEvaluations) {
		this.autoEvaluations = autoEvaluations;
	}

	/**
	 * getter/setter
	 * @return dateJour {@link LocalDate}
	 */
	public LocalDate getDateJour() {
		return dateJour;
	}

	/**
	 * getter/setter
	 * @param dateJour {@link LocalDate}
	 */
	public void setDateJour(LocalDate dateJour) {
		this.dateJour = dateJour;
	}

	/**
	 * getter/setter
	 * @return identifiantAutoEvaluation {@link String}
	 */
	public String getIdentifiantAutoEvaluation() {
		return identifiantAutoEvaluation;
	}

	/**
	 * getter/setter
	 * @param identifiantAutoEvaluation {@link String}
	 */
	public void setIdentifiantAutoEvaluation(String identifiantAutoEvaluation) {
		this.identifiantAutoEvaluation = identifiantAutoEvaluation;
	}

	/**
	 * getter/setter
	 * @return autoEvaluation {@link AutoEvaluation}
	 */
	public AutoEvaluation getAutoEvaluation() {
		return autoEvaluation;
	}

	/**
	 * getter/setter
	 * @param autoEvaluation {@link AutoEvaluation}
	 */
	public void setAutoEvaluation(AutoEvaluation autoEvaluation) {
		this.autoEvaluation = autoEvaluation;
	}

	/**
	 * getter/setter
	 * @return sequences {@link Sequences}
	 */
	public Sequences getSequences() {
		return sequences;
	}

	/**
	 * getter/setter
	 * @param sequences {@link Sequences}
	 */
	public void setSequences(Sequences sequences) {
		this.sequences = sequences;
	}

	/**
	 * getter/setter
	 * @return modules {@link Modules}
	 */
	public Modules getModules() {
		return modules;
	}

	/**
	 * getter/setter
	 * @param modules {@link Modules}
	 */
	public void setModules(Modules modules) {
		this.modules = modules;
	}

	/**
	 * getter/setter
	 * @return module {@link Module}
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * getter/setter
	 * @param module {@link Module}
	 */
	public void setModule(Module module) {
		this.module = module;
	}

	/**
	 * getter/setter
	 * @return jsonData {@link String}
	 */
	public String getJsonData() {
		return jsonData;
	}

	/**
	 * getter/setter
	 * @param jsonData {@link String}
	 */
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	/**
	 * getter/setter
	 * @return competences {@link Competences}
	 */
	public Competences getCompetences() {
		return competences;
	}

	/**
	 * getter/setter
	 * @param competences {@link Competences}
	 */
	public void setCompetences(Competences competences) {
		this.competences = competences;
	}
}
