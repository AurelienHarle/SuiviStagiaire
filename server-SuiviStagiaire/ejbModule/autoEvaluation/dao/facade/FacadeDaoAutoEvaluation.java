package autoEvaluation.dao.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import autoEvaluation.dao.AutoEvaluationDao;
import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.entity.Competence;
import autoEvaluation.technique.AutoEvaluations;
import compteUtilisateur.entity.Stagiaire;
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

    /**
	 * Contr�le et insert une {@link AutoEvaluation} si elle correspond au r�gle m�tier
	 * 
	 * @Param {@link AutoEvaluation}
	 * @throws NullException
	 * @throws DateNullException
	 */
    @Override
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException {

		autoEvaluationDao.insertAutoEvaluation(autoEvaluation);
		
	}
    
    /**
	 * Contr�le et update une {@link AutoEvaluation} si elle correspond au r�gle m�tier
	 */
    @Override
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation)  {
		autoEvaluationDao.updateAutoEvaluation(autoEvaluation);
		
	}
    
    /**
	 * Supprime une {@link AutoEvaluation}
	 */
    @Override
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation) {
		autoEvaluationDao.deleteAutoEvaluation(autoEvaluation);
		
	}
    
    /**
	 * Select une {@link AutoEvaluation} par son {@link Stagiaire}, {@link Competence}, Date permet aussi certaine contr�le
	 * 
	 * @Param {@link AutoEvaluation}
	 * @throws NullException
	 * @throws DateNullException
	 */
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
