package testUnitaire.casNominaux.autoEvaluation;

import static org.junit.Assert.assertEquals;
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
public class TestAutoEvaluationUpdateDao {
	
	
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
		moduleInsert = facadeSuiviStagiaireRemote.selectModule(moduleInsert);
		
		//Creation et insertion du module pour testSelectSequence()
		sequenceInsert = new Sequence("S1",moduleInsert,"Test","Test");
		facadeSuiviStagiaireRemote.insertSequence(sequenceInsert);
		sequenceInsert = facadeSuiviStagiaireRemote.selectSequence(sequenceInsert);
		
		//Competences pour testSelectCompetence()
		competenceInsert = new Competence("C1",sequenceInsert,"Test","Test");
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
	
	/**
	 * Test d'une update d'une {@link AutoEvaluation}
	 * @throws UnfoundException 
	 */
	@Test
	public void testUpdateAutoEvaluation() throws UnfoundException{
		
		//Creation date pour test
		LocalDate date = LocalDate.now();
				
		boolean condition = true;
		AutoEvaluation autoEvaluation = new AutoEvaluation(competenceInsert,niveauAcquisitionInsert,stagiaireInsert,date,"Update from the hell");
		
		try{
			
			facadeSuiviStagiaireRemote.updateAutoEvaluation(autoEvaluation);
			
		}catch (Exception e) {
			
			condition = false;
			e.printStackTrace();
			
		}
		
		AutoEvaluation autoEvaluationBDD = null;
		
		try {
			autoEvaluationBDD = facadeSuiviStagiaireRemote.selectAutoEvaluationByStagCompDate(autoEvaluation);
		} catch (NullException e) {
			e.printStackTrace();
		}
		
		assertTrue("Aucune lever d'exception : ",condition);
		
		//assertEquals("Indentifiant : ",autoEvaluation.getIdentifiant(), autoEvaluationBDD.getIdentifiant());
		assertEquals("Date : ",autoEvaluation.getDateAutoEvaluation(), autoEvaluationBDD.getDateAutoEvaluation());
		assertEquals("Ressenti : ",autoEvaluation.getRessenti(), autoEvaluationBDD.getRessenti());
		assertEquals("Competence ID : ",autoEvaluation.getCompetence().getIdentifiant(), autoEvaluationBDD.getCompetence().getIdentifiant());
		assertEquals("Stagiaire ID : ",autoEvaluation.getStagiaire().getOsia(), autoEvaluationBDD.getStagiaire().getOsia());
		assertEquals("NiveauAcquisition ID : ",autoEvaluation.getNiveauAcquisition().getIdentifiant(), autoEvaluationBDD.getNiveauAcquisition().getIdentifiant());

		
	}

}
