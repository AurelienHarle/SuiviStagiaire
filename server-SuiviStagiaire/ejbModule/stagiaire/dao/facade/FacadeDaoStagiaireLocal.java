package stagiaire.dao.facade;

import javax.ejb.Local;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import stagiaire.entity.Stagiaire;

@Local
public interface FacadeDaoStagiaireLocal {


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
