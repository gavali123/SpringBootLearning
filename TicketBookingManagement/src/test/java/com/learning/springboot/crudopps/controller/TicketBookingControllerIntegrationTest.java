package com.learning.springboot.crudopps.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.learning.springboot.crudopps.config.TicketBookingManagementApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TicketBookingManagementApplication.class)
@AutoConfigureMockMvc
public class TicketBookingControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTicket_notFound_returns404() throws Exception {
        mockMvc.perform(get("/ticket/getTicket/99999"))
                .andExpect(status().isNotFound());
    }
}
