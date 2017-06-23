package autoEvaluation.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import autoEvaluation.dao.FacadeDaoOther;
import autoEvaluation.entity.Competence;
import autoEvaluation.entity.Module;
import autoEvaluation.entity.NiveauAcquisition;
import autoEvaluation.entity.Sequence;
import compteUtilisateur.entity.Stagiaire;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;

/**
 * Session Bean implementation class FacadeServiceOther
 */
@Stateless
@LocalBean
public class FacadeServiceOther implements FacadeServiceOtherLocal {

	@EJB
	FacadeDaoOther facadeDaoOther;
	
    /**
     * Default constructor. 
     */
    public FacadeServiceOther() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void insertModule(Module module) throws DoublonException, NullException {
		facadeDaoOther.insertModule(module);
	}

	@Override
	public void insertSequence(Sequence sequence) throws DoublonException, NullException {
		facadeDaoOther.insertSequence(sequence);
	}

	@Override
	public void insertCompetence(Competence competence) throws DoublonException, NullException {
		facadeDaoOther.insertCompetence(competence);
		
	}

	@Override
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException {
		facadeDaoOther.insertNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException {
		facadeDaoOther.insertStagiaire(stagiaire);
		
	}
	
	@Override
	public void updateModule(Module module) {
		facadeDaoOther.updateModule(module);
		
	}

	@Override
	public void updateSequence(Sequence sequence) {
		facadeDaoOther.updateSequence(sequence);
		
	}

	@Override
	public void updateCompetence(Competence competence) {
		facadeDaoOther.updateCompetence(competence);
		
	}

	@Override
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		facadeDaoOther.updateNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public void updateStagiaire(Stagiaire stagiaire) {
		facadeDaoOther.updateStagiaire(stagiaire);
		
	}
	
	@Override
	public void deleteModule(Module module) {
		facadeDaoOther.deleteModule(module);
	}

	@Override
	public void deleteSequence(Sequence sequence) {
		facadeDaoOther.deleteSequence(sequence);
		
	}

	@Override
	public void deleteCompetence(Competence competence) {
		facadeDaoOther.deleteCompetence(competence);
		
	}

	@Override
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		facadeDaoOther.deleteNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public void deleteStagiaire(Stagiaire stagiaire) {
		facadeDaoOther.deleteStagiaire(stagiaire);
		
	}
	
	@Override
	public Module selectModule(Module module) throws UnfoundException {
		return facadeDaoOther.selectModule(module);
		
	}

	@Override
	public Sequence selectSequence(Sequence sequence) throws UnfoundException {
		return facadeDaoOther.selectSequence(sequence);
		
	}

	@Override
	public Competence selectCompetence(Competence competence) throws UnfoundException {
		return facadeDaoOther.selectCompetence(competence);
		
	}

	@Override
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException {
		return facadeDaoOther.selectNiveauAcquisition(niveauAcquisition);
		
	}

	@Override
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException {
		return facadeDaoOther.selectStagiaire(stagiaire);
		
	} 

}
