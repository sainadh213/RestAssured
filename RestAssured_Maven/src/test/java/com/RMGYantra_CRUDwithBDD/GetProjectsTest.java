package com.RMGYantra_CRUDwithBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetProjectsTest {
	@Test
	public void getProjectsTest()
	{
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
		
		
	}
	

}
