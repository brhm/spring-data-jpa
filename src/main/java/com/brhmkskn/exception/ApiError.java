package com.brhmkskn.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<T> {
	
	private Integer Status;
	private Exception<T> exception; // generic yapı kuruyoruz. string te olabilir list te olabilir.
	
}
