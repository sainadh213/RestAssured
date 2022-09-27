package com.RMGYantra.RequestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class RequestChaining {
	@Test
	public void requestChainig()
	{
		Response resp = when().get("http://localhost:8084/projects");
		String proId = resp.jsonPath().get("[0].projectId");
		given()
		.pathParam("projectId", proId)
		.when()
		.delete("http://localhost:8084/projects/{projectId}")
		.then()
		.log().all();
		
	}

}
