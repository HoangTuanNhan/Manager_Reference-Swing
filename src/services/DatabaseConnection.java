package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

	Connection conn;

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Connection getConn() {
		return conn;
	}

	public String connectDatabase(String host, String port, String dbname, String user, String pwd) {
		conn = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
		}

		try {
			String url = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + dbname;

			conn = DriverManager.getConnection(url, user, pwd);

			return "Connected successful!";

		} catch (SQLException e) {

			return "Eror : " + e.toString();
		}

	}
}
