package logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class JournaliseurNiveauError extends Logger {

	private FileHandler handler;
	private SimpleFormatter formatter;
	private static final JournaliseurNiveauError INSTANCE = new JournaliseurNiveauError();
	
	/**
	 * Never use it for Singleton pattern
	 * 
	 * @param name
	 * @param resourceBundleName
	 * @see JournaliseurNiveauError
	 */
	@Deprecated
	protected JournaliseurNiveauError(String name, String resourceBundleName) {
		super(name, resourceBundleName);
	}


	private JournaliseurNiveauError() {
		super("LogError", null);
		init();
		
	}

	private void init() {

		formatter = new SimpleFormatter(); 
		try {
			handler = new FileHandler("D:\\Projet\\Suivi stagiaire\\Git\\SuiviStagiaire\\server-SuiviStagiaire\\logs\\"+ LocalDate.now() + "_ERROR_" + ".log");
			handler.setFormatter(formatter); 
			handler.setLevel(Level.SEVERE);
			this.setLevel(Level.SEVERE);
			addHandler(handler);
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static JournaliseurNiveauError getINSTANCE() {
		return INSTANCE;
	}


	public void log(String string) {
		
		String heure = LocalTime.now() + " ";
		string = heure + string;
		
		this.log(Level.SEVERE, string);
		
	}
	
}
