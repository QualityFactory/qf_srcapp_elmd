package br.com.qualityfactory.el.elmd.transaction;

import br.com.qualityfactory.el.elmd.enums.EnumMessageType;
import lombok.Data;

@Data
public class Message {
	private EnumMessageType messageType;

	/**
	 * Exception name
	 */
	private String exception;

	/**
	 * Original exception name
	 */
	private String originalException;
	private String value;
}