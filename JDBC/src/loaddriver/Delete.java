package loaddriver;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;

	import oracle.jdbc.driver.OracleDriver;

	public class Delete
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
			
			PreparedStatement pstmt = con.prepareStatement("delete from FEB where usn=?");
			pstmt.setString(1, usn);
			
			pstmt.executeUpdate();
			System.out.println("Row deleted");
		}
	}


