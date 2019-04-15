package model.sevices;

import model.dao.DaoFactory;
import model.dao.UserDao;
import model.entities.User;

public class UserService {
	
	private UserDao dao = DaoFactory.createUserdao();
	
	public boolean userValidation(User user) {
		boolean result = dao.userValidation(user);
		return result;
	}
}
