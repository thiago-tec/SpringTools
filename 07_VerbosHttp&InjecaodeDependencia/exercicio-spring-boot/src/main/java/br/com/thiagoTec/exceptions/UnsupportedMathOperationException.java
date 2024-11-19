package br.com.thiagoTec.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)//informando qual o codigo de erro que vai passar
public class UnsupportedMathOperationException extends RuntimeException {

	public UnsupportedMathOperationException(String ex) {
		super(ex);
	}

	private static final long serialVersionUID = 1L;

}
