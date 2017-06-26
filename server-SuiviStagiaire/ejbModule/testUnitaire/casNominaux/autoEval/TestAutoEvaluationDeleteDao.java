package testUnitaire.casNominaux.autoEval;

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
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/06/2017
 *
 */
public class TestAutoEvaluationDeleteDao {
	
	
	private static Context context;
	private static FacadeSuiviStagiaireRemote facadeSuiviStagiaireRemote;
	
	private static Module moduleInsert;
	private static Sequence sequenceInsert;
	private static Competence competenceInsert;
	private static Stagiaire stagiaireInsert;
	private static NiveauAcquisition niveauAcquisitionInsert;
	private static AutoEvaluation autoEvaluationInsert;
	private static boolean conditionSelectAutoEvaluation;

	
	@BeforeClass
	public static void init() throws NamingException, DoublonException, NullException, UnfoundException, DateNullException{
		
		//Initialisation du context
		context = new InitialContext();
		facadeSuiviStagiaireRemote = (FacadeSuiviStagiaireRemote) context.lookup("ejb:/server-SuiviStagiaire/FacadeSuiviStagiaire!facade.FacadeSuiviStagiaireRemote");
		
		//Module pour testSelectModule()
		moduleInsert = new Module("M1","Test","Test");
		facadeSuiviStagiaireRemote.insertModule(moduleInsert);
		moduleInsert = facadeSuiviStagiaireRemote.selectModule(moduleInsert);
		
		//Creation et insertion du module pour testSelectSequence()
		sequenceInsert = new Sequence("S1",moduleInsert,"Test","Test");
		facadeSuiviStagiaireRemote.insertSequence(sequenceInsert);
		sequenceInsert = facadeSuiviStagiaireRemote.selectSequence(sequenceInsert);
		
		//Competences pour testSelectCompetence()
		competenceInsert = new Competence("C1",sequenceInsert,moduleInsert,"Test","Test");
		facadeSuiviStagiaireRemote.insertCompetence(competenceInsert);
		competenceInsert = facadeSuiviStagiaireRemote.selectCompetence(competenceInsert);
		
		//Stagiaire pour testSelectStagiaire()
		stagiaireInsert = new Stagiaire("login","motdepasse","nom","prenom",null,null,null,null,null,null);
		facadeSuiviStagiaireRemote.insertStagiaire(stagiaireInsert);
		stagiaireInsert = facadeSuiviStagiaireRemote.selectStagiaire(stagiaireInsert);
		
		//NiveauAcquisition pour testSelectNiveauAcquisition()
		niveauAcquisitionInsert = new NiveauAcquisition("1","A");
		facadeSuiviStagiaireRemote.insertNiveauAcquisition(niveauAcquisitionInsert);
		niveauAcquisitionInsert = facadeSuiviStagiaireRemote.selectNiveauAcquisition(niveauAcquisitionInsert);
		
		//Creation date pour testSelectAutoEvaluation()
		LocalDate date = LocalDate.now();
		
		//AutoEvaluation pour testSelectAutoEvaluation()
		autoEvaluationInsert = new AutoEvaluation(competenceInsert,sequenceInsert,moduleInsert,niveauAcquisitionInsert,stagiaireInsert,date,null);
		facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluationInsert);
		autoEvaluationInsert = facadeSuiviStagiaireRemote.selectAutoEvaluationByStagCompDate(autoEvaluationInsert);
		
		conditionSelectAutoEvaluation = true;

	}
	

	//TODO DELETE WHEN COMPLETE TEST
	@AfterClass
	public static void finalizeur(){
		
		facadeSuiviStagiaireRemote.deleteCompetence(competenceInsert);
		facadeSuiviStagiaireRemote.deleteSequence(sequenceInsert);
		facadeSuiviStagiaireRemote.deleteModule(moduleInsert);
		facadeSuiviStagiaireRemote.deleteNiveauAcquisition(niveauAcquisitionInsert);
		facadeSuiviStagiaireRemote.deleteStagiaire(stagiaireInsert);
		
	}


	
	/**
	 * Test delete
	 * @throws UnfoundException 
	 */
	@Test
	public void testDelete() throws UnfoundException{

		AutoEvaluation autoEvaluation = null;
//		Competence competence = null;
//		Sequence sequence = null;
//		Module module = null;
//		Stagiaire stagiaire = null;
//		NiveauAcquisition niveauAcquisition = null;
		
		facadeSuiviStagiaireRemote.deleteAutoEvaluation(autoEvaluationInsert);
//		facadeSuiviStagiaireRemote.deleteCompetence(competenceInsert);		
//		facadeSuiviStagiaireRemote.deleteSequence(sequenceInsert);
//		facadeSuiviStagiaireRemote.deleteModule(moduleInsert);
//		facadeSuiviStagiaireRemote.deleteStagiaire(stagiaireInsert);
//		facadeSuiviStagiaireRemote.deleteNiveauAcquisition(niveauAcquisitionInsert);


		try {
			autoEvaluation = facadeSuiviStagiaireRemote.selectAutoEvaluationByStagCompDate(autoEvaluationInsert);
		} catch (NullException | UnfoundException e) {
			conditionSelectAutoEvaluation = true;
		}
		
//		competence = facadeSuiviStagiaireRemote.selectCompetence(competenceInsert);
//		sequence = facadeSuiviStagiaireRemote.selectSequence(sequenceInsert);
//		module = facadeSuiviStagiaireRemote.selectModule(moduleInsert);
//		stagiaire = facadeSuiviStagiaireRemote.selectStagiaire(stagiaireInsert);
//		niveauAcquisition = facadeSuiviStagiaireRemote.selectNiveauAcquisition(niveauAcquisitionInsert);

		assertNull(autoEvaluation);
		assertTrue(conditionSelectAutoEvaluation);
//		assertNull(niveauAcquisition);
//		assertNull(stagiaire);
//		assertNull(competence);
//		assertNull(sequence);
//		assertNull(module);
		
	}

}
