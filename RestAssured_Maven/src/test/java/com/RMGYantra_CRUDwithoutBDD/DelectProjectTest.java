package com.RMGYantra_CRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DelectProjectTest {
	@Test
	public void deleteProjectTest()
	{
	Response rt = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_402");
	//rt.prettyPrint();

	ValidatableResponse vr = rt.then();
	vr.assertThat().statusCode(204);
	vr.assertThat().contentType(ContentType.JSON);
	vr.log().all();
}
}