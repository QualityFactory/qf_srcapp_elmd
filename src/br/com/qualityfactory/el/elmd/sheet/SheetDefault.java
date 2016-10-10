package br.com.qualityfactory.el.elmd.sheet;

public interface SheetDefault {
	
	/**
	 * C�digo do atributo na planilha
	 * @return Retorna o c�digo do atributo informado na planilha
	 */
	public String getCode();
	
	/**
	 * C�digo do atributo na planilha
	 * @param code Atribui um c�digo para o atributo no banco de dados
	 */
	public void setCode(String code);
}
