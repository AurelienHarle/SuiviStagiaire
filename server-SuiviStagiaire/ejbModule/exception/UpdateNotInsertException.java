package exception;

import autoEvaluation.entity.AutoEvaluation;
import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw si on essaye d'entrer une {@link AutoEvaluation} d�j� existante en base de donn�es
 * chaque lever d'exeception provoque une �criture dans les logs Warning
 * 
 * @see JournaliseurNiveauWarning
 * 
 * @author Aur�lien Harl�
 * @Version 1
 * @Since 27/06/2017
 *
 */
public class UpdateNotInsertException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static String MESSAGE = "[ERROR] FacadeServiceInsert not possible become an FacadeServiceUpdate [Method] : ";
	

	public UpdateNotInsertException(String suiteMessage) {
		super(MESSAGE + suiteMessage);
		JournaliseurNiveauWarning.getINSTANCE().log(MESSAGE + suiteMessage);
	}
}
