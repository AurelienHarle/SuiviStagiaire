package fr.suiviStagiaire.logger;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

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
@Singleton

@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)

public class JournaliseurNiveauConfig extends Logger implements Serializable {

	private static final long serialVersionUID = 1L;
	private FileHandler handler;
	private SimpleFormatter formatter;
	private ConsoleHandler handlerConsole;
	private static final JournaliseurNiveauConfig INSTANCE = new JournaliseurNiveauConfig();
	private final static String LOGGER_NAME = "LogConfig";
	private final static String LOGGER_PATH = "D:\\Projet\\Suivi stagiaire\\Git\\SuiviStagiaire\\server-SuiviStagiaire\\logs\\"+ LocalDate.now() + "_" + Level.CONFIG.getName() + "_" + ".log";

	public JournaliseurNiveauConfig() {
		super(LOGGER_NAME, null);
	}

	/**
	 * Initialise le logger avec tout les configurations nécessaire
	 */
	@PostConstruct
	private void init() {
		
		formatter = new SimpleFormatter(); 
		
		try {
			
			handler = new FileHandler(LOGGER_PATH,true);
			handlerConsole = new ConsoleHandler();
			
			handlerConsole.setFormatter(formatter);
			handler.setFormatter(formatter); 
			
			handlerConsole.setLevel(Level.CONFIG);
			handler.setLevel(Level.CONFIG);
			this.setLevel(Level.CONFIG);
			
			addHandler(handlerConsole);
			addHandler(handler);
			
		} catch (SecurityException | IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Renvoie l'instance du {@link JournaliseurNiveauConfig}
	 * @return INSTANCE {@link JournaliseurNiveauConfig}
	 */
	public static JournaliseurNiveauConfig getINSTANCE() {
		return INSTANCE;
	}

	/**
	 * Permet d'ecrire le log, rajoute aussi la date et l'heure actuelle.
	 * 
	 * @param message {@link String} Permet d'ecrire le message qu'on veux logger
	 */
	public void log(String message) {
		
		String heure = LocalTime.now() + " ";
		message = heure + message;
		
		this.log(Level.CONFIG, message);
		
	}
	
}
