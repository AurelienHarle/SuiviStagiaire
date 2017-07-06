package facade;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.facade.FacadeServiceAutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import competence.entity.Competence;
import competence.facade.FacadeServiceCompetence;
import competence.technique.Competences;
import exception.DateNullException;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import logger.JournaliseurNiveauConfig;
import module.entity.Module;
import module.facade.FacadeServiceModule;
import module.technique.Modules;
import niveauAcquisition.entity.NiveauAcquisition;
import niveauAcquisition.facade.FacadeServiceNiveauAcquisition;
import niveauAcquisition.technique.NiveauAcquisitions;
import sequence.entity.Sequence;
import sequence.facade.FacadeServiceSequence;
import sequence.technique.Sequences;
import stagiaire.entity.Stagiaire;
import stagiaire.facade.FacadeServiceStagiaire;

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
    FacadeServiceCompetence facadeServiceCompetence;
    @EJB
    FacadeServiceSequence facadeServiceSequence;
    @EJB
    FacadeServiceModule facadeServiceModule;
    @EJB
    FacadeServiceStagiaire facadeServiceStagiaire;
    @EJB
    FacadeServiceNiveauAcquisition facadeServiceNiveauAcquisition;
    
    JournaliseurNiveauConfig journaliseurNiveauConfig = JournaliseurNiveauConfig.getINSTANCE();

	@Override
	public void insertModule(Module module) throws DoublonException, NullException {
		facadeServiceModule.insertModule(module);
	}

	@Override
	public void updateModule(Module module) {
		facadeServiceModule.updateModule(module);
	}

	@Override
	public void deleteModule(Module module) {
		facadeServiceModule.deleteModule(module);
	}

	@Override
	public Module selectModule(Module module) throws UnfoundException {
		return facadeServiceModule.selectModule(module);
	}

	@Override
	public Modules selectModules() {
		return facadeServiceModule.selectModules();
	}

	@Override
	public void insertSequence(Sequence sequence) throws DoublonException, NullException {
		facadeServiceSequence.insertSequence(sequence);
	}

	@Override
	public void updateSequence(Sequence sequence) {
		facadeServiceSequence.updateSequence(sequence);
	}

	@Override
	public void deleteSequence(Sequence sequence) {
		facadeServiceSequence.deleteSequence(sequence);
	}

	@Override
	public Sequence selectSequence(Sequence sequence) throws UnfoundException {
		return facadeServiceSequence.selectSequence(sequence);
	}

	@Override
	public Sequences selectSequenceByModule(Module module) {
		return facadeServiceSequence.selectSequenceByModule(module);
	}

	@Override
	public Sequences selectSequences() {
		return facadeServiceSequence.selectSequences();
	}

	@Override
	public void insertCompetence(Competence competence) throws DoublonException, NullException {
		facadeServiceCompetence.insertCompetence(competence);
	}

	@Override
	public void updateCompetence(Competence competence) {
		facadeServiceCompetence.updateCompetence(competence);
	}

	@Override
	public void deleteCompetence(Competence competence) {
		facadeServiceCompetence.deleteCompetence(competence);
	}

	@Override
	public Competence selectCompetence(Competence competence) throws UnfoundException {
		return facadeServiceCompetence.selectCompetence(competence);
	}

	@Override
	public Competences selectCompetenceByModule(Module module) {
		return facadeServiceCompetence.selectCompetenceByModule(module);
	}

	@Override
	public Competences selectCompetences() {
		return facadeServiceCompetence.selectCompetences();
	}

	@Override
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException {
		facadeServiceNiveauAcquisition.insertNiveauAcquisition(niveauAcquisition);
	}

	@Override
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		facadeServiceNiveauAcquisition.updateNiveauAcquisition(niveauAcquisition);
	}

	@Override
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		facadeServiceNiveauAcquisition.deleteNiveauAcquisition(niveauAcquisition);
	}

	@Override
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException {
		return facadeServiceNiveauAcquisition.selectNiveauAcquisition(niveauAcquisition);
	}

	@Override
	public NiveauAcquisitions selectNiveauAcquisitions() {
		return facadeServiceNiveauAcquisition.selectNiveauAcquisitions();
	}

	@Override
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException {
		facadeServiceStagiaire.insertStagiaire(stagiaire);
	}

	@Override
	public void updateStagiaire(Stagiaire stagiaire) {
		facadeServiceStagiaire.updateStagiaire(stagiaire);
	}

	@Override
	public void deleteStagiaire(Stagiaire stagiaire) {
		facadeServiceStagiaire.deleteStagiaire(stagiaire);
	}

	@Override
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException {
		return facadeServiceStagiaire.selectStagiaire(stagiaire);
	}

	@Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException {
		facadeServiceAutoEvaluation.insertAutoEvaluation(autoEvaluation);
	}

	@Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation) {
		facadeServiceAutoEvaluation.updateAutoEvaluation(autoEvaluation);
	}

	@Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		facadeServiceAutoEvaluation.deleteAutoEvaluation(autoEvaluation);
	}

	@Override
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation) {
		return facadeServiceAutoEvaluation.selectAutoEvaluation(autoEvaluation);
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
    
}
