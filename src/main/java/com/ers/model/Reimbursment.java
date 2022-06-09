package com.ers.model;

import java.sql.Timestamp;

public class Reimbursment {
	private int id;
	private String title;
	private String description;
	private String status;
	private String resolvedBy;
	private Timestamp submitted;
	private Timestamp resolved; 
	private User user;
	
	public Reimbursment() {}
	
	public Reimbursment(int id, String title, String description, String status, String resolvedBy, Timestamp submitted,
			Timestamp resolved, User user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.resolvedBy = resolvedBy;
		this.submitted = submitted;
		this.resolved = resolved;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
