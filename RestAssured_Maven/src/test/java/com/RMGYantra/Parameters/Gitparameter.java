package com.RMGYantra.Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Gitparameter {
	@Test
	public void gitparameter()
	{
		
		given()
		.pathParam("username", "sainadh213")
		.queryParam("sort","creted")
		.when()
		.get("https://api.github.com/users/{username}/repos")
		.then()
		.log().all();
		
	}

}
