package testUnitaire.casNominaux.competence;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import autoEvaluation.technique.Competences;
import facade.FacadeSuiviStagiaireRemote;

public class TestSelectCompetences {

	private static InitialContext context;
	private static FacadeSuiviStagiaireRemote facadeSuiviStagiaireRemote;
	private static Competences competences;

	@BeforeClass
	public static void init() throws NamingException{
		
		//Initialisation du context
		context = new InitialContext();
		facadeSuiviStagiaireRemote = (FacadeSuiviStagiaireRemote) context.lookup("ejb:/server-SuiviStagiaire/FacadeSuiviStagiaire!facade.FacadeSuiviStagiaireRemote");
	
	}
	
	@Test
	public void testSelectCompetences(){
		
		competences = facadeSuiviStagiaireRemote.selectCompetences();
		System.out.println(competences);
		
	}
	
	
}
