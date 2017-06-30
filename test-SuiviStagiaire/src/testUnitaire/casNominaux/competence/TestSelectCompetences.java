package testUnitaire.casNominaux.competence;

import static org.junit.Assert.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import autoEvaluation.entity.Competence;
import autoEvaluation.technique.Competences;
import facade.FacadeSuiviStagiaireRemote;

public class TestSelectCompetences {

	private static InitialContext context;
	private static FacadeSuiviStagiaireRemote facadeSuiviStagiaireRemote;
	private static Competences competences;
	private boolean condition = true;
	
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
	
	
}
