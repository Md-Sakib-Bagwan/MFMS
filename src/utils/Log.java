package utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

	private final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void log(String message) {
		logger.log(Level.INFO, message);
	}
}
