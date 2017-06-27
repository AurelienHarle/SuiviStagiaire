package autoEvaluation.dao.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import autoEvaluation.dao.AutoEvaluationDao;
import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import exception.DateNullException;
import exception.NullException;
import exception.UnfoundException;

/**
 * Session Bean implementation class FacadeDaoAutoEvaluation
 */
@Stateless
@LocalBean
public class FacadeDaoAutoEvaluation implements FacadeDaoAutoEvaluationLocal {

	@EJB
	AutoEvaluationDao autoEvaluationDao;
	
    /**
     * Default constructor. 
     */
    public FacadeDaoAutoEvaluation() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException {

		autoEvaluationDao.insertAutoEvaluation(autoEvaluation);
		
	}
    
    @Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation)  {
		autoEvaluationDao.updateAutoEvaluation(autoEvaluation);
		
	}
    
    @Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		autoEvaluationDao.deleteAutoEvaluation(autoEvaluation);
		
	}
    
    @Override
	public AutoEvaluation selectAutoEvaluationByDateRessentiCompetenceModuleNiveauAcquisitionSequenceStagiaire(
			AutoEvaluation autoEvaluation) {
		return autoEvaluationDao.selectAutoEvaluationByDateRessentiCompetenceModuleNiveauAcquisitionSequenceStagiaire(autoEvaluation);
	}

	@Override
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException {
		return autoEvaluationDao.selectAutoEvaluationByStagCompDate(autoEvaluation);
		
	}

	@Override
	public AutoEvaluations selectAutoEvaluationByStagComp(AutoEvaluation autoEvaluation) {
		return autoEvaluationDao.selectAutoEvaluationByStagComp(autoEvaluation);
	}

	@Override
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation) {
		return autoEvaluationDao.selectAutoEvaluationByStag(autoEvaluation);
	}

    
}
