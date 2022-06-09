package com.ers.dao;

public interface ManagerDao {
	public int approveRequest(int reqId, int authId, String resolvedBy);
	public int denyRequest(int reqId, int authId, String resolvedBy);
}
