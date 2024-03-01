package com.ct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ct.request.Passenger;
import com.ct.response.Ticket;
import com.ct.service.MakeMyTripService;

@Controller
public class MakeMyTripController {

	@Autowired
	private MakeMyTripService service;

	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam Integer ticketNum , Model model) {
		
		Ticket ticketByNum=service.getTicketByNum(ticketNum);
		model.addAttribute("ticket", ticketByNum);
		return "ticket-form";
		
	}
	
	@GetMapping("/ticket")
	public String getTicketForm(Model model) {
		
		model.addAttribute("ticket", new Ticket());
		return "ticket-form";
	}

	// After submitting request
	
	@PostMapping("/book")
	public String bookTicket(@ModelAttribute("passenger") Passenger passenger, Model model) {

		Ticket ticketBook = service.bookTicket(passenger);
		model.addAttribute("msg", "Your Ticket Booked with ID:-" + ticketBook.getTicketNum());
		System.out.println(passenger);

		return "index";
	}

	// First Page Load using Below Method
	
	@GetMapping("/")
	public String loadForm(Model model) {

		model.addAttribute("passenger", new Passenger());

		return "index";
	}

}
