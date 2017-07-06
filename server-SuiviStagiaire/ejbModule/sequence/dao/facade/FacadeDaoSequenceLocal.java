package sequence.dao.facade;

import javax.ejb.Local;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import sequence.entity.Sequence;
import sequence.technique.Sequences;

@Local
public interface FacadeDaoSequenceLocal {


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
	
}
