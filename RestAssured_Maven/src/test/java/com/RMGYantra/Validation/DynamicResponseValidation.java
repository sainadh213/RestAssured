package com.RMGYantra.Validation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponseValidation {
	@Test
	public void dynamicValidation()
	{
		String exp="RestAssuredProjectwithBDD1";
		Response rsp = when().get("http://localhost:8084/projects");
		List<String> allp = rsp.jsonPath().get("projectName");
		for(String pro:allp)
		{
			if(pro.equals(exp))
			{
				System.out.println("Project name matched");
				break;
			}
		}
	}

}
