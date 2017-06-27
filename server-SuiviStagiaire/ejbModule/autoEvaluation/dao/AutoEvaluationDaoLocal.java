package autoEvaluation.dao;

import javax.ejb.Local;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import exception.DateNullException;
import exception.NullException;
import exception.UnfoundException;

@Local
public interface AutoEvaluationDaoLocal {

	
	/**
	 * Contr�le et insert une {@link AutoEvaluation} si elle correspond au r�gle m�tier
	 * 
	 * @Param {@link AutoEvaluation}
	 * @throws NullException
	 * @throws DateNullException
	 */
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException;
	
	/**
	 * Contr�le et update une {@link AutoEvaluation} si elle correspond au r�gle m�tier
	 */
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation) throws UnfoundException;
	
	/**
	 * Supprime une {@link AutoEvaluation} si elle correspond au r�gle m�tier
	 */
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation);
	
	/**
	 * Select d'une auto evaluation par son Stagiaire / Comp / Date
	 * @throws UnfoundException 
	 * @throws NullException 
	 * @throws SelectAutoEvaluationNoResultException 
	 */
	public AutoEvaluation selectAutoEvaluationByStagCompDate(AutoEvaluation autoEvaluation) throws UnfoundException, NullException;
	
	/**
	 * Select d'une auto evaluation par son Stagiaire / Comp
	 */
	public AutoEvaluations selectAutoEvaluationByStagComp(AutoEvaluation autoEvaluation);
	
	/**
	 * Select d'une auto evaluation par son Stagiaire
	 */
	public AutoEvaluations selectAutoEvaluationByStag(AutoEvaluation autoEvaluation);
	
	/**
	 * Select d'une auto evaluation par sa Competences
	 */
	public AutoEvaluations selectAutoEvaluationByComp(AutoEvaluation autoEvaluation);
	
}
