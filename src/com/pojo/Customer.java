package com.pojo;

public class Customer {
	private int custid;
	private String custname;
	private long mobileNo;
	private String emailid;
	private String password;
	public Customer(String custname, long mobileNo, String emailid, String password) {
		super();
		this.custname = custname;
		this.mobileNo = mobileNo;
		this.emailid = emailid;
		this.password = password;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getCustName() {
		return custname;
	}
	public void setCustName(String custName) {
		this.custname = custName;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
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
		return "Customer [custName=" + custname + ", mobileNo=" + mobileNo + ", emailid=" + emailid + ", Password="
				+ password + "]";
	}
	
	

	
	


}
