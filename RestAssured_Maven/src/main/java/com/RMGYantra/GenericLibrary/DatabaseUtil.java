package com.RMGYantra.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtil {
	
	public Connection con=null;
	
	public void createConnection() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		
	}
	public ResultSet createStament(String query) throws Throwable
	{
		Statement st = con.createStatement();
	ResultSet result = st.executeQuery(query);
	return result;
	}
	public void closeConnection() throws Throwable
	{
		con.close();
	}

}
