package fr.suiviStagiaire.formation.contenu.sequence.dao.facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import fr.suiviStagiaire.exception.DoublonException;
import fr.suiviStagiaire.exception.NullException;
import fr.suiviStagiaire.exception.UnfoundException;
import fr.suiviStagiaire.formation.contenu.module.entity.Module;
import fr.suiviStagiaire.formation.contenu.sequence.dao.SequenceDao;
import fr.suiviStagiaire.formation.contenu.sequence.entity.Sequence;
import fr.suiviStagiaire.formation.contenu.sequence.technique.Sequences;

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
	public Sequences selectSequenceByModule(Module module) {
		return sequenceDao.selectSequenceByModule(module);
	}


	@Override
	public Sequences selectSequences() {
		return sequenceDao.selectSequences();
	} 
    
}
