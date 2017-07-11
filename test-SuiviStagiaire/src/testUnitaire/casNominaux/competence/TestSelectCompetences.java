package testUnitaire.casNominaux.competence;

import static org.junit.Assert.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import autoEvaluation.entity.Competence;
import autoEvaluation.entity.Module;
import autoEvaluation.entity.Sequence;
import autoEvaluation.technique.Competences;
import exception.DoublonException;
import exception.NullException;
import facade.FacadeSuiviStagiaireRemote;

public class TestSelectCompetences {

	private static InitialContext context;
	private static FacadeSuiviStagiaireRemote facadeSuiviStagiaireRemote;
	private static Competences competences;
	private boolean condition = true;
	private Module module;
	private Sequence sequence;
	private Competence competence;
	
	@BeforeClass
	public static void init() throws NamingException{
		
		//Initialisation du context
		context = new InitialContext();
		facadeSuiviStagiaireRemote = (FacadeSuiviStagiaireRemote) context.lookup("ejb:/server-SuiviStagiaire/FacadeSuiviStagiaire!facade.FacadeSuiviStagiaireRemote");
	
	}

	/**
	 * Test si on peux récupéré la liste de {@link Competence} présente en base
	 */
	@Test
	public void testSelectCompetences(){
		
		competences = facadeSuiviStagiaireRemote.selectCompetences();

		if(competences.isEmpty()){
			condition = false;
		}
		
		assertNotNull("Not null",competences);
		assertTrue("Not empty",condition);
	}
	
	@Test
	public void testInsertCompetence(){
		
		module = new Module("M1","NomLong","NomCourt");
		sequence = new Sequence("S1",module,"NomLong","NomCour");
		competence = new Competence("C1", sequence,"NomLong","NomCour");
		
		try {
			facadeSuiviStagiaireRemote.insertModule(module);
		} catch (DoublonException | NullException e1) {
			e1.printStackTrace();
		}
		
		try {
			facadeSuiviStagiaireRemote.insertSequence(sequence);
		} catch (DoublonException | NullException e1) {
			e1.printStackTrace();
		}
		
		try {
			facadeSuiviStagiaireRemote.insertCompetence(competence);
		} catch (DoublonException | NullException e) {
			
			e.printStackTrace();
			
		}
	}
	
	
}
