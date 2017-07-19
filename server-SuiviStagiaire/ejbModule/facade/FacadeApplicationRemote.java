package facade;

import javax.ejb.Remote;

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


/**
 * {@link Class} interface qui est la facade principal de l'application elle permet de rediriger une {@link Requete} vers le service appropri�
 * Implementer par {@link FacadeApplication}
 * 
 * @author Aur�lien Harl�
 * @version 2
 * @since 18/07/2017
 * 
 */
@Remote
public interface FacadeApplicationRemote {

	 /**
	 * Contr�le vers quel service la requ�te dois �tre rediriger.
	 * 
	 * @param requete {@link Requete} dois obligatoirement contenir un service et selon le service demand� elle dois contenir plus d'information.
	 * @throws UndefinedActionException 
	 * @throws UndefinedObjectException 
	 * @throws NullRequeteException 
	 * @throws NullActionException 
	 * @throws NullObjectException 
	 * @throws UnfoundException 
	 * @throws NullSpecificationActionException 
	 * @throws UndefinedSpecificationActionException 
	 * @throws {@link UndefinedServiceException}
	 */
	public void traite(Requete requete) throws UndefinedServiceException, UndefinedActionException, UndefinedObjectException, NullRequeteException, NullActionException, NullObjectException, UnfoundException, UndefinedSpecificationActionException, NullSpecificationActionException;
	
}
