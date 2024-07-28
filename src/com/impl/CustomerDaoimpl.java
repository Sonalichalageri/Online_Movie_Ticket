package com.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.CustomerDao;
import com.pojo.Customer;

import Utility.Connect;

public class CustomerDaoimpl implements CustomerDao {
	PreparedStatement ps;
	Connection con=Connect.getConnect();
	int i= 0;
	ResultSet rs;
	Customer c=new Customer();

	@Override
	public boolean addcustomer(Customer c) {
		//add customer details
		try {
			ps=con.prepareStatement("insert into customer(custname,mobileNo,emailid,password) values(?,?,?,?)");
			ps.setString(1,c.getCustName());
			ps.setLong(2, c.getMobileNo());
			ps.setString(3, c.getEmailid());
			ps.setString(4, c.getPassword());
			
		i=	ps.executeUpdate();
		
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		if(i>0)
		{
			return true;
		}else
		{
			return false;
		}
		
	}

	
	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> list=new ArrayList<Customer>();
		try {
		ps=con.prepareStatement("select custid,custname,mobileNo,emailid from customer");
		rs=ps.executeQuery();
		while(rs.next())
		{
			Customer c2=new Customer();
		c2.setCustid(rs.getInt(1));
		c2.setCustName(rs.getString(2));
		c2.setMobileNo(rs.getLong(3));
		c2.setEmailid(rs.getString(4));
		
		
		list.add(c2);

				}

		
		}
	
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return list;
		
		
	}

	@Override
	public boolean seachbycustid(int custid) {
		try {
		ps=con.prepareStatement("select * customer where custid=?");
		rs=ps.executeQuery();
		if(rs.next())
		{
			c.setCustName(rs.getString(1));
			c.setMobileNo(rs.getInt(2));
			c.setEmailid(rs.getString(3));
			c.setPassword(rs.getString(4));
			
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return false;
	}


	@Override
	public boolean updatecustomer(Customer c1)
	{
		try {
		ps=con.prepareStatement("update customer set custname=?,mobileNo=?,password=? where emailid=?");
		
		
		ps.setString(1, c1.getCustName());
		ps.setLong(2, c1.getMobileNo());
		ps.setString(3, c1.getPassword());
		ps.setString(4, c1.getEmailid());
		
		i=ps.executeUpdate();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	if(i>0)
	{
		return true;
	}
	else {
		
		return false;
	}
	}


	@Override
	public boolean deletecustomer(String emailid) {

		try {
			ps=con.prepareStatement("delete from Customer where emailid=?");
			ps.setString(1, emailid);
			
			i=ps.executeUpdate();
			
			
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return false;
	}


	@Override
	public Customer seachbyemailid(String emailid) {
		
		try {
			ps=con.prepareStatement("select custid,custname,mobileNo from customer where emailid=?");
			ps.setString(1, emailid);
			rs=ps.executeQuery();
			
			if(rs.next())
			{	Customer c=new Customer();
				c.setCustid(rs.getInt(1));
				c.setCustName(rs.getString(2));
				c.setMobileNo(rs.getLong(3));
				
			return c;	
				
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		return null;
	}
	

	

	

}
