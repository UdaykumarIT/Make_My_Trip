package com.ct.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ct.request.Passenger;
import com.ct.response.Ticket;

@Service
public class MakeMyTripIMPL implements MakeMyTripService {

	private String BOOK_TICKET_URL = "http://localhost:8081/book";

	private String GET_TICKET_URL = "http://localhost:8081/ticket/{ticketNum}";

	@Override
	public Ticket bookTicket(Passenger passenger) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> resEntity = rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);


		System.out.println("uday");


		Ticket ticket = resEntity.getBody();

		return ticket;
	}

	@Override
	public Ticket getTicketByNum(Integer ticketNum) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> respEntity = rt.getForEntity(GET_TICKET_URL, Ticket.class, ticketNum);

		Ticket t = respEntity.getBody();
		return t;
	}

}
