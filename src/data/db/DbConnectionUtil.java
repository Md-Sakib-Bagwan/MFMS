package data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnectionUtil {

	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String DB_UNAME = "root";
	private final static String DB_PASS = "root";

	private static Connection dbConnection;
	private static PreparedStatement statement;

	private final static String DB_NAME = "mf_investment_db";

	private static boolean isConnectionEstablished = false;
	private static boolean isConnectionClosed = false;

	public DbConnectionUtil() {
		if (!DbConnectionUtil.isConnectionEstablished) {
			openConnection();
			DbConnectionUtil.isConnectionEstablished = true;
		}
	}

	private void openConnection() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			DbConnectionUtil.dbConnection = DriverManager.getConnection(URL, DB_UNAME, DB_PASS);

			DbConnectionUtil.statement = getPreparedStatement("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
			DbConnectionUtil.statement.execute();

			DbConnectionUtil.statement = getPreparedStatement("USE " + DB_NAME);
			DbConnectionUtil.statement.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PreparedStatement getPreparedStatement(String QUERY) {
		try {
			DbConnectionUtil.statement = dbConnection.prepareStatement(QUERY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DbConnectionUtil.statement;
	}

	public void closeConnection() {
		try {
			if (!DbConnectionUtil.isConnectionClosed) {

				DbConnectionUtil.statement.close();
				DbConnectionUtil.dbConnection.close();

				DbConnectionUtil.isConnectionClosed = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}