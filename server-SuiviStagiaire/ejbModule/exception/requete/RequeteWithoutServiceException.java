package exception.requete;

import java.util.logging.Level;

import entity.requete.Requete;
import entity.requete.Service;
import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw si on essaye d'instancier une {@link Requete} avec un {@link Service} a null.
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/07/2017
 *
 */
public class RequeteWithoutServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	final static String MESSAGE = "[ERROR] Impossible d'instancié une Requete avec un service null";
	
	/**
	 * Constructeur d'exception qui affiche un message, et le log avec un {@link Level} Warning
	 * 
	 * @see JournaliseurNiveauWarning
	 */
	public RequeteWithoutServiceException() {
		super(MESSAGE);
		JournaliseurNiveauWarning.getINSTANCE().log(MESSAGE);
	}
	
}
