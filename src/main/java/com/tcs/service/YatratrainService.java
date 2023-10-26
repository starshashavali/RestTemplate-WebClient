package com.tcs.service;

import com.tcs.dto.PassengerDTO;
import com.tcs.dto.TicketDTO;

public interface YatratrainService {
	
	public TicketDTO bookTicket(PassengerDTO passenger);
	
	public TicketDTO getTicket(Integer ticketNum);

}
