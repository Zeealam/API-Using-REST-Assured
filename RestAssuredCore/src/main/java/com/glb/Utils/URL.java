package com.glb.Utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class URL {
	
	private static Logger log = LogManager.getLogger(URL.class.getName());
	public static final String URL = "http://localhost:8080";
	
	public static String getEndPoint() {
		log.info("Base URI :"+URL);
		return URL;
	}
	
	public static String getEndPoint(String resources) {
		log.info("URI End Point:" +URL+ resources);
		return URL + resources;
	}

}
