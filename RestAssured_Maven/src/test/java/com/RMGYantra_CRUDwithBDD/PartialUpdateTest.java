package com.RMGYantra_CRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class PartialUpdateTest {
	@Test
	public void partialUpdateTest()
	{
	JSONObject jobj=new JSONObject();
	
	jobj.put("projectName","RestAssuredProject213");
	jobj.put("createdBy","Sainadh2130");
	jobj.put("status", "Ongoing");
	jobj.put("teamSize",30);
	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
	.patch("https://reqres.in/api/users/2")
	.then()
	.assertThat().contentType(ContentType.JSON)
	.assertThat().statusCode(200)
	.log().all();
	

}
}