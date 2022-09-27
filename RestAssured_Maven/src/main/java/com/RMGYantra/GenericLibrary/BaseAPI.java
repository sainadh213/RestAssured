package com.RMGYantra.GenericLibrary;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
public class BaseAPI {
	 public DatabaseUtil dbs=new DatabaseUtil();
	@BeforeSuite
	public void getConnection() throws Throwable
	{
		dbs.createConnection();
	}
	
	@AfterSuite
	public void closeConnection() throws Throwable
	{
		dbs.closeConnection();
	}
}