package niveauAcquisition.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import niveauAcquisition.dao.facade.FacadeDaoNiveauAcquisition;
import niveauAcquisition.entity.NiveauAcquisition;

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
        // TODO Auto-generated constructor stub
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

}
