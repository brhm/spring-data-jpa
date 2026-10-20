package com.brhmkskn.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoHome {
	
	private Long id;
	
	private String name;
	
	private BigDecimal price;
	private List<DtoRoom> room;
}
