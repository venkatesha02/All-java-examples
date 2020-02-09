package com.tyss.log4j;

import org.apache.log4j.Logger;

public class Demo {

	static Logger log = Logger.getLogger("dimple");
	
	public static void main(String[] args) {

		System.out.println("=-=-=-=-=-==-=-=-=-=-=-=-=- I am ready =-=-=-=-=-=-=-==-=-=-=-=");
		log.trace("I am a trace method");
		log.debug("I am a debug method");
		log.info("I am a info method");
		log.warn("I am a warn method");
		log.error("I am a error method");
		log.fatal("I am a fatal method");
		log.trace("I am killing my self");
	}

}
