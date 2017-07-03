package facade;

import javax.ejb.Remote;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.technique.AutoEvaluations;
import competence.entity.Competence;
import competence.technique.Competences;
import exception.DateNullException;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import module.entity.Module;
import niveauAcquisition.entity.NiveauAcquisition;
import niveauAcquisition.technique.NiveauAcquisitions;
import sequence.entity.Sequence;
import stagiaire.entity.Stagiaire;

@Remote
public interface FacadeSuiviStagiaireRemote {

	/**
	 * TODO 
	 * 
	 * @param module
	 * @throws DoublonException
	 * @throws NullException
	 */
	public void insertModule(Module module) throws DoublonException, NullException;

	/**
	 * TODO
	 */
	public void updateModule(Module module);

	/**
	 * Delete d'un Module
	 */
	public void deleteModule(Module module);

	/**
	 * Select d'un Module
	 * @return 
	 * @throws UnfoundException 
	 */
	public Module selectModule(Module module) throws UnfoundException;

	/**
	 * TODO 
	 * 
	 * @param sequence
	 * @throws DoublonException
	 * @throws NullException
	 */
	public void insertSequence(Sequence sequence) throws DoublonException, NullException;

	/**
	 * TODO
	 */
	public void updateSequence(Sequence sequence);

	/**
	 * Delete d'une Sequence
	 */
	public void deleteSequence(Sequence sequence);

	/**
	 * Select d'une Sequence
	 * @throws UnfoundException 
	 */
	public Sequence selectSequence(Sequence sequence) throws UnfoundException;

	/**
	 * TODO 
	 * 
	 * @param competence
	 * @throws DoublonException
	 * @throws NullException
	 */
	public void insertCompetence(Competence competence) throws DoublonException, NullException;

	/**
	 * TODO
	 */
	public void updateCompetence(Competence competence);

	/**
	 * Delete d'une Competences
	 */
	public void deleteCompetence(Competence competence);

	/**
	 * Select d'une Competences
	 * @throws UnfoundException 
	 */
	public Competence selectCompetence(Competence competence) throws UnfoundException;

	/**
	 * Retourne toute les competences de la table comp
	 * @return competences {@link Competences}
	 */
	public Competences selectCompetences();

	/**
	 * TODO 
	 * 
	 * @param niveauAcquisition
	 * @throws DoublonException
	 * @throws NullException
	 */
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException;

	/**
	 * TODO
	 */
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition);

	/**
	 * Delete NiveauAcquisition
	 */
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition);

	/**
	 * Select NiveauAcquisition
	 * @throws UnfoundException 
	 */
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException;

	/**
	 * Select NiveauAcquisitions
	 * @throws UnfoundException 
	 */
	public NiveauAcquisitions selectNiveauAcquisitions();
	
	/**
	 * TODO 
	 * 
	 * @param stagiaire
	 * @throws DoublonException
	 * @throws NullException
	 */
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException;

	/**
	 * TODO
	 */
	public void updateStagiaire(Stagiaire stagiaire);

	/**
	 * Delete Stagiaire
	 */
	public void deleteStagiaire(Stagiaire stagiaire);

	/**
	 * Select Stagiaire
	 * @throws UnfoundException 
	 */
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException;

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
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation);
	
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
}
