package br.com.qualityfactory.el.elmd.enums;

public enum EnumNameField {
	CODE("C�digo"), NAME("Nome"), VALUE("Valor");
	
	public String descricao;
	
	private EnumNameField(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
