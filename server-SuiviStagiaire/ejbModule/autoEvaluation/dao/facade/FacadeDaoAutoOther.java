package autoEvaluation.dao.facade;

import javax.ejb.Local;

import autoEvaluation.entity.Competence;
import autoEvaluation.entity.Module;
import autoEvaluation.entity.NiveauAcquisition;
import autoEvaluation.entity.Sequence;
import autoEvaluation.technique.Competences;
import compteUtilisateur.entity.Stagiaire;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;

@Local
public interface FacadeDaoAutoOther {


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
	 * 
	 */
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException;
	
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
	 * Select d'un Module
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
	 * Select NiveauAcquisition
	 * @throws UnfoundException 
	 */
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException;
	
	/**
	 * Select Stagiaire
	 * @throws UnfoundException 
	 */
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException;

	public Competences selectCompetences();
	
}
