package logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class JournaliseurNiveauInfo extends Logger {

	private FileHandler handler;
	private SimpleFormatter formatter;
	private static final JournaliseurNiveauInfo INSTANCE = new JournaliseurNiveauInfo();
	
	/**
	 * Never use it for Singleton pattern
	 * 
	 * @param name
	 * @param resourceBundleName
	 * @see JournaliseurNiveauInfo
	 */
	@Deprecated
	protected JournaliseurNiveauInfo(String name, String resourceBundleName) {
		super(name, resourceBundleName);
	}


	private JournaliseurNiveauInfo() {
		super("LogInfo", null);
		init();
		
	}

	private void init() {

		formatter = new SimpleFormatter(); 
		try {
			handler = new FileHandler("D:\\Projet\\Suivi stagiaire\\Git\\SuiviStagiaire\\server-SuiviStagiaire\\logs\\"+ LocalDate.now() + "_INFO_" + ".log",true);
			handler.setFormatter(formatter); 
			handler.setLevel(Level.CONFIG);
			this.setLevel(Level.CONFIG);
			addHandler(handler);
		} catch (SecurityException | IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static JournaliseurNiveauInfo getINSTANCE() {
		return INSTANCE;
	}


	public void log(String string) {
		
		String heure = LocalTime.now() + " ";
		string = heure + string;
		
		this.log(Level.INFO, string);
		
	}
	
}
