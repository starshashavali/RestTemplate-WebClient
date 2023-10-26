package com.tcs.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

    @NotNull(message = "Ticket number cannot be null")
    private Integer ticketNum;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Cost is mandatory")
    @Pattern(regexp = "^\\d+(\\.\\d{1,2})?$", message = "Cost should be a valid number")
    private String cost;

    @NotBlank(message = "From field is mandatory")
    private String from;

    @NotBlank(message = "To field is mandatory")
    private String to;

    @NotNull(message = "Date of journey is mandatory")
    private String doj;

    @NotBlank(message = "Status is mandatory")
    private String status;

}
