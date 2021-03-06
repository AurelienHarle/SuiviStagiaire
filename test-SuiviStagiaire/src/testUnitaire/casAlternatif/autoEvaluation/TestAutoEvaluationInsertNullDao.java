package testUnitaire.casAlternatif.autoEvaluation;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.suiviStagiaire.exception.DateNullException;
import fr.suiviStagiaire.exception.DoublonException;
import fr.suiviStagiaire.exception.NullException;
import fr.suiviStagiaire.exception.UnfoundException;
import fr.suiviStagiaire.facade.FacadeSuiviStagiaireRemote;
import fr.suiviStagiaire.formation.autoEvaluation.entity.AutoEvaluation;
import fr.suiviStagiaire.formation.autoEvaluation.niveauAcquisition.entity.NiveauAcquisition;
import fr.suiviStagiaire.formation.contenu.competence.entity.Competence;
import fr.suiviStagiaire.formation.contenu.module.entity.Module;
import fr.suiviStagiaire.formation.contenu.sequence.entity.Sequence;
import fr.suiviStagiaire.stagiaire.entity.Stagiaire;

/**
 * Test de la {@link Class} {@link GetDao}
 * 
 * @author Aur�lien Harl�
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
	private static AutoEvaluation autoEvaluation1;
	private static AutoEvaluation autoEvaluation2;
	private static AutoEvaluation autoEvaluation3;
	private static AutoEvaluation autoEvaluation4;
	
	@BeforeClass
	public static void init() throws NamingException, DoublonException, NullException{
		
		//Initialisation du context
		context = new InitialContext();
		facadeSuiviStagiaireRemote = (FacadeSuiviStagiaireRemote) context.lookup("ejb:/server-SuiviStagiaire/FacadeSuiviStagiaire!fr.suiviStagiaire.facade.FacadeSuiviStagiaireRemote");
		
		//Creation des donn�es utile pour testInsertAutoEvaluationNull()		
		conditionInsert = false;
		conditionSelect = true;
		autoEvaluation = null;
		
		//Creation et insertion des donn�es utile pour testInsertAutoEvaluationProprieteNull()		

		module = new Module("M5","D�velopper une application en couches","D�v une app N-tiers");
		try {
			facadeSuiviStagiaireRemote.insertModule(module);
		} catch (DoublonException | NullException e) {
			
			e.printStackTrace();
		}
		
		sequence = new Sequence("S4",module,"Pr�parer et ex�cuter les plans de tests d�une application et pr�parer et ex�cuter le d�ploiement d�une application",
				"Pr�pa & exec plans de tests d'une app et du deploie d'une app");
		try {
			facadeSuiviStagiaireRemote.insertSequence(sequence);
		} catch (DoublonException | NullException e) {
			
			e.printStackTrace();
		}
		
		competence = new Competence("C2",sequence,"Pr�parer et ex�cuter les plans de tests","Pr�pa & exec plan de tests");
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
		
		stagiaire = new Stagiaire("13111384","Password","Harl�","Aur�lien",null,null,null,null,null,null);
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
		
//Creation des autoEvaluation avec une propri�t� a null		
		autoEvaluation1 = new AutoEvaluation(null, niveauAcquisition, stagiaire, date, null);
		autoEvaluation2 = new AutoEvaluation(competence, null, stagiaire, date, null);
		autoEvaluation3 = new AutoEvaluation(competence, niveauAcquisition, null, date, null);
		autoEvaluation4 = new AutoEvaluation(competence, niveauAcquisition, stagiaire, null, null);

	}
	

	@AfterClass
	public static void finalizeur(){
		
		facadeSuiviStagiaireRemote.deleteCompetence(competence);
		facadeSuiviStagiaireRemote.deleteSequence(sequence);
		facadeSuiviStagiaireRemote.deleteModule(module);
		
		facadeSuiviStagiaireRemote.deleteNiveauAcquisition(niveauAcquisition);
		facadeSuiviStagiaireRemote.deleteStagiaire(stagiaire);
		
	}
	
	/**
	 * Test d'une insertion d'une {@link AutoEvaluation} Null
	 * @throws UnfoundException 
	 */
	@Test
	public void testInsertAutoEvaluationNull()  {

		
		try {
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluation);
		} catch (NullException | DateNullException e) {
			conditionInsert = true;
		}
	
		try {
			autoEvaluation = facadeSuiviStagiaireRemote.selectAutoEvaluationByStagCompDate(autoEvaluation);
		} catch (UnfoundException | NullException e) {
			conditionSelect = true;
		}
	
		assertTrue(conditionInsert);
		assertTrue(conditionSelect);
		assertNull(autoEvaluation);
		
	}
	
	/**
	 * Test d'insertion d'un module avec une propri�t� obligatoire a Null
	 *   
	 */
	@Test
	public void testInsertAutoEvaluationProprieteNull(){

//Insertion des autoEvaluation avec une propri�t� a null Dois throw une NullException et pass� la condition a true
		try {
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluation1);
		} catch (NullException | DateNullException e) {
			conditionInsertAutoEvaluation1 = true;
		}
		
		try {
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluation2);
		} catch (NullException | DateNullException e) {
			conditionInsertAutoEvaluation2 = true;
		}
		
		try {
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluation3);
		} catch (NullException | DateNullException e) {
			conditionInsertAutoEvaluation3 = true;
		}
		
		try {
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluation4);
		} catch (NullException | DateNullException e) {
			conditionInsertAutoEvaluation4 = true;
		}


		//Verification des diff�rente condition
		assertTrue("Insert autoEvaluation1", conditionInsertAutoEvaluation1);
		assertTrue("Insert autoEvaluation2", conditionInsertAutoEvaluation2);
		assertTrue("Insert autoEvaluation3", conditionInsertAutoEvaluation3);
		assertTrue("Insert autoEvaluation4", conditionInsertAutoEvaluation4);
		
	}


//	/**
//	 * Test d'insertion d'un module avec une propri�t� obligatoire a Null
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
