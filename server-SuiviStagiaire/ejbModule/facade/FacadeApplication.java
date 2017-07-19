package facade;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import entity.requete.Requete;
import exception.dao.UnfoundException;
import exception.requete.NullActionException;
import exception.requete.NullObjectException;
import exception.requete.NullRequeteException;
import exception.requete.NullSpecificationActionException;
import exception.requete.UndefinedObjectException;
import exception.requete.UndefinedActionException;
import exception.requete.UndefinedServiceException;
import exception.requete.UndefinedSpecificationActionException;
import facade.persistance.FacadePersistance;
import logger.JournaliseurNiveauConfig;

/**
 * {@link Class} qui est la facade principal de l'application elle permet de rediriger une {@link Requete} vers le service appropri�
 * Implementation de {@link FacadeApplicationRemote}
 * 
 * @author Aur�lien Harl�
 * @version 2
 * @since 18/07/2017
 * 
 */
@Stateless
@Remote(FacadeApplicationRemote.class)
public class FacadeApplication implements FacadeApplicationRemote {

	@EJB
    private FacadePersistance facadePersistance;
	@SuppressWarnings("unused")
	private JournaliseurNiveauConfig journaliseurNiveauConfig = JournaliseurNiveauConfig.getINSTANCE();
   
	/**
     * Constructeur par d�faut utilis� par EJB.
     */
    public FacadeApplication() {
    }

    /**
	 * Contr�le vers quel service la requ�te dois �tre rediriger en utilisant pour �a le nom de service pr�sent dans la requ�te.
	 * 
	 * @param requete {@link Requete} dois obligatoirement contenir un service et selon le service demand� elle dois contenir plus d'information.
     * 
     * @throws UndefinedActionException 
     * @throws UndefinedObjectException 
     * @throws NullRequeteException 
     * @throws NullActionException 
     * @throws NullObjectException 
     * @throws UnfoundException 
     * @throws NullSpecificationActionException 
     * @throws UndefinedSpecificationActionException 
	 * @throws UndefinedServiceException
	 */
    @Override
	public void traite(Requete requete) throws UndefinedServiceException, UndefinedActionException, UndefinedObjectException, NullRequeteException, NullActionException, NullObjectException, UnfoundException, UndefinedSpecificationActionException, NullSpecificationActionException{
    	
    	if(requete == null) throw new NullRequeteException();
    	
			switch (requete.getService()) {
			case PERSISTANCE:
				facadePersistance.traite(requete);
				break;
			default:
				throw new UndefinedServiceException();
			}
		
	}
	
    
}
