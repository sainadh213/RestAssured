package com.RMGYantra_differentwaystoPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateProjectWithJSONFile {
	@Test
	public void createProjectWithJSONFile()
	{
		
		File fi=new File("./Sample.json");
		given()
		.contentType(ContentType.JSON)
		.body(fi)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
	}

}
