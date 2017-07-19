package facade.persistance.select;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entity.requete.Requete;
import exception.dao.UnfoundException;
import exception.requete.NullSpecificationActionException;
import exception.requete.UndefinedSpecificationActionException;
import service.select.ServiceSelectSequence;

@Stateless
@LocalBean
public class FacadeSelectSequence {

	@EJB
	ServiceSelectSequence serviceSelectSequence;
	
	public void traite(Requete requete) throws NullSpecificationActionException, UnfoundException, UndefinedSpecificationActionException {
		
		if(requete.getSpecificationAction() == null) throw new NullSpecificationActionException();
		
		switch (requete.getSpecificationAction()) {
			case BY_ID:
				serviceSelectSequence.selectSequence(requete);
				break;
			case BY_MODULE:
				serviceSelectSequence.selectSequenceByModule(requete);
				break;
			case ALL:
				serviceSelectSequence.selectSequences();
				break;	
			default:
				throw new UndefinedSpecificationActionException();
		}
		
	}

}
