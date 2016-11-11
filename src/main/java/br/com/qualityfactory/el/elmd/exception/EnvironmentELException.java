package br.com.qualityfactory.el.elmd.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class EnvironmentELException extends GenericELException {
	private static final long serialVersionUID = 1L;

	public EnvironmentELException(String message, Exception originalException) {
		super(originalException);
	}

	public EnvironmentELException(String message) {
		super(message);
	}
}
