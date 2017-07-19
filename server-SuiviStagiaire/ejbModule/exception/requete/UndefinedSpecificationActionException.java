package exception.requete;

import java.util.logging.Level;

import entity.requete.Action;
import entity.requete.SpecificationAction;
import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw si on essaye d'atteindre une {@link Action} avec une {@link SpecificationAction} non existant.
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/07/2017
 *
 */
public class UndefinedSpecificationActionException extends Exception {
	
	private static final long serialVersionUID = 1L;
	final static String MESSAGE = "[ERROR] Vous essayez d'atteindre une SpecificationAction non existant dans cette application";
	
	/**
	 * Constructeur d'exception qui affiche un message, et le log avec un {@link Level} Warning
	 * 
	 * @see JournaliseurNiveauWarning
	 */
	public UndefinedSpecificationActionException() {
		super(MESSAGE);
		JournaliseurNiveauWarning.getINSTANCE().log(MESSAGE);
	}
}
