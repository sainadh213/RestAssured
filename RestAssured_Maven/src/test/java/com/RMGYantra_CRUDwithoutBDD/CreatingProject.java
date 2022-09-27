package com.RMGYantra_CRUDwithoutBDD;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreatingProject {
	@Test
	public void createProject()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("projectName","RestAssuredProject");
		jobj.put("createdBy","Sainadh213");
		jobj.put("status", "Created");
		jobj.put("teamSize",14);
		RequestSpecification rsp = RestAssured.given();
		rsp.contentType(ContentType.JSON);
		rsp.body(jobj);
		Response rs = rsp.post("http://localhost:8084/addProject");
		ValidatableResponse vr = rs.then();
		vr.log().all();
		vr.assertThat().statusCode(201);
	
		
	}

	
}
