package fr.suiviStagiaire.formation.autoEvaluation.niveauAcquisition.facade;

import javax.ejb.Local;

import fr.suiviStagiaire.exception.DoublonException;
import fr.suiviStagiaire.exception.NullException;
import fr.suiviStagiaire.exception.UnfoundException;
import fr.suiviStagiaire.formation.autoEvaluation.niveauAcquisition.entity.NiveauAcquisition;
import fr.suiviStagiaire.formation.autoEvaluation.niveauAcquisition.technique.NiveauAcquisitions;

@Local
public interface FacadeServiceNiveauAcquisitionLocal {
	
	/**
	 * Insertion d'un NiveauAcquisition
	 * @param competence
	 * @throws DoublonException
	 * @throws NullException
	 */
	public void insertNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws DoublonException, NullException;
	
	/**
	 * Update d'un NiveauAcquisition
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
	
}