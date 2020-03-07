package com.springboot.learn.SBLearn;
import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	org.apache.logging.log4j.Logger LOGGER =LogManager.getLogger(CustomExceptionHandler.class);
	@ExceptionHandler(CustomExceptions.InvalidData.class )
	ResponseEntity<Object> getDataErrorMessage()
	{
		
		LOGGER.debug("InternalServer error");
		
		return new ResponseEntity<Object>("Error dude " ,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(CustomExceptions.InvalidUser.class )
	ResponseEntity<String> getUnAuthorizedErrorMessage()
	{
		LOGGER.debug("Wait a minute who are you");
		return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
	}
}
