package com.RMGYantra.Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	@Test
	public void pathParameter()
	{
		given()
		.pathParam("projectID","TY_PROJ_1006")
		.when()
		.get("http://localhost:8084/projects/{projectID}")
		.then()
		.log().all();
	}

}
