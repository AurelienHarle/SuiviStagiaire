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
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import facade.FacadeSuiviStagiaireRemote;

/**
 * Test de la {@link Class} {@link GetDao}
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/06/2017
 *
 */
public class TestAutoEvaluationInsertNullDao {
	
	
	private static Context context;
	private static FacadeSuiviStagiaireRemote facadeSuiviStagiaireRemote;
	private static AutoEvaluation autoEvaluation;
	private static boolean conditionInsert;
	private static boolean conditionSelect;
	private static Module module;
	private static Sequence sequence;
	private static Competence competence;
	private static NiveauAcquisition niveauAcquisition;
	private static Stagiaire stagiaire;
	private static LocalDate date;
	private static boolean conditionInsertAutoEvaluation1;
	private static boolean conditionInsertAutoEvaluation2;
	private static boolean conditionInsertAutoEvaluation3;
	private static boolean conditionInsertAutoEvaluation4;
	private static boolean conditionInsertAutoEvaluation5;
	private static boolean conditionInsertAutoEvaluation6;
	private static AutoEvaluation autoEvaluation1;
	private static AutoEvaluation autoEvaluation2;
	private static AutoEvaluation autoEvaluation3;
	private static AutoEvaluation autoEvaluation4;
	private static AutoEvaluation autoEvaluation5;
	private static AutoEvaluation autoEvaluation6;
	
	@BeforeClass
	public static void init() throws NamingException, DoublonException, NullException{
		
		//Initialisation du context
		context = new InitialContext();
		facadeSuiviStagiaireRemote = (FacadeSuiviStagiaireRemote) context.lookup("ejb:/server-SuiviStagiaire/FacadeSuiviStagiaire!facade.FacadeSuiviStagiaireRemote");
		
		//Creation des données utile pour testInsertAutoEvaluationNull()		
		conditionInsert = false;
		conditionSelect = true;
		autoEvaluation = null;
		
		//Creation et insertion des données utile pour testInsertAutoEvaluationProprieteNull()		

		module = new Module("M5","Développer une application en couches","Dév une app N-tiers");
		try {
			facadeSuiviStagiaireRemote.insertModule(module);
		} catch (DoublonException | NullException e) {
			
			e.printStackTrace();
		}
		
		sequence = new Sequence("S4",module,"Préparer et exécuter les plans de tests d’une application et préparer et exécuter le déploiement d’une application",
				"Prépa & exec plans de tests d'une app et du deploie d'une app");
		try {
			facadeSuiviStagiaireRemote.insertSequence(sequence);
		} catch (DoublonException | NullException e) {
			
			e.printStackTrace();
		}
		
		competence = new Competence("C2",sequence,module,"Préparer et exécuter les plans de tests","Prépa & exec plan de tests");
		try {
			facadeSuiviStagiaireRemote.insertCompetence(competence);
		} catch (DoublonException | NullException e) {
			
			e.printStackTrace();
		}
		
		niveauAcquisition = new NiveauAcquisition("2","AC");
		try {
			facadeSuiviStagiaireRemote.insertNiveauAcquisition(niveauAcquisition);
		} catch (DoublonException | NullException e) {
			
			e.printStackTrace();
		}
		
		stagiaire = new Stagiaire("13111384","Password","Harlé","Aurélien",null,null,null,null,null,null);
		try {
			facadeSuiviStagiaireRemote.insertStagiaire(stagiaire);
		} catch (DoublonException | NullException e) {
			
			e.printStackTrace();
		}
		
		date = LocalDate.now();
		
//Creation des boolean de controle		
		conditionInsertAutoEvaluation1 = false;
		conditionInsertAutoEvaluation2 = false;
		conditionInsertAutoEvaluation3 = false;
		conditionInsertAutoEvaluation4 = false;
		conditionInsertAutoEvaluation5 = false;
		conditionInsertAutoEvaluation6 = false;
		
//Creation des autoEvaluation avec une propriété a null		
		autoEvaluation1 = new AutoEvaluation(null, sequence, module, niveauAcquisition, stagiaire, date, null);
		autoEvaluation2 = new AutoEvaluation(competence, null, module, niveauAcquisition, stagiaire, date, null);
		autoEvaluation3 = new AutoEvaluation(competence, sequence, null, niveauAcquisition, stagiaire, date, null);
		autoEvaluation4 = new AutoEvaluation(competence, sequence, module, null, stagiaire, date, null);
		autoEvaluation5 = new AutoEvaluation(competence, sequence, module, niveauAcquisition, null, date, null);
		autoEvaluation6 = new AutoEvaluation(competence, sequence, module, niveauAcquisition, stagiaire, null, null);

	}
	

