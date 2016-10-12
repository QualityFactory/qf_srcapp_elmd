package br.com.qualityfactory.el.elmd.enums;

public enum EnumNameFieldSheet {
	CODE("C�digo"), NAME("Nome"), VALUE("Valor");
	
	private String descricao;
	
	private EnumNameFieldSheet(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
