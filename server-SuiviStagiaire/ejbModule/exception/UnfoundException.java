package exception;

import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw lorsque le SELECT ne retourne pas de résultat en base de données
 * chaque lever d'exeception provoque une écriture dans les logs Warning
 * 
 * @see JournaliseurNiveauWarning
 * 
 * @author Aurélien Harlé
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
