package com.hrgiri.models;

public class Department {

	private int did;
	private String dName;
	private int dHeadId;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Department (String dName,int dHeadId) {
		super();
		
		this.dName = dName;
		this.dHeadId = dHeadId;
	}
	
	public Department(int did, String dName,int dHeadId) {
		super();
		this.did = did;
		this.dName = dName;
		this.dHeadId = dHeadId;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String didName) {
		this.dName = didName;
	}

	

	@Override
	public String toString() {
		return "[Department ID : " + did + " | Department Name : " + dName + "]";
	}

	public int getdHeadId() {
		return dHeadId;
	}

	public void setdHeadId(int dHeadId) {
		this.dHeadId = dHeadId;
	}
	
	
}
