package contracts;

import data.db.entities.user.User;

public interface LoginContract {

	interface LoginModel {

		User getUser(User user);
	}

	interface LoginView {

		void runLoginWindow();

		void closeLoginWindow();

		public void showErrorJOptionPane(String errorMessage);

		public void showInfoJOptionPane(String infoMessage);

		public void openInvestmentsDashboardWindow();

		public void openRegistrationWindow();
	}

	interface LoginPresenter {

		void onLoginButtonClick(String username, char[] password, char[] login_pin);

		void onCreateAccountButtonClick();
	}
}
