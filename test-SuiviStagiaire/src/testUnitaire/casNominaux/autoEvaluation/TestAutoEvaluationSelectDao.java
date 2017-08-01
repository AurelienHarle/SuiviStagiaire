package testUnitaire.casNominaux.autoEvaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/06/2017
 *
 */
public class TestAutoEvaluationSelectDao {
	
	
	private static Context context;
	private static FacadeSuiviStagiaireRemote facadeSuiviStagiaireRemote;

	private static Module moduleInsert;
	private static Sequence sequenceInsert;
	private static Competence competenceInsert;
	private static Stagiaire stagiaireInsert;
	private static NiveauAcquisition niveauAcquisitionInsert;
	private static AutoEvaluation autoEvaluationInsert;
	
	@BeforeClass
	public static void init() throws NamingException, DoublonException, NullException, UnfoundException, DateNullException{
		
		//Initialisation du context
		context = new InitialContext();
		facadeSuiviStagiaireRemote = (FacadeSuiviStagiaireRemote) context.lookup("ejb:/server-SuiviStagiaire/FacadeSuiviStagiaire!fr.suiviStagiaire.facade.FacadeSuiviStagiaireRemote");
		
		//Module pour testSelectModule()
		moduleInsert = new Module("M1","Test","Test");
		facadeSuiviStagiaireRemote.insertModule(moduleInsert);
		
		//Creation et insertion du module pour testSelectSequence()
		sequenceInsert = new Sequence("S1",moduleInsert,"Test","Test");
		facadeSuiviStagiaireRemote.insertSequence(sequenceInsert);
		
		//Competences pour testSelectCompetence()
		competenceInsert = new Competence("C1",sequenceInsert,"Test","Test");
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
		autoEvaluationInsert = new AutoEvaluation(competenceInsert,niveauAcquisitionInsert,stagiaireInsert,date,null);
		facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluationInsert);
		autoEvaluationInsert = facadeSuiviStagiaireRemote.selectAutoEvaluationByStagCompDate(autoEvaluationInsert);
	}
	

	@AfterClass
	public static void finalizeur(){
		
		facadeSuiviStagiaireRemote.deleteAutoEvaluation(autoEvaluationInsert);
		facadeSuiviStagiaireRemote.deleteCompetence(competenceInsert);
		facadeSuiviStagiaireRemote.deleteSequence(sequenceInsert);
		facadeSuiviStagiaireRemote.deleteModule(moduleInsert);
		facadeSuiviStagiaireRemote.deleteNiveauAcquisition(niveauAcquisitionInsert);
		facadeSuiviStagiaireRemote.deleteStagiaire(stagiaireInsert);
		
	}
	
	
//	/**
//	 * Test d'selection d'un Module
//	 */
//	@Test
//	public void testSelectModule(){
//		
//		Module moduleSelect = null;
//		boolean condition = true;
//		try {
//			moduleSelect = facadeSuiviStagiaireRemote.selectModule(moduleInsert);
//		} catch (UnfoundException e) {
//			condition = false;
//			
//		}
//		
//		assertTrue(condition);
//		assertNotNull(moduleSelect);
//		assertEquals(moduleInsert.getIdentifiant(), moduleSelect.getIdentifiant());
//		assertEquals(moduleInsert.getNomCourt(), moduleSelect.getNomCourt());
//		assertEquals(moduleInsert.getNomLong(), moduleSelect.getNomLong());
//		
//	}
//	
//	/**
//	 * Test d'selection d'une Sequence
//	 */
//	@Test
//	public void testSelectSequence(){
//		
//		Sequence sequenceSelect = null;
//		boolean condition = true;
//		try {
//			sequenceSelect = facadeSuiviStagiaireRemote.selectSequence(sequenceInsert);
//		} catch (UnfoundException e) {
//			condition = false;
//			
//		}
//		
//		assertTrue(condition);
//		assertNotNull(sequenceSelect);
//		assertEquals(sequenceInsert.getIdentifiant(), sequenceSelect.getIdentifiant());		
//		assertEquals(sequenceInsert.getNomCourt(), sequenceSelect.getNomCourt());
//		assertEquals(sequenceInsert.getNomLong(), sequenceSelect.getNomLong());
//	}
//	
//	/**
//	 * Test d'selection d'une Competences
//	 */
//	@Test
//	public void testSelectCompetence(){
//		
//		Competence competenceSelect = null;
//		boolean condition = true;
//		try {
//			competenceSelect = facadeSuiviStagiaireRemote.selectCompetence(competenceInsert);
//		} catch (UnfoundException e) {
//			condition = false;
//			
//		}
//		
//		assertTrue(condition);
//		assertNotNull(competenceSelect);
//		assertEquals(competenceInsert.getIdentifiant(), competenceSelect.getIdentifiant());
//		assertEquals(competenceInsert.getNomCourt(), competenceSelect.getNomCourt());
//		assertEquals(competenceInsert.getNomLong(), competenceSelect.getNomLong());
//
//	}
//	
//	/**
//	 * Test d'selection d'un Stagiaire
//	 */
//	@Test
//	public void testSelectStagiaire(){
//		
//		Stagiaire stagiaireSelect = null;
//		boolean condition = true;
//		try {
//			stagiaireSelect = facadeSuiviStagiaireRemote.selectStagiaire(stagiaireInsert);
//		} catch (UnfoundException e) {
//			condition = false;
//			
//		}
//		
//		assertTrue(condition);
//		assertNotNull(stagiaireSelect);
//		assertEquals(stagiaireInsert.getLogin(), stagiaireSelect.getLogin());
//		assertEquals(stagiaireInsert.getMotDePasse(), stagiaireSelect.getMotDePasse());
//		assertEquals(stagiaireInsert.getNom(), stagiaireSelect.getNom());
//		assertEquals(stagiaireInsert.getPrenom(), stagiaireSelect.getPrenom());
//		
//	}
//	
//	/**
//	 * Test d'selection d'un NiveauAcquisition
//	 */
//	@Test
//	public void testSelectNiveauAcquisition(){
//		
//		NiveauAcquisition niveauAcquisitionSelect = null;
//		boolean condition = true;
//		try {
//			niveauAcquisitionSelect = facadeSuiviStagiaireRemote.selectNiveauAcquisition(niveauAcquisitionInsert);
//		} catch (UnfoundException e) {
//			condition = false;
//			
//		}
//		
//		assertTrue(condition);
//		assertNotNull(niveauAcquisitionSelect);
//		assertEquals(niveauAcquisitionInsert.getIdentifiant(), niveauAcquisitionSelect.getIdentifiant());
//		assertEquals(niveauAcquisitionInsert.getNiveau(), niveauAcquisitionSelect.getNiveau());
//		
//		
//	}
	
	/**
	 * Test d'une selection d'une {@link AutoEvaluation}
	 */
	@Test
	public void testSelectAutoEvaluation(){
		
		AutoEvaluation autoEvaluationSelect = null;
		boolean condition = true;
		try {
			autoEvaluationSelect = facadeSuiviStagiaireRemote.selectAutoEvaluationByStagCompDate(autoEvaluationInsert);
		} catch (UnfoundException | NullException e) {
			condition = false;
			
		}		
		
		assertTrue(condition);
		assertNotNull(autoEvaluationSelect);
		assertEquals(autoEvaluationInsert.getIdentifiant(), autoEvaluationSelect.getIdentifiant());
		assertEquals(autoEvaluationInsert.getDateAutoEvaluation(), autoEvaluationSelect.getDateAutoEvaluation());
		assertEquals(autoEvaluationInsert.getRessenti(), autoEvaluationSelect.getRessenti());

	}

}
