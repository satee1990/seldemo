package com.fit.selmor;

import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class AppTest 
{
    private static final Logger logger = 
    		LogManager.getLogger(AppTest.class);

    @Test
    public void hello()
    {
    	System.out.println("ok");
    	logger.info("Information");
        logger.warn("Warning");
        logger.error("Error");
        logger.fatal("Fatal error");
        logger.debug("Debug");

    }
}
