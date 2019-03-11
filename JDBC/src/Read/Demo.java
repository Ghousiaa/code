package Read;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class Demo
{
	public static void main(String[] args) throws SQLException 
	{
		DriverManager.registerDriver(new OracleDriver());
		System.out.println("Driver Loaded");

		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "system");
		System.out.println("Connection Established successfully");

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter USN: ");
		String temp=scan.next();

		PreparedStatement pstmt = con.prepareStatement("select * from Feb where usn=?");
		pstmt.setString(1, temp);
		ResultSet res = pstmt.executeQuery();

		while(res.next()== true) 
		{
			String usn=res.getString(1);
			String name = res.getString(2);
			int m1 = res.getInt(3);
			int m2 = res.getInt(4);
			int m3 = res.getInt(5);
			System.out.println(usn+" "+name+" "+m1+" "+m2+" "+m3);
		}
	}
}

