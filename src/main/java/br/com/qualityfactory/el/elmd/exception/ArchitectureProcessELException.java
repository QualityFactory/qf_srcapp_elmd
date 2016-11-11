package br.com.qualityfactory.el.elmd.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ArchitectureProcessELException extends GenericELException {
	private static final long serialVersionUID = 1L;

	public ArchitectureProcessELException(Exception originalException) {
		super(originalException);
	}

	public ArchitectureProcessELException(String message) {
		super(message);
	}
}
