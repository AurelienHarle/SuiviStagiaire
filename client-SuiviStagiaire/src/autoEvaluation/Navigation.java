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
		Stagiaire stagiaire = new Stagiaire("13111384", "Password", "Harlé", "Aurélien", null, null, null, null, null, null);
		
		niveauAcquisitions = facadeSuiviStagiaireRemote.selectNiveauAcquisitions();
		
		if(identifiantAutoEvaluation!=null){
			
			autoEvaluation = new AutoEvaluation(Integer.parseInt(identifiantAutoEvaluation));
			autoEvaluation = facadeSuiviStagiaireRemote.selectAutoEvaluation(autoEvaluation);
			
		}
		
		if(autoEvaluation == null){
			
			autoEvaluation = new AutoEvaluation(null, null, stagiaire, LocalDate.now(), null);
			autoEvaluations = facadeSuiviStagiaireRemote.selectAutoEvaluationsByStagDate(autoEvaluation);
			
		}
		dateJour = LocalDate.now();
		return MODIFICATION;
		
	}
	
	/**
	 * Méthode lancer avant l'arriver sur la page, de suppression d'une auto-évaluation, 
	 * 
	 * @return
	 */
	public String suppression(){
		
		init();
		
		//Stagiaire creer en dure avant gestion des comptes
		Stagiaire stagiaire = new Stagiaire("13111384", "Password", "Harlé", "Aurélien", null, null, null, null, null, null);
		
		AutoEvaluation autoEvaluation = new AutoEvaluation(null, null, stagiaire, null, null);
		
		autoEvaluations = facadeSuiviStagiaireRemote.selectAutoEvaluationByStag(autoEvaluation);
		
		return SUPPRESSION;
		
	}
	
	/**
	 * Méthode lancer avant l'arriver sur la page, de rechercher d'une auto-évaluation, 
	 * 
	 * @return
	 */
	public String recherche(){
		
		init();
		
		//System.out.println("recherche");
		competences = facadeSuiviStagiaireRemote.selectCompetences();
		sequences = facadeSuiviStagiaireRemote.selectSequences();
		modules = facadeSuiviStagiaireRemote.selectModules();
		
		niveauAcquisitions = facadeSuiviStagiaireRemote.selectNiveauAcquisitions();
		return RECHERCHE;
		
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
	 * {@link Method} qui récupère un text JSon qui représente un {@link Module} avec son identifiant,
	 * Instancie ensuite un {@link Module} avec la librairie {@link Gson}, pour sélectionner dans la base de données
	 * les {@link Sequences} et les {@link Competences} compris dans ce {@link Module}.
	 */
	public String ajaxRecherche(){

		//Retour de la methode
		init();
		String retour = Action.SUCCESS;
		
		//System.out.println(jsonData);
		
		//Creation de l'objet module depuis JSon recus, de la page web avec requette ajax
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
					e.printStackTrace();

				}
				
			}else{

				module = gson.fromJson(jsonData, Module.class);
				
				try {
					
					module = facadeSuiviStagiaireRemote.selectModule(module);
					sequences = facadeSuiviStagiaireRemote.selectSequenceByModule(module);					
					competences = facadeSuiviStagiaireRemote.selectCompetenceByModule(module);

				} catch (UnfoundException e) {
	
					retour = Action.ERROR;
					e.printStackTrace();
	
				}
			}

		return retour;
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

	public Sequences getSequences() {
		return sequences;
	}

	public void setSequences(Sequences sequences) {
		this.sequences = sequences;
	}

	public Modules getModules() {
		return modules;
	}

	public void setModules(Modules modules) {
		this.modules = modules;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public Competences getCompetences() {
		return competences;
	}

	public void setCompetences(Competences competences) {
		this.competences = competences;
	}
}
