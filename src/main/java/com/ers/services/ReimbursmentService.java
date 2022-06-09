package com.ers.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ers.dao.ReimbursmentDao;
import com.ers.model.Reimbursment;
import com.ers.model.User;
import com.ers.util.ConnectionFactory;
import com.mysql.jdbc.PreparedStatement;

public class ReimbursmentService implements ReimbursmentDao {
	Connection conn = ConnectionFactory.initConnection();

	@Override
	public int addReimbursment(Reimbursment rb) {
		int res = 0;
		try {

			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(
					"Insert into reimbursment(title,description,status,submittedAt,resolvedAt,userId) Values(?,?,?,?,?,?)");
			pstmt.setString(1, rb.getTitle());
			pstmt.setString(2, rb.getDescription());
			pstmt.setString(3, "pending");
			pstmt.setTimestamp(4, rb.getSubmitted());
			pstmt.setTimestamp(5, rb.getSubmitted());
			pstmt.setInt(6, rb.getUser().getId());

			res = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return res;
	}

	@Override
	public int resolveReimbursment(Reimbursment reimbursment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Reimbursment getReimbursmentByName(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursment getReimbursmentByAuthorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursment> getAllPendingReimbursments() {
		List<Reimbursment> rbs = new ArrayList<>();

		try {

			PreparedStatement pstmt = (PreparedStatement) conn
					.prepareStatement("Select * from reimbursment where status='pending'");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Reimbursment rb = new Reimbursment();
				rb.setId(rs.getInt("id"));
				rb.setTitle(rs.getString("title"));
				rb.setDescription(rs.getString("description"));
				rb.setSubmitted(rs.getTimestamp("submittedAt"));
				rb.setStatus(rs.getString("status"));
				User u = new User();
				u.setId(rs.getInt("userId"));
				rb.setUser(u);

				rbs.add(rb);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return rbs;
	}

	@Override
	public List<Reimbursment> getAllResolvedReimbursments() {
		List<Reimbursment> rbs = new ArrayList<>();

		try {

			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("Select * from reimbursment where status='resolved'");			
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Reimbursment rb = new Reimbursment();
				rb.setId(rs.getInt("id"));
				rb.setTitle(rs.getString("title"));
				rb.setDescription(rs.getString("description"));
				rb.setResolvedBy(rs.getString("resolvedBy"));
				rb.setSubmitted(rs.getTimestamp("submittedAt"));
				rb.setResolved(rs.getTimestamp("resolvedAt"));
				rb.setStatus(rs.getString("status"));
				
				User u = new User();
				u.setId(rs.getInt("userId"));
				
				rb.setUser(u);

				rbs.add(rb);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return rbs;
	}

	@Override
	public List<Reimbursment> getAllPendingReimbursmentByAuthor(int id) {
		List<Reimbursment> rbs = new ArrayList<>();

		try {

			PreparedStatement pstmt = (PreparedStatement) conn
					.prepareStatement("Select * from reimbursment where userId=? and status='pending'");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Reimbursment rb = new Reimbursment();
				rb.setId(rs.getInt("id"));
				rb.setTitle(rs.getString("title"));
				rb.setDescription(rs.getString("description"));
				rb.setSubmitted(rs.getTimestamp("submittedAt"));
				rb.setStatus(rs.getString("status"));
				
				User u = new User();
				u.setId(rs.getInt("userId"));
				
				rb.setUser(u);
				
				rbs.add(rb);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return rbs;
	}

	@Override
	public List<Reimbursment> getAllResolvedReimbursmentByAuthor(int id) {
		List<Reimbursment> rbs = new ArrayList<>();

		try {

			PreparedStatement pstmt = (PreparedStatement) conn
					.prepareStatement("Select * from reimbursment where userId=? and status='resolved'");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Reimbursment rb = new Reimbursment();
				rb.setId(rs.getInt("id"));
				rb.setTitle(rs.getString("title"));
				rb.setDescription(rs.getString("description"));
				rb.setResolvedBy(rs.getString("resolvedBy"));
				rb.setSubmitted(rs.getTimestamp("submittedAt"));
				rb.setResolved(rs.getTimestamp("resolvedAt"));
				rb.setStatus(rs.getString("status"));
				
				User u = new User();
				u.setId(rs.getInt("userId"));
				
				rb.setUser(u);
				
				rbs.add(rb);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return rbs;
	}

	@Override
	public List<Reimbursment> getAllReimbursmentsByAuthorId(int id) {
		List<Reimbursment> rbs = new ArrayList<>();

		try {

			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("Select * from reimbursment where userId=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Reimbursment rb = new Reimbursment();
				rb.setId(rs.getInt("id"));
				rb.setTitle(rs.getString("title"));
				rb.setDescription(rs.getString("description"));
				rb.setResolvedBy(rs.getString("resolvedBy"));
				rb.setSubmitted(rs.getTimestamp("submittedAt"));
				rb.setResolved(rs.getTimestamp("resolvedAt"));
				rb.setStatus(rs.getString("status"));
				
				User u = new User();
				u.setId(rs.getInt("userId"));
				
				rb.setUser(u);
				
				rbs.add(rb);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return rbs;
	}

}
