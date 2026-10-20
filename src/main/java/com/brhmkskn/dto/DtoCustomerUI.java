package com.brhmkskn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoCustomerUI {
	
	private Long id;
	
	private String name;
	
	private DtoAddress address;
}
