package exception;

import logger.JournaliseurNiveauWarning;

public class UpdateNotInsertException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String message = "[ERROR] Insert not possible become an Update [Method] : ";
	

	public UpdateNotInsertException(String string) {
		super(message + string);
		JournaliseurNiveauWarning.getINSTANCE().log(message + string);
	}
}
