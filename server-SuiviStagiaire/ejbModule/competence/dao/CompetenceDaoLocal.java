package competence.dao;

import javax.ejb.Local;

import competence.entity.Competence;
import competence.technique.Competences;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;

/**
 * Local Bean de {@link CompetenceDao} qui permet l'insertion l'update et le delete dans la base de donn�es
 * 
 * @author Aur�lien Harl�
 * @Version 1
 * @Since 19/06/2017
 *
 */
@Local
public interface CompetenceDaoLocal {
	
		
	/**
	 * Insertion d'une competence
	 * @throws DoublonException 
	 * @throws NullException 
	 */
	public void insertCompetence(Competence competence) throws DoublonException, NullException;
	
	/**
	 * Update d'une Competences
	 */
	public void updateCompetence(Competence competence);
	
	/**
	 * Delete d'une Competences
	 */
	public void deleteCompetence(Competence competence);
	
	/**
	 * Select d'une Competences
	 * @throws UnfoundException 
	 */
	public Competence selectCompetence(Competence competence) throws UnfoundException;
	
	/**
	 * Retourne toute les competences de la table comp
	 * @return competences {@link Competences}
	 */
	public Competences selectCompetences();

	
	


	
}