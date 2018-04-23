package com.glb.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class PayloadConverter {

	private static Logger log = LogManager.getLogger(PayloadConverter.class.getName());
	
	public static String generatePayLoadsString(String filename) throws IOException {

		log.info("Inside PayLoadConverter file");
		String filepath = System.getProperty("user.dir") + "\\resources\\" + filename;
		
		try {
			return new String(Files.readAllBytes(Paths.get(filepath)));
		} catch (Exception e) {
			log.error(e);
		}
		return null;
		
	}
	
}
