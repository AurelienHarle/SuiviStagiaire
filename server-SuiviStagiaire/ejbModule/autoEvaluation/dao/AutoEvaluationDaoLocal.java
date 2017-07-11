package autoEvaluation.dao;

import javax.ejb.Local;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import competence.entity.Competence;
import exception.DateNullException;
import exception.NullException;
import exception.UnfoundException;
import module.entity.Module;
import sequence.entity.Sequence;
import stagiaire.entity.Stagiaire;

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
	 * Supprime une {@link AutoEvaluation}
	 */
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation);
	
	/**
	 * Select une {@link AutoEvaluation} par son {@link Stagiaire}, {@link Competence}, Date permet aussi certaine contr�le
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
	 * Select une {@link AutoEvaluation} par son {@link identifiant}.
	 * 
	 * @param autoEvaluation {@link AutoEvaluation}
	 * @return autoEvaluation {@link AutoEvaluation}
	 */
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation);

	/**
	 * S�lectionne une autoEvaluation celons les crit�res envoy�
	 * @param autoEvaluationDater {@link AutoEvaluation}
	 * @param moduleRechercher {@link Module}
	 * @param sequenceRechercher {@link Sequence}
	 * @param competenceRechercher {@link Competence}
	 * @param autoEvaluationNoter {@link AutoEvaluation}
	 * @return {@link AutoEvaluations}
	 */
	public AutoEvaluations selectAutoEvaluationsByMultipleCritere(AutoEvaluation autoEvaluationDater, Module moduleRechercher,
			Sequence sequenceRechercher, Competence competenceRechercher,AutoEvaluation autoEvaluationNoter);

}
