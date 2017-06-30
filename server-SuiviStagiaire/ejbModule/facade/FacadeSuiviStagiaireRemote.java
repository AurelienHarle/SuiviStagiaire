package facade;

import javax.ejb.Remote;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.entity.Competence;
import autoEvaluation.entity.Module;
import autoEvaluation.entity.NiveauAcquisition;
import autoEvaluation.entity.Sequence;
import autoEvaluation.technique.AutoEvaluations;
import autoEvaluation.technique.Competences;
import compteUtilisateur.entity.Stagiaire;
import exception.DateNullException;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;

@Remote
public interface FacadeSuiviStagiaireRemote {

	/**
	 * Contrôle et insert une {@link AutoEvaluation} si elle correspond au règle métier
	 * 
	 * @Param {@link AutoEvaluation}
	 * @throws NullException
	 * @throws DateNullException
	 */
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws NullException, DateNullException;
	
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
	 * 
	 * @param sequence
	 * @throws DoublonException
	 * @throws NullException
	 */
	public void insertSequence(Sequence sequence) throws DoublonException, NullException;
	
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
	 * 
	 * @param niveauAcquisition
	 * @throws DoublonException
	 * @throws NullException
	 */
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException;
	
	/**
	 * TODO 
	 * 
	 * @param stagiaire
	 * @throws DoublonException
	 * @throws NullException
	 */
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException;
	
	/**
	 * Contrôle et update une {@link AutoEvaluation} si elle correspond au règle métier
	 */
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation);
	
	/**
	 * TODO
	 */
	public void updateModule(Module module);
	
	/**
	 * TODO
	 */
	public void updateSequence(Sequence sequence);
	
	/**
	 * TODO
	 */
	public void updateCompetence(Competence competence);
	
	/**
	 * TODO
	 */
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition);
	
	/**
	 * TODO
	 */
	public void updateStagiaire(Stagiaire stagiaire);
	
	/**
	 * Supprime une {@link AutoEvaluation}
	 */
	public void deleteAutoEvaluation(AutoEvaluation autoEvaluation);

	/**
	 * Delete d'un Module
	 */
	public void deleteModule(Module module);
	
	/**
	 * Delete d'une Sequence
	 */
	public void deleteSequence(Sequence sequence);
	
	/**
	 * Delete d'une Competences
	 */
	public void deleteCompetence(Competence competence);
	
	/**
	 * Delete NiveauAcquisition
	 */
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition);
	
	/**
	 * Delete Stagiaire
	 */
	public void deleteStagiaire(Stagiaire stagiaire);
	
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
	 * Select d'un Module
	 * @return 
	 * @throws UnfoundException 
	 */
	public Module selectModule(Module module) throws UnfoundException;
	
	/**
	 * Select d'une Sequence
	 * @throws UnfoundException 
	 */
	public Sequence selectSequence(Sequence sequence) throws UnfoundException;
	
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
	 * Select NiveauAcquisition
	 * @throws UnfoundException 
	 */
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException;
	
	/**
	 * Select Stagiaire
	 * @throws UnfoundException 
	 */
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException;
}
