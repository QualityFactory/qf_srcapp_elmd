package br.com.qualityfactory.el.elmd.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DataBaseELException extends GenericELException {
	private static final long serialVersionUID = 1L;

	public DataBaseELException(Exception originalException) {
		super(originalException);
	}

	public DataBaseELException(String message) {
		super(message);
	}
}
