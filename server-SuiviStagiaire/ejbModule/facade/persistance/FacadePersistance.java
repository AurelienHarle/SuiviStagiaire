package facade.persistance;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entity.requete.Requete;
import exception.dao.UnfoundException;
import exception.requete.NullActionException;
import exception.requete.NullObjectException;
import exception.requete.NullSpecificationActionException;
import exception.requete.UndefinedObjectException;
import exception.requete.UndefinedSpecificationActionException;
import exception.requete.UndefinedActionException;
import facade.persistance.delete.FacadeServiceDelete;
import facade.persistance.insert.FacadeServiceInsert;
import facade.persistance.select.FacadeServiceSelect;
import facade.persistance.update.FacadeServiceUpdate;

/**
 * Class qui est la facade du service de persistance elle permet de rediriger vers le service appropri�.
 * 
 * @author Aur�lien Harl�
 * @version 1
 * @since 18/07/2017
 *
 */
@Stateless
@LocalBean
public class FacadePersistance implements FacadePersistanceLocal {

	@EJB
	FacadeServiceSelect facadeServiceSelect;
	@EJB
	FacadeServiceInsert facadeServiceInsert;
	@EJB
	FacadeServiceUpdate facadeServiceUpdate;
	@EJB
	FacadeServiceDelete facadeServiceDelete;
	
    /**
     * Default constructor. 
     */
    public FacadePersistance() {
        // TODO Auto-generated constructor stub
    }

    /**
   	 * Contr�le vers quel service la requ�te dois �tre rediriger en utilisant pour �a le action du service pr�sent dans la requ�te..
   	 * 
   	 * @param requete {@link Requete} dois obligatoirement contenir un service et selon le service demand� elle dois contenir plus d'information.
     * 
     * @throws UndefinedObjectException 
     * @throws NullActionException 
     * @throws NullObjectException 
     * @throws UnfoundException 
     * @throws NullSpecificationActionException 
     * @throws UndefinedSpecificationActionException 
   	 * @throws {@link UndefinedActionException}
   	 */
	public void traite(Requete requete) throws UndefinedActionException, UndefinedObjectException, NullActionException, NullObjectException, UnfoundException, UndefinedSpecificationActionException, NullSpecificationActionException {
		
		if(requete.getAction() == null) throw new NullActionException();
		
		switch (requete.getAction()) {
		case SELECT:
			facadeServiceSelect.traite(requete);
			break;
		case INSERT:
			facadeServiceInsert.traite(requete);
			break;
		case UPDATE:
			facadeServiceUpdate.traite(requete);
			break;
		case DELETE:
			facadeServiceDelete.traite(requete);
			break;
		default:
			throw new UndefinedActionException();
		}
		
	}
    
    

}
