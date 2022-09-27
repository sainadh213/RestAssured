package com.RMGYantra_CRUDwithBDD;

import org.json.simple.JSONObject;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class CreateProjectTest {
	@Test
	public void createProject()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("projectName","RestAssuredProjectwithBDD");
		jobj.put("createdBy","Sainadh213");
		jobj.put("status", "Created");
		jobj.put("teamSize",14);
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}

}
