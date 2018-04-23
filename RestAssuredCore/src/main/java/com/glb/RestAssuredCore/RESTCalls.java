package com.glb.RestAssuredCore;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RESTCalls {

	// This class will be responsible to fire request.

	private static Logger log = LogManager.getLogger(RESTCalls.class.getName());



	public static Response GETRequest(String URL) {

		log.info("Inside GETRequest call");
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(URL);
		log.debug(requestSpecification.log().all());
		return response;

	}

	public static Response POSTRequest(String URL, String strJSON) {

		log.info("Inside GETRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);

		Response response = requestSpecification.post(URL);
		log.debug(requestSpecification.log().all());
		return response;

	}

	public static Response POSTRequest(String URL, String strJSON, String sessionID) {

		log.info("Inside GETRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("cookie", "JSESSIONID=" + sessionID + "");
		Response response = requestSpecification.post(URL);
		log.debug(requestSpecification.log().all());
		return response;

	}

	public static Response PUTRequest(String URL, String strJSON) {

		log.info("Inside GETRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);

		Response response = requestSpecification.put(URL);
		log.debug(requestSpecification.log().all());
		return response;
	}

	public static Response DELETERequest(String URL, String strJSON) {

		log.info("Inside GETRequest call");
		RequestSpecification requestSpecification = RestAssured.given().body(strJSON);
		requestSpecification.contentType(ContentType.JSON);

		Response response = requestSpecification.delete(URL);
		log.debug(requestSpecification.log().all());
		return response;
	}

}
