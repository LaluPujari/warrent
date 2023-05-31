package jDBCPractice;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoTheDB {

	public static void main(String[] args) throws SQLException  {
		Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","root");
		Statement statement = connection.createStatement();
		//String 	Quiery=" Insert into emp values('suresh', 400, '1999-01-20','banglore', 98748565,123)";
		//add/ update colume details 
		String 	Quiery="Update emp set birthplace='mgr' where id=101";
		
		int result = statement.executeUpdate(Quiery);
	
		boolean f= false;
		if(result==1)
		{
			
			System.out.println(" all data added successfully");
			f= true;
		}
	
		connection.close();
		

		
		
		
		
	}

}
