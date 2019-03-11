package readrows;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

public class Demo32
{
	public static void main(String[] args) throws SQLException 
	{
		DriverManager.registerDriver(new OracleDriver());
		System.out.println("Driver Loaded");

		Connection con= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "system", "system");
		System.out.println("Connection Established successfully");

		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery("select * from Feb");
		System.out.println("Query excuted successfuly");

		ResultSetMetaData meta = res.getMetaData();
		for(int i=1; i<=meta.getColumnCount(); i++)
		{
			System.out.println(meta.getColumnName(i)+" "+meta.getColumnTypeName(i));
		}

		System.out.println();

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
