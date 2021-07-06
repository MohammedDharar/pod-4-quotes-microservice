package com.cognizant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class QuotesNotFoundException extends Exception {
	/**
	 * 
	 */
private static final long serialVersionUID=1L;

	public QuotesNotFoundException(String message) {
		super(message);
	}

}
