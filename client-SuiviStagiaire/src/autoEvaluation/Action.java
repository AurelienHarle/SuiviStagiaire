package autoEvaluation;

import java.awt.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.InitialContext;

import com.sun.javafx.collections.MappingChange.Map;

import autoEvaluation.entity.AutoEvaluation;
import competence.entity.Competence;
import exception.DateNullException;
import exception.NullException;
import exception.UnfoundException;
import facade.FacadeSuiviStagiaireRemote;
import module.entity.Module;
import niveauAcquisition.entity.NiveauAcquisition;
import sequence.entity.Sequence;
import stagiaire.dao.StagiaireDao;
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
	private static final String LISTER = "lister";
	
	private String stringCompetence;
	private String stringNiveauAcquisition;
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
			e.printStackTrace();
		}
		
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

}
