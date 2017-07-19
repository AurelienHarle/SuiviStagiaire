package exception;

import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw si on essaye d'atteindre une action non existante dans le service.
 * chaque lever d'exeception provoque une écriture dans les logs Warning
 * 
 * @see JournaliseurNiveauWarning
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 27/06/2017
 *
 */
public class UndefinedActionException extends Exception {
	
	private static final long serialVersionUID = 1L;
	final static String MESSAGE = "[ERROR] Vous essayez d'atteindre une action non definit dans ce service";
	
	/**
	 * @param suiteMessage 
	 * 
	 */
	public UndefinedActionException() {
		super(MESSAGE);
		JournaliseurNiveauWarning.getINSTANCE().log(MESSAGE);
	}
}