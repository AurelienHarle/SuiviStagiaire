package sequence.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import module.entity.Module;
import sequence.dao.facade.FacadeDaoSequence;
import sequence.entity.Sequence;
import sequence.technique.Sequences;

/**
 * Session Bean implementation class FacadeServiceCompetence
 */
@Stateless
@LocalBean
public class FacadeServiceSequence implements FacadeServiceSequenceLocal {

	@EJB
	FacadeDaoSequence facadeDaoSequence;
	
    /**
     * Default constructor. 
     */
    public FacadeServiceSequence() {
    }
    
    @Override
	public void insertSequence(Sequence sequence) throws DoublonException, NullException {
		facadeDaoSequence.insertSequence(sequence);
	}

	@Override
	public void updateSequence(Sequence sequence) {
		facadeDaoSequence.updateSequence(sequence);
	}

	@Override
	public void deleteSequence(Sequence sequence) {
		facadeDaoSequence.deleteSequence(sequence);
	}

	@Override
	public Sequence selectSequence(Sequence sequence) throws UnfoundException {
		return facadeDaoSequence.selectSequence(sequence);
	}

	@Override
	public Sequences selectSequenceByModule(Module module) {
		return facadeDaoSequence.selectSequenceByModule(module);
	}

	@Override
	public Sequences selectSequences() {
		return facadeDaoSequence.selectSequences();
	} 

}
