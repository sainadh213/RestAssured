package com.RMGYantra.EndtoEndScenarios;

import static io.restassured.RestAssured.*;

import java.sql.ResultSet;

import org.testng.annotations.Test;

import com.RMGYantra.GenericLibrary.BaseAPI;
import com.RMGYantra.GenericLibrary.Endpoints;
import com.RMGYantra.GenericLibrary.JavaUtil;
import com.RMGYantraPOJOLibrary.POJO;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEndScenario extends BaseAPI  {
	   
	  @Test
	public void endToEnd() throws Throwable
	{
		 baseURI="http://localhost";
		 port=8084;
		
	    JavaUtil javautil=new JavaUtil();
		POJO po= new POJO("Sainadh","EndToEndScenario"+javautil.getRandomNumber(),"Created",20);
		
		Response resp= given()
			    .contentType(ContentType.JSON)
			    .body(po)
			    .when()
			    .post(Endpoints.createProject);
			    resp.prettyPrint();
		       String proId = resp.jsonPath().get("projectId");
		    
		       Response resp2=  given()
		        .pathParam("project", proId)
				.when()
				.get(Endpoints.getProject+"/{project}");
		          resp2.prettyPrint();
				 String proName = resp2.jsonPath().get("projectName");
				System.out.println(proName);
			ResultSet result = dbs.createStament("select project_name from project where project_id='"+proId+"'");
				while(result.next())
				{
					if(proName.equals(result.getString(1)))
		           {
					System.out.println(proName+":Is available in DataBase");
					break;
				   }
				}
	}
}