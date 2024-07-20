package model;

import java.util.ArrayList;

import contracts.InvestmentsDashboardContract;
import data.db.entities.investment.InvestmentDao;
import data.db.entities.investment.InvestmentItem;
import data.db.entities.user.User;

public class InvestmentsDashboardModel implements InvestmentsDashboardContract.InvestmentsDashboardModel {

	InvestmentDao investmentDao = new InvestmentDao();

	@Override
	public int addInvestmentItem(InvestmentItem investmentItem) {

		int resultCode = investmentDao.addInvestmentItem(investmentItem);

		return resultCode;
	}

	@Override
	public ArrayList<InvestmentItem> getInvestmentItems(User user) {

		ArrayList<InvestmentItem> investmentItems = investmentDao.getInvestmentItems(user);

		return investmentItems;
	}

	@Override
	public int updateInvestment(InvestmentItem investmentItem) {

		int resultCode = investmentDao.updateInvestment(investmentItem);

		return resultCode;
	}

	@Override
	public int deleteInvestment(InvestmentItem investmentItem) {
		
		int resultCode = investmentDao.deleteInvestment(investmentItem);

		return resultCode;
	}

}
