package com.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.dao.TheaterDao;
import com.pojo.Customer;
import com.pojo.Theater;

import Utility.Connect;

public class TheaterDaoimpl implements TheaterDao{
	DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	PreparedStatement ps;
	Connection con=Connect.getConnect();
	ResultSet rs;
	int i;
	Theater m=new Theater();
	

	
	@Override
	public boolean addmovie(Theater m) {
		
		
		try 
		{
        ps=con.prepareStatement("insert into Theater (movieName,movieType,moviePrice,movieDate,movieTimefrom,movieTimeto,seats)values(?,?,?,?,?,?,?)");
		//add movie details
		ps.setString(1, m.getMovieName());
		ps.setString(2, m.getMovieType());
		ps.setInt(3, m.getMoviePrice());
		ps.setObject(4, m.getMovieDate());
		ps.setObject(5, m.getMovieTimefrom());
		ps.setObject(6, m.getMovieTimeto());
		ps.setInt(7, m.getSeats());
		
		
		
		i=ps.executeUpdate();////will execute the sql query in the mysql database
		
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
	public boolean updatemovie(Theater m) {
		try {
		ps=con.prepareStatement("update theater set movieType=?,moviePrice=? where movieName=?");
		ps.setString(1, m.getMovieType());
		ps.setInt(2, m.getMoviePrice());
		ps.setString(3, m.getMovieName());
		
		i =ps.executeUpdate();
		
		}catch(Exception e)
		{
		System.out.println(e);	
		}
		
		if(i>0)
		{
			return true;
		}else {
		return false;
		}
	}

	@Override
	public boolean deletemovie(String movieName) {

		try {
			ps=con.prepareStatement("delete from theater where movieName=?");
			ps.setString(1, movieName);
			//excuteupdate use for insert ,update ,delete
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
	public Theater searchmovie(int movieid) {
		try	{
			
		ps=con.prepareStatement("select *from theater where movieid=?");
		ps.setInt(1, movieid);
		//executequery for select query 
		rs=ps.executeQuery();
		if(rs.next())
		{
			Theater m1=new Theater();
			m1.setMovieid(rs.getInt(1));
			m1.setMovieName(rs.getString(2));
			m1.setMovieType(rs.getString(3));
			m1.setMoviePrice(rs.getInt(4));
			m1.setMovieDate(rs.getString(5));
			m1.setMovieTimefrom(rs.getString(6));
			m1.setMovieTimeto(rs.getString(7));
			m1.setSeats(rs.getInt(8));
			
			
		return m1;
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Theater> getallmovie() {
		List<Theater> l=new ArrayList<Theater>();

		try {
			
			ps=con.prepareStatement("select *from theater");
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Theater m2=new Theater();
		    m2.setMovieid(rs.getInt(1));
			m2.setMovieName(rs.getString(2));
			m2.setMovieType(rs.getString(3));
			m2.setMoviePrice(rs.getInt(4));
			m2.setMovieDate(rs.getString(5));
			m2.setMovieTimefrom(rs.getString(6));
			m2.setMovieTimeto(rs.getString(7));
			m2.setSeats(rs.getInt(8));
			
			l.add(m2);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		return l;
	}

	@Override
	public List<Theater> searchbyname(String movieName) {
		List<Theater> l=new ArrayList<Theater>();
		try 
		{
			ps=con.prepareStatement("select *from theater where movieName like ?");
			ps.setString(1, "%"+movieName+"%");
			rs=ps.executeQuery();
			while(rs.next())
			{
				Theater t1=new Theater();
				t1.setMovieid(rs.getInt(1));
				t1.setMovieName(rs.getString(2));
				t1.setMovieType(rs.getString(3));
				t1.setMoviePrice(rs.getInt(4));
				t1.setMovieDate(rs.getString(5));
				t1.setMovieTimefrom(rs.getString(6));
				t1.setMovieTimeto(rs.getString(7));
				t1.setSeats(rs.getInt(8));
				
			l.add(t1);	
			}
			}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return l;
	}

	@Override
	public List<Theater> searchbytype(String movieType) 
	{
		List<Theater> l=new ArrayList<Theater>();
		try 
		{
			ps=con.prepareStatement("select *from theater where movieType like ?");
			ps.setString(1, "%"+movieType+"%");
			rs=ps.executeQuery();
			while(rs.next())
			{   m.setMovieid(rs.getInt(1));
				m.setMovieName(rs.getString(2));
				m.setMovieType(rs.getString(3));
				m.setMoviePrice(rs.getInt(4));
				m.setMovieDate(rs.getString(5));
				m.setMovieTimefrom(rs.getString(6));
				m.setMovieTimeto(rs.getString(7));
				m.setSeats(rs.getInt(8));
				
			l.add(m);	
			}
			

		
	}catch(Exception e)
		{
		System.out.println(e);
	}

		return l;

}

	@Override
	public List<Theater> TicketAvalability(String movieName) {
		try {
		ps=con.prepareStatement("select Seats from theater where movieName=?");
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}}
