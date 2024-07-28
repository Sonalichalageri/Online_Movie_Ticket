package com.dao;

import java.util.List;

import com.pojo.Customer;

public interface CustomerDao {
	boolean addcustomer(Customer c);
	boolean updatecustomer(Customer c);
	boolean  deletecustomer(String emailid );
	boolean  seachbycustid(int custid );
	Customer  seachbyemailid(String emailid);
	
	
	
	
	
	List<Customer> getAllCustomer();
	

}
