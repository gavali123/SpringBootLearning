package com.learning.springboot.crudopps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springboot.crudopps.dao.TicketBookingDao;
import com.learning.springboot.crudopps.entity.Ticket;
import com.learning.springboot.crudopps.exception.ResourceNotFoundException;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDao ticketBookingDao;

	public Ticket create(Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}

	public Ticket getTicketById(Integer ticketId) {
		return ticketBookingDao.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + ticketId));
	}

	public Iterable<Ticket> getAllTickets() {
		return ticketBookingDao.findAll();
	}

	public void deleteById(Integer ticketId) {
		ticketBookingDao.deleteById(ticketId);
	}

	public Ticket updateTicket(Ticket ticket, Integer ticketId) {
		Ticket dbTicket = ticketBookingDao.findById(ticketId)
				.orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + ticketId));
		mergeTicket(ticket, dbTicket);
		return ticketBookingDao.save(dbTicket);
	}

	private void mergeTicket(Ticket ticket, Ticket dbTicket) {
		if (ticket.getBookingDate() != null) {
			dbTicket.setBookingDate(ticket.getBookingDate());
		}
		if (ticket.getDestinationStation() != null) {
			dbTicket.setDestinationStation(ticket.getDestinationStation());
		}
		if (ticket.getEmail() != null) {
			dbTicket.setEmail(ticket.getEmail());
		}
		if (ticket.getPassengerName() != null) {
			dbTicket.setPassengerName(ticket.getPassengerName());
		}
		if (ticket.getSourceStation() != null) {
			dbTicket.setSourceStation(ticket.getSourceStation());
		}
	}
}
