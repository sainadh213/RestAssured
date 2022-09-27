package com.RMGYantra.RequestChaining;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class REquestChainingWithPOSTMethod {
	@Test
	public void requestChaining()
	{
		
		JSONObject jobj=new JSONObject();
		jobj.put("projectName","RequestChaing1");
		jobj.put("createdBy","Sainadh");
		jobj.put("status", "Created");
		jobj.put("teamSize",35);
		Response rsps = given()
				.contentType(ContentType.JSON)
				.body(jobj)
				.when()
				.post("http://localhost:8084/addProject");
		String proID = rsps.jsonPath().get("projectId");

		given()
		.pathParam("projID", proID)
		.when()
		.delete("http://localhost:8084/projects/{projID}")
		.then()
		.log()
		.all();
		
		
		
	}

}