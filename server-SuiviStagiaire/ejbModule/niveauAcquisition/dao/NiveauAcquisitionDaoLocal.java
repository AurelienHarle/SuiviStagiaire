package niveauAcquisition.dao;

import javax.ejb.Local;

import competence.dao.CompetenceDao;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import niveauAcquisition.entity.NiveauAcquisition;

/**
 * Local Bean de {@link CompetenceDao} qui permet l'insertion l'update et le delete dans la base de données
 * 
 * @author Aurélien Harlé
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

	
	


	
}
