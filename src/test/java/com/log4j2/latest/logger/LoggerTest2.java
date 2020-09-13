package com.log4j2.latest.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest2 {

    private static final Logger log = LogManager.getLogger(LoggerTest2.class);
 
  public static void main(String[] args) {
	
    	//PropertyConfigurator.configure("Log4j.properties"); 
	  log.info("it is info");
	  log.trace("this is trace");
	  log.error("this is error");
	  log.warn("This is warn");
	  log.fatal("This is fatal");
    }
    
    
   
}