package sequence.facade;

import javax.ejb.Local;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import sequence.entity.Sequence;

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
}
