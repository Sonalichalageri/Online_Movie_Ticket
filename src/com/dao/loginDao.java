package com.dao;

public interface loginDao  {
	boolean userlogin(String emailid,String password);
	boolean userchangepassword(String custname,String newpassword);
	boolean adminlogin(String emailid,String password);
	boolean adminchangepassword(String adminName,String newpassword);
	
	

}
