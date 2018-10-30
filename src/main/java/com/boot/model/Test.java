package com.boot.model;

public class Test {

	public Test(String success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	private String success;
	private String message;
	
	public String getSuccess() {
		return success;
	}
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
