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
public class TestSelectDao {
	
	
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
		
		//Creation et insertion du module pour testSelectSequence()
		sequenceInsert = new Sequence("S1",moduleInsert,"Test","Test");
		facadeSuiviStagiaireRemote.insertSequence(sequenceInsert);
		
		//Competences pour testSelectCompetence()
		competenceInsert = new Competence("C1",sequenceInsert,moduleInsert,"Test","Test");
		facadeSuiviStagiaireRemote.insertCompetence(competenceInsert);
		
		//Stagiaire pour testSelectStagiaire()
		stagiaireInsert = new Stagiaire("login","motdepasse","nom","prenom",null,null,null,null,null,null);
		facadeSuiviStagiaireRemote.insertStagiaire(stagiaireInsert);
		
		//NiveauAcquisition pour testSelectNiveauAcquisition()
		niveauAcquisitionInsert = new NiveauAcquisition("1","A");
		facadeSuiviStagiaireRemote.insertNiveauAcquisition(niveauAcquisitionInsert);
		
		//Creation date pour testSelectAutoEvaluation()
		LocalDate date = LocalDate.now();
		
		//AutoEvaluation pour testSelectAutoEvaluation()
		autoEvaluationInsert = new AutoEvaluation(competenceInsert,sequenceInsert,moduleInsert,niveauAcquisitionInsert,stagiaireInsert,date,null);
		facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluationInsert);
		
	}
	

	@AfterClass
	public static void finalizeur(){
		
		//TODO FIX IT
		
//		autoEvaluationSelect = facadeSuiviStagiaireRemote.selectAutoEvaluation(autoEvaluationSelect);
//		System.out.println(autoEvaluationSelect);
//		facadeSuiviStagiaireRemote.deleteAutoEvaluation(autoEvaluationSelect);
//		
//		moduleSelect = facadeSuiviStagiaireRemote.selectModule(moduleSelect);
//		System.out.println(moduleSelect);
//		facadeSuiviStagiaireRemote.deleteModule(moduleSelect);
//		
//		sequenceSelect = facadeSuiviStagiaireRemote.selectSequence(sequenceSelect);
//		System.out.println(sequenceSelect);
//		facadeSuiviStagiaireRemote.deleteSequence(sequenceSelect);
//		
//		competenceSelect = facadeSuiviStagiaireRemote.selectCompetence(competenceSelect);
//		System.out.println(competenceSelect);
//		facadeSuiviStagiaireRemote.deleteCompetence(competenceSelect);
//		
//		stagiaireSelect = facadeSuiviStagiaireRemote.selectStagiaire(stagiaireSelect);
//		System.out.println(stagiaireSelect);
//		facadeSuiviStagiaireRemote.deleteStagiaire(stagiaireSelect);
//		
//		niveauAcquisitionSelect = facadeSuiviStagiaireRemote.selectNiveauAcquisition(niveauAcquisitionSelect);
//		System.out.println(niveauAcquisitionSelect);
//		facadeSuiviStagiaireRemote.deleteNiveauAcquisition(niveauAcquisitionSelect);
//		
//		moduleSequenceSelect = facadeSuiviStagiaireRemote.selectModule(moduleSequenceSelect);
//		System.out.println(moduleSequenceSelect);
//		facadeSuiviStagiaireRemote.deleteModule(moduleSequenceSelect);
//		
//		moduleCompetenceSelect = facadeSuiviStagiaireRemote.selectModule(moduleCompetenceSelect);
//		System.out.println(moduleCompetenceSelect);
//		facadeSuiviStagiaireRemote.deleteModule(moduleCompetenceSelect);
//		
//		sequenceCompetenceSelect = facadeSuiviStagiaireRemote.selectSequence(sequenceCompetenceSelect);
//		System.out.println(sequenceCompetenceSelect);
//		facadeSuiviStagiaireRemote.deleteSequence(sequenceCompetenceSelect);
		
	}
	
	
	/**
	 * Test d'selection d'un Module
	 */
	@Test
	public void testSelectModule(){
		
		Module moduleSelect = facadeSuiviStagiaireRemote.selectModule(moduleInsert);
		
		assertEquals(moduleInsert.getIdentifiant(), moduleSelect.getIdentifiant());
		assertEquals(moduleInsert.getNomCourt(), moduleSelect.getNomCourt());
		assertEquals(moduleInsert.getNomLong(), moduleSelect.getNomLong());
		
	}
	
	/**
	 * Test d'selection d'une Sequence
	 */
	@Test
	public void testSelectSequence(){
		
		Sequence sequenceSelect = facadeSuiviStagiaireRemote.selectSequence(sequenceInsert);
		
		assertEquals(sequenceInsert.getIdentifiant(), sequenceSelect.getIdentifiant());		
		assertEquals(sequenceInsert.getNomCourt(), sequenceSelect.getNomCourt());
		assertEquals(sequenceInsert.getNomLong(), sequenceSelect.getNomLong());
	}
	
	/**
	 * Test d'selection d'une Competences
	 */
	@Test
	public void testSelectCompetence(){
		
		Competence competenceSelect = facadeSuiviStagiaireRemote.selectCompetence(competenceInsert);
		
		assertEquals(competenceInsert.getIdentifiant(), competenceSelect.getIdentifiant());
		assertEquals(competenceInsert.getNomCourt(), competenceSelect.getNomCourt());
		assertEquals(competenceInsert.getNomLong(), competenceSelect.getNomLong());

	}
	
	/**
	 * Test d'selection d'un Stagiaire
	 */
	@Test
	public void testSelectStagiaire(){
		
		Stagiaire stagiaireSelect = facadeSuiviStagiaireRemote.selectStagiaire(stagiaireInsert);
		
		assertEquals(stagiaireInsert.getLogin(), stagiaireSelect.getLogin());
		assertEquals(stagiaireInsert.getMotDePasse(), stagiaireSelect.getMotDePasse());
		assertEquals(stagiaireInsert.getNom(), stagiaireSelect.getNom());
		assertEquals(stagiaireInsert.getPrenom(), stagiaireSelect.getPrenom());
		
	}
	
	/**
	 * Test d'selection d'un NiveauAcquisition
	 */
	@Test
	public void testSelectNiveauAcquisition(){
		
		NiveauAcquisition niveauAcquisitionSelect = facadeSuiviStagiaireRemote.selectNiveauAcquisition(niveauAcquisitionInsert);
		
		assertEquals(niveauAcquisitionInsert.getIdentifiant(), niveauAcquisitionSelect.getIdentifiant());
		assertEquals(niveauAcquisitionInsert.getNiveau(), niveauAcquisitionSelect.getNiveau());
		
		
	}
	
	/**
	 * Test d'une selection d'une {@link AutoEvaluation}
	 */
	@Test
	public void testSelectAutoEvaluation(){
		
		AutoEvaluation autoEvaluationSelect = facadeSuiviStagiaireRemote.selectAutoEvaluation(autoEvaluationInsert);
		
		assertEquals(autoEvaluationInsert.getIdentifiant(), autoEvaluationSelect.getIdentifiant());
		assertEquals(autoEvaluationInsert.getDateAutoEvaluation(), autoEvaluationSelect.getDateAutoEvaluation());

	}

}
