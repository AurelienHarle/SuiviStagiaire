package fr.suiviStagiaire.formation.contenu.sequence.dao;

import javax.ejb.Local;

import fr.suiviStagiaire.exception.DoublonException;
import fr.suiviStagiaire.exception.NullException;
import fr.suiviStagiaire.exception.UnfoundException;
import fr.suiviStagiaire.formation.contenu.competence.dao.CompetenceDao;
import fr.suiviStagiaire.formation.contenu.module.entity.Module;
import fr.suiviStagiaire.formation.contenu.sequence.entity.Sequence;
import fr.suiviStagiaire.formation.contenu.sequence.technique.Sequences;

/**
 * Local Bean de {@link CompetenceDao} qui permet l'insertion l'update et le delete dans la base de données
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/06/2017
 *
 */
@Local
public interface SequenceDaoLocal {
	
	/**
	 * Insertion d'une Sequence
	 * @throws DoublonException 
	 * @throws NullException 
	 */
	public void insertSequence(Sequence sequence) throws DoublonException, NullException;
	
	/**
	 * Update d'une Sequence
	 * 
	 */
	public void updateSequence(Sequence sequence);
	
	/**
	 * Delete d'une Sequence
	 */
	public void deleteSequence(Sequence sequence);
	
	/**
	 * Select d'une Sequence
	 * @throws UnfoundException 
	 */
	public Sequence selectSequence(Sequence sequence) throws UnfoundException;

	/**
	 * Selectionne tout les sequences de la table seq
	 * @return {@link Sequences}
	 */
	public Sequences selectSequences();

	/**
	 * Selectionne les {@link Sequences} d'un {@link Module}
	 * @param module {@link Module}
	 * @return {@link Sequences}
	 */
	public Sequences selectSequenceByModule(Module module);
	
}
