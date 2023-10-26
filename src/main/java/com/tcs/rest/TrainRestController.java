package com.tcs.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.dto.PassengerDTO;
import com.tcs.dto.TicketDTO;
import com.tcs.service.YatratrainService;

@RestController
public class TrainRestController {
	
	@Autowired
	private YatratrainService service;

	@PostMapping("/save")
	public ResponseEntity<?> bookBusticket(@Valid @RequestBody PassengerDTO passengerDto) {
		TicketDTO bookTicket = service.bookTicket(passengerDto);
		return new ResponseEntity<TicketDTO>(bookTicket,HttpStatus.CREATED);
	}

	@GetMapping("getticket/{id}")
	public ResponseEntity<?> getBusTicket(@Valid @PathVariable Integer id) {
		TicketDTO ticket = service.getTicket(id);
		return new ResponseEntity<TicketDTO>(ticket,HttpStatus.OK);
		
	}

}
