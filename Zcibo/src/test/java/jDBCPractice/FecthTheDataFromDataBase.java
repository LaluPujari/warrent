package jDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FecthTheDataFromDataBase {
	
	
	public static void main(String[] args) throws SQLException {
		
		Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "root");
		Statement statement = connection.createStatement();
		String Query="Select * From emp";
		ResultSet result = statement.executeQuery(Query);
		
		while(result.next()) {
			
			//System.out.println(result.getString(2)+"---"+result.getString(1)+"----"+result.getString(3));
			
			String name = result.getString(1);
			
			if(name.equalsIgnoreCase("lalu"))
			{
				System.out.println(name+":"+result.getString(3));
			}
	
			//System.out.println(row);
		}
		connection.close();
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
