package com.app.exceptionHandler;

import java.time.LocalDateTime;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.app.customExceptionHandler.CustomExceptionHandler;
import com.app.dto.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomExceptionHandler.class)
	public ResponseEntity<?> handleCustomException(CustomExceptionHandler e) {
		ErrorResponse resp = new ErrorResponse(e.getMessage(), LocalDateTime.now());
		log.error("custom Exception occured: "+e.getStackTrace());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> handleExistingUserExcetpion(DataIntegrityViolationException e) {
		ErrorResponse resp = new ErrorResponse("User already exisited with this Email!", LocalDateTime.now());
		log.error("Trying to persist duplicate entry: "+e.getStackTrace());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request)
	{
		System.out.println("in handle invalid meth args ");
		StringBuilder sb = new StringBuilder("Validation Errors : ");
		ex.getBindingResult().getFieldErrors().forEach(e -> sb.append(e.getDefaultMessage()+" "));
		log.error("Field validation errors: "+sb);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(sb.toString(), LocalDateTime.now()));
	}
}
