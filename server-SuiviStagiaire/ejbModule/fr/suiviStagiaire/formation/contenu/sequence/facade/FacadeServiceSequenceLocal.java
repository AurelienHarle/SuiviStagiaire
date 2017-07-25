package fr.suiviStagiaire.formation.contenu.sequence.facade;

import javax.ejb.Local;

import fr.suiviStagiaire.exception.DoublonException;
import fr.suiviStagiaire.exception.NullException;
import fr.suiviStagiaire.exception.UnfoundException;
import fr.suiviStagiaire.formation.contenu.module.entity.Module;
import fr.suiviStagiaire.formation.contenu.sequence.entity.Sequence;
import fr.suiviStagiaire.formation.contenu.sequence.technique.Sequences;

@Local
public interface FacadeServiceSequenceLocal {
	
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
	 * Selectionne les {@link Sequences} d'un {@link Module}
	 * @param module {@link Module}
	 * @return {@link Sequences}
	 */
	public Sequences selectSequenceByModule(Module module);
	
	/**
	 * Selectionne tout les sequences de la table seq
	 * @return {@link Sequences}
	 */
	public Sequences selectSequences();
}
