package br.com.qualityfactory.el.elmd.enums;

public enum EnumNamesMethod {
	CODE("getCode");

	private String descricao;

	private EnumNamesMethod(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
