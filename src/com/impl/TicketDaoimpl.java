package com.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.dao.TicketBookDao;
import com.pojo.Theater;
import com.pojo.TicketBook;

import Utility.Connect;

public class TicketDaoimpl implements TicketBookDao{
	PreparedStatement ps;
	Connection con=Connect.getConnect();
	ResultSet rs;
	int i;
	Theater th;
	int totalBill;
	TicketBook t;
	

	@Override
	public boolean Bookticket(TicketBook t) {
      LocalDateTime dt=LocalDateTime.now();//to get current date and time
		
		DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime=dt.format(format);
		totalBill=getTotalPrice(t.getMovieid());		
		 Theater th = new Theater();
		 
		try {
			ps=con.prepareStatement("insert into ticketbook(emailid,movieid,Noofseat,total_price,B_status,DateTime)values(?,?,?,?,?,?)");
		     th= new TheaterDaoimpl().searchmovie(t.getMovieid());
		     ps.setString(1, t.getEmailid());
		     ps.setInt(2, t.getMovieid());
		     ps.setInt(3, t.getNoofseat());
		   //calculate total price
		   int  total_price=totalBill*t.getNoofseat();
		     ps.setInt(4,total_price);
			ps.setString(5, t.getB_status());
			ps.setTimestamp(6, Timestamp.valueOf(dt));
			
			 i=ps.executeUpdate();
		}
			catch(Exception e)
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
	public List<TicketBook> showAllBookedticket() {
		List<TicketBook> list=new ArrayList<TicketBook>();
	
		try {
			ps=con.prepareStatement("select *from ticketbook");
		    rs=ps.executeQuery();
		    
		while(rs.next()) {
			TicketBook t1=new TicketBook();
			t1.setB_id(rs.getInt(1));
			t1.setEmailid(rs.getString(2));
			t1.setMovieid(rs.getInt(3));
			t1.setNoofseat(rs.getInt(4));
			t1.setTotal_price(rs.getInt(5));
			t1.setB_status(rs.getString(6));
			t1.setDateTime(rs.getTimestamp(7).toLocalDateTime());
			
			
			list.add(t1);
		}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	

	@Override
	public TicketBook showTicketbookedhistory(String emailid) {
		try {
			ps=con.prepareStatement("select *from ticketbook where emailid=?");
			ps.setString(1, emailid);
		rs=ps.executeQuery();
		
		
		while(rs.next()) {
			TicketBook t=new TicketBook();
			t.setB_id(rs.getInt(1));
			t.setEmailid(rs.getString(2));
			t.setMovieid(rs.getInt(3));
			t.setTotal_price(rs.getInt(4));
			t.setNoofseat(rs.getInt(5));
			t.setB_status(rs.getString(6));
			t.setDateTime(rs.getTimestamp(7).toLocalDateTime());
			
			return t;
		}
		}
		catch(Exception e)
		    {
			System.out.println(e);
	        }
		
		return null;
	     }
	
	public int getTotalPrice(int movieid) {
		
		
		try {
			ps=con.prepareStatement("select moviePrice from theater where movieid=?");
			ps.setInt(1, movieid);
			rs=ps.executeQuery();
			
			totalBill=0;
			while(rs.next())
			{
				
			
				totalBill+=rs.getInt("moviePrice");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return totalBill;
	}

	@Override
	public TicketBook showticketbyBookingid(int B_id) 
	{

		try 
		{
			ps=con.prepareStatement("select *from ticketbook where B_id=?");
			ps.setInt(1, B_id);
			rs=ps.executeQuery();
			
			if(rs.next())
			{TicketBook t=new TicketBook();
			t.setB_id(rs.getInt(1));
			t.setEmailid(rs.getString(2));
			t.setMovieid(rs.getInt(3));
			t.setNoofseat(rs.getInt(4));
			t.setTotal_price(rs.getInt(5));
			t.setB_status(rs.getString(6));
			t.setDateTime(rs.getTimestamp(7).toLocalDateTime());
			
			
			return t;
			}
				
			}catch(Exception e)
		     {
			System.out.println(e);
		      }
		
		return null;
	}

	@Override
	public boolean CancelTicketbyBookingid(int B_id) {


		try {
			ps=con.prepareStatement("delete from ticketbook where B_id=?");
			ps.setInt(1, B_id);
			
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

	
}
