package com.RMGYantra.Authentications;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Preemptive_Digestive {
	@Test
	public void premetive()
	{
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("http://localhost:8084/login")
		.then()
		.log()
		.all();
	}
	@Test
	public void digestive()
	{
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		.when()
		.get("http://localhost:8084/login")
		.then()
		.log()
		.all();
	}

}
