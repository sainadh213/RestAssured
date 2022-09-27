package com.RMGYantra.Authentications;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BarerToken {
	@Test
	public void barerToken()
	{
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.log()
		.all();
	}

}
