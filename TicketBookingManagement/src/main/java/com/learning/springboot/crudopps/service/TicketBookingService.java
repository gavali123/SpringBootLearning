package com.learning.springboot.crudopps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springboot.crudopps.dao.TicketBookingDao;
import com.learning.springboot.crudopps.entity.Ticket;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDao ticketBookingDao;

	public Ticket create(Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}

	public Ticket getTicketById(Integer ticketId) {
		return ticketBookingDao.findById(ticketId).get();
	}

	public Iterable<Ticket> getAllTickets() {
		return ticketBookingDao.findAll();
	}

	public void deleteById(Integer ticketId) {
		ticketBookingDao.deleteById(ticketId);
	}

	public Ticket updateTicket(Ticket ticket, Integer ticketId) {
		Ticket dbTicket = ticketBookingDao.findById(ticketId).get();
		updateTicket(ticket, dbTicket);
		return ticketBookingDao.save(dbTicket);
	}

	private void updateTicket(Ticket ticket, Ticket dbTicket) {
		dbTicket.setBookingDate(ticket.getBookingDate());
		dbTicket.setDestinationStation(ticket.getDestinationStation());
		dbTicket.setEmail(ticket.getEmail());
		dbTicket.setPassengerName(ticket.getPassengerName());
		dbTicket.setSourceStation(ticket.getSourceStation());
	}
}
