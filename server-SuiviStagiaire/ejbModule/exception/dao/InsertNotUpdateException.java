package exception.dao;

import autoEvaluation.entity.AutoEvaluation;
import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw si on essaye d'facadeServiceUpdate une {@link AutoEvaluation} qui n'est pas du jour en base de données
 * chaque lever d'exeception provoque une écriture dans les logs Warning
 * 
 * @see JournaliseurNiveauWarning
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 27/06/2017
 *
 */
public class InsertNotUpdateException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static String MESSAGE = "[ERROR] FacadeServiceUpdate not possible become an FacadeServiceInsert [Method] : ";
	

	public InsertNotUpdateException(String suiteMessage) {
		super(MESSAGE + suiteMessage);
		JournaliseurNiveauWarning.getINSTANCE().log(MESSAGE + suiteMessage);
	}
}