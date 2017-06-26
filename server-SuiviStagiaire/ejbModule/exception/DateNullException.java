package exception;

import logger.JournaliseurNiveauWarning;

public class DateNullException extends Exception {
	
	private static final long serialVersionUID = 1L;
	static String message = "[ERROR] Insertion d'une entity avec une date Null impossible [Method] : ";
	
	/**
	 * @param string 
	 * 
	 */
	public DateNullException(String string) {
		super(message + string);
		JournaliseurNiveauWarning.getINSTANCE().log(message + string);
	}
}
