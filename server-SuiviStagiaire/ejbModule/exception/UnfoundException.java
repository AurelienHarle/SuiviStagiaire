package exception;

import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw si on essaye d'entrer un null en base de données
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/06/2017
 *
 */
public class UnfoundException extends Exception{

	JournaliseurNiveauWarning journaliseurNiveauWarning = JournaliseurNiveauWarning.getINSTANCE();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String message = "[ERROR] Select impossible [Method] : ";
	

	public UnfoundException(String string) {
		super(message + string);
		journaliseurNiveauWarning.log(message + string);
	}

}
