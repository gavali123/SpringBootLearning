package com.learning.springboot.crudopps.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Ticket> create(@RequestBody Ticket ticket) {
		Ticket created = ticketBookingService.create(ticket);
		URI location = URI.create("/ticket/getTicket/" + created.getTicketId());
		return ResponseEntity.created(location).body(created);
	}

	@GetMapping(value = "/getTicket/{ticketId}", produces = "application/json")
	public ResponseEntity<Ticket> getTicket(@PathVariable("ticketId") Integer ticketId) {
		Ticket ticket = ticketBookingService.getTicketById(ticketId);
		return ResponseEntity.ok(ticket);
	}

	@GetMapping(value = "/all", produces = "application/json")
	public ResponseEntity<Iterable<Ticket>> getAllTickets() {
		return ResponseEntity.ok(ticketBookingService.getAllTickets());
	}

	@PutMapping(value = "/update/{ticketId}")
	public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket, @PathVariable("ticketId") Integer ticketId) {
		Ticket updated = ticketBookingService.updateTicket(ticket, ticketId);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping(value = "/delete/{ticketId}")
	public ResponseEntity<Void> deleteById(@PathVariable("ticketId") Integer ticketId) {
		ticketBookingService.deleteById(ticketId);
		return ResponseEntity.noContent().build();
	}

}
