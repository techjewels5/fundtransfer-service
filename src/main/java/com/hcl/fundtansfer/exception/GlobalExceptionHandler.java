package com.hcl.fundtansfer.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hcl.fundtansfer.utils.ResponseData;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	 	@ExceptionHandler(ResourceNotFoundException.class)
	    public final ResponseEntity<Object> handleAllExceptions(ResourceNotFoundException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getMessage());
	        ResponseData error = new ResponseData(ex.getMessage(), HttpStatus.BAD_REQUEST, null);
	        return new ResponseEntity<>(error, error.getHttpStatus());
	    }
	
}