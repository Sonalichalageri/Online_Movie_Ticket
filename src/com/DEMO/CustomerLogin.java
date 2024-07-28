package com.DEMO;

import java.time.LocalDateTime;
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

public class CustomerLogin {

	public static void main(String[] args) {

		login();
		}
	static void login()
	{	
		LoginDaoimpl limpl=new LoginDaoimpl();
		CustomerDaoimpl cimpl= new CustomerDaoimpl();
		Scanner sc=new Scanner(System.in);
		
		boolean flag=true;
		boolean flag1=true;
		
		while(flag)
		{
			System.out.println("1. Register the user");
			System.out.println("2. Login");
			
			int op=sc.nextInt();
			switch(op)
			{
     case 1:
			  {
				  System.out.println("enter user name");
				    String custName=sc.next();
					 
					 System.out.println("enter mobile number");
					   Long mobileNo=sc.nextLong();
					 
					 System.out.println("enter emailid ");
					  String emailid=sc.next();
					  
					  String reg="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
					  boolean f=emailid.matches(reg);
					  if(!f)
					  {
						System.out.println("your emaiiid is not valid"); 
						break;
					  }
					 
					 System.out.println("enter Password");
					   String password=sc.next();
					 
					  Customer c= new Customer(custName, mobileNo, emailid, password);
					  flag1=cimpl.addcustomer(c);
					  if(flag1)
					  {
						  System.out.println("successfully Registred");
					  }else
					  {
						  System.out.println("please check details");
					  }
				
			}
			  break;
           case 2:
                  {
                	 System.out.println("enter your  emailid for login");
     				 String  emailid=sc.next();
     				 
     				 System.out.println("enter password for login");
     				 String  password=sc.next();
     				 
     				 flag1 =limpl.userlogin(emailid, password);
     				 if(flag1)
     				      {
     					 System.out.println("Logined succussfully");
     					 
     					 while(true)
     					 {
     						 System.out.println("1.LIST OF MOVIES");
     						 System.out.println("2.SEARCH MOVIE BY MOVIE NAME");
     						 System.out.println("3.SEARCH MOVIE BY MOVIE TYPE");
     						 System.out.println("4.BOOK MOVIE TICKET");
     						 System.out.println("5.SEARCH YOUR TICKET BY BOOKING ID");
     						 System.out.println("6.UPDATE YOUR PROFILE");
     						 System.out.println("7.CANCEL YOUR TICKET");
     						 System.out.println("8.LOGOUT");
     						 
     						 
     						 TheaterDaoimpl td=new TheaterDaoimpl();
     						 CustomerDaoimpl cd= new CustomerDaoimpl();
     						 TicketDaoimpl timpl =new TicketDaoimpl();
     						 int n=sc.nextInt();
     						 switch(n)
     						 {
     				    case 1:
     				          {
     				        	 System.out.println("Get all movie");
     							List<Theater> l=td.getallmovie();
     							if(l!=null)
     							{
     								Iterator<Theater> it=l.iterator();
     								while(it.hasNext())
     								{
     									System.out.println(it.next());
     									
     								}
     							}else {
     								System.out.println("not found");
     							}
     							}
     				       break;
     				    case 2:
     				    {
     				    	System.out.println("search movie by name");
     						String movieName=sc.next();
     						List<Theater> l1=td.searchbyname(movieName);
     						if(l1!=null)
     						{
     							Iterator<Theater> it=l1.iterator();
     							System.out.println(l1);
     							
     						}else 
     						{
     							System.out.println("please check again ");
     						}
     				    	
     				    }break;
     				    
     				    case 3:
     				    {
     				    	System.out.println("search movie by movieType");
     						 String movieType=sc.next();
     						
     						List<Theater> l2=td.searchbytype(movieType);
     						if(l2!=null)
     						{
     							Iterator<Theater> it=l2.iterator();
     							
     								System.out.println(l2);
     								
     							}else 
     							{
     								System.out.println("please check again ");
     							}
     						 }
     				  break;
     				    
     				    case 4:
     				    {
     			                 List<Theater> l=td.getallmovie();
     			                 
     			                 //iterator used because to get all movie deatils
     							Iterator<Theater> it=l.iterator();
     							
     							while(it.hasNext())
     							{
     								System.out.println(it.next()); 
     						      }
     							
     							System.out.println("choose movie id you want to book");
     							int movieid=sc.nextInt();
     							
     							System.out.println("how many tickets you want to book");
     							int Noofseat=sc.nextInt();
     							
     							int total_price=timpl.getTotalPrice(movieid)*Noofseat;
     							 System.out.println("Total Price to pay "+total_price);
     							 total_price =sc.nextInt();
     							 
     							 System.out.println("DateTime ");
     							LocalDateTime	DateTime=LocalDateTime.now();
     								
     							 System.out.println("Proceed to book?? Enter yes or no...");
     							String	B_status=sc.next().toLowerCase();
     								
     								if(B_status.equals("yes"))
     								{
     									B_status="Booked";
     									
     								TicketBook	t1=new TicketBook(emailid, movieid, Noofseat, total_price, B_status, DateTime);
     										flag1=timpl.Bookticket(t1);
     										
     										if(flag1) 
     										{
     											System.out.println("Booked successfully");
     										}else
     										{
     											System.out.println("pelase check your  details");
     										}

     																	 }
     								else {
     										 System.out.println("if you want to book type yes");
     									 }
     								}
     				    break;
     				    
     				    case 5:
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
     				    
     				    case 6:
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
     				    }
     				    break;
     				    
     				   case 7:
     					{
     						System.out.println("you want cancel your Ticket enter Booking id");
     						int B_id=sc.nextInt();
     						
     						boolean b1=timpl.CancelTicketbyBookingid(B_id);
     						if(b1)
     						{
     							System.out.println("Your ticket id cancelled...");
     						}else
     						{
     							System.out.println("Not cancelled");
     						}
     					}break;
     				   case 8:return;
     					     				    	
     				    
     				    default:System.out.println("invalid number");
     						 
     						 }

     					 }
     					  }
     				
    	 
               }break;
   
			  
          
			}
		}
		
		
		
	}}


