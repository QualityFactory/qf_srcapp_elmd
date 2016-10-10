package br.com.qualityfactory.el.elmd.sheet;

public interface SheetDefault {
	
	/**
	 * Código do atributo na planilha
	 * @return Retorna o código do atributo informado na planilha
	 */
	public String getCode();
	
	/**
	 * Código do atributo na planilha
	 * @param code Atribui um código para o atributo no banco de dados
	 */
	public void setCode(String code);
}
