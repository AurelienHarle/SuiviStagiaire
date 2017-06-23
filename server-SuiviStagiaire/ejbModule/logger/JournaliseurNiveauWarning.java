package logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class JournaliseurNiveauWarning extends Logger {

	private FileHandler handler;
	private SimpleFormatter formatter;
	private static final JournaliseurNiveauWarning INSTANCE = new JournaliseurNiveauWarning();
	
	/**
	 * Never use it for Singleton pattern
	 * 
	 * @param name
	 * @param resourceBundleName
	 * @see JournaliseurNiveauWarning
	 */
	@Deprecated
	protected JournaliseurNiveauWarning(String name, String resourceBundleName) {
		super(name, resourceBundleName);
	}


	private JournaliseurNiveauWarning() {
		super("LogWarn", null);
		init();
		
	}

	private void init() {

		formatter = new SimpleFormatter(); 
		try {
			handler = new FileHandler("D:\\Projet\\Suivi stagiaire\\Git\\SuiviStagiaire\\server-SuiviStagiaire\\logs\\"+ LocalDate.now() + "_WARN_" + ".log",true);
			handler.setFormatter(formatter); 
			handler.setLevel(Level.WARNING);
			this.setLevel(Level.WARNING);
			addHandler(handler);
		} catch (SecurityException | IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static JournaliseurNiveauWarning getINSTANCE() {
		return INSTANCE;
	}


	public void log(String string) {
		
		String heure = LocalTime.now() + " ";
		string = heure + string;
		
		this.log(Level.WARNING, string);
		
	}
	
}
