/*
 * 
 */
package com.acilia.ttschool.exception;

import javax.servlet.http.HttpServletRequest;
import org.hibernate.exception.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandlingController {
	
	private static final String EXCEPTION_MESSAGE_CVE=" El campo con valor <TAG1> ya existe";
	 
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> methodMySQLIntegrityConstraintViolationException(HttpServletRequest request, DataIntegrityViolationException e) {
    	
        ExceptionResponse exceptionresponse = new ExceptionResponse();
        exceptionresponse.setErrorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));

        // extract the affected database constraint name:
        String constraintName = null;
        if ((e.getCause() != null) && (e.getCause() instanceof ConstraintViolationException)) {
        	ConstraintViolationException cve =(ConstraintViolationException)e.getCause();
        	try  {
        	String value= getConstraintValue(cve.getCause().getMessage());
        	exceptionresponse.setErrorMessage(replaceAll(EXCEPTION_MESSAGE_CVE,value));
        	} catch (Exception ex ){
        		exceptionresponse.setErrorMessage(e.getLocalizedMessage());
        	}
        	
        } else  {
        	exceptionresponse.setErrorMessage(e.getLocalizedMessage());
        }
        
        return new ResponseEntity<ExceptionResponse>(exceptionresponse, HttpStatus.BAD_REQUEST);

        
    }
    
    private String replaceAll(String message, String replacement) {
    	return message.replaceAll("<TAG1>", replacement);
    }
    private String getConstraintValue(String message){
    	String value=null;
    	value=message.substring(message.indexOf("\'") + 1);
    	value= value.substring(0, value.indexOf("\'"));
    	return value;
    }
}
