package facade;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import entity.requete.Requete;
import exception.UndefinedActionException;
import exception.UndefinedServiceException;
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
	private JournaliseurNiveauConfig journaliseurNiveauConfig = JournaliseurNiveauConfig.getINSTANCE();
   
	/**
     * Constructeur par d�faut utilis� par EJB.
     */
    public FacadeApplication() {
    }

    /**
	 * Contr�le vers quel service la requ�te dois �tre rediriger.
	 * 
	 * @param requete {@link Requete} dois obligatoirement contenir un service et selon le service demand� elle dois contenir plus d'information.
     * @throws UndefinedActionException 
	 * @throws {@link UndefinedServiceException}
	 */
    @Override
	public void traite(Requete requete) throws UndefinedServiceException, UndefinedActionException{
	
			switch (requete.getService()) {
			case PERSISTANCE:
				facadePersistance.traite(requete);
				break;
			default:
				throw new UndefinedServiceException();
			}
		
	}
	
    
}
