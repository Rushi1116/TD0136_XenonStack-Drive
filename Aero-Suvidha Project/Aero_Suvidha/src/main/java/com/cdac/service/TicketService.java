package com.cdac.service;

import com.cdac.dto.TicketDTO;
import com.cdac.dto.TicketOutDTO;

public interface TicketService {

	TicketOutDTO generateTicket( TicketDTO t);
	
}
