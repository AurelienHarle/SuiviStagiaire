package autoEvaluation.dao;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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
 * Session Bean implementation class FacadeDaoAutoEvaluation
 */
@Stateless
@LocalBean
public class FacadeDaoAutoEvaluation implements FacadeDaoAutoEvaluationLocal {
	
	@EJB
	Dao dao;
	
    /**
     * Default constructor. 
     */
    public FacadeDaoAutoEvaluation() {
    }

	@Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws DoublonException, NullException {

		dao.insertAutoEvaluation(autoEvaluation);
		
	}

	@Override
	public void insertModule(Module module) throws DoublonException, NullException {
		dao.insertModule(module);
		
	}

	@Override
	public void insertSequence(Sequence sequence) throws DoublonException, NullException {
		dao.insertSequence(sequence);
	}

	@Override
	public void insertCompetence(Competence competence) throws DoublonException, NullException {
		dao.insertCompetence(competence);
	}

	@Override
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException {
		dao.insertNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException {
		dao.insertStagiaire(stagiaire);
		
	}

	@Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation) throws UpdateException {
		dao.updateAutoEvaluation(autoEvaluation);
		
	}

	@Override
	public void updateModule(Module module) {
		dao.updateModule(module);
		
	}

	@Override
	public void updateSequence(Sequence sequence) {
		dao.updateSequence(sequence);
		
	}

	@Override
	public void updateCompetence(Competence competence) {
		dao.updateCompetence(competence);
		
	}

	@Override
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		dao.updateNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public void updateStagiaire(Stagiaire stagiaire) {
		dao.updateStagiaire(stagiaire);
		
	}

	@Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		dao.deleteAutoEvaluation(autoEvaluation);
		
	}

	@Override
	public void deleteModule(Module module) {
		
		dao.deleteModule(module);
	}

	@Override
	public void deleteSequence(Sequence sequence) {
		dao.deleteSequence(sequence);
		
	}

	@Override
	public void deleteCompetence(Competence competence) {
		dao.deleteCompetence(competence);
		
	}

	@Override
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		dao.deleteNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public void deleteStagiaire(Stagiaire stagiaire) {
		dao.deleteStagiaire(stagiaire);
		
	}

	@Override
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation) throws UnfoundException {
		return dao.selectAutoEvaluation(autoEvaluation);
		
	}
	
	@Override
	public AutoEvaluation selectAutoEvaluationByDateRessentiCompetenceModuleNiveauAcquisitionSequenceStagiaire(
			AutoEvaluation autoEvaluation) {
		return dao.selectAutoEvaluationByDateRessentiCompetenceModuleNiveauAcquisitionSequenceStagiaire(autoEvaluation);
	}

	@Override
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException {
		return dao.selectAutoEvaluationByStagCompDate(autoEvaluation);
		
	}

	@Override
	public AutoEvaluations selectAutoEvaluationByStagComp(AutoEvaluation autoEvaluation) {
		return dao.selectAutoEvaluationByStagComp(autoEvaluation);
	}

	@Override
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation) {
		return dao.selectAutoEvaluationByStag(autoEvaluation);
	}

	@Override
	public Module selectModule(Module module) throws UnfoundException {
		return dao.selectModule(module);
		
	}

	@Override
	public Sequence selectSequence(Sequence sequence) throws UnfoundException {
		return dao.selectSequence(sequence);
		
	}

	@Override
	public Competence selectCompetence(Competence competence) throws UnfoundException {
		return dao.selectCompetence(competence);
		
	}

	@Override
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException {
		return dao.selectNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException {
		return dao.selectStagiaire(stagiaire);
		
	} 
    
}
