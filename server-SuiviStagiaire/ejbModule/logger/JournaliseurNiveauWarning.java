package logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import sun.security.jca.GetInstance;

/**
 * Cette classe est une {@link Logger} qui journalise les traces de CONFIG de l'application {@link Level} 
 * 
 * Elle journalise dans une fichier de log path : 
 * "D:\Projet\Suivi stagiaire\Git\SuiviStagiaire\server-SuiviStagiaire\logs\"+ LocalDate.now() + "_" + Level.CONFIG.getName() + "_" + ".log"
 * Grace a un {@link FileHandler}
 * 
 * Ainsi que dans la console 
 * Grace a une {@link ConsoleHandler}
 * 
 * sur la version final de l'application le niveau de Config ne seras plus logger
 * 
 * C'est un Singleton il faut donc utiliser la méthode {@link GetInstance}
 * 
 * @author Aurélien Harlé
 * @version 1
 * @since 27/06/2017
 *
 */
public class JournaliseurNiveauWarning extends Logger {

	private FileHandler handler;
	private SimpleFormatter formatter;
	private static final JournaliseurNiveauWarning INSTANCE = new JournaliseurNiveauWarning();
	private final static String LOGGER_NAME = "LogWarn";
	private final static String LOGGER_PATH = "D:\\Projet\\Suivi stagiaire\\Git\\SuiviStagiaire\\server-SuiviStagiaire\\logs\\"+ LocalDate.now() + "_" + Level.WARNING.getName() + "_" + ".log";
	
	private JournaliseurNiveauWarning() {
		super(LOGGER_NAME, null);
		init();
		
	}

	/**
	 * Initialise le logger avec tout les configurations nécessaire
	 */
	private void init() {

		formatter = new SimpleFormatter(); 
		try {
			handler = new FileHandler(LOGGER_PATH,true);
			handler.setFormatter(formatter); 
			handler.setLevel(Level.WARNING);
			this.setLevel(Level.WARNING);
			addHandler(handler);
		} catch (SecurityException | IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Renvoie l'instance du {@link JournaliseurNiveauWarning}
	 * @return INSTANCE {@link JournaliseurNiveauWarning}
	 */
	public static JournaliseurNiveauWarning getINSTANCE() {
		return INSTANCE;
	}

	/**
	 * Permet d'ecrire le log, rajoute aussi la date et l'heure actuelle.
	 * 
	 * @param message {@link String} Permet d'ecrire le message qu'on veux logger
	 */
	public void log(String string) {
		
		String heure = LocalTime.now() + " ";
		string = heure + string;
		
		this.log(Level.WARNING, string);
		
	}
	
}
