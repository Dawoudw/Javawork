package dev.wsd.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DBConnectionUtil {
	private static Connection con = null;
	// final static String conString =
	// "jdbc:mariadb://bankdb-wael.c7w4umijvqtz.us-east-2.rds.amazonaws.com:3306/bankdb-wael?user=admin&password=Wsd_1981";

	public static Connection openCon() throws SQLException {
		try {
			Properties props = new Properties();
			Class.forName("org.mariadb.jdbc.Driver");
			FileInputStream in= new FileInputStream(DBConnectionUtil.class.getClassLoader().getResource("connection.properties").getFile());
		//	FileInputStream in = new FileInputStream("src/main/resources/connection.properties");
		

			props.load(in);
			//AWS Connection
			//String conString = props.getProperty("conString");
			//Local Connection
			String conString = props.getProperty("conStringLocal");
			
			con = DriverManager.getConnection(conString);
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		return null;
	}

}
