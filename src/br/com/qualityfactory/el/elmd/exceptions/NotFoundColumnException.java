package br.com.qualityfactory.el.elmd.exceptions;

public class NotFoundColumnException extends StructureException {
	private static final long serialVersionUID = 1L;

	public NotFoundColumnException(String descricao) {
		super(descricao);
	}
}
