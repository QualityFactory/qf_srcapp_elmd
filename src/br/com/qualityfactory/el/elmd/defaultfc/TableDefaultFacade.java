package br.com.qualityfactory.el.elmd.defaultfc;

import java.util.List;

public interface TableDefaultFacade {
	/**
	 * Recupera todos os registros da tabela passada via parametro
	 * @param model Objeto que representa a tabela no banco de dados, a consulta pode ser parametrizada
	 * @return Retorna a listagem de 
	 */
	public List<Model> obterTodos(Model model);
}
