package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import org.testng.annotations.Test;
import com.mysql.jdbc.Driver;
public class SampleProgram2 {
	Connection con;
	@Test
	public void sampleTest() throws Throwable {
		
		try {
			//connection con = null;;
			Driver	driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "admin");
	
		   Statement stat = con.createStatement();
		   String query =" insert into students_info (regno, firstName, middleName, lastName) values('7', 'hentry','raj', 'h');";
		   int result = stat.executeUpdate(query);
		 if(result == 1) {
			 System.out.println("updated");
		 }
		}
		 catch (Exception e) {
			 System.err.println("not updated");
		 }
		finally {
			con.close();
		}
	}
}
