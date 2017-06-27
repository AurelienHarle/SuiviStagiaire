package exception;

import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw si on essaye d'entrer une date a null en base de données
 * chaque lever d'exeception provoque une écriture dans les logs Warning
 * 
 * @see JournaliseurNiveauWarning
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 27/06/2017
 *
 */
public class DateNullException extends Exception {
	
	private static final long serialVersionUID = 1L;
	final static String MESSAGE = "[ERROR] Insertion d'une entity avec une date Null impossible [Method] : ";
	
	/**
	 * @param suiteMessage 
	 * 
	 */
	public DateNullException(String suiteMessage) {
		super(MESSAGE + suiteMessage);
		JournaliseurNiveauWarning.getINSTANCE().log(MESSAGE + suiteMessage);
	}
}
