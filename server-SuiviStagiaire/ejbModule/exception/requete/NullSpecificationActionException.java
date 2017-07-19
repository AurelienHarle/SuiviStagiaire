package exception.requete;

import java.util.logging.Level;

import entity.requete.Requete;
import entity.requete.SpecificationAction;
import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw si on envoie une {@link Requete} avec une {@link SpecificationAction} null alors qu'il est nécessaire.
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/07/2017
 *
 */
public class NullSpecificationActionException extends Exception {

	private static final long serialVersionUID = 1L;
	final static String MESSAGE = "[ERROR] Requete avec une SpecificationAction null alors qu'il est obligatoire";
	
	/**
	 * Constructeur d'exception qui affiche un message, et le log avec un {@link Level} Warning
	 * 
	 * @see JournaliseurNiveauWarning
	 */
	public NullSpecificationActionException() {
		super(MESSAGE);
		JournaliseurNiveauWarning.getINSTANCE().log(MESSAGE);
	}
	
}
