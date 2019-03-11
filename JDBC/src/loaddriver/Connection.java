package loaddriver;



import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class Connection 
{
	public static void main(String[] args) throws SQLException 
	{
		DriverManager.registerDriver(new OracleDriver());
		System.out.println("Driver Loaded");
		Connection con= (Connection) DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.2:1521/XE", "system", "system");
		System.out.println("Connection Established successfully");
	}

}
