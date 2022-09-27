package com.RMGYantra_CRUDwithBDD;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CompleUpdateTest {
	@Test
	public void completeUpdateTest()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("projectName","BDD213");
		jobj.put("createdBy","Sai");
		jobj.put("status", "Ongoing");
		jobj.put("teamSize",25);
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_803")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(200)
		.log().all();
	}

}
