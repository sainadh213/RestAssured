package com.RMGYantra_CRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.AuthenticationSpecification;
import io.restassured.specification.RequestSpecification;

public class PartialUpdate {
	@Test
	public void partialUpdateProject()
	{
		JSONObject jobj=new JSONObject();
		
	jobj.put("projectName","RestAssuredProject213");
	jobj.put("createdBy","Sainadh213");
	jobj.put("status", "Ongoing");
	jobj.put("teamSize",30);
	RequestSpecification rsp = RestAssured.given();
	rsp.contentType(ContentType.JSON);
	rsp.body(jobj);
	Response res = rsp.patch("https://reqres.in/api/users/2");
	//Response rs = rsp.patch("http://localhost:8084/projects/TY_PROJ_803");
	ValidatableResponse vr = res.then();
	vr.log().all();
	vr.assertThat().statusCode(200);
	
		
	}

}
