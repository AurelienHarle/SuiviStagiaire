package stagiaire.facade;

import javax.ejb.Local;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import stagiaire.entity.Stagiaire;

@Local
public interface FacadeServiceStagiaireLocal {
	
	/**
	 * Insertion d'un Stagiaire
	 * 
	 */
	public void insertStagiaire(Stagiaire stagiaire) throws DoublonException, NullException;

	/**
	 * FacadeServiceUpdate d'un Stagiaire
	 */
	public void updateStagiaire(Stagiaire stagiaire);
	
	/**
	 * FacadeServiceDelete Stagiaire
	 */
	public void deleteStagiaire(Stagiaire stagiaire);
	
	/**
	 * FacadeServiceSelect Stagiaire
	 * @throws UnfoundException 
	 */
	public Stagiaire selectStagiaire(Stagiaire stagiaire) throws UnfoundException;
	
}
