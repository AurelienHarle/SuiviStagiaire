package exception;

import logger.JournaliseurNiveauWarning;

public class RequeteWithoutServiceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static String MESSAGE = "[ERROR] Can not instantiate a request without service";
	

	public RequeteWithoutServiceException() {
		super(MESSAGE);
		JournaliseurNiveauWarning.getINSTANCE().log(MESSAGE);
	}
}
