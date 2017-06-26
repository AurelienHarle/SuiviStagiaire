package testUnitaire.casAlternatif.autoEval;

import static org.junit.Assert.*;

import java.time.LocalDate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.entity.Competence;
import autoEvaluation.entity.Module;
import autoEvaluation.entity.NiveauAcquisition;
import autoEvaluation.entity.Sequence;
import compteUtilisateur.entity.Stagiaire;
import exception.DateNullException;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import facade.FacadeSuiviStagiaireRemote;

/**
 * Test de la {@link Class} {@link GetDao}
 * 
 * @author Aur�lien Harl�
 * @Version 1
 * @Since 19/06/2017
 *
 */
public class TestAutoEvaluationInsertDoublonDao {
	
	
	private static Context context;
	private static FacadeSuiviStagiaireRemote facadeSuiviStagiaireRemote;
	
	private static AutoEvaluation autoEvaluation;
	private static Module module;
	private static Sequence sequence;
	private static Competence competence;
	private static NiveauAcquisition niveauAcquisition;
	private static Stagiaire stagiaire;
	private static LocalDate date;
	private static boolean conditionInsertAutoEvaluation1;
	private static AutoEvaluation autoEvaluationDoublon;
	private boolean conditionSelectAutoEvaluation1;
	private AutoEvaluation autoEvaluationBDD;
	
	@BeforeClass
	public static void init() throws NamingException, DoublonException, NullException, DateNullException{
		
		//Initialisation du context
		context = new InitialContext();
		facadeSuiviStagiaireRemote = (FacadeSuiviStagiaireRemote) context.lookup("ejb:/server-SuiviStagiaire/FacadeSuiviStagiaire!facade.FacadeSuiviStagiaireRemote");
		
		//Creation des donn�es utile pour testInsertAutoEvaluationNull()
		autoEvaluation = null;
		
		//Creation et insertion des donn�es utile pour testInsertAutoEvaluationProprieteNull()		

		module = new Module("M5","D�velopper une application en couches","D�v une app N-tiers");
		facadeSuiviStagiaireRemote.insertModule(module);
		
		
		sequence = new Sequence("S4",module,"Pr�parer et ex�cuter les plans de tests d�une application et pr�parer et ex�cuter le d�ploiement d�une application",
				"Pr�pa & exec plans de tests d'une app et du deploie d'une app");
		facadeSuiviStagiaireRemote.insertSequence(sequence);
		
		
		competence = new Competence("C2",sequence,module,"Pr�parer et ex�cuter les plans de tests","Pr�pa & exec plan de tests");
		facadeSuiviStagiaireRemote.insertCompetence(competence);
		
		
		niveauAcquisition = new NiveauAcquisition("2","AC");
		facadeSuiviStagiaireRemote.insertNiveauAcquisition(niveauAcquisition);
		
		stagiaire = new Stagiaire("13111384","Password","Harl�","Aur�lien",null,null,null,null,null,null);
		facadeSuiviStagiaireRemote.insertStagiaire(stagiaire);

		date = LocalDate.now();
		
//Creation des boolean de controle		
		conditionInsertAutoEvaluation1 = false;

		
//Creation des autoEvaluation avec une propri�t� a null		
		autoEvaluation = new AutoEvaluation(competence, sequence, module, niveauAcquisition, stagiaire, date, null);
		facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluation);
		autoEvaluationDoublon = new AutoEvaluation(competence, sequence, module, niveauAcquisition, stagiaire, date, "Updated");

	}

	@AfterClass
	public static void finalizeur(){
		
	}


	
	/**
	 * Test d'insertion d'un doublon AutoEvalution
	 * 
	 * Conform�ment a la r�gle m�tier une Auto Evaluation peux �tre fait qu'une seul fois par jour
	 * SI un stagiaire creer une nouvelle Auto Evaluation � la m�me date il y aura update de celle fait le m�me jour
	 */
	@Test
	public void testInsertDoublonAutoEvaluation(){
		
		try {
			
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluationDoublon);
			
		} catch (DoublonException | NullException | DateNullException e) {
			
			conditionInsertAutoEvaluation1 = false;
			
		}
		
		try {
			autoEvaluationBDD = facadeSuiviStagiaireRemote.selectAutoEvaluationByStagCompDate(autoEvaluationDoublon);
		} catch (UnfoundException | NullException e) {
			conditionSelectAutoEvaluation1 = false;
		}

		
		assertTrue("Lever d'exception Insert ",conditionInsertAutoEvaluation1);
		assertTrue("Lever d'exception Select ",conditionSelectAutoEvaluation1);
		
		assertEquals("Date : ",autoEvaluationDoublon.getDateAutoEvaluation(), autoEvaluationBDD.getDateAutoEvaluation());
		assertEquals("Ressenti : ",autoEvaluationDoublon.getRessenti(), autoEvaluationBDD.getRessenti());
		assertEquals("Module ID : ",autoEvaluationDoublon.getModule().getIdentifiant(), autoEvaluationBDD.getModule().getIdentifiant());
		assertEquals("Sequence ID : ",autoEvaluationDoublon.getSequence().getIdentifiant(), autoEvaluationBDD.getSequence().getIdentifiant());
		assertEquals("Competence ID : ",autoEvaluationDoublon.getCompetence().getIdentifiant(), autoEvaluationBDD.getCompetence().getIdentifiant());
		assertEquals("Stagiaire ID : ",autoEvaluationDoublon.getStagiaire().getLogin(), autoEvaluationBDD.getStagiaire().getLogin());
		assertEquals("NiveauAcquisition ID : ",autoEvaluationDoublon.getNiveauAcquisition().getIdentifiant(), autoEvaluationBDD.getNiveauAcquisition().getIdentifiant());
		
		
		
		
	}
}