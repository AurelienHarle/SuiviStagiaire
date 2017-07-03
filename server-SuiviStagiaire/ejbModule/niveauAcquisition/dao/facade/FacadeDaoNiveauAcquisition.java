package niveauAcquisition.dao.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import niveauAcquisition.dao.NiveauAcquisitionDao;
import niveauAcquisition.entity.NiveauAcquisition;
import niveauAcquisition.technique.NiveauAcquisitions;

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
