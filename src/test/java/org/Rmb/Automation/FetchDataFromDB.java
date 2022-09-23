package org.Rmb.Automation;

import java.sql.SQLException;
import java.util.List;

import org.tyss.rmb.genericUtility.DataBaseUtility;
import org.tyss.rmb.genericUtility.IConstExternalPath;

public class FetchDataFromDB 
{
public static void main(String[] args) throws SQLException 
{
	DataBaseUtility dataBaseUtility=new DataBaseUtility();
	dataBaseUtility.openDBConnection(IConstExternalPath.DB_URL, "root", "root");
	List<String> data = dataBaseUtility.getDataFromDataBase("select *from openacc;", "name") ;
	System.out.println(data);
	dataBaseUtility.closeDBConnection();
}
}
