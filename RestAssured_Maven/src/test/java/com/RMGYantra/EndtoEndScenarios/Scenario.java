package com.RMGYantra.EndtoEndScenarios;

import static io.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario {
	@Test
	public void scenario_1() throws Throwable
	{
		JSONObject jobj=new JSONObject();
		jobj.put("projectName","EndtoEndScenario_4");
		jobj.put("createdBy","Sainadh");
		jobj.put("status", "Created");
		jobj.put("teamSize",25);
	Response resp = given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject");
	resp.prettyPrint();
	   String proname = resp.jsonPath().get("projectName");
	   String proid=resp.jsonPath().get("projectId");
	   System.out.println("Project Id : "+proid);
	   System.out.println("In RMGYantra :"+proname);
   given()
	.pathParam("prid",proid)
	.when()
	.get("http://localhost:8084/projects/{prid}")
	.then()
	.assertThat().statusCode(200)
	.assertThat().contentType(ContentType.JSON)
	.log().all();
	
	
	
		Connection con=null;
		try {
			//Step-1 Register to Driver
			
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			
			//Step-2 Connect to DataBase
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");

			//Step-3 Create a Statement
			
			Statement stat = con.createStatement();
			
			//Step-4 Execute the Query
			
			ResultSet result = stat.executeQuery("select project_name from project where project_id='"+proid+"'");
			while(result.next())
			{
				String prname = result.getString(1);
			
				System.out.println("In DATABASE :"+prname);
			
				Assert.assertEquals(proname, prname);
				System.out.println("Project Added in database");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			//Step-5 Close Connection
			
			con.close();
			
		}
		}
		}
	


