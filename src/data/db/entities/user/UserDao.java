package data.db.entities.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.db.DbConnectionUtil;
import data.db.DbSchema;

public class UserDao {

	private static String QUERY;

	private static DbConnectionUtil dbConnectionUtil;
	private PreparedStatement statement;
	private ResultSet resultSet;

	private int resultCode;

	public UserDao() {
		dbConnectionUtil = new DbConnectionUtil();
	}

	public int addUser(User user) {

		QUERY = "INSERT INTO " + DbSchema.USER_ACCOUNT_TABLE + " VALUES(?, AES_ENCRYPT(?, ?), AES_ENCRYPT(?, ?))";

		statement = dbConnectionUtil.getPreparedStatement(QUERY);

		try {

			statement.setString(1, user.username);
			statement.setString(2, user.password);
			statement.setString(3, user.username);
			statement.setString(4, user.loginPin);
			statement.setString(5, user.username);

			resultCode = statement.executeUpdate();

		} catch (SQLException e) {
			resultCode = e.getErrorCode();
			e.printStackTrace();
		}

		return resultCode;
	}

	public User getUser(User user) {

		try {

			// query to get username
			QUERY = "SELECT * FROM " + DbSchema.USER_ACCOUNT_TABLE + " WHERE username = ?";
			statement = dbConnectionUtil.getPreparedStatement(QUERY);
			statement.setString(1, user.username);
			resultSet = statement.executeQuery();
			resultSet.next();

			// store the username
			User userResult = new User();
			userResult.username = resultSet.getString(1);

			// query to get the password
			QUERY = "SELECT CAST(AES_DECRYPT(password, ?) AS CHAR) FROM " + DbSchema.USER_ACCOUNT_TABLE
					+ " WHERE username = ?";
			statement = dbConnectionUtil.getPreparedStatement(QUERY);
			statement.setString(1, user.username);
			statement.setString(2, user.username);
			resultSet = statement.executeQuery();
			resultSet.next();

			// store the password
			userResult.password = resultSet.getString(1);

			// query to get the login_pin
			QUERY = "SELECT CAST(AES_DECRYPT(login_pin, ?) AS CHAR) FROM " + DbSchema.USER_ACCOUNT_TABLE
					+ " WHERE username = ?";
			statement = dbConnectionUtil.getPreparedStatement(QUERY);
			statement.setString(1, user.username);
			statement.setString(2, user.username);
			resultSet = statement.executeQuery();
			resultSet.next();

			// store the login_pin
			userResult.loginPin = resultSet.getString(1);

			// return the result
			return userResult;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}