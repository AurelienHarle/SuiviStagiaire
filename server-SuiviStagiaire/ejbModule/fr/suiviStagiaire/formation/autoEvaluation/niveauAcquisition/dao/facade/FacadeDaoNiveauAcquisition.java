package fr.suiviStagiaire.formation.autoEvaluation.niveauAcquisition.dao.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.suiviStagiaire.exception.DoublonException;
import fr.suiviStagiaire.exception.NullException;
import fr.suiviStagiaire.exception.UnfoundException;
import fr.suiviStagiaire.formation.autoEvaluation.niveauAcquisition.dao.NiveauAcquisitionDao;
import fr.suiviStagiaire.formation.autoEvaluation.niveauAcquisition.entity.NiveauAcquisition;
import fr.suiviStagiaire.formation.autoEvaluation.niveauAcquisition.technique.NiveauAcquisitions;

/**
 * Session Bean implementation class FacadeDaoCompetence
 */
@Stateless
@LocalBean
public class FacadeDaoNiveauAcquisition implements FacadeDaoNiveauAcquisitionLocal {

	@EJB
	NiveauAcquisitionDao niveauAcquisitionDao;
	
    /**
     * Default constructor. 
     */
    public FacadeDaoNiveauAcquisition() {
    }
	
	@Override
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException {
		niveauAcquisitionDao.insertNiveauAcquisition(niveauAcquisition);	
	}

	@Override
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		niveauAcquisitionDao.updateNiveauAcquisition(niveauAcquisition);
	}

	@Override
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition) {
		niveauAcquisitionDao.deleteNiveauAcquisition(niveauAcquisition);
	}

	@Override
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException {
		return niveauAcquisitionDao.selectNiveauAcquisition(niveauAcquisition);
	}

	@Override
	public NiveauAcquisitions selectNiveauAcquisitions() {
		return niveauAcquisitionDao.selectNiveauAcquisitions();
	} 
    
}