	@AfterClass
	public static void finalizeur(){
		
	}
	
	
//	/**
//	 * Test d'insertion d'un Module Null
//	 * @throws UnfoundException 
//	 */
//	@Test
//	public void testInsertModuleNull(){
//		
//		boolean conditionInsert = false;
//		boolean conditionSelect = true;
//		Module module = null;
//		
//		try {
//			facadeSuiviStagiaireRemote.insertModule(module);
//		} catch (DoublonException | NullException e) {
//			conditionInsert = true;
//		}
//
//		try {
//			module = facadeSuiviStagiaireRemote.selectModule(module);
//		} catch (UnfoundException e) {
//			conditionSelect = true;
//		}
//		
//		assertTrue(conditionInsert);
//		assertTrue(conditionSelect);
//		assertNull(module);
//		
//	}
	
//	/**
//	 * Test d'insertion d'une Sequence Null
//	 * @throws UnfoundException 
//	 */
//	@Test
//	public void testInsertSequenceNull(){
//		
//		boolean conditionInsert = false;
//		boolean conditionSelect = true;
//		Sequence sequence = null;
//		
//		try {
//			facadeSuiviStagiaireRemote.insertSequence(sequence);
//		} catch (DoublonException | NullException e) {
//			conditionInsert = true;
//		}
//
//		try {
//			sequence = facadeSuiviStagiaireRemote.selectSequence(sequence);
//		} catch (UnfoundException e) {
//			conditionSelect = true;
//		}
//
//		assertTrue(conditionInsert);
//		assertTrue(conditionSelect);
//		assertNull(sequence);
//		
//	}
	
//	/**
//	 * Test d'insertion d'une Competences Null
//	 * @throws UnfoundException 
//	 */
//	@Test
//	public void testInsertCompetenceNull() {
//		
//		boolean conditionInsert = false;
//		boolean conditionSelect = true;
//		Competence competence = null;
//		
//		try {
//			facadeSuiviStagiaireRemote.insertCompetence(competence);
//		} catch (DoublonException | NullException e) {
//			conditionInsert = true;
//		}
//
//		try {
//			competence = facadeSuiviStagiaireRemote.selectCompetence(competence);
//		} catch (UnfoundException e) {
//			conditionSelect = true;
//		}
//		
//		assertTrue(conditionInsert);
//		assertTrue(conditionSelect);
//		assertNull(competence);
//	}
	
//	/**
//	 * Test d'insertion d'un Stagiaire Null
//	 * @throws UnfoundException 
//	 */
//	@Test
//	public void testInsertStagiaireNull()  {
//		
//		boolean conditionInsert = false;
//		boolean conditionSelect = true;
//		Stagiaire stagiaire = null;
//		
//		try {
//			facadeSuiviStagiaireRemote.insertStagiaire(stagiaire);
//		} catch (DoublonException | NullException e) {
//			conditionInsert = true;
//		}
//
//		try {
//			stagiaire = facadeSuiviStagiaireRemote.selectStagiaire(stagiaire);
//		} catch (UnfoundException e) {
//			conditionSelect = true;
//		}
//
//		
//		assertTrue(conditionInsert);
//		assertTrue(conditionSelect);
//		assertNull(stagiaire);
//		
//	}
	
//	/**
//	 * Test d'insertion d'un NiveauAcquisition Null
//	 * @throws UnfoundException 
//	 */
//	@Test
//	public void testInsertNiveauAcquisitionNull()  {
//		
//		boolean conditionInsert = false;
//		boolean conditionSelect = true;
//		NiveauAcquisition niveauAcquisition = null;
//		
//		try {
//			facadeSuiviStagiaireRemote.insertNiveauAcquisition(niveauAcquisition);
//		} catch (DoublonException | NullException e) {
//			conditionInsert = true;
//		}
//
//		try {
//			niveauAcquisition = facadeSuiviStagiaireRemote.selectNiveauAcquisition(niveauAcquisition);
//		} catch (UnfoundException e) {
//			conditionSelect = true;
//		}
//
//		assertTrue(conditionInsert);
//		assertTrue(conditionSelect);
//		assertNull(niveauAcquisition);
//		
//	}
	
	/**
	 * Test d'une insertion d'une {@link AutoEvaluation} Null
	 * @throws UnfoundException 
	 */
	@Test
	public void testInsertAutoEvaluationNull()  {

		
		try {
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluation);
		} catch (DoublonException | NullException e) {
			conditionInsert = true;
		}
	
