package data.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbSchema {

	public static final String USER_ACCOUNT_TABLE = "user_account";
	public static final String USER_MF_INVESTMENT_TABLE = "investment";

	private boolean isSchemaCreated = false;

	private static String QUERY;

	public DbSchema() {
		if (!isSchemaCreated) {
			createSchema();
			isSchemaCreated = true;
		}
	}

	private static void createSchema() {

		try {

			DbConnectionUtil dbConnectionUtil = new DbConnectionUtil();

			QUERY = "CREATE TABLE IF NOT EXISTS " + USER_ACCOUNT_TABLE + "(" 
					+ "username VARCHAR(50) NOT NULL,"
					+ "password VARBINARY(50) NOT NULL," 
					+ "login_pin VARBINARY(50) NOT NULL," 
					+ "PRIMARY KEY(username)"
					+ ")";
			PreparedStatement statement = dbConnectionUtil.getPreparedStatement(QUERY);
			statement.execute();

			QUERY = "CREATE TABLE IF NOT EXISTS " + USER_MF_INVESTMENT_TABLE + "(" 
					+ "username VARCHAR(50) NOT NULL,"
					+ "amc_name VARCHAR(50),"
					+ "fund_name VARCHAR(50)," 
					+ "invested_amount VARCHAR(50)," 
					+ "date_of_investment VARCHAR(50),"
					+ "balanced_units VARCHAR(50)," 
					+ "average_nav VARCHAR(50)," 
					+ "current_nav VARCHAR(50),"
					+ "investment_type VARCHAR(50)," 
					+ "folio_number INT(50) PRIMARY KEY," 
					+ "xirr VARCHAR(50),"
					+ "tenure_of_investments VARCHAR(50), " 
					+ "FOREIGN KEY (`username`) REFERENCES `" + DbSchema.USER_ACCOUNT_TABLE + "` (`username`)"
					+ ");";
			statement = dbConnectionUtil.getPreparedStatement(QUERY);
			statement.execute();
			
			QUERY = "CREATE TABLE IF NOT EXISTS sip_investments(fund_no int, principle int, tenure int)";
			statement = dbConnectionUtil.getPreparedStatement(QUERY);
			statement.execute();
			
			QUERY = "CREATE TABLE IF NOT EXISTS lumpsum_investments(fund_no int, principle int, tenure int)";
			statement = dbConnectionUtil.getPreparedStatement(QUERY);
			statement.execute();
			
			QUERY = "CREATE TABLE IF NOT EXISTS redeemed_funds(username VARCHAR(50), fund_no int)";
			statement = dbConnectionUtil.getPreparedStatement(QUERY);
			statement.execute();
			
			QUERY = "CREATE TABLE IF NOT EXISTS current_nav(fund_no int, nav int)";
			statement = dbConnectionUtil.getPreparedStatement(QUERY);
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
