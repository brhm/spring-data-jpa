package com.brhmkskn.exception;

public class BaseException extends RuntimeException{
	
	public BaseException() {
	
		// TODO Auto-generated constructor stub
	}
	public BaseException(ErrorMessage errorMessage) {
		super(errorMessage.prepareErrorMessage());
		
	}

}
