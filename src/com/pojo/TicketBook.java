package com.pojo;

import java.time.LocalDateTime;

public class TicketBook {
	private int B_id;
	private String emailid;
	private int movieid;
	private int Noofseat;
	private int total_price;
	private String B_status;
	private LocalDateTime DateTime;
	
	public TicketBook( String emailid, int movieid,int noofseat, int total_price, String b_status, LocalDateTime dateTime
			) {
		super();
		
		this.emailid = emailid;
		this.movieid = movieid;
		Noofseat = noofseat;
		this.total_price = total_price;
		B_status = b_status;
		DateTime = dateTime;
		
	}
	public TicketBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getB_id() {
		return B_id;
	}
	public void setB_id(int b_id) {
		B_id = b_id;
	}
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public String getB_status() {
		return B_status;
	}
	public void setB_status(String b_status) {
		B_status = b_status;
	}
	public LocalDateTime getDateTime() {
		return DateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		DateTime = dateTime;
	}
	public int getNoofseat() {
		return Noofseat;
	}
	public void setNoofseat(int noofseat) {
		Noofseat = noofseat;
	}
	@Override
	public String toString() {
		return "TicketBook [B_id=" + B_id + ", emailid=" + emailid + ", movieid=" + movieid + ", Noofseat=" + Noofseat + ", total_price="
				+ total_price + ", B_status=" + B_status + ", DateTime=" + DateTime  +"]";
	}

	
	}

	
