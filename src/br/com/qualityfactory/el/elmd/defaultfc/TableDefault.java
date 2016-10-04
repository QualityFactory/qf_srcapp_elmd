package br.com.qualityfactory.el.elmd.defaultfc;

import java.util.Collection;

import br.com.qualityfactory.el.elmd.ejb.factory.SQLFactory;

public interface TableDefault {
	/**
	 * Recupera todos os registros da tabela passada via parametro
	 * @param model Objeto que representa a tabela no banco de dados, a consulta pode ser parametrizada
	 * @return Retorna a listagem de 
	 */
	public default Collection<Model> obterTodos(Model model) {
		return SQLFactory.getDataTable(model);
	}
}
