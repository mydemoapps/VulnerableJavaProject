import java.sql.*;
import java.io.*;

public class Demo {

	public static void main(String arg[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection conn=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/demo?characterEncoding=utf8","AppSecUser","AppSec"); 
			
			
			System.out.print("Enter employee ID: ");
			
			BufferedReader r = new BufferedReader (new InputStreamReader(System.in));
			String empID = r.readLine();
			
			if (!empID.contains("emp"))
				System.out.println("Employee ID begins with emp e.g., emp01.");
			
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from employees where empID='" + empID +"'");

			while(rs.next())
			{
				System.out.println(rs.getString("empID") + " " + rs.getString("empName") + 
						" " + rs.getString("dept"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
