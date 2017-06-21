package testUnitaire.casNominaux.autoEval;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
import facade.FacadeSuiviStagiaireRemote;

/**
 * Test de la {@link Class} {@link GetDao}
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/06/2017
 *
 */
public class TestUpdateDao {
	
	
	private static Context context;
	private static FacadeSuiviStagiaireRemote facadeSuiviStagiaireRemote;

	private static Module moduleInsert;
	private static Sequence sequenceInsert;
	private static Competence competenceInsert;
	private static Stagiaire stagiaireInsert;
	private static NiveauAcquisition niveauAcquisitionInsert;
	private static AutoEvaluation autoEvaluationInsert;
	
	
	@BeforeClass
	public static void init() throws NamingException, DoublonException, NullException{
		
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
		
		
	}
	

	@AfterClass
	public static void finalizeur(){
		
	}
	
	
	/**
	 * Test d'update d'un Module
	 */
	@Test
	public void testUpdateModule(){
		
		boolean condition = true;
		Module module = new Module("M1","Update","Update");
		
		try{
			
			facadeSuiviStagiaireRemote.updateModule(module);
			
		}catch (Exception e) {
			
			condition = false;
			e.printStackTrace();
			
		}
		
		assertTrue(condition);
		
		Module moduleBDD = facadeSuiviStagiaireRemote.selectModule(module);
		
		assertEquals(module.getIdentifiant(),moduleBDD.getIdentifiant());
		assertEquals(module.getNomCourt(), moduleBDD.getNomCourt());
		assertEquals(module.getNomLong(), moduleBDD.getNomLong());
		
	}
	
	/**
	 * Test d'update d'une Sequence
	 */
	@Test
	public void testUpdateSequence(){
		
		boolean condition = true;
		Sequence sequence = new Sequence("S1",moduleInsert,"update","update");
		
		try{
			
			facadeSuiviStagiaireRemote.updateSequence(sequence);
			
		}catch (Exception e) {
			
			condition = false;
			e.printStackTrace();
			
		}
		
		assertTrue(condition);
		
		Sequence sequenceBDD = facadeSuiviStagiaireRemote.selectSequence(sequence);
		
		assertEquals(sequence.getIdentifiant(),sequenceBDD.getIdentifiant());
		assertEquals(sequence.getNomCourt(), sequenceBDD.getNomCourt());
		assertEquals(sequence.getNomLong(), sequenceBDD.getNomLong());
	}
	
	/**
	 * Test d'update d'une Competences
	 */
	@Test
	public void testUpdateCompetence(){
		
		boolean condition = true;
		Competence competence = new Competence("C1",sequenceInsert,moduleInsert,"Update","Update");
		
		try{
			
			facadeSuiviStagiaireRemote.updateCompetence(competence);
			
		}catch (Exception e) {
			
			condition = false;
			e.printStackTrace();
			
		}
		
		assertTrue(condition);
		
		Competence competenceBDD = facadeSuiviStagiaireRemote.selectCompetence(competence);
		
		assertEquals(competence.getIdentifiant(),competenceBDD.getIdentifiant());
		assertEquals(competence.getNomCourt(), competenceBDD.getNomCourt());
		assertEquals(competence.getNomLong(), competenceBDD.getNomLong());
	}
	
	/**
	 * Test d'update d'un Stagiaire
	 */
	@Test
	public void testUpdateStagiaire(){
		
		boolean condition = true;
		Stagiaire stagiaire = new Stagiaire("login","Update","Update","Update",null,null,null,null,null,null);
		
		try{
			
			facadeSuiviStagiaireRemote.updateStagiaire(stagiaire);
			
		}catch (Exception e) {
			
			condition = false;
			e.printStackTrace();
			
		}
		
		assertTrue(condition);
		
		Stagiaire stagiaireBDD = facadeSuiviStagiaireRemote.selectStagiaire(stagiaire);
		
		assertEquals(stagiaire.getLogin(), stagiaireBDD.getLogin());
		assertEquals(stagiaire.getMotDePasse(), stagiaireBDD.getMotDePasse());
		assertEquals(stagiaire.getNom(), stagiaireBDD.getNom());
		assertEquals(stagiaire.getPrenom(), stagiaireBDD.getPrenom());
	}
	
	/**
	 * Test d'update d'un NiveauAcquisition
	 */
	@Test
	public void testUpdateNiveauAcquisition(){
		
		boolean condition = true;
		NiveauAcquisition niveauAcquisition = new NiveauAcquisition("1","UP");
		
		try{
			
			facadeSuiviStagiaireRemote.updateNiveauAcquisition(niveauAcquisition);
			
		}catch (Exception e) {
			
			condition = false;
			e.printStackTrace();
			
		}
		
		assertTrue(condition);
		
		NiveauAcquisition niveauAcquisitionBDD = facadeSuiviStagiaireRemote.selectNiveauAcquisition(niveauAcquisition);
		
		assertEquals(niveauAcquisition.getIdentifiant(),niveauAcquisitionBDD.getIdentifiant());
		assertEquals(niveauAcquisition.getIdentifiant(), niveauAcquisitionBDD.getIdentifiant());
		assertEquals(niveauAcquisition.getNiveau(), niveauAcquisitionBDD.getNiveau());
		
	}
	
	/**
	 * Test d'une update d'une {@link AutoEvaluation}
	 */
	@Test
	public void testUpdateAutoEvaluation(){
		
		//Creation date pour test
		LocalDate date = LocalDate.now();
				
		boolean condition = true;
		AutoEvaluation autoEvaluation = new AutoEvaluation(competenceInsert,sequenceInsert,moduleInsert,niveauAcquisitionInsert,stagiaireInsert,date,"Update from the hell");
		
		try{
			
			facadeSuiviStagiaireRemote.updateAutoEvaluation(autoEvaluation);
			
		}catch (Exception e) {
			
			condition = false;
			e.printStackTrace();
			
		}
		
		assertTrue(condition);
		
		AutoEvaluation autoEvaluationBDD = facadeSuiviStagiaireRemote.selectAutoEvaluation(autoEvaluation);
		
		assertEquals(autoEvaluation.getIdentifiant(),autoEvaluationBDD.getIdentifiant());
		assertEquals(autoEvaluation.getIdentifiant(), autoEvaluationBDD.getIdentifiant());
		assertEquals(autoEvaluation.getDateAutoEvaluation(), autoEvaluationBDD.getDateAutoEvaluation());
		assertEquals(autoEvaluation.getRessenti(), autoEvaluationBDD.getRessenti());
		
	}

}
