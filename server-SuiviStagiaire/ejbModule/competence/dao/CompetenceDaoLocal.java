package competence.dao;

import javax.ejb.Local;

import competence.entity.Competence;
import competence.technique.Competences;
import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import module.entity.Module;
import sequence.entity.Sequence;

/**
 * Local Bean de {@link CompetenceDao} qui permet l'insertion l'update et le delete dans la base de données
 * 
 * @author Aurélien Harlé
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
	
	/**
	 * select les {@link Competences} d'après un module
	 * @param module {@link Module}
	 * @return {@link Competences}
	 * 
	 */
	public Competences selectCompetenceByModule(Module module);

	/**
	 * select les {@link Competences} d'après une {@link Sequence}
	 * @param module {@link Sequence}
	 * @return {@link Competences}
	 * 
	 */
	public Competences selectCompetenceBySequence(Sequence sequence);

	
	


	
}
