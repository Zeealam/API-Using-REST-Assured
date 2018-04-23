package com.glb.Utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class TestUtils {

	
	private static Logger log = LogManager.getLogger(TestUtils.class.getName());
	
	public static String getResponseString(Response response) {
		log.info("Converting Response To String.");
		String strResponse = response.getBody().asString();
		log.debug(strResponse);
		return strResponse;		
	}
	
	public static JsonPath JsonParse(String response) {
		log.info("Parsing String Response To Json.");
		JsonPath jsonResponse = new JsonPath(response);
		log.debug(jsonResponse);
		return jsonResponse;
	}
	
	public static XmlPath XmlParse(String response) {
		log.info("Parsing String Response To Json");
		XmlPath XmlResponse = new XmlPath(response);
		log.debug(XmlResponse);
		return XmlResponse;
	}
	
	public static int getStatusCode(Response response) {
		log.info("Getting Response Status Code");
		int statusCode=response.statusCode();
		log.debug(statusCode);
		return statusCode;
	}
	
	public static String getStatusMessage(Response response) {
		log.info("Getting Response Status Message");
		String responseMessage = response.getStatusLine();
		log.debug(responseMessage);
		return responseMessage;
		
	}
}
