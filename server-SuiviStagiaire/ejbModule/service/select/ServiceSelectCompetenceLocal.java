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
     * S�lectionne une {@link Competence} de la table comp selon sa cl� primaire.
     */
	public Competence selectCompetence(Requete requete) throws UnfoundException;

	/**
     * S�lectionne les {@link Competence} de la table comp selon la cl� primaire d'un {@link Module}.
	 * @throws UnfoundException 
     */
	public Competences selectCompetenceByModule(Requete requete) throws UnfoundException;

	/**
	 * S�lectionne les {@link Competence} de la table comp selon la cl� primaire d'un {@link Sequence}.
	 * @throws UnfoundException 
	 */
	public Competences selectCompetenceBySequence(Requete requete) throws UnfoundException;
	
	/**
	 * S�lectionne toute les {@link Competence} de la table comp.
	 * @throws UnfoundException 
	 */
	public Competences selectCompetences() throws UnfoundException;

}
