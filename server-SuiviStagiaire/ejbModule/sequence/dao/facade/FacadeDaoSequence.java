package sequence.dao.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import exception.DoublonException;
import exception.NullException;
import exception.UnfoundException;
import sequence.dao.SequenceDao;
import sequence.entity.Sequence;
import sequence.technique.Sequences;

/**
 * Session Bean implementation class FacadeDaoCompetence
 */
@Stateless
@LocalBean
public class FacadeDaoSequence implements FacadeDaoSequenceLocal {

	@EJB
	SequenceDao sequenceDao;
	
    /**
     * Default constructor. 
     */
    public FacadeDaoSequence() {
    }
	

	@Override
	public void insertSequence(Sequence sequence) throws DoublonException, NullException {
		sequenceDao.insertSequence(sequence);
	}

	@Override
	public void updateSequence(Sequence sequence) {
		sequenceDao.updateSequence(sequence);
		
	}

	@Override
	public void deleteSequence(Sequence sequence) {
		sequenceDao.deleteSequence(sequence);
		
	}

	@Override
	public Sequence selectSequence(Sequence sequence) throws UnfoundException {
		return sequenceDao.selectSequence(sequence);
		
	}


	@Override
	public Sequences selectSequences() {
		return sequenceDao.selectSequences();
	} 
    
}
