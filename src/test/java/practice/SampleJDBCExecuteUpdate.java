package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	@Test
	public void DBUpdate() throws SQLException
	{
		Connection con=null;
		try {
		Driver driverref=new Driver();
		//step 1:Register the driver
		DriverManager.registerDriver(driverref);
		//step 2: Get the connection
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root", "root");
		//step 3:issue create statement
		Statement query=con.createStatement();
		//update the data
		
		String query1="insert into qspider values('Abhishek',21,'New York');";
		
		int result=query.executeUpdate(query1);
		if(result>=1)
		{
			System.out.println("data added");
			
		}
		
		// Execute the query
		
		ResultSet res=query.executeQuery("select * from qspider;");
		while(res.next())
		{
			System.out.println(res.getString(1)+" "+res.getInt(2)+" "+res.getString(3));
			
		}
		}
		
		//step 5: close the database
		finally {
		con.close();
		System.out.println("db closed");
		}
		
		
		
	}
	

}
