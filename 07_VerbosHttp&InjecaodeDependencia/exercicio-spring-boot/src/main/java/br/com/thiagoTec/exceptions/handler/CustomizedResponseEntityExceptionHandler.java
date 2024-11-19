package br.com.thiagoTec.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.thiagoTec.exceptions.ExceptionResponse;
import br.com.thiagoTec.exceptions.UnsupportedMathOperationException;

@ControllerAdvice // serve para concetrar algum tratamento que vai ser espalhado para todos os
					// controllers, ou seja se nenhum outro controller tratar de forma especifica
					// ele
					// irá cair nesse tratamento global onde foi marcado essa anotação
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class) // excessão mais generica do java e no rest é a internal_server_error(erro 500)
	public final ResponseEntity<ExceptionResponse> hadleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), // passando data
				ex.getMessage(), // pegando a mensagem de erro da class Exception de java.lang
				request.getDescription(false));// informando para não passar aquele textão de descrição
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UnsupportedMathOperationException.class)
	public final ResponseEntity<ExceptionResponse> hadleBadRequestExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
