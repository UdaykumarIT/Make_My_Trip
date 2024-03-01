package com.ct.response;

import lombok.Data;

@Data
public class Ticket {

	private Integer ticketNum;
	private String status;
	private Double Cost;

	private String name;
	private String from;
	private String to;
	private String doj;
	private String trainNumber;

}
