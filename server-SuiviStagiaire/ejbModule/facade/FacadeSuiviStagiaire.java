package facade;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.entity.Competence;
import autoEvaluation.entity.Module;
import autoEvaluation.entity.NiveauAcquisition;
import autoEvaluation.entity.Sequence;
import autoEvaluation.facade.FacadeServiceAutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import compteUtilisateur.entity.Stagiaire;
import exception.DoublonException;
import exception.NullException;
import logger.Journaliseur;

/**
 * Session Bean implementation class FacadeSuiviStagiaire
 */
@Stateless
@Remote(FacadeSuiviStagiaireRemote.class)
public class FacadeSuiviStagiaire implements FacadeSuiviStagiaireRemote {

    /**
     * Default constructor. 
     */
    public FacadeSuiviStagiaire() {
    }
    
    @EJB
    FacadeServiceAutoEvaluation facadeServiceAutoEvaluation;
    
    Journaliseur journaliseur = Journaliseur.getINSTANCE();

	@Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws DoublonException, NullException {
		facadeServiceAutoEvaluation.insertAutoEvaluation(autoEvaluation);
		
	}

	@Override
	public void insertModule(Module module) throws DoublonException, NullException {
		facadeServiceAutoEvaluation.insertModule(module);

	}

	@Override
	public void insertSequence(Sequence sequence) throws DoublonException, NullException {
		facadeServiceAutoEvaluation.insertSequence(sequence);
		
	}

	@Override
	public void insertCompetence(Competence competence) throws DoublonException, NullException {
		facadeServiceAutoEvaluation.insertCompetence(competence);
		
	}

	@Override
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException {
		facadeServiceAutoEvaluation.insertNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException {
		facadeServiceAutoEvaluation.insertStagiaire(stagiaire);
		
	}

	@Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation) {
		facadeServiceAutoEvaluation.updateAutoEvaluation(autoEvaluation);
		
	}

	@Override
	public void updateModule(Module module) {
		
		facadeServiceAutoEvaluation.updateModule(module);
	}

	@Override
	public void updateSequence(Sequence sequence) {
		
		facadeServiceAutoEvaluation.updateSequence(sequence);
	}

	@Override
	public void updateCompetence(Competence competence) {
		facadeServiceAutoEvaluation.updateCompetence(competence);
		
	}

	@Override
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		facadeServiceAutoEvaluation.updateNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public void updateStagiaire(Stagiaire stagiaire) {
		facadeServiceAutoEvaluation.deleteStagiaire(stagiaire);
		
	}

	@Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		facadeServiceAutoEvaluation.deleteAutoEvaluation(autoEvaluation);
		
	}

	@Override
	public void deleteModule(Module module) {
		facadeServiceAutoEvaluation.deleteModule(module);
	}

	@Override
	public void deleteSequence(Sequence sequence) {
		facadeServiceAutoEvaluation.deleteSequence(sequence);
		
	}

	@Override
	public void deleteCompetence(Competence competence) {
		facadeServiceAutoEvaluation.deleteCompetence(competence);
		
	}

	@Override
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		facadeServiceAutoEvaluation.deleteNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public void deleteStagiaire(Stagiaire stagiaire) {
		facadeServiceAutoEvaluation.deleteStagiaire(stagiaire);
		
	}

	@Override
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation) {
		return facadeServiceAutoEvaluation.selectAutoEvaluation(autoEvaluation);
		
	}

	@Override
	public AutoEvaluation selectAutoEvaluationByDateRessentiCompetenceModuleNiveauAcquisitionSequenceStagiaire(
			AutoEvaluation autoEvaluation) {
		return facadeServiceAutoEvaluation.selectAutoEvaluationByDateRessentiCompetenceModuleNiveauAcquisitionSequenceStagiaire(autoEvaluation);
	}

	@Override
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) {
		return facadeServiceAutoEvaluation.selectAutoEvaluationByStagCompDate(autoEvaluation);
		
	}

	@Override
	public AutoEvaluations selectAutoEvaluationByStagComp(AutoEvaluation autoEvaluation) {
		return facadeServiceAutoEvaluation.selectAutoEvaluationByStagComp(autoEvaluation);
	}

	@Override
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation) {
		return facadeServiceAutoEvaluation.selectAutoEvaluationByStag(autoEvaluation);
	}

	@Override
	public Module selectModule(Module module) {
		return facadeServiceAutoEvaluation.selectModule(module);
		
	}

	@Override
	public Sequence selectSequence(Sequence sequence) {
		return facadeServiceAutoEvaluation.selectSequence(sequence);
		
	}

	@Override
	public Competence selectCompetence(Competence competence) {
		return facadeServiceAutoEvaluation.selectCompetence(competence);
		
	}

	@Override
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		return facadeServiceAutoEvaluation.selectNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public Stagiaire selectStagiaire(Stagiaire stagiaire) {
		return facadeServiceAutoEvaluation.selectStagiaire(stagiaire);
		
	} 
    
}
