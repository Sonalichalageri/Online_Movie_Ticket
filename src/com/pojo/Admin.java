package com.pojo;

public class Admin {

	private String adminName;
	private String emailid;
	private String password;
	public Admin(String adminName, String emailid, String password) {
		super();
		this.adminName = adminName;
		this.emailid = emailid;
		this.password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", emailid=" + emailid + ", password=" + password + "]";
	}
	
	
	
}
