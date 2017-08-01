package testUnitaire.casNominaux.competence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.suiviStagiaire.exception.DoublonException;
import fr.suiviStagiaire.exception.NullException;
import fr.suiviStagiaire.facade.FacadeSuiviStagiaireRemote;
import fr.suiviStagiaire.formation.contenu.competence.entity.Competence;
import fr.suiviStagiaire.formation.contenu.competence.technique.Competences;
import fr.suiviStagiaire.formation.contenu.module.entity.Module;
import fr.suiviStagiaire.formation.contenu.sequence.entity.Sequence;

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
