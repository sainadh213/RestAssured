package com.RMGYantra_CRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	@Test
	public void updateProject()
	{JSONObject jobj=new JSONObject();
	jobj.put("projectName","RestAssuredProject213");
	jobj.put("createdBy","Sainadh213");
	jobj.put("status", "Ongoing");
	jobj.put("teamSize",20);
	RequestSpecification rsp = RestAssured.given();
	rsp.contentType(ContentType.JSON);
	rsp.body(jobj);
	Response rs = rsp.put("http://localhost:8084/projects/TY_PROJ_803");
	ValidatableResponse vr = rs.then();
	vr.log().all();
	vr.assertThat().statusCode(200);
		 
	}

}
