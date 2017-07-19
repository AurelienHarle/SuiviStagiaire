package facade;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import entity.requete.Requete;
import exception.UndefinedActionException;

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
   	 * Contr�le vers quel service la requ�te dois �tre rediriger.
   	 * 
   	 * @param requete {@link Requete} dois obligatoirement contenir un service et selon le service demand� elle dois contenir plus d'information.
   	 * @throws {@link UndefinedActionException}
   	 */
	public void traite(Requete requete) throws UndefinedActionException {
		
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
