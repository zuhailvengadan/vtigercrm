package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class readFromDataBase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		//step1;;create an instance of jdbc driver
		Driver jdDriver=new Driver();
		//step 2;;register driver
		DriverManager.registerDriver(jdDriver);
		//step 3;;Establish database connection
		Connection connection=DriverManager.getConnection("Jdbc:mysql://localhost:3306/jdbc830","root","root");
		//step 4;;create statement
		Statement statement=connection.createStatement();
		//step 5;;execute query to fetch data
		ResultSet result=statement.executeQuery("select * from employee;");
		
		while (result.next()) {
			System.out.println(result.getInt("empID")+"\t"+result.getString("name"));
		}
		//step 6;; close statement
		connection.close();
	}

}
