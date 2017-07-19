package exception.requete;

import java.util.logging.Level;

import entity.requete.Requete;
import facade.FacadeApplication;
import logger.JournaliseurNiveauWarning;

/**
 * {@link Exception} qui est throw si on envoie une {@link Requete} null dans la {@link FacadeApplication} .
 * 
 * @author Aurélien Harlé
 * @Version 1
 * @Since 19/07/2017
 *
 */
public class NullRequeteException extends Exception {

	private static final long serialVersionUID = 1L;
	final static String MESSAGE = "[ERROR] Requete null a la FacadeApplication";
	
	/**
	 * Constructeur d'exception qui affiche un message, et le log avec un {@link Level} Warning
	 * 
	 * @see JournaliseurNiveauWarning
	 */
	public NullRequeteException() {
		super(MESSAGE);
		JournaliseurNiveauWarning.getINSTANCE().log(MESSAGE);
	}
	
}
