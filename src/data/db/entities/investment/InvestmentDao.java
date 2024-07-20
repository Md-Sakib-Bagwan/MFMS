package data.db.entities.investment;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.db.DbConnectionUtil;
import data.db.DbSchema;
import data.db.entities.user.User;
import utils.Log;

public class InvestmentDao {
	private static String QUERY;

	private static DbConnectionUtil dbConnectionUtil;
	private PreparedStatement statement;

	private int resultCode;

	private static String CLASS;

	public InvestmentDao() {
		dbConnectionUtil = new DbConnectionUtil();
		CLASS = this.getClass().getSimpleName();
	}

	public int addInvestmentItem(InvestmentItem investmentItem) {

		QUERY = "INSERT INTO " + DbSchema.USER_MF_INVESTMENT_TABLE + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		statement = dbConnectionUtil.getPreparedStatement(QUERY);

		try {

			statement.setString(1, investmentItem.username);
			statement.setString(2, investmentItem.amcName);
			statement.setString(3, investmentItem.fundName);
			statement.setString(4, investmentItem.investedAmount);
			statement.setString(5, investmentItem.dateOfInvestment);
			statement.setString(6, investmentItem.balancedUnit);
			statement.setString(7, investmentItem.averageNav);
			statement.setString(8, investmentItem.currentNav);
			statement.setString(9, investmentItem.investmentType);
			statement.setInt(10, investmentItem.folioNumber);
			statement.setString(11, investmentItem.xirr);
			statement.setString(12, investmentItem.tenureOfInvestment);

			synchronized (this) {
				resultCode = statement.executeUpdate();

				if (investmentItem.investmentType.equals("SIP")) {
					QUERY = "INSERT INTO sip_investments VALUES(?, ?, ?)";
					statement = dbConnectionUtil.getPreparedStatement(QUERY);
					statement.setInt(1, investmentItem.folioNumber);
					statement.setString(2, investmentItem.investedAmount);
					statement.setString(3, investmentItem.tenureOfInvestment);
					statement.executeUpdate();
				}

				if (investmentItem.investmentType.equals("Lumpsum")) {
					QUERY = "INSERT INTO lumpsum_investments VALUES(?, ?, ?)";
					statement = dbConnectionUtil.getPreparedStatement(QUERY);
					statement.setInt(1, investmentItem.folioNumber);
					statement.setString(2, investmentItem.investedAmount);
					statement.setString(3, investmentItem.tenureOfInvestment);
					statement.executeUpdate();
				}
			}

		} catch (SQLException e) {
			resultCode = e.getErrorCode();
			e.printStackTrace();
		}

		return resultCode;
	}

	public int countOfInvestmentItems(User user) {
		ResultSet resultSet;
		try {
			QUERY = "SELECT COUNT(*) FROM " + DbSchema.USER_MF_INVESTMENT_TABLE + " WHERE username = ?";
			statement = dbConnectionUtil.getPreparedStatement(QUERY);
			statement.setString(1, user.username);
			resultSet = statement.executeQuery();

			resultSet.next();
			return resultSet.getInt(1);
		} catch (Exception e) {

		}

		return 0;
	}

