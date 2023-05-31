package jDbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataintoMySql {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		
   try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myData","root","root");
		Statement statement = connection.createStatement();
		
		String Query = "insert  into emp values('pujari',103,'1999-09-10')";
		int result = statement.executeUpdate(Query);
		
		if(result==1)
		{
			System.out.println("data added");
		}
		else
		{
			System.out.println("data not added");
		}
	}
   finally {
	   
	   connection.close();
   }
   

}
}
