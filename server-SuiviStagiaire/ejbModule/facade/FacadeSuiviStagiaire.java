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
import autoEvaluation.facade.FacadeServiceOther;
import autoEvaluation.technique.AutoEvaluations;
import compteUtilisateur.entity.Stagiaire;
import exception.DateNullException;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import logger.JournaliseurNiveauConfig;

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
    @EJB
    FacadeServiceOther facadeServiceOther;
    
    JournaliseurNiveauConfig journaliseurNiveauConfig = JournaliseurNiveauConfig.getINSTANCE();

	@Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException {
		facadeServiceAutoEvaluation.insertAutoEvaluation(autoEvaluation);
		
	}

	@Override
	public void insertModule(Module module) throws DoublonException, NullException {
		facadeServiceOther.insertModule(module);

	}

	@Override
	public void insertSequence(Sequence sequence) throws DoublonException, NullException {
		facadeServiceOther.insertSequence(sequence);
		
	}

	@Override
	public void insertCompetence(Competence competence) throws DoublonException, NullException {
		facadeServiceOther.insertCompetence(competence);
		
	}

	@Override
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException {
		facadeServiceOther.insertNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException {
		facadeServiceOther.insertStagiaire(stagiaire);
		
	}

	@Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation) {
		facadeServiceAutoEvaluation.updateAutoEvaluation(autoEvaluation);
		
	}

	@Override
	public void updateModule(Module module) {
		
		facadeServiceOther.updateModule(module);
	}

	@Override
	public void updateSequence(Sequence sequence) {
		
		facadeServiceOther.updateSequence(sequence);
	}

	@Override
	public void updateCompetence(Competence competence) {
		facadeServiceOther.updateCompetence(competence);
		
	}

	@Override
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		facadeServiceOther.updateNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public void updateStagiaire(Stagiaire stagiaire) {
		facadeServiceOther.updateStagiaire(stagiaire);
		
	}

	@Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		facadeServiceAutoEvaluation.deleteAutoEvaluation(autoEvaluation);
		
	}

	@Override
	public void deleteModule(Module module) {
		facadeServiceOther.deleteModule(module);
	}

	@Override
	public void deleteSequence(Sequence sequence) {
		facadeServiceOther.deleteSequence(sequence);
		
	}

	@Override
	public void deleteCompetence(Competence competence) {
		facadeServiceOther.deleteCompetence(competence);
		
	}

	@Override
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		facadeServiceOther.deleteNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public void deleteStagiaire(Stagiaire stagiaire) {
		facadeServiceOther.deleteStagiaire(stagiaire);
		
	}

	@Override
	public AutoEvaluation selectAutoEvaluationByDateRessentiCompetenceModuleNiveauAcquisitionSequenceStagiaire(
			AutoEvaluation autoEvaluation) {
		return facadeServiceAutoEvaluation.selectAutoEvaluationByDateRessentiCompetenceModuleNiveauAcquisitionSequenceStagiaire(autoEvaluation);
	}

	@Override
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException {
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
	public Module selectModule(Module module) throws UnfoundException {
		return facadeServiceOther.selectModule(module);
		
	}

	@Override
	public Sequence selectSequence(Sequence sequence) throws UnfoundException {
		return facadeServiceOther.selectSequence(sequence);
		
	}

	@Override
	public Competence selectCompetence(Competence competence) throws UnfoundException {
		return facadeServiceOther.selectCompetence(competence);
		
	}

	@Override
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException {
		return facadeServiceOther.selectNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException {
		return facadeServiceOther.selectStagiaire(stagiaire);
		
	} 
    
}
