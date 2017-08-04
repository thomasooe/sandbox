package com.tom.patterns.adapter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;

public class ApacheCommonsLogAdapter extends Logger {
	private Log logger = new Log4JLogger("LoggerAdapter");
	@Override
	public void trace(String str) {
		logger.trace(str);
	}

	@Override
	public void debug(String str) {
		logger.debug(str);
	}

	@Override
	public void log(String str) {
		logger.info(str);
	}

}
