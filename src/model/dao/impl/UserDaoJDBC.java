package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbException;
import model.dao.UserDao;
import model.entities.User;

public class UserDaoJDBC implements UserDao{

	private Connection conn;
	
	public UserDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean userValidation(User user) {
		List<User> users = findAll();
		if(users.contains(user)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT userName, password FROM user");
			rs = st.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
			return users;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
}
