package com.RMGYantra_CRUDwithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleProjectTest {
	@Test
	public void getSingleProjectTest()
	{
		when()
		.get("http://localhost:8084/projects/TY_PROJ_206")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(200)
		.log().all();
	}

}
