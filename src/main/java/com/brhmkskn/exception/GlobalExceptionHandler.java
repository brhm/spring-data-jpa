package com.brhmkskn.exception;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = {BaseException.class})
	public ResponseEntity<ApiError> handleBaseException(BaseException exception,WebRequest request) {
		return ResponseEntity.badRequest().body(createApiError(exception.getMessage(),request));
	}
	
	
	// Handle Spring Validation Exceptions
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,WebRequest request) {
		Map<String,List<String>> errorsMap= new HashMap<>();
		
		for (ObjectError objectError:ex.getBindingResult().getAllErrors()) {
			String fieldName=((FieldError)objectError).getField();
			if(errorsMap.containsKey(fieldName))
			{
				errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), objectError.getDefaultMessage()));
				
			}else {
				errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objectError.getDefaultMessage()));
			}
		}
		return ResponseEntity.badRequest().body(createApiError(errorsMap.toString(),request));
		
	}
	private List<String> addMapValue(List<String> list,String newValue) {
		list.add(newValue);
		return list;
		
	}
	private String getHostname() {
		try {
		return InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("hostname bulunamadı!");
		}
		return null;
		
	}
	private <T> ApiError<T> createApiError(T message, WebRequest request) {
		ApiError<T> apiError=new ApiError<T>();
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());
		Exception<T> exception=new Exception<T>();
		exception.setCreateTime(new Date());
		exception.setHostname(getHostname());
		exception.setPath(request.getDescription(false));
		exception.setMessage(message);
		
		apiError.setException(exception);
		
		return apiError;
	}
}
