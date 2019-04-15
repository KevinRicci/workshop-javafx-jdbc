package model.dao;

import java.util.List;

import model.entities.User;

public interface UserDao {

	boolean userValidation(User user);
	List<User> findAll();
}
