package autoEvaluation.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import autoEvaluation.dao.FacadeDaoAutoEvaluation;
import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.entity.Competence;
import autoEvaluation.entity.Module;
import autoEvaluation.entity.NiveauAcquisition;
import autoEvaluation.entity.Sequence;
import autoEvaluation.technique.AutoEvaluations;
import compteUtilisateur.entity.Stagiaire;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import exception.UpdateException;

/**
 * Session Bean implementation class FacadeServiceAutoEvaluation
 */
@Stateless
@LocalBean
public class FacadeServiceAutoEvaluation implements FacadeServiceAutoEvaluationLocal {

	@EJB
	FacadeDaoAutoEvaluation facadeDaoAutoEvaluation;
	
    /**
     * Default constructor. 
     */
    public FacadeServiceAutoEvaluation() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws DoublonException, NullException {

		facadeDaoAutoEvaluation.insertAutoEvaluation(autoEvaluation);
		
	}

	@Override
	public void insertModule(Module module) throws DoublonException, NullException {
		facadeDaoAutoEvaluation.insertModule(module);
	}

	@Override
	public void insertSequence(Sequence sequence) throws DoublonException, NullException {
		facadeDaoAutoEvaluation.insertSequence(sequence);
	}

	@Override
	public void insertCompetence(Competence competence) throws DoublonException, NullException {
		facadeDaoAutoEvaluation.insertCompetence(competence);
		
	}

	@Override
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException {
		facadeDaoAutoEvaluation.insertNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException {
		facadeDaoAutoEvaluation.insertStagiaire(stagiaire);
		
	}

	@Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation) throws UpdateException {
		facadeDaoAutoEvaluation.updateAutoEvaluation(autoEvaluation);
		
	}

	@Override
	public void updateModule(Module module) {
		facadeDaoAutoEvaluation.updateModule(module);
		
	}

	@Override
	public void updateSequence(Sequence sequence) {
		facadeDaoAutoEvaluation.updateSequence(sequence);
		
	}

	@Override
	public void updateCompetence(Competence competence) {
		facadeDaoAutoEvaluation.updateCompetence(competence);
		
	}

	@Override
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		facadeDaoAutoEvaluation.updateNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public void updateStagiaire(Stagiaire stagiaire) {
		facadeDaoAutoEvaluation.updateStagiaire(stagiaire);
		
	}
	
	@Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		facadeDaoAutoEvaluation.deleteAutoEvaluation(autoEvaluation);
		
	}

	@Override
	public void deleteModule(Module module) {
		facadeDaoAutoEvaluation.deleteModule(module);
	}

	@Override
	public void deleteSequence(Sequence sequence) {
		facadeDaoAutoEvaluation.deleteSequence(sequence);
		
	}

	@Override
	public void deleteCompetence(Competence competence) {
		facadeDaoAutoEvaluation.deleteCompetence(competence);
		
	}

	@Override
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		facadeDaoAutoEvaluation.deleteNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public void deleteStagiaire(Stagiaire stagiaire) {
		facadeDaoAutoEvaluation.deleteStagiaire(stagiaire);
		
	}

	@Override
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation) throws UnfoundException {
		return facadeDaoAutoEvaluation.selectAutoEvaluation(autoEvaluation);
		
	}
	
	@Override
	public AutoEvaluation selectAutoEvaluationByDateRessentiCompetenceModuleNiveauAcquisitionSequenceStagiaire(
			AutoEvaluation autoEvaluation) {

		return facadeDaoAutoEvaluation.selectAutoEvaluationByDateRessentiCompetenceModuleNiveauAcquisitionSequenceStagiaire(autoEvaluation);
	}

	@Override
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException {
		return facadeDaoAutoEvaluation.selectAutoEvaluationByStagCompDate(autoEvaluation);
		
	}

	@Override
	public AutoEvaluations selectAutoEvaluationByStagComp(AutoEvaluation autoEvaluation) {
		return facadeDaoAutoEvaluation.selectAutoEvaluationByStagComp(autoEvaluation);
	}

	@Override
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation) {
		return facadeDaoAutoEvaluation.selectAutoEvaluationByStag(autoEvaluation);
	}

	@Override
	public Module selectModule(Module module) throws UnfoundException {
		return facadeDaoAutoEvaluation.selectModule(module);
		
	}

	@Override
	public Sequence selectSequence(Sequence sequence) throws UnfoundException {
		return facadeDaoAutoEvaluation.selectSequence(sequence);
		
	}

	@Override
	public Competence selectCompetence(Competence competence) throws UnfoundException {
		return facadeDaoAutoEvaluation.selectCompetence(competence);
		
	}

	@Override
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException {
		return facadeDaoAutoEvaluation.selectNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException {
		return facadeDaoAutoEvaluation.selectStagiaire(stagiaire);
		
	} 

}
