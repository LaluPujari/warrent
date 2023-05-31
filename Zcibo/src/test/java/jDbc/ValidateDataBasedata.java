package jDbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ValidateDataBasedata {

	public static void main(String[] args) throws SQLException {
		 String project = "cibo_warrent2";
		Connection connection=null;
		try
		{
		 Driver driver=new Driver();
		 DriverManager.registerDriver(driver);
		 connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from project");
		
		boolean f= false;
		while(result.next())
		{
			String data = result.getString(4);
			System.out.println(data);
			if(data.contains(project)) {
				System.out.println(project+" data is present");
				f= true;
				break;
			}
		}
		
		if(!f)
		{
		System.out.println("data is not present");
		}
		} finally {
			connection.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
