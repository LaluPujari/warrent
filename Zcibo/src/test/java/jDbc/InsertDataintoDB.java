package jDbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataintoDB {

	public static void main(String[] args) throws SQLException {
		
		 Connection connection = null;
		  String project = "cibo_warrent22";
			
		  try {
				Driver driver = new Driver();
				DriverManager.registerDriver(driver);
				connection=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
				Statement statement = connection.createStatement();
				
				String Query = "insert  into project values('TY_PROJ_1288','LALAPPA','11-05-2023','"+project+"','on going', 3)";
				int result = statement.executeUpdate(Query);
				if(result==1)
				{
					System.out.println("data added");
				} else {
					System.out.println("not added");
				}
		  }
		  
				finally {
					connection.close();
				}
		  
		  
		
		
		
		
		

	}

}
