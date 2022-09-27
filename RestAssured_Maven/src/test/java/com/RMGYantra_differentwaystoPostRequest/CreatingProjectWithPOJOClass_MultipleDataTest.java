package com.RMGYantra_differentwaystoPostRequest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RMGYantraPOJOLibrary.POJO;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatingProjectWithPOJOClass_MultipleDataTest {
	@Test(dataProvider="mutlipleData")
	public void creatingProjectwith_MultipleDataTest(String createdBy, String projectName, String status, int teamSize)
	{
		POJO p=new POJO(createdBy,projectName,status,teamSize);
		given()
		.contentType(ContentType.JSON)
		.body(p)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.and()
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
	@DataProvider
	public Object mutlipleData()
	{
		Object obj [][]=new Object[2][4];
		obj[0][0]="sainadh";
		obj[0][1]="Pojo31";
		obj[0][2]="created";
		obj[0][3]=10;
		
		obj[1][0]="sainadh";
		obj[1][1]="Pojo41";
		obj[1][2]="created";
		obj[1][3]=60;
		return obj;
	}

}
