import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author rohan.sharma
 *
 *         Steps involved in JDBC
 * 
 *         1. Imprort the packages --> java.sql.*; 2. Load and register the
 *         driver --> com.mysql.jdbc.Driver 3. Create a connection -->
 *         Connection interface 4. Create a statement --> Statement interface 5.
 *         Execute the statement 6. process the result 7. Close the connection
 * 
 */

public class JDBCSteps {

	public static void main(String[] args) {

		String query = "select * from student";

		// Register the driver
		try {
			// Class.forName() --> Used to load the Driver class
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.getMessage();
			System.out.println("Exception Occurred: " + e.getMessage() + " for Exception Class: " + e.getClass());
		}

		Properties propObj = loadProperties();
		try {
			// Creating the connection
			Connection conn = DriverManager.getConnection(propObj.getProperty("URL"), propObj.getProperty("UserName"),
					propObj.getProperty("PassWord"));
			Statement stat = conn.createStatement();
			ResultSet res = stat.executeQuery(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Properties loadProperties() {

		try {
			FileInputStream file = new FileInputStream("/JDBCBasics/src/properties/JDBCDetails.properties");
			Properties prop = new Properties();
			prop.load(file);
			return prop;
		} catch (FileNotFoundException e) {
			System.out.println("Exception encountered: " + e.getMessage() + " Exception Class: " + e.getClass());
		} catch (IOException e) {
			System.out.println("Exception encountered: " + e.getMessage() + " Exception Class: " + e.getClass());

		}
		return null;

	}

}
