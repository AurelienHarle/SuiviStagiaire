package autoEvaluation.dao;

import javax.ejb.Local;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.entity.Competence;
import autoEvaluation.technique.AutoEvaluations;
import compteUtilisateur.entity.Stagiaire;
import exception.DateNullException;
import exception.NullException;
import exception.UnfoundException;

@Local
public interface AutoEvaluationDaoLocal {

	
	/**
	 * Contrôle et insert une {@link AutoEvaluation} si elle correspond au règle métier
	 * 
	 * @Param {@link AutoEvaluation}
	 * @throws NullException
	 * @throws DateNullException
	 */
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException;
	
	/**
	 * Contrôle et update une {@link AutoEvaluation} si elle correspond au règle métier
	 */
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation) throws UnfoundException;
	
	/**
	 * Supprime une {@link AutoEvaluation}
	 */
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation);
	
	/**
	 * Select une {@link AutoEvaluation} par son {@link Stagiaire}, {@link Competence}, Date permet aussi certaine contrôle
	 * 
	 * @Param {@link AutoEvaluation}
	 * @throws NullException
	 * @throws DateNullException
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
