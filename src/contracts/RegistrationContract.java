package contracts;

import data.db.entities.user.User;

public interface RegistrationContract {

	interface RegistrationModel {

		int addUser(User user);
	}

	interface RegistrationView {

		void runRegistrationWindow();

		void closeRegistrationWindow();

		public void showErrorJOptionPane(String errorMessage);

		public void showInfoJOptionPane(String infoMessage);
	}

	interface RegistrationPresenter {

		void onLoginButtonClick();

		void onCreateAccountButtonClick(String username, String password, String loginPin);
	}
}