		try {
			autoEvaluation = facadeSuiviStagiaireRemote.selectAutoEvaluation(autoEvaluation);
		} catch (UnfoundException e) {
			conditionSelect = true;
		}
	
		assertTrue(conditionInsert);
		assertTrue(conditionSelect);
		assertNull(autoEvaluation);
		
	}
	
	/**
	 * Test d'insertion d'un module avec une propriété obligatoire a Null
	 *   
	 */
	@Test
	public void testInsertAutoEvaluationProprieteNull(){

//Insertion des autoEvaluation avec une propriété a null Dois throw une NullException et passé la condition a true
		try {
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluation1);
		} catch (DoublonException | NullException e) {
			conditionInsertAutoEvaluation1 = true;
		}
		
		try {
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluation2);
		} catch (DoublonException | NullException e) {
			conditionInsertAutoEvaluation2 = true;
		}
		
		try {
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluation3);
		} catch (DoublonException | NullException e) {
			conditionInsertAutoEvaluation3 = true;
		}
		
		try {
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluation4);
		} catch (DoublonException | NullException e) {
			conditionInsertAutoEvaluation4 = true;
		}
		
		try {
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluation5);
		} catch (DoublonException | NullException e) {
			conditionInsertAutoEvaluation5 = true;
		}
		
		try {
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluation6);
		} catch (DoublonException | NullException e) {
			conditionInsertAutoEvaluation6 = true;
		}

//Verification des différente condition
		assertTrue("Insert autoEvaluation1", conditionInsertAutoEvaluation1);
		assertTrue("Insert autoEvaluation2", conditionInsertAutoEvaluation2);
		assertTrue("Insert autoEvaluation3", conditionInsertAutoEvaluation3);
		assertTrue("Insert autoEvaluation4", conditionInsertAutoEvaluation4);
		assertTrue("Insert autoEvaluation5", conditionInsertAutoEvaluation5);
		assertTrue("Insert autoEvaluation6", conditionInsertAutoEvaluation6);
		
	}


//	/**
//	 * Test d'insertion d'un module avec une propriété obligatoire a Null
//	 * @throws UnfoundException 
//	 */
//	@Test
//	public void testInsertModuleProprieteNull(){
//		
////Declaration variable module 1
//		boolean conditionInsert1 = false;
//		boolean conditionSelect1 = false;		
//		Module module1 = new Module(null,"test","test");
//		
////Declaration variable module 2
//		boolean conditionInsert2 = false;
//		boolean conditionSelect2 = false;	
//		Module module2 = new Module("1",null,"test");
//		
////Declaration variable module 3
//		boolean conditionInsert3 = false;
//		boolean conditionSelect3 = false;	
//		Module module3 = new Module("1","test",null);
//		
////Insertion Module 1 identifiant null
//		try {
//			facadeSuiviStagiaireRemote.insertModule(module1);
//		} catch (DoublonException | NullException e) {
//			conditionInsert1 = true;
//		}
//
////Insertion Module 2 nomLong null
//		try {
//			facadeSuiviStagiaireRemote.insertModule(module2);
//		} catch (DoublonException | NullException e) {
//			conditionInsert2 = true;
//		}
//		
////Insertion Module 3 nomCourt null
//		try {
//			facadeSuiviStagiaireRemote.insertModule(module3);
//		} catch (DoublonException | NullException e) {
//			conditionInsert3 = true;
//		}
//	
////Selection module1 dois throw UnfoundException
//		try{
//			module1 = facadeSuiviStagiaireRemote.selectModule(module1);
//		}catch (UnfoundException e) {
//			conditionSelect1 = true;
//		}
//		
////Selection module2 dois throw UnfoundException
//		try{
//			module2 = facadeSuiviStagiaireRemote.selectModule(module2);
//		}catch (UnfoundException e) {
//			conditionSelect2 = true;
//		}
//		
////Selection module3 dois throw UnfoundException
//		try{
//			module3 = facadeSuiviStagiaireRemote.selectModule(module3);
//		}catch (UnfoundException e) {
//			conditionSelect3 = true;
//		}
//		
////Tests
//		assertTrue("Insert Module1",conditionInsert1);
//		assertTrue("Select Module1",conditionSelect1);
//		assertNull("Null Module 1",module1);
//		assertTrue("Insert Module2",conditionInsert2);
//		assertTrue("Select Module2",conditionSelect2);
//		assertNull("Null Module 2",module2);
//		assertTrue("Insert Module3",conditionInsert3);
//		assertTrue("Select Module3",conditionSelect3);
//		assertNull("Null Module 3",module3);
//		
//	}

}
