package presenters;

import contracts.RegistrationContract;
import data.db.entities.user.User;

public class RegistrationPresenter implements RegistrationContract.RegistrationPresenter {

	private RegistrationContract.RegistrationView registrationView;
	private RegistrationContract.RegistrationModel registrationModel;

	private User user;

	public RegistrationPresenter(RegistrationContract.RegistrationView registrationView,
			RegistrationContract.RegistrationModel registrationModel) {
		this.registrationModel = registrationModel;
		this.registrationView = registrationView;
	}

	@Override
	public void onLoginButtonClick() {
		registrationView.closeRegistrationWindow();
	}

	@Override
	public void onCreateAccountButtonClick(String username, String password, String loginPin) {

		user = new User();

		user.username = username;
		user.password = password;
		user.loginPin = loginPin;

		int resultCode = registrationModel.addUser(user);

		if (resultCode == 1062) {
			registrationView.showErrorJOptionPane("User with " + user.username + " already exist");
		}

		if (resultCode == 1) {
			registrationView.showInfoJOptionPane("Account created successfully");
		}
	}
}
