package logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
 
public class JournaliseurNiveauConfig extends Logger {

	private FileHandler handler;
	private SimpleFormatter formatter;
	private ConsoleHandler handlerConsole;
	private static final JournaliseurNiveauConfig INSTANCE = new JournaliseurNiveauConfig();
	
	/**
	 * Never use it for Singleton pattern
	 * 
	 * @param name
	 * @param resourceBundleName
	 * @see JournaliseurNiveauConfig
	 */
	@Deprecated
	protected JournaliseurNiveauConfig(String name, String resourceBundleName) {
		super(name, resourceBundleName);
	}


	private JournaliseurNiveauConfig() {
		super("LogConfig", null);
		init();
		
	}

	private void init() {
		
		formatter = new SimpleFormatter(); 
		
		try {
			
			handler = new FileHandler("D:\\Projet\\Suivi stagiaire\\Git\\SuiviStagiaire\\server-SuiviStagiaire\\logs\\"+ LocalDate.now() + "_CONFIG_" + ".log",true);
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
	
	public static JournaliseurNiveauConfig getINSTANCE() {
		return INSTANCE;
	}


	public void log(String string) {
		
		String heure = LocalTime.now() + " ";
		string = heure + string;
		
		this.log(Level.CONFIG, string);
		
	}
	
}
