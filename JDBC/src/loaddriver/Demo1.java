package loaddriver;

public class Demo1
{

	public static void main(String[] args) throws ClassNotFoundException 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver successfully loaded");
	}

}
