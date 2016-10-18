package br.com.qualityfactory.el.elmd.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class StructureException extends Exception {

	private static final long serialVersionUID = 1L;
	private String descricao;
	
	public StructureException(String descricao) {
		this.descricao = descricao;
	}
}
