package com.springbyexample.chapter1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageRunner {

    final static Logger logger = LoggerFactory.getLogger(MessageRunner.class);
    
    /**
     * Main method.
     */
    public static void main(String[] args) {
        logger.info("Initializing Spring context.");
        
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");
        
        logger.info("Spring context initialized.");

        SetterMessage message = (SetterMessage) applicationContext.getBean("message");

        logger.debug("message='" + message.getMessage() + "'");
    }

}
