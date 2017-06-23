package exception;

import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw si on essaye d'entrer un null en base de donn�es
 * 
 * @author Aur�lien Harl�
 * @Version 1
 * @Since 19/06/2017
 *
 */
public class NullException extends Exception{

	JournaliseurNiveauWarning journaliseurNiveauWarning = JournaliseurNiveauWarning.getINSTANCE();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static String message = "[ERROR] Insertion d'un null impossible [Method] : ";
	

	public NullException(String string) {
		super(message + string);
		journaliseurNiveauWarning.log(message + string);
	}

}
