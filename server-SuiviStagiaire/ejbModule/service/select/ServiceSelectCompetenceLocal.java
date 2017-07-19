package service.select;

import javax.ejb.Local;

import competence.entity.Competence;
import competence.technique.Competences;
import entity.requete.Requete;
import exception.dao.UnfoundException;
import module.entity.Module;
import sequence.entity.Sequence;

@Local
public interface ServiceSelectCompetenceLocal {

	/**
     * Sélectionne une {@link Competence} de la table comp selon sa clé primaire.
     */
	public Competence selectCompetence(Requete requete) throws UnfoundException;

	/**
     * Sélectionne les {@link Competence} de la table comp selon la clé primaire d'un {@link Module}.
	 * @throws UnfoundException 
     */
	public Competences selectCompetenceByModule(Requete requete) throws UnfoundException;

	/**
	 * Sélectionne les {@link Competence} de la table comp selon la clé primaire d'un {@link Sequence}.
	 * @throws UnfoundException 
	 */
	public Competences selectCompetenceBySequence(Requete requete) throws UnfoundException;
	
	/**
	 * Sélectionne toute les {@link Competence} de la table comp.
	 * @throws UnfoundException 
	 */
	public Competences selectCompetences() throws UnfoundException;

}
