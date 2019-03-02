package com.learning.springboot.crudopps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.crudopps.entity.Ticket;
import com.learning.springboot.crudopps.service.TicketBookingService;

@RestController
@RequestMapping(value = "/ticket")
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;

	@PostMapping(value = "/create")
	public Ticket create(@RequestBody Ticket ticket) {
		return ticketBookingService.create(ticket);
	}

	@GetMapping(value = "/getTicket/{ticketId}", produces = "application/json")
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		return ticketBookingService.getTicketById(ticketId);
	}

	@GetMapping(value = "/all", produces = "application/json")
	public Iterable<Ticket> getAllTickets() {
		return ticketBookingService.getAllTickets();
	}
	
	@PutMapping(value = "/update/{ticketId}")
	public Ticket updateTicket(@RequestBody Ticket ticket, @PathVariable("ticketId") Integer ticketId) {
		return ticketBookingService.updateTicket(ticket, ticketId);
	}
	
	@DeleteMapping(value = "/delete/{ticketId}")
	public void deleteById(@PathVariable("ticketId") Integer ticketId) {
		ticketBookingService.deleteById(ticketId);
	}
	

}
