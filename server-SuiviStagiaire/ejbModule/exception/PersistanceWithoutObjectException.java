package exception;

import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw si on essaye d'atteindre une action de persistance sans object.
 * chaque lever d'exeception provoque une écriture dans les logs Warning
 * 
 * @see JournaliseurNiveauWarning
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 27/06/2017
 *
 */
public class PersistanceWithoutObjectException extends Exception {
	
	private static final long serialVersionUID = 1L;
	final static String MESSAGE = "[ERROR] Vous essayez d'atteindre le service de persistance sans object";
	
	/**
	 * @param suiteMessage 
	 * 
	 */
	public PersistanceWithoutObjectException() {
		super(MESSAGE);
		JournaliseurNiveauWarning.getINSTANCE().log(MESSAGE);
	}
}