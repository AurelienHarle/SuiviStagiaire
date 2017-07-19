package niveauAcquisition.facade;

import javax.ejb.Local;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import niveauAcquisition.entity.NiveauAcquisition;
import niveauAcquisition.technique.NiveauAcquisitions;

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
	 * FacadeServiceUpdate d'un NiveauAcquisition
	 */
	public void updateNiveauAcquisition(NiveauAcquisition niveauAcquisition);
	
	/**
	 * FacadeServiceDelete NiveauAcquisition
	 */
	public void deleteNiveauAcquisition(NiveauAcquisition niveauAcquisition);
	
	/**
	 * FacadeServiceSelect NiveauAcquisition
	 * @throws UnfoundException 
	 */
	public NiveauAcquisition selectNiveauAcquisition(NiveauAcquisition niveauAcquisition) throws UnfoundException;

	/**
	 * FacadeServiceSelect NiveauAcquisitions
	 * @throws UnfoundException 
	 */
	public NiveauAcquisitions selectNiveauAcquisitions();
	
}
