package exception.requete;

import java.util.logging.Level;

import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw si on essaye d'atteindre une action non existante dans le service.
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 27/07/2017
 *
 */
public class UndefinedActionException extends Exception {
	
	private static final long serialVersionUID = 1L;
	final static String MESSAGE = "[ERROR] Vous essayez d'atteindre une action non definit dans ce service";

	/**
	 * Constructeur d'exception qui affiche un message, et le log avec un {@link Level} Warning
	 * 
	 * @see JournaliseurNiveauWarning
	 */
	public UndefinedActionException() {
		super(MESSAGE);
		JournaliseurNiveauWarning.getINSTANCE().log(MESSAGE);
	}
}