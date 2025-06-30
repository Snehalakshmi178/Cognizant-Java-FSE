package Junit.SL4J;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SL4Jc {
	
	private static final Logger logger = LoggerFactory.getLogger(SL4Jc.class);
	public static void main(String[] args) {
	logger.error("This is an error message");
	logger.warn("This is a warning message");
	}
	

}
