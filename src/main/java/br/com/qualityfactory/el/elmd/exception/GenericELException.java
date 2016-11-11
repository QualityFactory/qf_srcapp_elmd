package br.com.qualityfactory.el.elmd.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class GenericELException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	private Exception originalException;

	public GenericELException(Exception originalException) {
		this.message = originalException.getMessage();
		this.originalException = originalException;
	}

	public GenericELException(String message) {
		this.message = message;
	}
}
