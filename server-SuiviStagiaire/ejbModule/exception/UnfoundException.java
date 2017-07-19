package exception;

import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw lorsque le SELECT ne retourne pas de r�sultat en base de donn�es
 * chaque lever d'exeception provoque une �criture dans les logs Warning
 * 
 * @see JournaliseurNiveauWarning
 * 
 * @author Aur�lien Harl�
 * @Version 1
 * @Since 27/06/2017
 *
 */
public class UnfoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static String MESSAGE = "[ERROR] FacadeServiceSelect impossible [Method] : ";
	

	public UnfoundException(String suiteMessage) {
		super(MESSAGE + suiteMessage);
		JournaliseurNiveauWarning.getINSTANCE().log(MESSAGE + suiteMessage);
	}

}
