package com.hrgiri.models;

public class Department {

	private int did;
	private String didName;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	public Department(int did, String didName) {
		super();
		this.did = did;
		this.didName = didName;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDidName() {
		return didName;
	}

	public void setDidName(String didName) {
		this.didName = didName;
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", didName=" + didName + "]";
	}
	
	
}
