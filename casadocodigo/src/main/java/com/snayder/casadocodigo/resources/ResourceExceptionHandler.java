package com.snayder.casadocodigo.resources;

import com.snayder.casadocodigo.utils.FieldMessage;
import com.snayder.casadocodigo.utils.ValidationError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> atributosInvalidos(HttpServletRequest req, MethodArgumentNotValidException ex) {
		ValidationError error = new ValidationError();

		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		error.setErro("Um ou mais campos estão inválidos.");
		error.setPath(req.getRequestURI());

		ex.getBindingResult().getFieldErrors().forEach(fieldError -> error.adicionarErro(new FieldMessage(fieldError.getField(), fieldError.getDefaultMessage())));

		return ResponseEntity.unprocessableEntity().body(error);
	}
}
