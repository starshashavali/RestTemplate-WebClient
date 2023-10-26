package com.tcs.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDTO {
	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotBlank(message = "From field is mandatory")
	private String from;

	@NotBlank(message = "To field is mandatory")
	private String to;

	@NotNull(message = "Date of journey is mandatory")
	private String doj;

	@NotBlank(message = "Train number is mandatory")
	private String trainNumber;

}
