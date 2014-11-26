import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogTester {
	public static void main(String[] args) {
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

		logger.log(Level.FINE, "==marker==");

		System.out.println(logger.getLevel().toString());

	}
}
