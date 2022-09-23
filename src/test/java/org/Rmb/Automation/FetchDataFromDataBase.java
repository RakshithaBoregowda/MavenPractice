package org.Rmb.Automation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * This class is used to fetch the data from the database
 * @author Rakshitha
 *
 */
public class FetchDataFromDataBase 
{
public static void main(String[] args) throws SQLException 
{
	//Step1: create the object for driver
	Driver dbdriver=new Driver();
	
	//Step2: register the driver instance to the jdbc
	DriverManager.registerDriver(dbdriver);

	//Step3: get/establish the database connection
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
	try {
	//Step4: create the statement 
	Statement statement= connection.createStatement();
	
	//Step5:Execute the query
    ResultSet result = statement.executeQuery("select* from openacc");
	
    //step6: verify /iterate/fetch the data
    while(result.next())
{
	System.out.println(result.getString(1)+","+result.getInt(3));
}
}
finally 
{
connection.close();
}
}}