package contracts;

import java.util.ArrayList;

import data.db.entities.investment.InvestmentItem;
import data.db.entities.user.User;

public interface InvestmentsDashboardContract {

	interface InvestmentsDashboardView {

		void runInvestmentsDashboardWindow();

		void closeInvestmentDashboardWindow();

		void showInfoJOptionPane(String message);

		void populateJTable();
	}

	interface InvestmentsDashboardModel {
		
		int addInvestmentItem(InvestmentItem investmentItem);

		ArrayList<InvestmentItem> getInvestmentItems(User user);
		
		int updateInvestment(InvestmentItem investmentItem);
		
		int deleteInvestment(InvestmentItem investmentItem);
	}

	interface InvestmentsDashboardPresenter {
		
		void onDoneButtonClick(InvestmentItem investmentItem);

		ArrayList<InvestmentItem> onLogin(User user);
		
		void onUpdateButtonClick(InvestmentItem investmentItem);
		
		void onRedeemButtonClick(InvestmentItem investmentItem);
	}

}
