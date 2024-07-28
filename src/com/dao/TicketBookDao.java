package com.dao;

import java.util.List;

import com.pojo.TicketBook;

public interface TicketBookDao {
	boolean Bookticket(TicketBook t);
	boolean CancelTicketbyBookingid(int B_id);
	List<TicketBook> showAllBookedticket();
	 public TicketBook showTicketbookedhistory(String emailid);
	public TicketBook showticketbyBookingid(int B_id);
		public int getTotalPrice(int movieid); 

	

}
