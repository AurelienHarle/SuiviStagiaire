package autoEvaluation.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import autoEvaluation.dao.facade.FacadeDaoAutoEvaluation;
import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import exception.DateNullException;
import exception.NullException;
import exception.UnfoundException;

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
        
    }

	@Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException {

		facadeDaoAutoEvaluation.insertAutoEvaluation(autoEvaluation);
		
	}

	

	@Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation)  {
		facadeDaoAutoEvaluation.updateAutoEvaluation(autoEvaluation);
		
	}

	
	
	@Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		facadeDaoAutoEvaluation.deleteAutoEvaluation(autoEvaluation);
		
	}

	

	@Override
	public AutoEvaluation selectAutoEvaluationByDateRessentiCompetenceModuleNiveauAcquisitionSequenceStagiaire(
			AutoEvaluation autoEvaluation) {

		return facadeDaoAutoEvaluation.selectAutoEvaluationByDateRessentiCompetenceModuleNiveauAcquisitionSequenceStagiaire(autoEvaluation);
	}

	@Override
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException {
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

	

}
