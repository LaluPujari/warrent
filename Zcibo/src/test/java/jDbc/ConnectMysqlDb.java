package jDbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ConnectMysqlDb {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		try
		{
		 Driver driver=new Driver();
		 DriverManager.registerDriver(driver);
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myData","root","root");
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from emp");
		while(result.next())
		{
			System.out.print(result.getString(1)+"  ");
			System.out.print(result.getString(2)+" ");
			System.out.println(result.getString(3)+" ");
		}
		
		} finally {
			connection.close();
		}
	
	}

}
