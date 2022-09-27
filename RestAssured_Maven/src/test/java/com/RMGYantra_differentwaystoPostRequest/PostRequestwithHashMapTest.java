package com.RMGYantra_differentwaystoPostRequest;


import java.util.HashMap;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostRequestwithHashMapTest {
	@Test
	public void postRequestwithHashMapTest()
	{
		HashMap hp=new HashMap();
		hp.put("projectName","RestAssuredProjectwithHashmap");
		hp.put("createdBy","Sainadh");
		hp.put("status", "Created");
		hp.put("teamSize",20);
		
		given()
		.contentType(ContentType.JSON)
		.body(hp)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		

}
}