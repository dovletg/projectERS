package com.ers.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ers.dao.UserDao;
import com.ers.model.User;
import com.ers.util.ConnectionFactory;
import com.mysql.jdbc.PreparedStatement;

public class UserService implements UserDao{
	
	Connection conn = ConnectionFactory.initConnection();
	
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		int res = 0;
		try {
			
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("Update user set username=?,password=? where id=?");
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getPassword());
			pstmt.setInt(3, user.getId());
			
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return res;
	}

	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserById(int id) {
		User u = null;
		try {
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("Select * from user where id=?");
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUserName(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setType(rs.getString("type"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return u;
	}

	@Override
	public User getUserByUserNameAndPassword(String username, String password) {
		User u = null;
		try {
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("Select * from user where username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUserName(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setType(rs.getString("type"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		try {
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("Select * from user");
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUserName(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setType(rs.getString("type"));
				
				users.add(u);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return users;
	}

}
