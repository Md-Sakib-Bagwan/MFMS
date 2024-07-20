package presenters;

import contracts.LoginContract;
import data.db.entities.user.User;

public class LoginPresenter implements LoginContract.LoginPresenter {

	LoginContract.LoginView loginView;
	LoginContract.LoginModel loginModel;

	private static String usernameForInvestmentRef;

	public LoginPresenter(LoginContract.LoginView loginView, LoginContract.LoginModel loginModel) {
		this.loginModel = loginModel;
		this.loginView = loginView;
	}

	@Override
	public void onLoginButtonClick(String username, char[] password, char[] login_pin) {

		User user = new User();
		user.username = username;
		user.password = new String(password);
		user.loginPin = new String(login_pin);

		User fetchedUserResult = loginModel.getUser(user);

		if (fetchedUserResult == null) {
			loginView.showErrorJOptionPane("User with username " + username + " not exists");
		} else if (!(fetchedUserResult.password.equals(user.password))) {
			loginView.showErrorJOptionPane("Entered password is wrong");
		} else if (!(fetchedUserResult.loginPin.equals(user.loginPin))) {
			loginView.showErrorJOptionPane("Entered login pin is wrong");
		} else {
			setUsernameForInvestmentRef(user.username);
			loginView.openInvestmentsDashboardWindow();
			loginView.closeLoginWindow();
		}
	}

	@Override
	public void onCreateAccountButtonClick() {
		loginView.openRegistrationWindow();
		loginView.closeLoginWindow();
	}

	public static String getUsernameForInvestmentRef() {
		return usernameForInvestmentRef;
	}

	public static void setUsernameForInvestmentRef(String usernameForInvestmentRef) {
		LoginPresenter.usernameForInvestmentRef = usernameForInvestmentRef;
	}
}
