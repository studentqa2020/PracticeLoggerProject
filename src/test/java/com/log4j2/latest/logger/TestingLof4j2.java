package com.log4j2.latest.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestingLof4j2 {

	 private  final static Logger logger = LogManager.getLogger(TestingLof4j2.class);
	
	public static void main(String[] args) {
		System.out.println("Hi ALL");
		logger.info("this is info log ");
		logger.debug("This is debug log");
		logger.trace("This is trace log");
		logger.warn("This is warn log");
		logger.error("This is error log");
		logger.fatal("This is fatal log");
	}

}
