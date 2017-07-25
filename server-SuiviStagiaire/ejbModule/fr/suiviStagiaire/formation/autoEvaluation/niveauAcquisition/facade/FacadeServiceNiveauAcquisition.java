package fr.suiviStagiaire.formation.autoEvaluation.niveauAcquisition.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.suiviStagiaire.exception.DoublonException;
import fr.suiviStagiaire.exception.NullException;
import fr.suiviStagiaire.exception.UnfoundException;
import fr.suiviStagiaire.formation.autoEvaluation.niveauAcquisition.dao.facade.FacadeDaoNiveauAcquisition;
import fr.suiviStagiaire.formation.autoEvaluation.niveauAcquisition.entity.NiveauAcquisition;
import fr.suiviStagiaire.formation.autoEvaluation.niveauAcquisition.technique.NiveauAcquisitions;

/**
 * Session Bean implementation class FacadeServiceCompetence
 */
@Stateless
@LocalBean
public class FacadeServiceNiveauAcquisition implements FacadeServiceNiveauAcquisitionLocal {

	@EJB
	FacadeDaoNiveauAcquisition facadeDaoNiveauAcquisition;
	
    /**
     * Default constructor. 
     */
    public FacadeServiceNiveauAcquisition() {
    }
    
    @Override
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException {
		facadeDaoNiveauAcquisition.insertNiveauAcquisition(niveauAcquisition);
	}

	@Override
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		facadeDaoNiveauAcquisition.updateNiveauAcquisition(niveauAcquisition);
	}

	@Override
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		facadeDaoNiveauAcquisition.deleteNiveauAcquisition(niveauAcquisition);
	}

	@Override
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException {
		return facadeDaoNiveauAcquisition.selectNiveauAcquisition(niveauAcquisition);
	}

	@Override
	public NiveauAcquisitions selectNiveauAcquisitions() {
		return facadeDaoNiveauAcquisition.selectNiveauAcquisitions();
	} 

}
