package testUnitaire.casNominaux.autoEvaluation;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import autoEvaluation.entity.AutoEvaluation;
import competence.entity.Competence;
import exception.DateNullException;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import facade.FacadeSuiviStagiaireRemote;
import module.entity.Module;
import niveauAcquisition.entity.NiveauAcquisition;
import sequence.entity.Sequence;
import stagiaire.entity.Stagiaire;

/**
 * Test de la {@link Class} {@link GetDao}
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/06/2017
 *
 */
public class TestAutoEvaluationInsertDao {
	
	
	private static Context context;
	private static FacadeSuiviStagiaireRemote facadeSuiviStagiaireRemote;
	
	private static AutoEvaluation autoEvaluationInsert;
//	private static Module moduleInsert;
//	private static Sequence sequenceInsert;
//	private static Competence competenceInsert;
//	private static Stagiaire stagiaireInsert;
//	private static NiveauAcquisition niveauAcquisitionInsert;
//	private static Module moduleSequenceInsert;
//	private static Module moduleCompetenceInsert;
//	private static Sequence sequenceCompetenceInsert;
	
	private static Stagiaire stagiaire;
	private static NiveauAcquisition niveauAcquisition;
	private static Competence competence;
	private static Sequence sequence;
	private static Module module;
	
	@BeforeClass
	public static void init() throws NamingException, DoublonException, NullException, UnfoundException{
		
		//Initialisation du context
		context = new InitialContext();
		facadeSuiviStagiaireRemote = (FacadeSuiviStagiaireRemote) context.lookup("ejb:/server-SuiviStagiaire/FacadeSuiviStagiaire!facade.FacadeSuiviStagiaireRemote");
		
		//Creation et insertion du module pour testInsertAutoEvaluation()
		module = new Module("M5","Développer une application en couches","Dév une app N-tiers");
		facadeSuiviStagiaireRemote.insertModule(module);
		module = facadeSuiviStagiaireRemote.selectModule(module);
		
		//Creation et insertion du sequence pour testInsertAutoEvaluation()
		sequence = new Sequence("S4",module,"Préparer et exécuter les plans de tests d’une application et préparer et exécuter le déploiement d’une application",
				"Prépa & exec plans de tests d'une app et du deploie d'une app");
		facadeSuiviStagiaireRemote.insertSequence(sequence);
		sequence = facadeSuiviStagiaireRemote.selectSequence(sequence);
		
		//Creation et insertion du competence pour testInsertAutoEvaluation()
		competence = new Competence("C2",sequence,"Préparer et exécuter les plans de tests","Prépa & exec plan de tests");
		facadeSuiviStagiaireRemote.insertCompetence(competence);
		competence = facadeSuiviStagiaireRemote.selectCompetence(competence);
		
		//Creation et insertion du niveauAcquisition pour testInsertAutoEvaluation()
		niveauAcquisition = new NiveauAcquisition("2","AC");
		facadeSuiviStagiaireRemote.insertNiveauAcquisition(niveauAcquisition);
		niveauAcquisition = facadeSuiviStagiaireRemote.selectNiveauAcquisition(niveauAcquisition);
		
		//Creation et insertion du stagiaire pour testInsertAutoEvaluation()
		stagiaire = new Stagiaire("13111384","Password","Harlé","Aurélien",null,null,null,null,null,null);
		facadeSuiviStagiaireRemote.insertStagiaire(stagiaire);
		stagiaire = facadeSuiviStagiaireRemote.selectStagiaire(stagiaire);
		
		//Creation date pour testInsertAutoEvaluation()
		LocalDate date = LocalDate.now();
		
		//Module pour testInsertModule()
//		moduleInsert = new Module("M1","Test","Test");
//		
//		//Creation et insertion du module pour testInsertSequence()
//		moduleSequenceInsert = new Module("M2","Test","Test");
//		facadeSuiviStagiaireRemote.insertModule(moduleSequenceInsert);
//		sequenceInsert = new Sequence("S1",moduleSequenceInsert,"Test","Test");
//		
//		//Creation et insertion du Module pour testInsertCompetence()
//		moduleCompetenceInsert = new Module("M3","Test","Test");
//		facadeSuiviStagiaireRemote.insertModule(moduleCompetenceInsert);
//		
//		//Creation et insertion de la sequence pour testInsertCompetence()
//		sequenceCompetenceInsert = new Sequence("S2",moduleCompetenceInsert,"Test","Test");
//		facadeSuiviStagiaireRemote.insertSequence(sequenceCompetenceInsert);
//		
//		//Competences pour testInsertCompetence()
//		competenceInsert = new Competence("C1",sequenceCompetenceInsert,moduleCompetenceInsert,"Test","Test");
//		
//		//Stagiaire pour testInsertStagiaire()
//		stagiaireInsert = new Stagiaire("login","motdepasse","nom","prenom",null,null,null,null,null,null);
//		
//		//NiveauAcquisition pour testInsertNiveauAcquisition()
//		niveauAcquisitionInsert = new NiveauAcquisition("1","A");
		
		//AutoEvaluation pour testInsertAutoEvaluation()
		autoEvaluationInsert = new AutoEvaluation(competence,niveauAcquisition,stagiaire,date,null);

	}
	

