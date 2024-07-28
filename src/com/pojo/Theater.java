package com.pojo;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Theater {
	private int movieid;
	private  String movieName;
	private  String movieType;
	private  int moviePrice;
	private  String movieDate;
	private  String movieTimefrom;
	private String movieTimeto;
	private int seats;

	
	
	public Theater(int movieid,String movieName, String movieType, int moviePrice, String movieDate, String movieTimefrom,
			String movieTimeto, int seats) {
		super();
		this.movieid=movieid;
		this.movieName = movieName;
		this.movieType = movieType;
		this.moviePrice = moviePrice;
		this.movieDate = movieDate;
		this.movieTimefrom = movieTimefrom;
		this.movieTimeto = movieTimeto;
		this.seats = seats;
	}

	public Theater() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieType() {
		return movieType;
	}

	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}

	public int getMoviePrice() {
		return moviePrice;
	}

	public void setMoviePrice(int moviePrice) {
		this.moviePrice = moviePrice;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public String getMovieTimefrom() {
		return movieTimefrom;
	}

	public void setMovieTimefrom(String movieTimefrom) {
		this.movieTimefrom = movieTimefrom;
	}

	public String getMovieTimeto() {
		return movieTimeto;
	}

	public void setMovieTimeto(String movieTimeto) {
		this.movieTimeto = movieTimeto;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Theater [movieid=" + movieid + ", movieName=" + movieName + ", movieType=" + movieType + ", moviePrice="
				+ moviePrice + ", movieDate=" + movieDate + ", movieTimefrom=" + movieTimefrom + ", movieTimeto="
				+ movieTimeto + ", seats=" + seats + "]";
	}

		
	

}
