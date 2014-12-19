package third;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;

public class ThirdMain {

	private static Logger log = Logger.getLogger(ThirdMain.class);
	
	public static void main(String[] args) {
		log.info("System initialized");
		
		log.error("What a Terrible Failure!!!");
		
		log.debug("Hello from some hot developer, call XXX-XXXXXXXX");
		
		log.warn("We did survived WTF one more time...");
		
		try {
			new FileInputStream("asd");
			
		} catch (Exception e) {
			log.error("Cannot do anything!!!", e);
		}
	}
	
}
