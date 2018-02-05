/*
 * 
 */
package com.acilia.ttschool.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionHandlingController {
	

	 
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionResponse> methodMySQLIntegrityConstraintViolationException(HttpServletRequest request, DataIntegrityViolationException e) {
        ExceptionResponse exceptionresponse = new ExceptionResponse();
      //  exceptionInfo.setErrorCode();
        exceptionresponse.setErrorMessage(e.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionresponse, HttpStatus.NOT_FOUND);

    }
}
