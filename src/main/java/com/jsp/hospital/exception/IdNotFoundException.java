package com.jsp.hospital.exception;

import lombok.Getter;

public class IdNotFoundException extends RuntimeException{

	@Getter
	private String message;

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}
}
