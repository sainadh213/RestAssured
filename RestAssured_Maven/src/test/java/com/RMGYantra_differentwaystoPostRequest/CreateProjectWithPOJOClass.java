package com.RMGYantra_differentwaystoPostRequest;

import org.testng.annotations.Test;

import com.RMGYantraPOJOLibrary.POJO;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectWithPOJOClass {
	@Test
	public void createProjectWithPOJOClass()
	{
		POJO p=new POJO("sainadh","POjoClass23","created", 25);
		given()
		.contentType(ContentType.JSON)
		.body(p)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		   
	}
   
}
