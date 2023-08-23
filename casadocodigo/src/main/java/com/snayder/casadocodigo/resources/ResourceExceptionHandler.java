package com.snayder.casadocodigo.resources;

import com.snayder.casadocodigo.exceptions.OperacaoInvalidaException;
import com.snayder.casadocodigo.exceptions.RecursoNaoEncontradoException;
import com.snayder.casadocodigo.utils.FieldMessage;
import com.snayder.casadocodigo.utils.StandardError;
import com.snayder.casadocodigo.utils.ValidationError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {
	@InitBinder
	private void activateDirectFieldAccess(DataBinder dataBinder) {
		dataBinder.initDirectFieldAccess();
	}

	@ExceptionHandler(OperacaoInvalidaException.class)
	public ResponseEntity<StandardError> operacaoInvalida(HttpServletRequest req, OperacaoInvalidaException ex) {
		StandardError error = new StandardError();

		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setErro(ex.getMessage());
		error.setPath(req.getRequestURI());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<StandardError> recursoNaoEncontrado(HttpServletRequest req, RecursoNaoEncontradoException ex) {
		StandardError error = new StandardError();

		error.setTimestamp(LocalDateTime.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setErro(ex.getMessage());
		error.setPath(req.getRequestURI());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

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
