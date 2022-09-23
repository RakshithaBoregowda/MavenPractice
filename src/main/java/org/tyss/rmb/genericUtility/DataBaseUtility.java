
package org.tyss.rmb.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility 
{

	Connection connection;
	/**
	 * This method is used to open the Database connection 
	 * @param DBURL
	 * @param DBUserName
	 * @param DBPassword
	 * @throws SQLException
	 */
	public void openDBConnection(String DBURL, String DBUserName, String DBPassword) throws SQLException
	{
		Driver dbDriver=new Driver();
		DriverManager.registerDriver(dbDriver);
		connection = DriverManager.getConnection(DBURL, DBUserName, DBPassword);
	}
	/**
	 * This method is used to fetch the data from data base
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */
	public List<String> getDataFromDataBase(String query, String columnName) throws SQLException
	{

		Statement statement= connection.createStatement();
		ResultSet result = statement.executeQuery(query);

		List<String> list=new ArrayList<String>();
		while(result.next())
		{
			list.add(result.getString(columnName));
		}
		return list;
	}
	/**
	 * This method is used to close the database connection
	 * @throws SQLException
	 */
	public void closeDBConnection() throws SQLException
	{
		connection.close();
	}




}