package com.ers.dao;

import java.util.List;

import com.ers.model.User;

public interface UserDao {
	public int addUser(User user);
	public int updateUser(User user);
	public int deleteUser(int userId);
	public User getUserById(int id);
	public User getUserByUserNameAndPassword(String username, String password);
	public List<User> getAllUsers();
}
