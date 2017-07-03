package autoEvaluation.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import autoEvaluation.dao.facade.FacadeDaoAutoEvaluation;
import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import competence.entity.Competence;
import exception.DateNullException;
import exception.NullException;
import exception.UnfoundException;
import stagiaire.entity.Stagiaire;

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

    /**
	 * Contrôle et insert une {@link AutoEvaluation} si elle correspond au règle métier
	 * 
	 * @Param {@link AutoEvaluation}
	 * @throws NullException
	 * @throws DateNullException
	 */
	@Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException {

		facadeDaoAutoEvaluation.insertAutoEvaluation(autoEvaluation);
		
	}

	/**
	 * Contrôle et update une {@link AutoEvaluation} si elle correspond au règle métier
	 */
	@Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation)  {
		facadeDaoAutoEvaluation.updateAutoEvaluation(autoEvaluation);
		
	}

	/**
	 * Supprime une {@link AutoEvaluation}
	 */
	@Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		facadeDaoAutoEvaluation.deleteAutoEvaluation(autoEvaluation);
		
	}

	/**
	 * Select une {@link AutoEvaluation} par son {@link Stagiaire}, {@link Competence}, Date permet aussi certaine contrôle
	 * 
	 * @Param {@link AutoEvaluation}
	 * @throws NullException
	 * @throws DateNullException
	 */
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
