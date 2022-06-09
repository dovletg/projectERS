package com.ers.dao;

import java.util.List;

import com.ers.model.Reimbursment;

public interface ReimbursmentDao {
	public int addReimbursment(Reimbursment reimbursment);
	public int resolveReimbursment(Reimbursment reimbursment);
	public Reimbursment getReimbursmentByName(String title);
	public Reimbursment getReimbursmentByAuthorId(int id);
	public List<Reimbursment> getAllPendingReimbursments();
	public List<Reimbursment> getAllResolvedReimbursments();
	public List<Reimbursment> getAllPendingReimbursmentByAuthor(int id);
	public List<Reimbursment> getAllResolvedReimbursmentByAuthor(int id);
	public List<Reimbursment> getAllReimbursmentsByAuthorId(int id);
}
