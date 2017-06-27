package autoEvaluation.facade;

import javax.ejb.Local;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import exception.DateNullException;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;

@Local
public interface FacadeServiceAutoEvaluationLocal {
	
	/**
	 * Insertion d'une auto evaluation dans la base
	 * @throws DateNullException 
	 * 
	 * @throws {@link DoublonException}
	 * @throws {@link NullException}
	 */
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException;
	
		
	/**
	 * Update d'une auto evaluation dans la base
	 * @throws UpdateNotInsertException 
	 */
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation);
	
	
	
	/**
	 * Delete d'une auto evaluation dans la base
	 */
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation);

	
	
	/**
	 * Select d'une auto evaluation par tout ses attribue
	 */
	public AutoEvaluation selectAutoEvaluationByDateRessentiCompetenceModuleNiveauAcquisitionSequenceStagiaire(AutoEvaluation autoEvaluation);
	
	/**
	 * Select d'une auto evaluation par son Stagiaire / Comp / Date
	 * @throws UnfoundException 
	 * @throws NullException 
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
	
}
