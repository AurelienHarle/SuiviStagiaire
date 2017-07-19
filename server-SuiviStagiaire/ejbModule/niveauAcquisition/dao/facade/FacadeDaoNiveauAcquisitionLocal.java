package niveauAcquisition.dao.facade;

import javax.ejb.Local;

import exception.dao.DoublonException;
import exception.dao.NullException;
import exception.dao.UnfoundException;
import niveauAcquisition.entity.NiveauAcquisition;
import niveauAcquisition.technique.NiveauAcquisitions;

@Local
public interface FacadeDaoNiveauAcquisitionLocal {

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
