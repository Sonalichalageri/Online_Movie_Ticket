package com.DEMO;

import java.util.Iterator;

import java.util.List;
import java.util.Scanner;

import com.impl.CustomerDaoimpl;
import com.pojo.Customer;
import com.pojo.Theater;

public class CustomerDemo {

	public static void main(String[] args) {
		 String custname;
		 long mobileNo;
		 String emailid;
		 String password;
		 boolean b;
		 
		 
		
 
		CustomerDaoimpl cd=new CustomerDaoimpl();
		Customer c =new Customer();
		Scanner sc=new Scanner(System.in);
		while(true) {
		
		System.out.println("ENTER YOUR CHOICE :");
		System.out.println("1.Add Customer Name");
		
		System.out.println("2.Update Details of Customer");
		System.out.println("3.Show List of Customer");
		System.out.println("4.Search by Email Id");
		System.out.println("5.Return or Exit");
		System.out.println("6.delete customer");
		
		int  choice=sc.nextInt();
		switch(choice){
		case 1:
		{
			System.out.println("Enter the customer name :");
			custname=sc.next();
			System.out.println("Enter your mobile number :");
			mobileNo=sc.nextLong();
			System.out.println("Enter your emailid :");
			emailid=sc.next();
			System.out.println("Enter your password :");
			password=sc.next();
			
			c=new Customer(custname, mobileNo, emailid, password);
			b=cd.addcustomer(c);
			if(b) 
			{
				System.out.println("Customer added successfully");
			}else {
				System.out.println("pelase check customer details");
			}
			
		}break;
		
		case 2:
		{

			System.out.println("Enter existing emailid for update details :");
			 emailid=sc.next();
			 System.out.println("Enter customer name");
			 custname=sc.next();
			 System.out.println("Enter customer mobile number");
			 mobileNo=sc.nextLong();
			 System.out.println("Enter new password");
			 password=sc.next();
			 
			 Customer c1=new Customer();
			 c1.setEmailid(emailid);
			 c1.setCustName(custname);
			 c1.setMobileNo(mobileNo);
			 c1.setPassword(password);
			 
			 b=cd.updatecustomer(c1);
			 if(b)
			 {
				 System.out.println("Customer details updated successfully");
			 }
			 else {
				 System.out.println("please check again");
	
			 }
			 
			
		}break;
		case 3:
		{
			System.out.println("Get all customer");
			List<Customer> list=cd.getAllCustomer();
			if(list!=null)
			{
				Iterator<Customer> it=list.iterator();
				while(it.hasNext())
				{
					System.out.println(it.next());
					
				}
			}else {
				System.out.println("not found");
			}
		
			
			
		}
		break;
		
		case 4:
		{
			System.out.println("Enter customer emailid");
			emailid=sc.next();
			
			Customer cust=cd.seachbyemailid(emailid);
			if(cust!=null)
			{
				
				
					System.out.println(cust);
					
				}else 
				{
					System.out.println("please check again ");
				}
		
		}
		break;
		case 5:
			System.exit(0);
			break;
		case 6:
		{
			System.out.println("you want delete your customer enter emailid");
			emailid =sc.next();
			
			boolean b1=cd.deletecustomer(emailid);
			if(b1)
			{
				System.out.println("Your ticket id cancelled...");
			}else
			{
				System.out.println("Not cancelled");
			}
			
		}break;
			default:
				System.out.println("Enter valid number from 1 to 5");
		}
		}
		
	}

}
