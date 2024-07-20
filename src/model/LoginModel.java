package model;

import contracts.LoginContract;
import data.db.entities.user.User;
import data.db.entities.user.UserDao;

public class LoginModel implements LoginContract.LoginModel {

	private User userFetchedResult;

	@Override
	public User getUser(User user) {

		UserDao userDao = new UserDao();

		userFetchedResult = userDao.getUser(user);

		return userFetchedResult;
	}
}
