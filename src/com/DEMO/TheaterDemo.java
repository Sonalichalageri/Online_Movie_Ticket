package com.DEMO;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.impl.TheaterDaoimpl;
import com.pojo.Theater;

public class TheaterDemo {

	public static void main(String[] args) { 
		     String movieName;
	   	     String movieType;
		     int moviePrice;
		     String movieDate;
			 String movieTimefrom;
			 String movieTimeto ;
			 int seats = 0;

		  boolean b;
		  boolean flag =true;

		TheaterDaoimpl mi=new TheaterDaoimpl();
		Theater m=new Theater();
		Scanner sc=new Scanner(System.in);
		
		while(flag) {
		System.out.println("ENTER YOUR CHOICE");
		System.out.println("1.Add Movie");
		System.out.println("2.Update Movie");
		System.out.println("3.List of Movie");
		System.out.println("4.Search by Movieid");
		System.out.println("5.Search by MovieName");
		System.out.println("6.Search by MovieType");
		System.out.println("7.delete movie");
		
		
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
		{
			System.out.println("Enter the MovieName:");
			movieName=sc.next();
			
			System.out.println("Enter Movie Type :");
			movieType=sc.next();
			
			System.out.println("Enter Movie price :");
			moviePrice=sc.nextInt();
			
			System.out.println("Enter Movie Date :");
			movieDate=sc.next();
			 
			System.out.println("Enter Movie Time from :");
		     movieTimefrom=sc.next();
		     
		     System.out.println("Enter Movie Time to:");
		     movieTimeto=sc.next();
		     
		    System.out.println("enter number of seats");
		    seats=sc.nextInt();
		     
			
		    m =new Theater(moviePrice, movieName, movieType, moviePrice, movieDate, movieTimefrom, movieTimeto, seats);
			b=mi.addmovie(m);
			
			if(b)
			{
				System.out.println("Movie added successfully.."+m);
				
			}else {
				System.out.println("Movie not added");
			}
			
		}break;
		case 2:
			
		{
			System.out.println("Enter exsting MovieName for update");
			movieName=sc.next();
			System.out.println("Enter the movie Type");
			movieType=sc.next();
			System.out.println("Enter the movie Price");
			moviePrice=sc.nextInt();
			
			m.setMovieName(movieName);
			m.setMovieType(movieType);
			m.setMoviePrice(moviePrice);
			b=mi.updatemovie(m);
			if(b)
			{
				System.out.println("Updated successfully..");
			}else {
				System.out.println("Not updated");
			}
			
		}break;
		
		case 3:
		
			System.out.println("Get all movie");
			List<Theater> l=mi.getallmovie();
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
			break;
		case 4:
		{
			System.out.println("Enter exsting movie id");
			int movieid=sc.nextInt();
			Theater th=mi.searchmovie(movieid);
				if(th!=null)
				{
					System.out.println(th);
					}else {
						System.out.println("movie is not available");
					}
	
				}break;
				
		case 5:
		{
			System.out.println("search movie by name");
			movieName=sc.next();
			List<Theater> l1=mi.searchbyname(movieName);
			if(l1!=null)
			{
				Iterator<Theater> it=l1.iterator();
				System.out.println(l1);
				
			}else 
			{
				System.out.println("please check again ");
			}
			
		}break;
		case 6:
		{
			System.out.println("search movie by movieType");
			movieType=sc.next();
			
			List<Theater> l2=mi.searchbytype(movieType);
			if(l2!=null)
			{
				Iterator<Theater> it=l2.iterator();
				
					System.out.println(l2);
					
				}else 
				{
					System.out.println("please check again ");
				}
		}break;
		case 7:{
			System.out.println("enter movie name you want to delete");
			movieName =sc.next();
			
			boolean b1=mi.deletemovie(movieName);
			if(b1)
			{
				System.out.println("Your ticket id cancelled...");
			}else
			{
				System.out.println("Not cancelled");
			}
			
		}break;
		default :{
			System.out.println("invalid enter ");
		}
		
		
		}
		
		
		
		
				
		}			
		
	}

}
