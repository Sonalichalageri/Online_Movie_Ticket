package com.DEMO;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.impl.CustomerDaoimpl;
import com.impl.LoginDaoimpl;
import com.impl.TheaterDaoimpl;
import com.impl.TicketDaoimpl;
import com.pojo.Customer;
import com.pojo.Theater;
import com.pojo.TicketBook;

public class AdminLogin {

	public static void main(String[] args) {
	main();
	}
		static void main() {
			CustomerDaoimpl cd=new CustomerDaoimpl();
			TheaterDaoimpl td=new TheaterDaoimpl();
			TicketDaoimpl timpl=new TicketDaoimpl();
			LoginDaoimpl ld=new LoginDaoimpl();
			Theater m=new Theater();
			
			Scanner sc=new Scanner(System.in);
			boolean flag=true;
			
			while(true)
			{
				System.out.println("1.Login");
				int num=sc.nextInt();
				
				switch(num)
				{
		  case 1:
				
					System.out.println("Enter Email");
					 String emailid=sc.next();
					 System.out.println("Enter Password");
					 String password=sc.next();
					 if(ld.adminlogin(emailid, password))
					 {
						 System.out.println("login successfully");
					 }
				
				while(true)
				{
					 System.out.println("1.Add Movie");
					 System.out.println("2.Update Movie");
					 System.out.println("3.Delete Movie");
					 System.out.println("4.Add Customer");
					 System.out.println("5.Update Customer");
					 System.out.println("6.Delete Customer");
					 System.out.println("7.List Of Customer");
					 System.out.println("8.Show all Booked Ticket");
					 System.out.println("9.Show Ticket by B_id");
					 System.out.println("10.logout");
					 System.out.println("11.change password");
					
					 int n=sc.nextInt();
					 switch(n)
					 {
					 case 1:
					 {
						 System.out.println("Enter the MovieName:");
						 String	movieName=sc.next();
							
							System.out.println("Enter Movie Type :");
							String movieType=sc.next();
							
							System.out.println("Enter Movie price :");
						  int 	moviePrice=sc.nextInt();
							
							System.out.println("Enter Movie Date :");
							String movieDate=sc.next();
							 
							System.out.println("Enter Movie Time from :");
						    String movieTimefrom=sc.next();
						     
						     System.out.println("Enter Movie Time to:");
						   String  movieTimeto=sc.next();
						     
						    System.out.println("enter number of seats");
						    int seats=sc.nextInt();
						     
							
						    m =new Theater(moviePrice, movieName, movieType, moviePrice, movieDate, movieTimefrom, movieTimeto, seats);
							boolean b=td.addmovie(m);
							
							if(b)
							{
								System.out.println("Movie added successfully..");
								
							}else {
								System.out.println("Movie not added");
							}
						 
						 
				}break;
				
					 case 2:
					 {
						 System.out.println("Enter exsting MovieName for update");
						String	movieName=sc.next();
						
							System.out.println("Enter the movie Type");
							String	movieType=sc.next();
							
							System.out.println("Enter the movie Price");
							int moviePrice=sc.nextInt();
							
							m.setMovieName(movieName);
							m.setMovieType(movieType);
							m.setMoviePrice(moviePrice);
						boolean	b=td.updatemovie(m);
							if(b)
							{
								System.out.println("Updated successfully..");
							}else {
								System.out.println("Not updated");
							}
						 
					 }break;
					 
					 case 3:
					 {
						 System.out.println("enter movie name you want to delete");
						String	movieName =sc.next();
							
							boolean b1=td.deletemovie(movieName);
							if(b1)
							{
								System.out.println("Your movie deleted...");
							}else
							{
								System.out.println("Not deleted");
							}
						 
						 
					 }break;
					 
					 case 4:
					 {

						  System.out.println("enter user name");
						    String custName=sc.next();
							 
							 System.out.println("enter mobile number");
							   Long mobileNo=sc.nextLong();
							 
							 System.out.println("enter emailid ");
							   emailid=sc.next();
							  
							  String reg="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
							  boolean f=emailid.matches(reg);
							  if(!f)
							  {
								System.out.println("your emaiiid is not valid"); 
								break;
							  }
							 
							 System.out.println("enter Password");
							    password=sc.next();
							 
							  Customer c= new Customer(custName, mobileNo, emailid, password);
							  flag=cd.addcustomer(c);
							  if(flag)
							  {
								  System.out.println("successfully Registred");
							  }else
							  {
								  System.out.println("please check details");
							  }
						   }break;
					 case 5:
					 {
						 System.out.println("Enter customer name");
  						String custname=sc.next();
  						 System.out.println("Enter customer mobile number");
  						Long mobileNo=sc.nextLong();
  						
  						 Customer c1=new Customer();
  						 c1.setEmailid(emailid);
  						 c1.setCustName(custname);
  						 c1.setMobileNo(mobileNo);
  						 c1.setPassword(password);
  						 
  						  boolean b=cd.updatecustomer(c1);
  						 if(b)
  						 {
  							 System.out.println("Customer details updated successfully");
  						 }
  						 else {
  							 System.out.println("please check again");
  				
  				    	
  						 }
						 
					 }break;
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
					 
					 case 7:
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
						
						 
					 }break;
					 case 8:
					 {System.out.println("Show All BookedTicket");
						List<TicketBook> l=timpl.showAllBookedticket();
						if(l!=null)
						{
							Iterator<TicketBook> it=l.iterator();
							while(it.hasNext())
							{
								System.out.println(it.next());
							}
						}
						else
						{
							System.out.println("Not Found");
						}
						 
						 
					 }break;
					 case 9:
					 {
						 System.out.println("Enter customer Bookingid");
  						int B_id=sc.nextInt();
  						
  						TicketBook t2=timpl.showticketbyBookingid(B_id);
  						if(t2!=null)
  						{
  							System.out.println(t2);
  						}
  						else
  						{
  							System.out.println("not found check again");
  						}
						 
					 }break;
					 case 10:return;
					 
					 
					 case 11:
					 {
						 
					 }break;
					 }
				}
				
				}break;
				}
				
			}
			
			
	

}
