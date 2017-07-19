package service.select;

import javax.ejb.Local;

import entity.requete.Requete;
import exception.dao.UnfoundException;
import sequence.entity.Sequence;
import sequence.technique.Sequences;

@Local
public interface ServiceSelectSequenceLocal {

	public Sequence selectSequence(Requete requete) throws UnfoundException;

	public Sequences selectSequenceByModule(Requete requete);

	public Sequences selectSequences();

}
