package com.DEMO;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.impl.LoginDaoimpl;
import com.impl.TheaterDaoimpl;
import com.impl.TicketDaoimpl;
import com.pojo.Theater;
import com.pojo.TicketBook;

public class TicketBookDemo {

	public static void main(String[] args) {
	
		 int B_id = 0 ;
		 String emailid;
		 int movieid;
		 int total_price;
		 String B_status;
		 LocalDateTime DateTime;
		 int Noofseat;
		 boolean flag=true;
		 boolean flag1=true;
		 
		 boolean b;
		 
		 TicketDaoimpl td=new TicketDaoimpl();
		 TheaterDaoimpl mi=new TheaterDaoimpl();
		 Scanner sc=new Scanner (System.in);
		 TicketBook t1=new TicketBook();
		 
		 
		 while(flag)
		 {
			 System.out.println("ENTER YOUR CHOCE");
			 System.out.println("1.BOOK YOUR MOVIE TICKET");
			 System.out.println("2.CHECK YOUR MOVIE TICKET BY EMAILID");
			 System.out.println("3.SHOW ALL BOOKEDTICKET");
			 System.out.println("4.CHECK YOUR TICKET BOOKED HISTORY");
			 System.out.println("5.CANCEL YOUR TICKET ");
			 int  choice=sc.nextInt();
				switch(choice) {
				case 1:
			{    System.out.println("Enter customer Emailid");
		          emailid=sc.next();
					
					List<Theater> l=mi.getallmovie();

					
					//iterator used because to get all movie deatils
					Iterator<Theater> it=l.iterator();
					
					while(it.hasNext())
					{
						System.out.println(it.next()); 
				      }
					
					System.out.println("choose movie id you want to book");
					movieid=sc.nextInt();
					
					System.out.println("how many tickets you want to book");
					Noofseat=sc.nextInt();
					
					total_price=td.getTotalPrice(movieid)*Noofseat;
					 System.out.println("Total Price to pay "+total_price);
					 total_price =sc.nextInt();
					 
					 System.out.println("DateTime ");
						DateTime=LocalDateTime.now();
						
					 System.out.println("Proceed to book?? Enter yes or no...");
						B_status=sc.next().toLowerCase();
						
						if(B_status.equals("yes"))
						{
							B_status="Booked";
							
							t1=new TicketBook(emailid, movieid, Noofseat, total_price, B_status, DateTime);
								flag1=td.Bookticket(t1);
								
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
				
				case 2:
				{
					System.out.println("Enter customer Bookingid");
					B_id=sc.nextInt();
					
					TicketBook t2=td.showticketbyBookingid(B_id);
					if(t2!=null)
					{
						System.out.println(t2);
					}
					else
					{
						System.out.println("not found check again");
					}
					
				}
				break;
				case 3:
				{
					System.out.println("Show All BookedTicket");
					List<TicketBook> l=td.showAllBookedticket();
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
				}
					break;
					
				case 4:
				{
					System.out.println("Enter your Emailid");
					emailid=sc.next();
					
					TicketBook t=td.showTicketbookedhistory(emailid);
					if(t!=null)
					{
						System.out.println(t);
					}
					else
					{
						System.out.println("not found check again");
					}
					
				}break;
				
				case 5:
				{
					System.out.println("you want cancel your Ticket enter Booking id");
					emailid =sc.next();
					
					boolean b1=td.CancelTicketbyBookingid(B_id);
					if(b1)
					{
						System.out.println("Your ticket id cancelled...");
					}else
					{
						System.out.println("Not cancelled");
					}
				}break;
				
				
				
					 
				}
			 
			 
		 }

		

		
			
			
	}

}

