package exception.requete;

import java.util.logging.Level;

import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw si on essaye d'atteindre une action de persistance sans object.
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 27/06/2017
 *
 */
public class UndefinedObjectException extends Exception {
	
	private static final long serialVersionUID = 1L;
	final static String MESSAGE = "[ERROR] Vous essayez d'atteindre le service de persistance sans object";
	
	/**
	 * Constructeur d'exception qui affiche un message, et le log avec un {@link Level} Warning
	 * 
	 * @see JournaliseurNiveauWarning
	 */
	public UndefinedObjectException() {
		super(MESSAGE);
		JournaliseurNiveauWarning.getINSTANCE().log(MESSAGE);
	}
}