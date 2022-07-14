package hashbrowns.p1.orm.utils;

import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	private static ConnectDB connDB;
	private Properties connectParams;

	static final String endpoint = "jdbc:postgresql://bankapp.cwhrhowdulyu.us-east-1.rds.amazonaws.com:5432/postgres",
			username = "postgres", password = "Q!w2e3r4t5";
	

	private ConnectDB() {
		/*
		connectParams = new Properties();

		InputStream propsFile = ConnectDB.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			connectParams.load(propsFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/

	};

	public static synchronized ConnectDB getConnectionDB() {
		
		if (connDB == null) {
			connDB = new ConnectDB();
		}
		
		return connDB;
	}

	public Connection getConnection() {

		Connection conn = null;
		
		/*
		String endpoint = connectParams.getProperty("db.url");
		String username = connectParams.getProperty("db.user");
		String password = connectParams.getProperty("db.password");
		 */
		//
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(endpoint, username, password);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;
	}

}
