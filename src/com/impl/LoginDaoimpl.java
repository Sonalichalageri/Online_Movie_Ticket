package com.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.loginDao;

import Utility.Connect;

public class LoginDaoimpl implements loginDao {
	Connection con=Connect.getConnect();

	PreparedStatement ps;
	String pass=null;
	ResultSet rs;
	boolean f=false;
	@Override
	public boolean userlogin(String emailid, String password) {
		
		try {
		ps=con.prepareStatement("Select * from customer where emailid=?");
		ps.setString(1, emailid);
	 rs=ps.executeQuery();
		if(rs.next())
		{
			pass=rs.getString("password");
		}
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		if(pass.equals(password))
		{
			return true;
		}else {
		return false;
		}
		
	}

	@Override
	public boolean userchangepassword(String custname, String newpassword) {

		try 
		{
			ps=con.prepareStatement("update customer set password=? where custname=?");
			ps.setString(1, custname);
			ps.setString(2, newpassword);
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean adminlogin(String emailid, String password) {
		try {
			ps=con.prepareStatement("Select *from admin where emailid=?and password=?");
			ps.setString(1, emailid);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
		
			f=rs.next();
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		return f;		
		
	}

	@Override
	public boolean adminchangepassword(String adminName, String newpassword) {

		try 
		{
			ps=con.prepareStatement("update admin set password=? where adminName=?");
			ps.setString(1, adminName );
			ps.setString(2, newpassword);
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return false;
	}

	
}
