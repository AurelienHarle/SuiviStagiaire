package competence.dao.facade;

import javax.ejb.Local;

import competence.entity.Competence;
import competence.technique.Competences;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import module.entity.Module;

@Local
public interface FacadeDaoCompetenceLocal {


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
	 * select les {@link Competences} d'apr�s un module
	 * @param module {@link Module}
	 * @return {@link Competences}
	 * 
	 */
	public Competences selectCompetenceByModule(Module module);
	
	/**
	 * Retourne toute les competences de la table comp
	 * @return competences {@link Competences}
	 */
	public Competences selectCompetences();
	
}
