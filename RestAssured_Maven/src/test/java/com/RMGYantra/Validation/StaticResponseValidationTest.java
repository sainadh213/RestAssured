package com.RMGYantra.Validation;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest {
	@Test
	public void staticResponce()
	{ 
		
		String exp="RestAssuredProjectwithBDD1";
		Response rsp = when().get("http://localhost:8084/projects");
		String act = rsp.jsonPath().get("[7].projectName");
		Assert.assertEquals(exp, act);
		
	}

}
