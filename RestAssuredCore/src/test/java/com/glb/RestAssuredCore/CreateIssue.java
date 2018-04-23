package com.glb.RestAssuredCore;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.glb.Utils.PayloadConverter;
import com.glb.Utils.URL;

import io.restassured.response.Response;

public class CreateIssue {

	private String sessionID;
	Response response;

	private static Logger log = LogManager.getLogger(CreateIssue.class.getName());

	@BeforeMethod
	public void setUp() throws Exception {

		sessionID= BaseTest.doLogin();
	}

	@Test
	public void createIssue() throws Exception {
		log.info("Starting Creating Issue.");
		String URI = URL.getEndPoint("/rest/api/2/issue/");
		String createIssuePayload = PayloadConverter.generatePayLoadsString("CreatingBug.json");
		response = RESTCalls.POSTRequest(URI, createIssuePayload, sessionID);
		
		BaseAssertions.verifyStatusCode(response, 201);

	}

}
