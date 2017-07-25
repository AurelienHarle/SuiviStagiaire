package fr.suiviStagiaire.formation.contenu.competence.dao.facade;

import javax.ejb.Local;

import fr.suiviStagiaire.exception.DoublonException;
import fr.suiviStagiaire.exception.NullException;
import fr.suiviStagiaire.exception.UnfoundException;
import fr.suiviStagiaire.formation.contenu.competence.entity.Competence;
import fr.suiviStagiaire.formation.contenu.competence.technique.Competences;
import fr.suiviStagiaire.formation.contenu.module.entity.Module;
import fr.suiviStagiaire.formation.contenu.sequence.entity.Sequence;

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
	
	/**
	 * Retourne toute les competences de la table comp
	 * @return competences {@link Competences}
	 */
	public Competences selectCompetences();
	
}
