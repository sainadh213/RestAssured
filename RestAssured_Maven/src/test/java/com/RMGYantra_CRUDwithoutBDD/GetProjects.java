package com.RMGYantra_CRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;

public class GetProjects {
	@Test
	public void getProjects()
	{
		Response rt = RestAssured.get("http://localhost:8084/projects");
		//rt.prettyPrint();
		ValidatableResponse vr = rt.then();
		vr.assertThat().statusCode(200);
		vr.assertThat().contentType(ContentType.JSON);
		vr.log().all();
		
		
	}
	
	

}
