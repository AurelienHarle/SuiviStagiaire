package facade.persistance.select;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entity.requete.Requete;
import exception.dao.UnfoundException;
import exception.requete.NullSpecificationActionException;
import exception.requete.UndefinedSpecificationActionException;
import service.select.ServiceSelectCompetence;

@Stateless
@LocalBean
public class FacadeSelectCompetence {

	@EJB
	ServiceSelectCompetence serviceSelectCompetence;
	
	public void traite(Requete requete) throws UnfoundException, UndefinedSpecificationActionException, NullSpecificationActionException {
		
		if(requete.getSpecificationAction() == null) throw new NullSpecificationActionException();
			
		switch (requete.getSpecificationAction()) {
			case BY_ID:
				serviceSelectCompetence.selectCompetence(requete);
				break;
			case BY_MODULE:
				serviceSelectCompetence.selectCompetenceByModule(requete);
				break;
			case BY_SEQUENCE:
				serviceSelectCompetence.selectCompetenceBySequence(requete);
				break;
			case ALL:
				serviceSelectCompetence.selectCompetences();
				break;	
			default:
				throw new UndefinedSpecificationActionException();
		}
		
	}

}
