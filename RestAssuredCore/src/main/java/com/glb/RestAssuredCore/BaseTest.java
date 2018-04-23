package com.glb.RestAssuredCore;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.glb.Utils.PayloadConverter;
import com.glb.Utils.TestUtils;
import com.glb.Utils.URL;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseTest {
	
	private static Logger log = LogManager.getLogger(BaseTest.class.getName());
	
	public static String doLogin() throws Exception {
		
		Response response;
		log.info("Stating Test Cases: doTest");
		String LoginPayload = PayloadConverter.generatePayLoadsString("JiraLogin.json");
		
		String endPointURI = URL.getEndPoint("/rest/auth/1/session");
		response = RESTCalls.POSTRequest(endPointURI, LoginPayload);
		log.info(response.getBody().asString());
		
		String strResponse = TestUtils.getResponseString(response);
		
		JsonPath jsonlogin = TestUtils.JsonParse(strResponse);
		String sessionID = jsonlogin.get("session.value");
		log.info("JIRA JSession ID" +sessionID);
		return sessionID;
	}

}
