package jDBCPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DeletTheRowFromDBtable {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","root");
		
		Statement statment = connection.createStatement();
		String qurie="Alter table emp Drop COLUMN telephone2";
	//	ResultSet result = statment.executeQuery(qurie);
		int result = statment.executeUpdate(qurie);
		
		if(result==1) {
	
			
			System.out.println(" deleted successfully ");
	
		{
		
		}
		connection.close();

	}

	}
}
