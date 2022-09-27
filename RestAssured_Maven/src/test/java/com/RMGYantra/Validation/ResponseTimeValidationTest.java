package com.RMGYantra.Validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidationTest {
	@Test
	public void responseTimeTest()
	{
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().time(Matchers.lessThan(500L),TimeUnit.SECONDS)
		.assertThat().body("[7].projectName",Matchers.equalTo("RestAssuredProjectwithBDD1"))
		.log().all();
		
	}

}
