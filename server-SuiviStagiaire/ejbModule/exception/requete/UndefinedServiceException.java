package exception.requete;

import java.util.logging.Level;

import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw si on essaye d'atteindre un service non existant.
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 27/06/2017
 *
 */
public class UndefinedServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;
	final static String MESSAGE = "[ERROR] Vous essayez d'atteindre un service non existant dans cette application";
	
	/**
	 * Constructeur d'exception qui affiche un message, et le log avec un {@link Level} Warning
	 * 
	 * @see JournaliseurNiveauWarning
	 */
	public UndefinedServiceException() {
		super(MESSAGE);
		JournaliseurNiveauWarning.getINSTANCE().log(MESSAGE);
	}
}
