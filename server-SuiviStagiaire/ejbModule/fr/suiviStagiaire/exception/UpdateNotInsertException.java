package fr.suiviStagiaire.exception;

import fr.suiviStagiaire.formation.autoEvaluation.entity.AutoEvaluation;
import fr.suiviStagiaire.logger.JournaliseurNiveauWarning;

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
	final static String MESSAGE = "[ERROR] Insert not possible become an Update [Method] : ";
	

	public UpdateNotInsertException(String suiteMessage) {
		super(MESSAGE + suiteMessage);
		JournaliseurNiveauWarning.getINSTANCE().log(MESSAGE + suiteMessage);
	}
}
