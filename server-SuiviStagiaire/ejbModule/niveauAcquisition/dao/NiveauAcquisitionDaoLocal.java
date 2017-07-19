package niveauAcquisition.dao;

import javax.ejb.Local;

import competence.dao.CompetenceDao;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import niveauAcquisition.entity.NiveauAcquisition;
import niveauAcquisition.technique.NiveauAcquisitions;

/**
 * Local Bean de {@link CompetenceDao} qui permet l'insertion l'facadeServiceUpdate et le facadeServiceDelete dans la base de donn�es
 * 
 * @author Aur�lien Harl�
 * @Version 1
 * @Since 19/06/2017
 *
 */
@Local
public interface NiveauAcquisitionDaoLocal {
		
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
