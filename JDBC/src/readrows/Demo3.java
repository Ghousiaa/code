package readrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class Demo3
{
	public static void main(String[] args) throws SQLException 
	{
		DriverManager.registerDriver(new OracleDriver());
		System.out.println("Driver Loaded");
		
		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "system");
		System.out.println("Connection Established successfully");
		
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery("select * from student");
		System.out.println("Query excuted successfuly");
		
		while(res.next()== true) 
		{
			String usn=res.getString("USN");
			String name = res.getString("NAME");
			int m1 = res.getInt("MARKS1");
			int m2 = res.getInt("MARKS2");
			int m3 = res.getInt("MARKS3");
			System.out.println(usn+" "+name+" "+m1+" "+m2+" "+m3);
		}
	}
}
