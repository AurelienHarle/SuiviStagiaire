package testUnitaire.casAlternatif.autoEval;

import static org.junit.Assert.*;

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
public class TestInsertNullDao {
	
	
	private static Context context;
	private static FacadeSuiviStagiaireRemote facadeSuiviStagiaireRemote;
	
	@BeforeClass
	public static void init() throws NamingException, DoublonException, NullException{
		
		//Initialisation du context
		context = new InitialContext();
		facadeSuiviStagiaireRemote = (FacadeSuiviStagiaireRemote) context.lookup("ejb:/server-SuiviStagiaire/FacadeSuiviStagiaire!facade.FacadeSuiviStagiaireRemote");

	}
	

	@AfterClass
	public static void finalizeur(){
		
	}
	
	
	/**
	 * Test d'insertion d'un Module Null
	 * @throws UnfoundException 
	 */
	@Test
	public void testInsertModuleNull(){
		
		boolean conditionInsert = false;
		boolean conditionSelect = true;
		Module module = null;
		
		try {
			facadeSuiviStagiaireRemote.insertModule(module);
		} catch (DoublonException | NullException e) {
			conditionInsert = true;
		}

		try {
			module = facadeSuiviStagiaireRemote.selectModule(module);
		} catch (UnfoundException e) {
			conditionSelect = true;
		}
		
		assertTrue(conditionInsert);
		assertTrue(conditionSelect);
		assertNull(module);
		
	}
	
	/**
	 * Test d'insertion d'une Sequence Null
	 * @throws UnfoundException 
	 */
	@Test
	public void testInsertSequenceNull(){
		
		boolean conditionInsert = false;
		boolean conditionSelect = true;
		Sequence sequence = null;
		
		try {
			facadeSuiviStagiaireRemote.insertSequence(sequence);
		} catch (DoublonException | NullException e) {
			conditionInsert = true;
		}

		try {
			sequence = facadeSuiviStagiaireRemote.selectSequence(sequence);
		} catch (UnfoundException e) {
			conditionSelect = true;
		}

		assertTrue(conditionInsert);
		assertTrue(conditionSelect);
		assertNull(sequence);
		
	}
	
	/**
	 * Test d'insertion d'une Competences Null
	 * @throws UnfoundException 
	 */
	@Test
	public void testInsertCompetenceNull() {
		
		boolean conditionInsert = false;
		boolean conditionSelect = true;
		Competence competence = null;
		
		try {
			facadeSuiviStagiaireRemote.insertCompetence(competence);
		} catch (DoublonException | NullException e) {
			conditionInsert = true;
		}

		try {
			competence = facadeSuiviStagiaireRemote.selectCompetence(competence);
		} catch (UnfoundException e) {
			conditionSelect = true;
		}
		
		assertTrue(conditionInsert);
		assertTrue(conditionSelect);
		assertNull(competence);
	}
	
	/**
	 * Test d'insertion d'un Stagiaire Null
	 * @throws UnfoundException 
	 */
	@Test
	public void testInsertStagiaireNull()  {
		
		boolean conditionInsert = false;
		boolean conditionSelect = true;
		Stagiaire stagiaire = null;
		
		try {
			facadeSuiviStagiaireRemote.insertStagiaire(stagiaire);
		} catch (DoublonException | NullException e) {
			conditionInsert = true;
		}

		try {
			stagiaire = facadeSuiviStagiaireRemote.selectStagiaire(stagiaire);
		} catch (UnfoundException e) {
			conditionSelect = true;
		}

		
		assertTrue(conditionInsert);
		assertTrue(conditionSelect);
		assertNull(stagiaire);
		
	}
	
	/**
	 * Test d'insertion d'un NiveauAcquisition Null
	 * @throws UnfoundException 
	 */
	@Test
	public void testInsertNiveauAcquisitionNull()  {
		
		boolean conditionInsert = false;
		boolean conditionSelect = true;
		NiveauAcquisition niveauAcquisition = null;
		
		try {
			facadeSuiviStagiaireRemote.insertNiveauAcquisition(niveauAcquisition);
		} catch (DoublonException | NullException e) {
			conditionInsert = true;
		}

		try {
			niveauAcquisition = facadeSuiviStagiaireRemote.selectNiveauAcquisition(niveauAcquisition);
		} catch (UnfoundException e) {
			conditionSelect = true;
		}

		assertTrue(conditionInsert);
		assertTrue(conditionSelect);
		assertNull(niveauAcquisition);
		
	}
	
	/**
	 * Test d'une insertion d'une {@link AutoEvaluation} Null
	 * @throws UnfoundException 
	 */
	@Test
	public void testInsertAutoEvaluationNull()  {
		
		boolean conditionInsert = false;
		boolean conditionSelect = true;
		AutoEvaluation autoEvaluation = null;
		
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
	 * @throws UnfoundException 
	 */
	@Test
	public void testInsertModuleProprieteNull(){
		
//Declaration variable module 1
		boolean conditionInsert1 = false;
		boolean conditionSelect1 = false;		
		Module module1 = new Module(null,"test","test");
		
//Declaration variable module 2
		boolean conditionInsert2 = false;
		boolean conditionSelect2 = false;	
		Module module2 = new Module("1",null,"test");
		
//Declaration variable module 3
		boolean conditionInsert3 = false;
		boolean conditionSelect3 = false;	
		Module module3 = new Module("1","test",null);
		
//Insertion Module 1 identifiant null
		try {
			facadeSuiviStagiaireRemote.insertModule(module1);
		} catch (DoublonException | NullException e) {
			conditionInsert1 = true;
		}

//Insertion Module 2 nomLong null
		try {
			facadeSuiviStagiaireRemote.insertModule(module2);
		} catch (DoublonException | NullException e) {
			conditionInsert2 = true;
		}
		
//Insertion Module 3 nomCourt null
		try {
			facadeSuiviStagiaireRemote.insertModule(module3);
		} catch (DoublonException | NullException e) {
			conditionInsert3 = true;
		}
	
//Selection module1 dois throw UnfoundException
		try{
			module1 = facadeSuiviStagiaireRemote.selectModule(module1);
		}catch (UnfoundException e) {
			conditionSelect1 = true;
		}
		
//Selection module2 dois throw UnfoundException
		try{
			module2 = facadeSuiviStagiaireRemote.selectModule(module2);
		}catch (UnfoundException e) {
			conditionSelect2 = true;
		}
		
//Selection module3 dois throw UnfoundException
		try{
			module3 = facadeSuiviStagiaireRemote.selectModule(module3);
		}catch (UnfoundException e) {
			conditionSelect3 = true;
		}
		
//Tests
		assertTrue("Insert Module1",conditionInsert1);
		assertTrue("Select Module1",conditionSelect1);
		assertNull("Null Module 1",module1);
		assertTrue("Insert Module2",conditionInsert2);
		assertTrue("Select Module2",conditionSelect2);
		assertNull("Null Module 2",module2);
		assertTrue("Insert Module3",conditionInsert3);
		assertTrue("Select Module3",conditionSelect3);
		assertNull("Null Module 3",module3);
		
	}

}