	public ArrayList<InvestmentItem> getInvestmentItems(User user) {

		ResultSet resultSet;

		try {

			// query to get username
			QUERY = "SELECT * FROM " + DbSchema.USER_MF_INVESTMENT_TABLE + " WHERE username = ?";
			statement = dbConnectionUtil.getPreparedStatement(QUERY);
			statement.setString(1, user.username);
			Log.log(CLASS + " " + user.username);
			resultSet = statement.executeQuery();

			int numberOfInvestments = countOfInvestmentItems(user);
			Log.log(CLASS + " " + numberOfInvestments);
			ArrayList<InvestmentItem> investmentItemResult = new ArrayList<InvestmentItem>();

			resultSet.next();

			for (int i = 0; i < numberOfInvestments; i++) {

				String amcName = resultSet.getString(2);
				String addInvestmentItem = resultSet.getString(3);
				String investedAmount = resultSet.getString(4);
				String dateOfInvestment = resultSet.getString(5);
				String balancedUnit = resultSet.getString(6);
				String averageNav = resultSet.getString(7);
				String currentNav = resultSet.getString(8);
				String investmentType = resultSet.getString(9);
				int folioNumber = resultSet.getInt(10);
				String xirr = resultSet.getString(11);
				String tenureOfInvestment = resultSet.getString(12);

				// store the Investment Item
				investmentItemResult.add(new InvestmentItem("", amcName, addInvestmentItem, investedAmount,
						dateOfInvestment, balancedUnit, averageNav, currentNav, investmentType, folioNumber, xirr,
						tenureOfInvestment));

				resultSet.next();
			}

			// return the result
			return investmentItemResult;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int updateInvestment(InvestmentItem investmentItem) {

		int resultSet;

		try {

			// query to update investment Item
			QUERY = "UPDATE " + DbSchema.USER_MF_INVESTMENT_TABLE
					+ " SET amc_name = ?, fund_name = ?, invested_amount = ?, date_of_investment = ?, "
					+ "balanced_units = ?, average_nav = ?, current_nav = ?, investment_type = ?, xirr = ?,"
					+ " tenure_of_investments = ? WHERE username = ? AND folio_number = ?";

			statement = dbConnectionUtil.getPreparedStatement(QUERY);

			synchronized (this) {
				statement.setString(1, investmentItem.amcName);
				statement.setString(2, investmentItem.fundName);
				statement.setString(3, investmentItem.investedAmount);
				statement.setString(4, investmentItem.dateOfInvestment);
				statement.setString(5, investmentItem.balancedUnit);
				statement.setString(6, investmentItem.averageNav);
				statement.setString(7, investmentItem.currentNav);
				statement.setString(8, investmentItem.investmentType);
				statement.setString(9, investmentItem.xirr);
				statement.setString(10, investmentItem.tenureOfInvestment);
				statement.setString(11, investmentItem.username);
				statement.setInt(12, investmentItem.folioNumber);

				// return the result
				resultCode = statement.executeUpdate();

				if (investmentItem.investmentType.equals("SIP")) {
					QUERY = "UPDATE sip_investments SET fund_no = ?, principle = ?, tenure = ?";
					statement = dbConnectionUtil.getPreparedStatement(QUERY);
					statement.setInt(1, investmentItem.folioNumber);
					statement.setString(2, investmentItem.investedAmount);
					statement.setString(3, investmentItem.tenureOfInvestment);
					statement.executeUpdate();
				}

				if (investmentItem.investmentType.equals("Lumpsum")) {
					QUERY = "UPDATE lumpsum_investments SET fund_no = ?, principle = ?, tenure = ?";
					statement = dbConnectionUtil.getPreparedStatement(QUERY);
					statement.setInt(1, investmentItem.folioNumber);
					statement.setString(2, investmentItem.investedAmount);
					statement.setString(3, investmentItem.tenureOfInvestment);
					statement.executeUpdate();
				}
			}

			Log.log(CLASS + String.valueOf(resultCode == 2));

		} catch (SQLException e) {
			resultCode = e.getErrorCode();
			e.printStackTrace();
		}

		return resultCode;
	}

	public int deleteInvestment(InvestmentItem investmentItem) {

		try {

			// query to update investment Item
			QUERY = "DELETE FROM " + DbSchema.USER_MF_INVESTMENT_TABLE + " WHERE username = ? AND folio_number = ?";

			statement = dbConnectionUtil.getPreparedStatement(QUERY);

			synchronized (this) {
				statement.setString(1, investmentItem.username);
				statement.setInt(2, investmentItem.folioNumber);

				// return the result
				resultCode = statement.executeUpdate();

				if (investmentItem.investmentType.equals("SIP")) {
					QUERY = "DELETE FROM sip_investments WHERE fund_no = ?";
					statement = dbConnectionUtil.getPreparedStatement(QUERY);
					statement.setInt(1, investmentItem.folioNumber);
					statement.executeUpdate();
				}

				if (investmentItem.investmentType.equals("Lumpsum")) {
					QUERY = "DELETE FROM lumpsum_investments WHERE fund_no = ?";
					statement = dbConnectionUtil.getPreparedStatement(QUERY);
					statement.setInt(1, investmentItem.folioNumber);
					statement.executeUpdate();
				}

				QUERY = "INSERT INTO redeemed_funds VALUES(?, ?)";
				statement = dbConnectionUtil.getPreparedStatement(QUERY);
				statement.setString(1, investmentItem.username);
				statement.setInt(2, investmentItem.folioNumber);
				statement.executeUpdate();
			}

			Log.log(CLASS + String.valueOf(resultCode == 2));

		} catch (SQLException e) {
			resultCode = e.getErrorCode();
			e.printStackTrace();
		}

		return resultCode;
	}
}
