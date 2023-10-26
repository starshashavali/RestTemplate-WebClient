package com.tcs.serviceimpl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.tcs.dto.PassengerDTO;
import com.tcs.dto.TicketDTO;
import com.tcs.service.YatratrainService;

@Service
public class Yatraserviceimpl implements YatratrainService {
	
	private String BOOK_TICKET="http://3.110.186.81:9999/save";
	
	private String GET_TICKET="http://3.110.186.81:9999/getticket/{id}";

	@Override
	public TicketDTO bookTicket(PassengerDTO passenger) {
		
		/*
		
		RestTemplate rt=new RestTemplate();
		ResponseEntity<TicketDTO> response = rt.postForEntity(BOOK_TICKET, passenger, TicketDTO.class);
		
		TicketDTO ticket = response.getBody();
		
		return ticket;
		*/
		//get implementation class object
		WebClient create = WebClient.create();
		//sync call
		TicketDTO ticket = create.post()
		.uri(BOOK_TICKET)
		.bodyValue(passenger)
		.retrieve()
		.bodyToMono(TicketDTO.class)
		.block();
		
		return ticket;
		
	}

	@Override
	public TicketDTO getTicket(Integer ticketNum) {
		/*
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<TicketDTO> response = restTemplate.getForEntity(GET_TICKET, TicketDTO.class, ticketNum);
		TicketDTO ticket = response.getBody();
		return ticket;
		
		*/
		WebClient create = WebClient.create();
		TicketDTO ticket = create.get()
		      .uri(GET_TICKET, ticketNum)
		      .retrieve()
		      .bodyToMono(TicketDTO.class)
		      .block();

		return ticket;
	}

}
