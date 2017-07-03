package stagiaire.dao;

import javax.ejb.Local;

import competence.dao.CompetenceDao;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import stagiaire.entity.Stagiaire;

/**
 * Local Bean de {@link CompetenceDao} qui permet l'insertion l'update et le delete dans la base de données
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/06/2017
 *
 */
@Local
public interface StagiaireDaoLocal {
	
		
	/**
	 * Insertion d'un Stagiaire
	 * 
	 */
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException;
	
	
	
	/**
	 * Update d'un Stagiaire
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

	
	


	
}
