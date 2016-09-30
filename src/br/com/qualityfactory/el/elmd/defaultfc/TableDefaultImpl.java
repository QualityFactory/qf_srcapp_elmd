package br.com.qualityfactory.el.elmd.defaultfc;

import java.util.List;

import br.com.qualityfactory.el.elmd.ejb.factory.DBFactory;

public abstract class TableDefaultImpl implements TableDefaultFacade {

	@Override
	public List<Model> obterTodos(Model model) {
		return DBFactory.getDataTable(model);
	}
}