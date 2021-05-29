package com.pinhobrunodev.course.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {

	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ExceptionResponse> handlerBusinessException(BusinessException e){
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionResponse(e.getMessage()));
	}
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionResponse> handerNotFoundException(NotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
	}
	
	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<ExceptionResponse> handerNotFoundException(EmptyListException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(e.getMessage()));
	}
}
