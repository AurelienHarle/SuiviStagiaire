package autoEvaluation.facade;

import javax.ejb.Local;

import autoEvaluation.entity.AutoEvaluation;
import autoEvaluation.entity.Competence;
import autoEvaluation.entity.Module;
import autoEvaluation.entity.NiveauAcquisition;
import autoEvaluation.entity.Sequence;
import compteUtilisateur.entity.Stagiaire;
import exception.DoublonException;
import exception.NullException;

@Local
public interface FacadeServiceAutoEvaluationLocal {
	
	/**
	 * Insertion d'une auto evaluation dans la base
	 * 
	 * @throws {@link DoublonException}
	 * @throws {@link NullException}
	 */
	public void insertAutoEvaluation(AutoEvaluation autoEvaluation) throws DoublonException, NullException;
	
	/**
	 * Insertion d'un Module
	 * @throws DoublonException 
	 * @throws NullException 
	 */
	public void insertModule(Module module) throws DoublonException, NullException;
	
	/**
	 * Insertion d'une Sequence
	 * @throws DoublonException 
	 * @throws NullException 
	 */
	public void insertSequence(Sequence sequence) throws DoublonException, NullException;
	
	/**
	 * Insertion d'une competence
	 * @throws DoublonException 
	 * @throws NullException 
	 */
	public void insertCompetence(Competence competence) throws DoublonException, NullException;
	
	/**
	 * Insertion d'un NiveauAcquisition
	 * @param competence
	 * @throws DoublonException
	 * @throws NullException
	 */
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException;
	
	/**
	 * Insertion d'un Stagiaire
	 * TODO MOVE TO COMPTE UTILISATEUR
	 */
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException;
	
	/**
	 * Update d'une auto evaluation dans la base
	 */
	public void updateAutoEvaluation(AutoEvaluation autoEvaluation);
	
	/**
	 * Update d'un Module
	 */
	public void updateModule(Module module);
	
	/**
	 * Update d'une Sequence
	 * 
	 */
	public void updateSequence(Sequence sequence);
	
	/**
	 * Update d'une Competences
	 */
	public void updateCompetence(Competence competence);
	
	/**
	 * Update d'un NiveauAcquisition
	 */
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition);
	
	/**
	 * Update d'un Stagiaire
	 */
	public void updateStagiaire(Stagiaire stagiaire);
	
	/**
	 * Delete d'une auto evaluation dans la base
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
	 * Select d'une auto evaluation dans la base
	 */
	public AutoEvaluation selectAutoEvaluation(AutoEvaluation autoEvaluation);

	/**
	 * Select d'un Module
	 */
	public Module selectModule(Module module);
	
	/**
	 * Select d'une Sequence
	 */
	public Sequence selectSequence(Sequence sequence);
	
	/**
	 * Select d'une Competences
	 */
	public Competence selectCompetence(Competence competence);
	
	/**
	 * Select NiveauAcquisition
	 */
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition);
	
	/**
	 * Select Stagiaire
	 */
	public Stagiaire selectStagiaire(Stagiaire stagiaire);
	
}
