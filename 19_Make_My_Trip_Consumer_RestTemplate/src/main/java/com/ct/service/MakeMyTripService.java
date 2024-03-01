package com.ct.service;

import com.ct.request.Passenger;
import com.ct.response.Ticket;


public interface MakeMyTripService {

	public Ticket bookTicket(Passenger passenger);

	public Ticket getTicketByNum(Integer ticketNum);

}
