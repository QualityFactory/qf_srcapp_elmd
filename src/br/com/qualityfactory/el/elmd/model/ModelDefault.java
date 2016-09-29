package br.com.qualityfactory.el.elmd.model;

import br.com.qualityfactory.el.elmd.defaultfc.Model;

/**
 * Classe genérica para obtenção dos campos id e code que devem existir em todas as tabelas
 * @author Eduardo
 *
 */
abstract class ModelDefault implements Model {

	private Integer id;
	private String code;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}
}
