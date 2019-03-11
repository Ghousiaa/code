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

public class Insert
{
	public static void main(String[] args) throws SQLException 
	{
		DriverManager.registerDriver(new OracleDriver());
		System.out.println("Driver Loaded");

		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "system");
		System.out.println("Connection Established successfully");

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter USN: ");
		String usn=scan.next();
		System.out.print("Enter NAME: ");
		String name=scan.next();
		System.out.print("Enter MARKS1: ");
		int m1=scan.nextInt();
		System.out.print("Enter MARKS2: ");
		int m2=scan.nextInt();
		System.out.print("Enter MARKS3: ");
		int m3=scan.nextInt();

		PreparedStatement pstmt = con.prepareStatement("insert into FEB values(?,?,?,?,?)");
		pstmt.setString(1, usn);
		pstmt.setString(2, name);
		pstmt.setInt(3, m1);
		pstmt.setInt(4, m2);
		pstmt.setInt(5, m3);
		pstmt.executeQuery();
		System.out.println("Row added");
	}
}
