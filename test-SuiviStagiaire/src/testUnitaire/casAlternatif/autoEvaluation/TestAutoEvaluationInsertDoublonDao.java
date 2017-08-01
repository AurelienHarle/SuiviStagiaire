package testUnitaire.casAlternatif.autoEvaluation;

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
	private static boolean conditionSelectAutoEvaluation1;
	private AutoEvaluation autoEvaluationBDD;

	@BeforeClass
	public static void init() throws NamingException{

		//Initialisation du context
		context = new InitialContext();
		facadeSuiviStagiaireRemote = (FacadeSuiviStagiaireRemote) context.lookup("ejb:/server-SuiviStagiaire/FacadeSuiviStagiaire!fr.suiviStagiaire.facade.FacadeSuiviStagiaireRemote");

		//Creation des donn�es utile pour testInsertAutoEvaluationNull()
		autoEvaluation = null;

		//Creation et insertion des donn�es utile pour testInsertAutoEvaluationProprieteNull()		

		module = new Module("M5","D�velopper une application en couches","D�v une app N-tiers");
		try {
			facadeSuiviStagiaireRemote.insertModule(module);
		} catch (DoublonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		sequence = new Sequence("S4",module,"Pr�parer et ex�cuter les plans de tests d�une application et pr�parer et ex�cuter le d�ploiement d�une application",
				"Pr�pa & exec plans de tests d'une app et du deploie d'une app");
		try {
			facadeSuiviStagiaireRemote.insertSequence(sequence);
		} catch (DoublonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		competence = new Competence("C2",sequence,"Pr�parer et ex�cuter les plans de tests","Pr�pa & exec plan de tests");
		try {
			facadeSuiviStagiaireRemote.insertCompetence(competence);
		} catch (DoublonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		niveauAcquisition = new NiveauAcquisition("2","AC");
		try {
			facadeSuiviStagiaireRemote.insertNiveauAcquisition(niveauAcquisition);
		} catch (DoublonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		stagiaire = new Stagiaire("13111384","Password","Harl�","Aur�lien",null,null,null,null,null,null);
		try {
			facadeSuiviStagiaireRemote.insertStagiaire(stagiaire);
		} catch (DoublonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		date = LocalDate.now();

		//Creation des boolean de controle		
		conditionInsertAutoEvaluation1 = true;
		conditionSelectAutoEvaluation1 = true;


		//Creation d'une auto-evaluation ins�r� et une pour test		
		autoEvaluation = new AutoEvaluation(competence,niveauAcquisition, stagiaire, date, null);
		try {
			facadeSuiviStagiaireRemote.insertAutoEvaluation(autoEvaluation);
		} catch (NullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DateNullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		autoEvaluationDoublon = new AutoEvaluation(competence,niveauAcquisition, stagiaire, date, "Updated");

	}

	@AfterClass
	public static void finalizeur(){

		facadeSuiviStagiaireRemote.deleteCompetence(competence);
		facadeSuiviStagiaireRemote.deleteSequence(sequence);
		facadeSuiviStagiaireRemote.deleteModule(module);

		facadeSuiviStagiaireRemote.deleteNiveauAcquisition(niveauAcquisition);
		facadeSuiviStagiaireRemote.deleteStagiaire(stagiaire);

		facadeSuiviStagiaireRemote.deleteAutoEvaluation(autoEvaluationDoublon);


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

		} catch (NullException | DateNullException e) {

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
		assertEquals("Competence ID : ",autoEvaluationDoublon.getCompetence().getIdentifiant(), autoEvaluationBDD.getCompetence().getIdentifiant());
		assertEquals("Stagiaire ID : ",autoEvaluationDoublon.getStagiaire().getOsia(), autoEvaluationBDD.getStagiaire().getOsia());
		assertEquals("NiveauAcquisition ID : ",autoEvaluationDoublon.getNiveauAcquisition().getIdentifiant(), autoEvaluationBDD.getNiveauAcquisition().getIdentifiant());

	}
}