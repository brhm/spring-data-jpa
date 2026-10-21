package com.brhmkskn.exception;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exception<T> {

	private String hostname;
	private String path;
	private Date createTime;
	private T message;
	
}
