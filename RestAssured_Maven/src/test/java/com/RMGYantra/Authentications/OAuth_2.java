package com.RMGYantra.Authentications;

import org.testng.annotations.Test;


import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth_2 {
	@Test 
	public void oAuth2()
	{
		Response resp = given()
		.formParam("client_id", "SDET_6_SN")
		.formParam("client_secret", "3b0237daa4d5c0ba7359c5aee56cc191")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://example.com")
		.post("http://coop.apps.symfonycasts.com/token");
		resp.prettyPrint();
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 3270)
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then()
		.log()
		.all();


}
}