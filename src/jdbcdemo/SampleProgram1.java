package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class SampleProgram1 {
	@Test
	public void sampleTest() throws Throwable {
		//step 1: Register the driver /database
			Driver	driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
	 //step 2 : connect to sql statements
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "admin");
	//issue/ create sql statements
		   Statement stat = con.createStatement();
		   String query =" select * from students_info";
		   ResultSet result = stat.executeQuery(query);
		   while(result.next()) {
			   System.out.println(result.getInt(1) + "\t"+ result.getString(2) + "\t" + result.getString(3) );
		   }

	}

}
