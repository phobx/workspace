import java.io.IOException;
import java.util.logging.*;

public class LogTester {
	public static void main(String[] args) {
		
		new LogTester().logTesting();
		
	}
	
	public void logTesting() {//LogManager lm = LogManager.getLogManager();
		Logger logger = Logger.getLogger("LogTester");
		
		logger.setLevel(Level.FINE);
		logger.setUseParentHandlers(false);
		
		Handler chandler = new ConsoleHandler();
		chandler.setLevel(Level.FINE);
		logger.addHandler(chandler);
		
		try {
			Handler fhandler = new FileHandler();
			logger.addHandler(fhandler);
		} catch (SecurityException e) {
			logger.log(Level.FINE, e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			logger.log(Level.FINE, e.toString());
			e.printStackTrace();
		}
		
		logger.log(Level.FINE,"==marker==");
		
		System.out.println(logger.getLevel().toString());
		
		
	}
}
