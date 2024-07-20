package model;

import contracts.RegistrationContract;
import data.db.entities.user.User;
import data.db.entities.user.UserDao;

public class RegistrationModel implements RegistrationContract.RegistrationModel {

	@Override
	public int addUser(User user) {

		UserDao userDao = new UserDao();

		int resultCode = userDao.addUser(user);

		return resultCode;
	}
}
