package presenters;

import java.util.ArrayList;

import contracts.InvestmentsDashboardContract;
import data.db.entities.investment.InvestmentItem;
import data.db.entities.user.User;
import utils.Log;

public class InvestmentsDashboardPresenter implements InvestmentsDashboardContract.InvestmentsDashboardPresenter {

	private static String CLASS;

	private InvestmentsDashboardContract.InvestmentsDashboardModel investmentDashboardModel;
	private InvestmentsDashboardContract.InvestmentsDashboardView investmentDashboardView;

	public InvestmentsDashboardPresenter(
			InvestmentsDashboardContract.InvestmentsDashboardModel investmentDashboardModel,
			InvestmentsDashboardContract.InvestmentsDashboardView investmentDashboardView) {

		this.investmentDashboardModel = investmentDashboardModel;
		this.investmentDashboardView = investmentDashboardView;

		CLASS = this.getClass().getSimpleName();

	}

	@Override
	public void onDoneButtonClick(InvestmentItem investmentItem) {

		investmentItem.username = LoginPresenter.getUsernameForInvestmentRef();

		int resultCode = investmentDashboardModel.addInvestmentItem(investmentItem);

		if (resultCode == 1) {
			investmentDashboardView.showInfoJOptionPane("Investment added successfully");

			investmentDashboardView.populateJTable();
		}
	}

	@Override
	public ArrayList<InvestmentItem> onLogin(User user) {

		ArrayList<InvestmentItem> investmentItems = investmentDashboardModel.getInvestmentItems(user);

		return investmentItems;
	}

	@Override
	public void onUpdateButtonClick(InvestmentItem investmentItem) {
		
		investmentItem.username = LoginPresenter.getUsernameForInvestmentRef();

		int resultCode = investmentDashboardModel.updateInvestment(investmentItem);

		if (resultCode == 1) {
			investmentDashboardView.showInfoJOptionPane("Investment updated successfully");

			investmentDashboardView.populateJTable();
		}
	}

	@Override
	public void onRedeemButtonClick(InvestmentItem investmentItem) {
		investmentItem.username = LoginPresenter.getUsernameForInvestmentRef();

		int resultCode = investmentDashboardModel.deleteInvestment(investmentItem);

		if (resultCode == 1) {
			investmentDashboardView.showInfoJOptionPane("Investment deleted successfully");

			investmentDashboardView.populateJTable();
		}		
	}

}
