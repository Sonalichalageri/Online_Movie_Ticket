package com.dao;

import java.util.List;

import com.pojo.Theater;

public interface TheaterDao {
	
	boolean addmovie(Theater m);
	boolean updatemovie(Theater m);
	
	boolean deletemovie(String movieName);
	public Theater searchmovie(int movieid);
	
	List<Theater> getallmovie();
	
	List<Theater> searchbyname( String movieName );
	List<Theater> searchbytype(String movieType);
	
	 List<Theater> TicketAvalability(String movieName);
	
	
	
	

}
