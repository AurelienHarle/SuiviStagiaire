package sequence.facade;

import javax.ejb.Local;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import module.entity.Module;
import sequence.entity.Sequence;
import sequence.technique.Sequences;

@Local
public interface FacadeServiceSequenceLocal {
	
	/**
	 * Insertion d'une Sequence
	 * @throws DoublonException 
	 * @throws NullException 
	 */
	public void insertSequence(Sequence sequence) throws DoublonException, NullException;
	
	/**
	 * FacadeServiceUpdate d'une Sequence
	 * 
	 */
	public void updateSequence(Sequence sequence);
	
	/**
	 * FacadeServiceDelete d'une Sequence
	 */
	public void deleteSequence(Sequence sequence);
	
	/**
	 * FacadeServiceSelect d'une Sequence
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
