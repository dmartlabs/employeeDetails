package com.dlabs.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Kamlesh Kumar
 * Date 27-August-2020
 * This is a EmployeeExceptionHandler class, act as handler of all types of exception
 */
@ControllerAdvice
@Slf4j
public class EmployeeExceptionHandler {

	/**
	 * @param constraintViolationException
	 * @return ResponseEntity
	 * This handles all constraints exception of Model's and Dto's
	 */
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<EmployeeExceptionMsg>  HandleImproperConstraintsException(ConstraintViolationException ex){
		log.error("Error has occured error is: "+ex.getMessage());
		EmployeeExceptionMsg empMsg=new EmployeeExceptionMsg();
		empMsg.setMsg(ex.getMessage());
		HttpStatus status=HttpStatus.BAD_REQUEST;
		return new ResponseEntity<>(empMsg,status);
	}
}