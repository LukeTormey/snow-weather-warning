package logging;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AssignmentLogger {
	
	static Logger log = Logger.getLogger("External file log");
	static Handler fileOut = createExternalLogFile();
	
	/**
	 * Register this computer and version of Java for the assignment
	 * Do not delete the log files
	 * 
	 */
	public synchronized static void register(Object classId) {
		log.log(Level.INFO,"\nRegister " + getDetails(classId) + "\n");
	}
	
	/**
	 * Makes a log entry at the start of the method
	 * @param classId Pass the current object as 'this'
	 */
	public synchronized static void logMethodEntry(Object classId) {
		log.log(Level.INFO,"\n"+ getDetails(classId));
	}
	
	/**
	 * Makes a log entry at the end of the method
	 * @param classId Pass the current object as 'this'
	 */
	public synchronized static void logMethodExit(Object classId) {
		log.log(Level.INFO,"\n"+getDetails(classId));
	}
	
	/**
	 * Makes a log entry at the beginning of a constructor
	 * @param classId Pass the current object as 'this'
	 */
	public synchronized static void logConstructor(Object classId) {
		log.log(Level.INFO,"\n"+getDetails(classId));	
	}
	
	/**
	 * Make a log for a static method entry
	 * No parameter as there is no object created
	 */
	public synchronized static void logStaticMethodEntry() {
		log.log(Level.WARNING,"\nStatic method entry " + "\n");
	}
	
	/**
	 * Make a log for a static method exit
	 * No parameter as there is no object created
	 */
	public synchronized static void logStaticMethodExit() {
		log.log(Level.WARNING,"\nStatic method exit " + "\n");
	}
	
	/**
	 * This method sets up the external file handler
	 * @return Handler the file handler for the external file log
	 */
	private synchronized static Handler createExternalLogFile() {
		Handler handler = null;
		try {
		  fileOut = new FileHandler(System.getProperty("user.name") + "_logDetails.txt", true);
		  fileOut.setFormatter(new SimpleFormatter());
		  log.addHandler(fileOut);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return handler;
	}
	
	/**
	 * Returns most details for use in the logger
	 * @param classId The class passed to the logger
	 * @return String of all of the details produced by the logger
	 */
	private static String getDetails(Object classId) {
		return classId.getClass().getCanonicalName() + "\nRan from: " + System.getProperty("user.dir") + "\nRan by: " + System.getProperty("user.name") + "\nOS Details:" + System.getProperty("os.name") + " " + System.getProperty("os.arch") + "\nJava details:" + System.getProperty("java.version") + " " + System.getProperty("java.home") + "\n";
	}
	
	
	
}
