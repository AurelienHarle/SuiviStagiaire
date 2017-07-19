package competence.dao.facade;

import javax.ejb.Local;

import competence.entity.Competence;
import competence.technique.Competences;
import exception.dao.DoublonException;
import exception.dao.NullException;
import exception.dao.UnfoundException;
import module.entity.Module;
import sequence.entity.Sequence;

@Local
public interface FacadeDaoCompetenceLocal {


	/**
	 * Insertion d'une competence
	 * @throws DoublonException 
	 * @throws NullException 
	 */
	public void insertCompetence(Competence competence) throws DoublonException, NullException;
	
	/**
	 * FacadeServiceUpdate d'une Competences
	 */
	public void updateCompetence(Competence competence);
	
	/**
	 * FacadeServiceDelete d'une Competences
	 */
	public void deleteCompetence(Competence competence);
	
	/**
	 * FacadeServiceSelect d'une Competences
	 * @throws UnfoundException 
	 */
	public Competence selectCompetence(Competence competence) throws UnfoundException;
	
	/**
	 * facadeServiceSelect les {@link Competences} d'après un module
	 * @param module {@link Module}
	 * @return {@link Competences}
	 * 
	 */
	public Competences selectCompetenceByModule(Module module);
	
	/**
	 * facadeServiceSelect les {@link Competences} d'après une {@link Sequence}
	 * @param module {@link Sequence}
	 * @return {@link Competences}
	 * 
	 */
	public Competences selectCompetenceBySequence(Sequence sequence);
	
	/**
	 * Retourne toute les competences de la table comp
	 * @return competences {@link Competences}
	 */
	public Competences selectCompetences();
	
}
