package com.ers.services;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;

import com.ers.dao.ManagerDao;
import com.ers.util.ConnectionFactory;
import com.mysql.jdbc.PreparedStatement;

public class ManagerService implements ManagerDao{
	
	Connection conn = ConnectionFactory.initConnection();
	
	@Override
	public int approveRequest(int reqId, int authId, String resolvedBy) {
		int res = 0;
		try {
			
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("Update reimbursment SET status=?,resolvedBy=?,resolvedAt=? where id=? and userId=?");
			pstmt.setString(1, "resolved");
			pstmt.setString(2, resolvedBy);
			Timestamp created = new Timestamp(new Date().getTime());
			pstmt.setTimestamp(3, created);
			pstmt.setInt(4, reqId);
			pstmt.setInt(5, authId);
			
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return res;
	}

	@Override
	public int denyRequest(int reqId, int authId, String resolvedBy) {
		int res = 0;
		try {
			
			PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement("Update reimbursment SET status=?,resolvedBy=?,resolvedAt=? where id=? and userId=?");
			pstmt.setString(1, "denied");
			pstmt.setString(2, resolvedBy);
			Timestamp created = new Timestamp(new Date().getTime());
			pstmt.setTimestamp(3, created);
			pstmt.setInt(4, reqId);
			pstmt.setInt(5, authId);
			
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return res;
	}

}