	@AfterClass
	public static void finalizeur(){
		
		facadeSuiviStagiaireRemote.deleteAutoEvaluation(autoEvaluationInsert);
		facadeSuiviStagiaireRemote.deleteCompetence(competence);
		facadeSuiviStagiaireRemote.deleteSequence(sequence);
		facadeSuiviStagiaireRemote.deleteModule(module);
		facadeSuiviStagiaireRemote.deleteNiveauAcquisition(niveauAcquisition);
		facadeSuiviStagiaireRemote.deleteStagiaire(stagiaire);
		
	}
	
	
//	/**
//	 * Test d'insertion d'un Module
//	 */
//	@Test
//	public void testInsertModule(){
//		
//		boolean condition = true;
//		
//		try {
//			
//			facadeSuiviStagiaireRemote.insertModule(moduleInsert);
//			
//		} catch (DoublonException | NullException e) {
//			
//			condition = false;
//			e.printStackTrace();
//			
//		}
//		
//		assertTrue(condition);
//		
//	}
//	
//	/**
//	 * Test d'insertion d'une Sequence
//	 */
//	@Test
//	public void testInsertSequence(){
//		
//		boolean condition = true;
//		
//		try {
//			
//			facadeSuiviStagiaireRemote.insertSequence(sequenceInsert);
//			
//		} catch (DoublonException | NullException e) {
//			
//			condition = false;
//			e.printStackTrace();
//			
//		}
//		
//		assertTrue(condition);
//	}
//	
//	/**
//	 * Test d'insertion d'une Competences
//	 */
//	@Test
//	public void testInsertCompetence(){
//		
//		boolean condition = true;
//		
//		try {
//			
//			facadeSuiviStagiaireRemote.insertCompetence(competenceInsert);
//			
//		} catch (DoublonException | NullException e) {
//			
//			condition = false;
//			e.printStackTrace();
//			
//		}
//		
//		assertTrue(condition);
//	}
//	
//	/**
//	 * Test d'insertion d'un Stagiaire
//	 */
//	@Test
//	public void testInsertStagiaire(){
//		
//		boolean condition = true;
//		
//		try {
//			
//			facadeSuiviStagiaireRemote.insertStagiaire(stagiaireInsert);
//			
//		} catch (DoublonException | NullException e) {
//			
//			condition = false;
//			e.printStackTrace();
//			
//		}
//		
//		assertTrue(condition);
//	}
//	
//	/**
//	 * Test d'insertion d'un NiveauAcquisition
//	 */
//	@Test
//	public void testInsertNiveauAcquisition(){
//		
//		boolean condition = true;
//		
//		try {
//			
//			facadeSuiviStagiaireRemote.insertNiveauAcquisition(niveauAcquisitionInsert);
//			
//		} catch (DoublonException | NullException e) {
//			
//			condition = false;
//			e.printStackTrace();
//			
//		}
//		
//		assertTrue(condition);
//	}
	
	/**
	 * Test d'une insertion d'une {@link AutoEvaluation}
	 */
	@Test
	public void testInsertAutoEvaluation(){
		
		boolean condition = true;
		
		try {
			
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluationInsert);
			
		} catch (NullException | DateNullException e) {
			
			condition = false;
			e.printStackTrace();
			
		}
		
		assertTrue(condition);
		
	}

}
