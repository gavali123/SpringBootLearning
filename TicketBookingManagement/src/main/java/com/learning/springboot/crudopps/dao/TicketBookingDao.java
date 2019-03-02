package com.learning.springboot.crudopps.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.springboot.crudopps.entity.Ticket;

public interface TicketBookingDao extends JpaRepository<Ticket, Integer> {

}
