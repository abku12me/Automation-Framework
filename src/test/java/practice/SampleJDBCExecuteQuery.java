package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	
 public static void main(String[] args) throws SQLException {
	 //configure the driver/drive from Mysql server
	 Driver driverref=new Driver();
	
	 //step 1: Register the Driver
	 DriverManager.registerDriver(driverref);
	 // step 2: get the connection
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium", "root", "root");
	 //step 3: issue create statement
	 Statement stmt=con.createStatement();
	 //step 4:Execute the query
	 ResultSet result=stmt.executeQuery("select * from selenium");
	 //we will get the data in the column wise
	 while(result.next())
	 {
		 System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));
	 }
	 
	 System.out.println("Below info from qspider table");
	 
	 ResultSet details=stmt.executeQuery("select * from qspider");
	 while(details.next())
	 {
		 System.out.println(details.getString(1)+" "+details.getInt(2)+" "+details.getString(3));
		 
	 }
	 
	 
	 //step 5:close the database
	 con.close();
	 System.out.println("DB closed");
	 
	 
}
	

}
